package com.myboot03.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {
	
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	ResponseEntity removeArticle(int articleNO, HttpServletRequest request, HttpServletResponse response)
			throws Exception;


}