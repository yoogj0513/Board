package com.yi.handler;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleUpdateHendler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ArticleDAO dao = ArticleDAO.getInstance();
				
				Article item = dao.selectArticleByNo(conn, no);
				req.setAttribute("item", item);
				
				return "/WEB-INF/view/articleUpdateForm.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			int readCnt = Integer.parseInt(req.getParameter("readCnt"));
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				conn.setAutoCommit(false);
				ArticleDAO dao = ArticleDAO.getInstance();
				
				Article article = new Article(no, 
											null, 
											null, 
											title, 
											null, 
											new Date(), 
											readCnt, 
											content);
				
				
				dao.updateAritcle(conn, article);
				dao.updateContent(conn, article);
				conn.commit();
				
				res.sendRedirect("list.do");
				
				return null;
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
