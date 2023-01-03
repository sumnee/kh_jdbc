package com.kh.jdbc.day03.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDao;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberService {

	private JDBCTemplate jTemp;
	private MemberDao mDao;
	Member member = null;
	
	public MemberService() {
		mDao = new MemberDao(); 	//생략하지 말기
	}
	
	/**
	 * 회원 전체보기
	 * @return
	 */
	public List<Member> selectAll() {
		List<Member> mList = null;
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectAll(conn);
		return mList;
	}
	
	/**
	 * 아이디로 조회
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = mDao.selectOneById(conn, memberId);
		return member;	
	}
	
	/**
	 * 이름으로 조회
	 * @param memberName
	 * @return List<Member>
	 */
	public List<Member> selectAllByName(String memberName) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> mList = mDao.selectAllByName(conn, memberName);
		return mList;
	}

	/**
	 * 회원 등록
	 * @param member
	 * @return 
	 */
	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	/**
	 * 회원정보 수정
	 * @param member
	 * @return
	 */
	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	/**
	 * 회원 탈퇴
	 * @param memberId
	 * @return
	 */
	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.deleteMember(conn, memberId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
