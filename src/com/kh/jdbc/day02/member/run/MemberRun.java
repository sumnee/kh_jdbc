package com.kh.jdbc.day02.member.run;

import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		Member member = null;
		List<Member> mList =null;
		String memberId = "";
		String memberName = "";
		int result = 0;
		
		Exit : 
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 1 :
				//전체조회
				mList = mCon.printAll();
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				} else {
					mView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
				
			case 2 :
				//아이디 조회
				
				break;
			case 3 :
				//이름 조회
				
				break;
			case 4 :
				//가입
				
				break;
			case 5 :
				//수정
				
				break;
			case 6 :
				//탈퇴
				
				break;
			case 0 :
				mView.printMessage("프로그램을 종료합니다.");
				break Exit;
				
			default :
				mView.printMessage("1~6 사이의 메뉴를 입력하세요.");
			}
			
			
			
			
			
		}
	}

}
