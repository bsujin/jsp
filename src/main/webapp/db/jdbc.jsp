<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//	db작업에 필요한 객체 변수 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. DB연결 ==> Connection 객체 생성
		//	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost",user, password);
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i< 30; i++){
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "sem", "java");
		}
		
		long endTime = System.currentTimeMillis();
		out.print("duration: " + (endTime-startTime));		

	} catch (SQLException e) {
		System.out.println("잘못입력했습니다.");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {		//6. 사용했던 자원 반납하기
		if(rs!=null) { try{ rs.close(); } catch(SQLException e) { } }
		if(stmt!=null) { try{ stmt.close(); } catch(SQLException e) { } } 
		if(conn!=null) { try{ conn.close(); } catch(SQLException e) { } }
	}
	
	%>
</body>
</html>