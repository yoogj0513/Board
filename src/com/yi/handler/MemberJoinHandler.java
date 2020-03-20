package com.yi.handler;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.MemberDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Member;
import com.yi.mvc.CommandHandler;

public class MemberJoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/memberJoinForm.jsp";
		}
		else if (req.getMethod().equalsIgnoreCase("post")) {
			req.setCharacterEncoding("utf-8");
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				MemberDAO dao = MemberDAO.getInstance();
				Member member = new Member(id, name, password, new Date());
				dao.insert(conn, member);
				
				req.setAttribute("id", id);
				return "/WEB-INF/view/memberJoinResult.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		
		return null;
	}

}
