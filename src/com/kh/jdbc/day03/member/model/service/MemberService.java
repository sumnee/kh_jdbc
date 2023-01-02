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
		jTemp = JDBCTemplate.getDriverLoad();
		mDao = new MemberDao();
	}
	
	public List<Member> selectAll() {
		List<Member> mList = null;
//		JDBCTemplate jTemp = JDBCTemplate.getDriverLoad();
		Connection conn = jTemp.getConnection();
		mList = mDao.selectAll(conn);
		jTemp.close(conn);
		return mList;
	}
	
	public Member selectOneById(String memberId) {
		Connection conn = jTemp.getConnection();
		Member member = mDao.selectOneById(conn, memberId);
		jTemp.close(conn);
		return member;
		
	}

	public int insertMember(Member member) {
//		JDBCTemplate jTemp = JDBCTemplate.getDriverLoad();
		Connection conn = jTemp.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			jTemp.commit(conn);
		} else {
			jTemp.rollback(conn);
		}
		jTemp.close(conn);
		return result;
	}
	
	public int updateMember(Member member) {
		Connection conn = jTemp.getConnection();
		int result = mDao.insertMember(conn, member);
		if(result > 0) {
			jTemp.commit(conn);
		} else {
			jTemp.rollback(conn);
		}
		jTemp.close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
