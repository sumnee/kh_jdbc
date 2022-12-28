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
		
		EXIT :
		while(true) {
			int choice = sView.mainMenu();
			switch(choice) {
			case 1 : 
				sList = sCon.printAll();
				sView.showAll(sList);
				break;
			case 2 : break;
			case 3 : break;
			case 4 : 
				//회원가입
				student = sView.inputStudent();
				int result = sCon.registerStudent(student);
				if(result > 0) {
					sView.displaySuccess("회원가입에 성공하셨습니다.");
				} else {
					sView.displayError("회원가입에 실패하였습니다.");
				}
				break;
			case 5 : break;
			case 6 : break;
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
