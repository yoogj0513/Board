package com.yi.handler;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleReadJsonHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			String sNo = req.getParameter("no");
			int no = Integer.parseInt(sNo);
			
			//no에 해당하는 게시글 데이터를 꺼냄
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ArticleDAO dao = ArticleDAO.getInstance();
				Article article = dao.selectArticleByNo(conn, no);
				
				// json string 변환
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(article);
				
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print(json);
				out.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
