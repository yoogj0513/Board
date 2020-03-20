package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.Article;

public class ArticleDAO {
	private static ArticleDAO dao = new ArticleDAO();
	
	public static ArticleDAO getInstance() {
		return dao;
	}
	
	private ArticleDAO() {}
	
	// insertArticle
	public void insertArticle(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into article values (null,?,?,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriterId());
			pstmt.setString(2, article.getWriterName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, new Timestamp(article.getReqdate().getTime()));
			pstmt.setTimestamp(5, new Timestamp(article.getModdate().getTime()));
			pstmt.executeUpdate();
		}finally {
			JDBCUtil.close(pstmt);
		}
		
	}
	
	//insertContent
	public void insertContent(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into article_content values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, article.getArticleNo());
			pstmt.setString(2, article.getContent());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	//listArticle
	public List<Article> listArticle(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from article";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Article> list = new ArrayList<>();
			while(rs.next()) {
				Article art = new Article(rs.getInt(1), 
										rs.getString(2), 
										rs.getString(3), 
										rs.getString(4), 
										rs.getTimestamp(5), 
										rs.getTimestamp(6), 
										rs.getInt(7));
				list.add(art);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	//updateAritcle (title, moddate, read_cnt 만 수정)
	public void updateAritcle(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update article set title = ? , moddate = ?, read_cnt = ? where article_no = ?";
			pstmt = conn.prepareStatement(sql);
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	//updateContent (content만 수정)
	public void updateContent(Connection conn, Article article) {
		
	}
	
	//deleteArticle
	public void deleteArticle(Connection conn, Article article) {
		
	}
	
	//deleteContent
	public void deleteContent(Connection conn, Article article) {
		
	}
	
	//selectArticleByNo
	public Article selectArticleByNo(Connection conn, int no) {
		return null;
	}
	
	//selectContentByNo
	public Article selectContentByNo(Connection conn, int no) {
		return null;
	}
}
