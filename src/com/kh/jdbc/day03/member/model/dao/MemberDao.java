package com.kh.jdbc.day03.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop;
	
	public MemberDao() {
		prop = new Properties();
		try {
			FileReader reader = new FileReader("src/resources/query.properties");
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 전부 출력 DAO
	 * @param conn
	 * @return
	 */
	public List<Member> selectAll(Connection conn) {
		List<Member> mList = null;
		String sql = prop.getProperty("selectAll");
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			mList = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();	
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 아이디로 조회 DAO
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public Member selectOneById(Connection conn, String memberId) {
		String sql = prop.getProperty("selectOneById");
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));	
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	/**
	 * 이름으로 조회 DAO
	 * @param conn
	 * @param memberName
	 * @return
	 */
	public List<Member> selectAllByName(Connection conn, String memberName) {
		String sql = prop.getProperty("selectAllByName");
		List<Member> mList = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+memberName+"%");		//와일드카드
			ResultSet rset = pstmt.executeQuery();
			mList = new ArrayList<Member>();
					
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberAge(rset.getInt("MEMBER_AGE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberAddress(rset.getString("MEMBER_ADDRESS"));
				member.setMemberHobby(rset.getString("MEMBER_HOBBY"));
				member.setMemberDate(rset.getTimestamp("MEMBER_DATE"));
				mList.add(member);
			}
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	/**
	 * 회원정보 등록 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int insertMember(Connection conn,Member member) {
		int result = 0;
		String sql = prop.getProperty("insertMember");
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setInt(5, member.getMemberAge());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setString(8, member.getMemberAddress());
			pstmt.setString(9, member.getMemberHobby()); //쿼리문 실행 준비 완료
			result = pstmt.executeUpdate(); //쿼리문 실행
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 회원정보 수정 DAO
	 * @param conn
	 * @param member
	 * @return
	 */
	public int updateMember(Connection conn, Member member) {
	
		String sql = prop.getProperty("updateMember");
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setString(5, member.getMemberHobby());
			pstmt.setString(6, member.getMemberId());
			result = pstmt.executeUpdate();	
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 회원정보 삭제 DAO
	 * @param conn
	 * @param memberId
	 * @return
	 */
	public int deleteMember(Connection conn, String memberId) {
		
		String sql = prop.getProperty("deleteMember");
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	

	
	
	
	
}
