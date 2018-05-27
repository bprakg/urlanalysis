package com.urlanalysis.api.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.business.AnalysisBusiness;

import lombok.extern.log4j.Log4j;

@WebMvcTest(AnalysisController.class)
@RunWith(SpringRunner.class)
@Log4j
public class AnalysisControllerTest {

	@MockBean
	private AnalysisBusiness business;

	@Autowired
	private MockMvc mvc;

	public @Test void getAnalysisTest1() {
		Analysis analysis = Analysis.builder().build();
		analysis.setUrl("google.com");
		given(this.business.getAnalysis(anyString())).willReturn(analysis);
		try {
			mvc.perform(get("/urlanalysis?url=gmail.com")).andExpect(status().isOk());
		} catch (Exception e) {
			log.info("logging exception", e);
		}
	}
}