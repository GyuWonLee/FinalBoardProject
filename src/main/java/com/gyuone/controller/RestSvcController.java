package com.gyuone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gyuone.model.ArticleVO;
import com.gyuone.service.BoardService;

@RestController
@RequestMapping("/rest")
public class RestSvcController {
	@Autowired
	ArticleVO articleVo;
	@Autowired
	BoardService boardService;
	
	Logger logger = LoggerFactory.getLogger("com.gyuone.controller.RestSvcController");

	@RequestMapping("/hello")
	public String hello() {
		logger.info("====> hello() 진입");
		return "Hello REST!!!!";
	}
	
	@RequestMapping(value="/article/{num}", method=RequestMethod.GET)
	public ArticleVO getArticle(@PathVariable("num") int articleNo) { // num 변수 
		articleVo = boardService.viewArticle(articleNo); // articleVo 통째로 넘겨버림
		return articleVo;
	}
	
}
