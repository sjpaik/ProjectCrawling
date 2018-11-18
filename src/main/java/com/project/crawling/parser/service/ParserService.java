package com.project.crawling.parser.service;

import com.project.crawling.parser.model.ParserModel;

import java.util.Map;

public interface ParserService {

    Map<String, Object> loadProduct(ParserModel parserModel);

}
