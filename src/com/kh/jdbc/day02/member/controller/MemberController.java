package com.kh.jdbc.day02.member.controller;

import java.util.List;

import com.kh.jdbc.day02.member.model.dao.MemberDao;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {

	/**
	 * 전체 목록 조회
	 */
	public List<Member> printAll() {
		MemberDao mDao = new MemberDao();
		List<Member> mList = mDao.selectAll();
		return mList;
	}
	
	/**
	 * 아이디로 조회
	 * @param memberId
	 * @return
	 */
	public Member printOneById(String memberId) {
		MemberDao mDao = new MemberDao();
		Member member = mDao.selectOneById(memberId);
		return member;
	}
	
	/**
	 * 로그인
	 * @param member
	 * @return
	 */
	public int checkInfo(Member member) {
		MemberDao mDao = new MemberDao();
		int result = mDao.checkLgin(member);
		return result;
	}
	
	/**
	 * 회원 가입
	 * @param member
	 */
	public int registerMember(Member member) {
		MemberDao mDao = new MemberDao();
		int result = mDao.insertMember(member);
		return result;
	}
	
	
	public int removeMember(String memberId) {
		MemberDao mDao = new MemberDao();
		int result = mDao.deleteMember(memberId);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
