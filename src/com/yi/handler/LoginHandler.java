package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yi.dao.MemberDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Member;
import com.yi.mvc.CommandHandler;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/loginForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				MemberDAO dao = MemberDAO.getInstance();
				Member member = dao.selectByIdAndPw(conn, id, password);
				if (member == null) { //일치하지 않을 때
					req.setAttribute("notMatch", true);
					return "/WEB-INF/view/loginForm.jsp";
				}
				
				// 자바에서는 아래와 같이 불러와야함
				//로그인
				HttpSession session = req.getSession();
				session.setAttribute("Auth", id);
				
				return "index.jsp"; //홈으로 이동
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			
		}
		
		return null;
	}

}
