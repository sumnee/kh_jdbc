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
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
