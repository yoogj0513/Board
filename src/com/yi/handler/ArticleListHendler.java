package com.yi.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleListHendler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ArticleDAO dao = ArticleDAO.getInstance();
			
			List<Article> list = dao.listArticle(conn);
			req.setAttribute("list", list);
			
			return "WEB-INF/view/articleList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		
		return null;
	}

}
