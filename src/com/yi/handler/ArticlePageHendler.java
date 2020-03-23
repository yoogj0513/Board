package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticlePageHendler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ArticleDAO dao = ArticleDAO.getInstance();
			int no = Integer.parseInt(req.getParameter("no"));
			
			Article item =  dao.selectArticleByNo(conn, no);
			
			Article article = new Article(no, 
										null, 
										null, 
										item.getTitle(), 
										null, 
										item.getModdate(), 
										item.getReadCnt() + 1);
			dao.updateAritcle(conn, article);
			
			req.setAttribute("item", item);
//			res.sendRedirect("read.do");
//			return null;
			return "/WEB-INF/view/articleListPage.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		
		return null;
	}

}
