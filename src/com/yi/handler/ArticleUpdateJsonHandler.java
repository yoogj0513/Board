package com.yi.handler;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.yi.dao.ArticleDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;
import com.yi.mvc.CommandHandler;

public class ArticleUpdateJsonHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			// no, title, content 옴
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//db에 수정하기
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				conn.setAutoCommit(false);
				ArticleDAO dao = ArticleDAO.getInstance();
				Article article = new Article();
				article.setArticleNo(Integer.parseInt(no));
				article.setTitle(title);
				article.setContent(content);
				article.setModdate(new Date());
				
				dao.updateAritcle(conn, article);
				dao.updateContent(conn, article);
				conn.commit();
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("result", "success"); // 성공 또는 실패 내용을 저장
				
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(map);
				
				// 브라우저로 보냄
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				out.print(json);
				out.flush();
				
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
