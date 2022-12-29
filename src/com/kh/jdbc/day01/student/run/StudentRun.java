package com.kh.jdbc.day01.student.run;

import java.util.List;

import com.kh.jdbc.day01.student.controller.StudentController;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day01.student.view.StudentView;

public class StudentRun {
	public static void main(String [] args) {
		StudentView sView = new StudentView();
		StudentController sCon = new StudentController();
		Student student = null;
		List<Student> sList = null;
		String studentId = "";
		String studentName = "";
		int result = 0;
		
		EXIT :
		while(true) {
			int choice = sView.mainMenu();
			switch(choice) {
			case 1 : 
				sList = sCon.printAll();
				if(!sList.isEmpty()) {
					sView.showAll(sList);
				} else {
					sView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
				
			case 2 : 
				//아이디로 조회
				studentId = sView.inputStudentId("검색");
				student = sCon.printOneById(studentId);
				if(student != null) {
					sView.showOne(student);
				} else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
				
			case 3 : 
				//이름으로 조회
				studentName = sView.inputStudentName("검색");
				sList = sCon.printAllByName(studentName);
				//sList는 항상 Null이 아니다! 값이 있는지 체크하는 메소드 isEmpty 사용
				if(!sList.isEmpty()) {
				sView.showAll(sList);
				} else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
				
			case 4 : 
				//회원 가입
				student = sView.inputStudent();
				result = sCon.registerStudent(student);
				if(result > 0) {
					sView.displaySuccess("가입 성공");
				} else {
					sView.displayError("가입 실패");
				}
				break;
				
			case 5 : 
				//회원정보 수정
				studentId = sView.inputStudentId("수정");
				student = sCon.printOneById(studentId);
				if(studentId != null) {
					student = sView.modifyStudent(student);
					sCon.modifyStudent(student);
				} else {
					sView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
				
			case 6 : 
				//회원 탈퇴
				studentId = sView.inputStudentId("삭제");
				result = sCon.removeStudent(studentId);
				if(result > 0) {
					sView.displaySuccess("탈퇴 완료");
				} else {
					sView.displayError("탈퇴 실패");
				}
				break;
				
			case 0 : 
				sView.printMessage("프로그램을 종료합니다.");
				break EXIT;
				
			default : 
				sView.printMessage("1~6 사이의 수를 입력하세요.");
				break;
			}
		}



	}

}
