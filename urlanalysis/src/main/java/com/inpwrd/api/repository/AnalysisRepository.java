package com.inpwrd.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.inpwrd.api.bean.Analysis;

public interface AnalysisRepository extends PagingAndSortingRepository<Analysis, Long> {

	Analysis findByUrl(String url);
}
