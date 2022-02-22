package com.myboot03.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myboot03.board.vo.ArticleVO;
import com.myboot03.board.vo.ImageVO;

@Mapper
@Repository("boardDAO")
public interface BoardDAO {

	List selectAllArticlesList() throws DataAccessException;

	int insertNewArticle(Map<String, Object> articleMap);

	ArticleVO selectArticle(int articleNO) throws DataAccessException;

	void updateArticle(Map articleMap);

	void deleteArticle(int articleNO);

	void insertNewImage(Map articleMap) throws DataAccessException;

	List<ImageVO> selectImageFileList(int articleNO);

}
