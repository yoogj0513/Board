package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.MemberDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Member;
import com.yi.mvc.CommandHandler;

public class ChangePwdHendler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/changePwdForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("password");
			String newPw = req.getParameter("newPassword");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				MemberDAO dao = MemberDAO.getInstance();
				Member member = dao.selectByIdAndPw(conn, id, pw);
				
				if(member == null) {
					req.setAttribute("notMatch", true);
					return "/WEB-INF/view/changePwdForm.jsp";
				}
				
				// 현재 비밀번호 일치
				Member memberNewPw = new Member(id, newPw);
				dao.update(conn, memberNewPw);
				
				return "/WEB-INF/view/changePwdSuccesss.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			
		}
		
		return null;
	}

}
