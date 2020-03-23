package com.yi.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.DBCPInit;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;

public class ArticleDAOTest {
	Connection conn = null;
	ArticleDAO dao = null;
	
	@Before
	public void before() {		
		//@Before은 @Test가 작동하기전에 자동으로 작동 (미리 작동)
		
		try {
			DBCPInit dbcpInit = new DBCPInit();
			dbcpInit.init(); //junit 테스트는 서버가 돌지 않으므로, 우리가 conneciont 
			conn = JDBCUtil.getConnection();
			dao = ArticleDAO.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@After
	public void after() {
		// @Test가 작동이 완료후 실행 (닫기)
		JDBCUtil.close(conn);
	}
	
	//@Test
	public void testInsert() throws SQLException {
		Article article = new Article(2, "test2", "test2", "제목2", new Date(), new Date(), 0, "내용 2");
		
		dao.insertArticle(conn, article);
		dao.insertContent(conn, article);
	}
	
	//@Test
	public void testList() throws SQLException {
		List<Article> list = dao.listArticle(conn);
		for(Article art : list) {
			System.out.println(art);
		}
	}
	
	//@Test
	public void testUpdate() throws SQLException {
		Article article = new Article(2, null, null, "수정된 게시글2", null, new Date(), 1, "수정 내용2");
		dao.updateAritcle(conn, article);
		dao.updateContent(conn, article);
	}
	
	//@Test
	public void testDelete() throws SQLException {
		Article article = new Article();
		article.setArticleNo(1);
		dao.deleteArticle(conn, article);
		dao.deleteContent(conn, article);
	}
}
