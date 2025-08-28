package com.mycompany.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.board.dto.BoardDto;

public class BoardDao {
	private String drivername = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springdb?serverTimezone=Asia/Seoul";
	private String username = "root";
	private String password = "12345";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	BoardDto boardDto = null;
	List<BoardDto> boardDtos = null;
	
	
	
	
	
	// db에 글쓰는 메서드
	public void write(String bname, String btitle, String bcontent) {
		String sql = "INSERT INTO boardtbl (bname, btitle, bcontent) VALUES (?, ?, ?)";
		
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	// 모든 글 가져오기 메서드
	public List<BoardDto> boardlist() {
		String sql = "SELECT * FROM boardtbl ORDER BY bnum DESC";
		boardDtos = new ArrayList<BoardDto>();
		
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
//				방법1, 2 둘다 상관 없음				
//				boardDto = new BoardDto();
//				boardDto.setBnum(rs.getInt("bnum"));
//				boardDto.setBtitle(rs.getString("btitle"));
//				boardDto.setBcontent(rs.getString("bcontent"));
//				boardDto.setBname(rs.getString("bname"));
//				boardDto.setBhit(rs.getInt("bhit"));
//				boardDto.setBdate(rs.getString("bdate"));
//				boardDtos.add(boardDto);
				
				// 방법2 코드가 간단해짐
				boardDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
				boardDtos.add(boardDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			return boardDtos;
			
		}
	
	
	
	
	
	
	
	// 글 번호에 해당되는 글 내용 가져오기
	public BoardDto contentview(String bnum) {
		updatehit(bnum); // 조회수 증가 함수 호출
		String sql = "SELECT * FROM boardtbl WHERE bnum = ?";
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				boardDto = new BoardDto(rs.getInt("bnum"), rs.getString("btitle"), rs.getString("bcontent"), rs.getString("bname"), rs.getInt("bhit"), rs.getString("bdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			return boardDto;
		
	}
	
	
	
	
	
	
	// 조회수 증가
	public void updatehit(String bnum) {
		String sql = "UPDATE boardtbl SET bhit = bhit + 1 WHERE bnum = ?";
		
		try {
			Class.forName(drivername);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
