package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentDAO {
	
	public List selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STUDENT";
		String password = "STUDENT";
		String sql = "SELECT * FROM STUDENT_TBL";
		Student student = null;
		List<Student> sList = null;
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DB 연결 생성
			Connection conn = DriverManager.getConnection(url, user, password);
			//3. 쿼리문 실행준비(Statement 생성)
			Statement stmt = conn.createStatement();
			//4. 쿼리문 실행 및 결과 받기
			ResultSet rset = stmt.executeQuery(sql);		//executeQuery 사용
			sList = new ArrayList<Student>();	//배열 할당(공간 만들어줌)
			//후처리
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("Student_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setAge(rset.getInt("AGE"));			//getInt 주의!!!!!!!!
				student.setGender(rset.getString("GENDER"));
				student.setPhone(rset.getString("PHONE"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setEmail(rset.getString("EMAIL"));
				student.setHobby(rset.getString("HOBBY"));			
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
				sList.add(student);
			}
			//6. 자원해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList; 	//리턴타입 void 자리에!
	}
	
	
	public int insertMember(Student student) {
		
		//1. 드라이버 등록
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "STUDENT";
		String password = "STUDENT";
		String sql = "INSERT INTO STUDENT_TBL VALUES('"+student.getStudentId()+"','"+student.getStudentPwd()+"','"+student.getStudentName()+"','"+student.getGender()+"',"+student.getAge()+","
				+ "'"+student.getEmail()+"','"+student.getPhone()+"','"+student.getAddress()+"','"+student.getHobby()+"',SYSDATE)";
		//'N' 문자열 , '"+N+"' 변수
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			
			//쿼리문 실행 - DML(insert)
			result = stmt.executeUpdate(sql); 	//중요! executeUpdate는 int로 받는다
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
