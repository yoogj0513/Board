package com.yi.handler;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleListJsonHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			//list data를 db로부터 가져와야 함
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ArticleDAO dao = ArticleDAO.getInstance();
				List<Article> list = dao.listArticle(conn);
				
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(list);
				
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
