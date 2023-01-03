package com.kh.jdbc.day03.member.run;

import java.util.List;

import com.kh.jdbc.day03.member.controller.MemberController;
import com.kh.jdbc.day03.member.model.vo.Member;
import com.kh.jdbc.day03.member.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		Member member = null;
		int result = 0;
		String memberId = "";
		String memberName = "";
		
		Exit : 
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 1 :
				//전체조회
				List<Member> mList = mCon.printAll();
				if(mList.size() > 0) {
					mView.showAll(mList);
				} else {
					mView.displayError("회원 정보가 없습니다.");
				}
				break;
				
			case 2 :
				//아이디 조회
				memberId = mView.inputMemberId("검색");
				member = mCon.printOneById(memberId);
				if(member != null) {
					mView.showOne(member);
				} else {
					mView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
				
			case 3 :
				//이름 조회
				memberName = mView.inputMemberName("검색");
				mList = mCon.printAllByName(memberName);
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				} else {
					mView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			
			case 4 :
				//가입
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.displaySuccess("회원가입 완료!");
				} else {
					mView.displayError("회원가입 실패... ");
				}
				break;
				
			case 5 :
				//수정(아이디 입력, 데이터 존재 시 수정)
				memberId = mView.inputMemberId("수정");
				member = mCon.printOneById(memberId);
				if(member != null) {
					member = mView.modifyMember(memberId);
					result = mCon.modifyMember(member);
					if(result>0) {
						mView.displaySuccess("수정이 완료되었습니다.");
					} else {
						mView.displayError("수정 실패");
					}
				} else {
					mView.displayError("일치하는 데이터가 없습니다.");
				}		
				break;
				
			case 6 :
				//탈퇴
				memberId = mView.inputMemberId("삭제");
				result = mCon.removeMember(memberId);
				if(result > 0) {
					mView.displaySuccess("회원 탈퇴 성공");
				} else {
					mView.displayError("회원 탈퇴 실패");
				}
				break;
				
//			case 7 :
//				member = mView.inputLoginInfo();
//				result = mCon.checkInfo(member);
//				if(result > 0) {
//					mView.displaySuccess("로그인 성공! 접속 완료");
//				} else {
//					mView.displayError("로그인 실패. 아이디와 비밀번호를 다시 확인하세요.");
//				}
//				break;
				
			case 0 :
				mView.printMessage("프로그램을 종료합니다.");
				break Exit;
				
			default :
				mView.printMessage("1~6 사이의 메뉴를 입력하세요.");
			}
			
			
			
			
			
		}
	}

}
