package com.kh.jdbc.day03.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		
		System.out.println("=== === 회원관리 프로그램 === ===");
		System.out.println("1. 회원 전체 보기");
		System.out.println("2. 회원 아이디로 조회");
		System.out.println("3. 회원 이름으로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 >>>> ");
		int choice = sc.nextInt();
		return choice;
		}

	public void showAll(List<Member> mList) {
		System.out.println("=== === 회원 전체 조회 === ===");
		for(Member mem : mList) {
			System.out.print("아이디 : " + mem.getMemberId());
			System.out.print(", 비밀번호 : " + mem.getMemberPwd());
			System.out.print(", 이름 : " + mem.getMemberName());
			System.out.print(", 성별 : " + mem.getMemberGender());
			System.out.print(", 나이 : " + mem.getMemberAge());
			System.out.print(", 이메일 : " + mem.getMemberEmail());
			System.out.print(", 전화번호 : " + mem.getMemberPhone());
			System.out.print(", 주소 : " + mem.getMemberAddress());
			System.out.print(", 취미 : " + mem.getMemberHobby());
			System.out.println(", 가입일 : " + mem.getMemberDate());
			System.out.println();
		}
	}
	
	public void showOne(Member member) {
		System.out.print("아이디 : " + member.getMemberId());
		System.out.print(", 비밀번호 : " + member.getMemberPwd());
		System.out.print(", 이름 : " + member.getMemberName());
		System.out.print(", 성별 : " + member.getMemberGender());
		System.out.print(", 나이 : " + member.getMemberAge());
		System.out.print(", 이메일 : " + member.getMemberEmail());
		System.out.print(", 전화번호 : " + member.getMemberPhone());
		System.out.print(", 주소 : " + member.getMemberAddress());
		System.out.print(", 취미 : " + member.getMemberHobby());
		System.out.println(", 가입일 : " + member.getMemberDate());
		System.out.println();
	}
	
	public Member inputLoginInfo() {
		System.out.println("=== === 로그인 정보 입력 === ===");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		return member;
		//리턴은 한번, 하나만 가능함 / 아이디비번을 다 보내기 위해 멤버에 넣어서 리턴
	}
	
	public String inputMemberId(String message) {
		System.out.print(message + "할 아이디 입력 >> ");
		String memberId = sc.next();
		return memberId;
	}
	
	public String inputMemberName(String message) {
		System.out.println(message + "할 이름 입력 >> ");
		String memberName = sc.next();
		return memberName;
	}
	
	public Member inputMember() {
		System.out.println("=== === 회원가입 === ===");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("성별 : ");
		String memberGender = sc.next();
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		System.out.print("이메일 : ");
		String memberEmail = sc.next();
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.print("취미 : ");
		String memberHobby = sc.next();
		
		Member member = new Member(memberId, memberPwd, memberName, memberGender, memberAge
									, memberEmail, memberPhone, memberAddress, memberHobby);
		return member;
	}
	
	public Member modifyMember(String memberId) {
		Member member = new Member();
		member.setMemberId(memberId);
		System.out.print("수정할 비밀번호 입력 : ");
		String memberPwd = sc.next();
		System.out.print("수정할 이메일 입력 : ");
		String memberEmail = sc.next();
		System.out.print("수정할 전화번호 입력 : ");
		String memberPhone = sc.next();
		System.out.print("수정할 주소 입력 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		System.out.print("수정할 취미 입력 : ");
		String memberHobby = sc.next();
		
		member.setMemberPwd(memberPwd);
		member.setMemberEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);
		return member;	
	}
	
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}
	
	public void displayError(String message) {
		System.out.println("[서비스 실패]" + message);
	}
	
	
}
