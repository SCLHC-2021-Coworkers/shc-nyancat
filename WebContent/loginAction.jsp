<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %> <!-- 넘어오는 데이터들을 모두 UTF 형식으로 -->
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 연습</title>
</head>
<body>
	<%
		UserDAO userDAO = new UserDAO();
		// 각각의 결과에 대한 값이 result에 저장됨
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		if (result == 1){ // 비밀번호가 일치할 경우
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
		}
		else if (result == 0){ // 비밀번호가 일치하지 않을 경우
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()"); // 이전페이지로 돌려보냄(login.jsp)
			script.println("</script>");
		}
		else if (result == -1){ // 아이디가 존재하지 않을 경우
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()"); 
			script.println("</script>");
		}
		else if (result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()"); 
			script.println("</script>");
		}
	%>
</body>
</html>