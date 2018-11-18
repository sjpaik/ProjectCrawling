package com.project.crawling.parser.service;

import com.project.crawling.parser.model.ParserModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParserServiceImpl implements ParserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserServiceImpl.class);
    private static final int BODY_SIZE = 1024 * 1024 * 10;

    public Map<String, Object> loadProduct(ParserModel parserModel){
        HashMap<String, Object> returnMap = new HashMap<String, Object>();
        String url = parserModel.getUrl();
        try {
            Document doc = Jsoup.connect(url).maxBodySize(BODY_SIZE).get();
            // LOGGER.info("doc :" + doc.toString());

            Elements articles = doc.select("div#roomsetMainContent");
            List<String> articleList = new ArrayList<String>();
            for(Element e : articles){
                articleList.add(e.text());
            }
            returnMap.put("article", articleList);
            LOGGER.info("article : " + articleList);

            Elements titles = doc.select("h1.ideasCloseUpHeader");
            List<String> titleList = new ArrayList<String>();
            for(Element e : titles){
                titleList.add(e.text());
            }
            returnMap.put("title", titleList);
            LOGGER.info("title : " + titleList);

            Elements articleDate = doc.select("div.ideasCloseUpDatePlaceHolder");
            List<String> articleDateList = new ArrayList<String>();
            for(Element e : articleDate){
                articleDateList.add(e.text());
            }
            returnMap.put("articleDate", articleDateList);
            LOGGER.info("articleDate : " + articleDateList.toString());

            Elements articleDesc = doc.select("div.ideasCloseUpDescription");
            List<String> articleDescList = new ArrayList<String>();
            for(Element e : articleDesc){
                articleDescList.add(e.text());
            }
            returnMap.put("articleDesc", articleDescList);
            LOGGER.info("articleDesc : " + articleDescList.toString());

            /*
            Elements articleTags = doc.select("div#ideaCloseUpTag");
            List<String> articleTagsList = new ArrayList<String>();
            for(Element e : articleTags){
                articleTagsList.add(e.toString());
            }
            returnMap.put("articleTags", articleTagsList);
            LOGGER.info("articleTags : " + articleTagsList.toString());
            */

            /*
            Elements images = doc.select("div.gridComponent img");
            List<String> imagesList = new ArrayList<String>();
            for(Element e : images){
                // imagesList.add(e.toString()); // 이미지 요소
                // imagesList.add(e.attr("src")); // 이미지 src
            }
            returnMap.put("images", imagesList);
            LOGGER.info("images : " + imagesList.toString());
            */

            /*
            Elements gridRow = doc.select("div.gridRow");
            List<String> gridRowList = new ArrayList<String>();
            for(Element e : gridRow){
                gridRowList.add(e.toString());
            }
            returnMap.put("gridRow", gridRowList);
            LOGGER.info("gridRow : " + gridRowList.toString());
            */

        } catch (Exception e) {
            LOGGER.error("error", e);
        }

        return returnMap;
    }

}
