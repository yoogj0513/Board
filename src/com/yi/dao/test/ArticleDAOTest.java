package com.yi.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

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
	
	@Test
	public void testInsert() throws SQLException {
		Article article = new Article(1, "test1", "test", "제목1", new Date(), new Date(), 0, "내용 1");
		
		dao.insertArticle(conn, article);
		dao.insertContent(conn, article);
	}
}
