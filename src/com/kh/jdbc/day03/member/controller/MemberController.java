package com.kh.jdbc.day03.member.controller;

import java.util.List;

import com.kh.jdbc.day03.member.model.dao.MemberDao;
import com.kh.jdbc.day03.member.model.service.MemberService;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberController {

	private MemberService mService;
	
	public MemberController() {
		mService = new MemberService();		//잊지말고 꼭 쓰기
	}
	
	
	public List<Member> printAll() {
		List<Member> mList = mService.selectAll();
		return mList;
	}
	
	public Member printOneById(String memberId) {
		Member member = mService.selectOneById(memberId);
		return member;	
	}

	/**
	 * 이름으로 조회
	 */
	public List<Member> printAllByName(String memberName) {
		List<Member> mList = mService.selectAllByName(memberName);
		return mList;
	}

	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public int registerMember(Member member) {
		int result = mService.insertMember(member);
		return result;
	}

	/**
	 * 회원 정보수정
	 * @param member
	 * @return
	 */
	public int modifyMember(Member member) {
		int result = mService.updateMember(member);
		return result;
	}

	public int removeMember(String memberId) {
		int result = mService.deleteMember(memberId);
		return result;
	}
	

}
