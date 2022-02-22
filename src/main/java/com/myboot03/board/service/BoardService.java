package com.myboot03.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface BoardService {
	public List listArticles() throws DataAccessException;

	


	public void modArticle(Map<String, Object> articleMap) throws Exception;

	public void removeArticle(int articleNO) throws Exception;

	public int addNewArticle(Map articleMap) throws Exception;
	
	public Map viewArticle(int articleNO) throws Exception;
}
