package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/newsdb?serverTimezone=Asia/Seoul";
	
	public Connection open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void addNews(News n) throws Exception {
		conn = open();
		
		String sql = "insert into news (title, img, date, content) values(?,?,CURRENT_TIMESTAMP(),?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getImg());
		pstmt.setString(3, n.getContent());
		
		pstmt.executeUpdate();	
		close();
	}
	
	public List<News> getAll() throws Exception {
		conn = open();
		List<News> newsList = new ArrayList<>();
		
		String sql = "select aid, title, date_format(date, '%Y-%m-%d %h:%m:%s') as cdate from news";
		
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			News n = new News();
			
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setDate(rs.getString("cdate"));
			
			newsList.add(n);
		}
		close();
		return newsList;
	}
	
	public News getNews(int aid) throws Exception {
		conn = open();
		String sql = "select aid, title, img, date_format(date, '%Y-%m-%d %h:%m:%s') as cdate, content from news "
				+ "where aid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		
		News n = new News();
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setDate(rs.getString("cdate"));
			n.setContent(rs.getString("content"));
		};
		close();
		return n;
	}

	public void delNews(int aid) throws Exception {
		conn = open();
		
		String sql = "delete from news where aid = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		
		if(pstmt.executeUpdate() == 0) {
			throw new SQLException("DB - news 삭제 에러");
		};
		close();
	}

}
