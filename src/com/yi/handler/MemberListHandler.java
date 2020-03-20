package com.yi.handler;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.MemberDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Member;
import com.yi.mvc.CommandHandler;

public class MemberListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
//		req.setCharacterEncoding("utf-8");
		
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			MemberDAO dao = MemberDAO.getInstance();
			List<Member> list = dao.selectAll(conn);
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/memberList.jsp";	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
				
		return null;
	}

}
