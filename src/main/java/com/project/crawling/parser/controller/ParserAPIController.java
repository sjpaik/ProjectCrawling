package com.project.crawling.parser.controller;

import com.project.crawling.parser.model.ParserModel;
import com.project.crawling.parser.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ParserAPIController {

    private final ParserService parserService;

    @Autowired
    public ParserAPIController(ParserService parserService) {
        this.parserService = parserService;
    }

    @PostMapping(value = "/load/product")
    @ResponseBody
    public Map<String, Object> loadProduct(ParserModel parserModel){
        return parserService.loadProduct(parserModel);
    }

}
