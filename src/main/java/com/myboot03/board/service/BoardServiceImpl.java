package com.myboot03.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myboot03.board.dao.BoardDAO;
import com.myboot03.board.vo.ArticleVO;
import com.myboot03.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<ArticleVO> listArticles() throws DataAccessException {
		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList();
		return articlesList;
	}

//	@Override
//	public int addNewArticle(Map<String, Object> articleMap) {
//		return boardDAO.insertNewArticle(articleMap);
//	}

	// ���� ���� ���̱�
//	@Override
//	public ArticleVO viewArticle(int articleNO) throws Exception {
//		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
//		return articleVO;
//	}
	// ���� ���� ���̱�
	@Override
	public Map viewArticle(int articleNO) throws Exception {
		Map articleMap = new HashMap();
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;
	}

	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
	}

	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}

//	@Override
//	public int addNewArticle(Map articleMap) throw Exception{
//		return boardDAO.insertNewArticle(articleMap);
//	}
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int articleNO = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNO", articleNO);
		boardDAO.insertNewImage(articleMap);
		return articleNO;
	}

}
