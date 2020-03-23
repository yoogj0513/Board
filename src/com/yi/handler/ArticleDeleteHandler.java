package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			ArticleDAO dao = ArticleDAO.getInstance();
			Article article = new Article();
			article.setArticleNo(Integer.parseInt(req.getParameter("no")));
			
			dao.deleteArticle(conn, article);
			dao.deleteContent(conn, article);
			conn.commit();
			
			res.sendRedirect("list.do");
			return null;
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		
		return null;
	}

}
