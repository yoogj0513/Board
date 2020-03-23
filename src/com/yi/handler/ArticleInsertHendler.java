package com.yi.handler;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.model.Auth;
import com.yi.mvc.CommandHandler;

public class ArticleInsertHendler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/articleInsertForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Auth auth = (Auth)req.getSession().getAttribute("Auth");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				conn.setAutoCommit(false); // commit 막음
				ArticleDAO dao = ArticleDAO.getInstance();
				
				Article article = new Article(0, auth.getId(), auth.getName(), title, new Date(), new Date(), 0, content);
				
				// last_insert_id()를 사용하기 위해서는 하나의 커넥션에서 이루어져야하고 받아올 id값이 먼저 insert되어야 함
				dao.insertArticle(conn, article);
				dao.insertContent(conn, article);
				conn.commit(); // commit 실행
				
				res.sendRedirect("list.do");
				return null;  
			} catch (Exception e) {
				conn.rollback(); // try 실행 중 exception 일어나면 롤백
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		
		return null;
	}

}
