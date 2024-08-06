<%@page import="projectD.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Process</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String ssn = request.getParameter("ssn");
	ProjectDAO dao = new ProjectDAO();
	
	if(dao.checkLogin(name, ssn)) {
		Cookie loginCookie = new Cookie("name", name);
		loginCookie.setMaxAge(60 * 60);
		response.addCookie(loginCookie);
		out.println("<script type='text/javascript'>");
		out.println("alert('환영합니다. " + name + "!')");
		out.println("window.location.href = 'index.jsp';");
		out.println("</script>");
	} else {
		out.println("<script type='text/javascript'>");
		out.println("alert('로그인 실패!');");
		out.println("window.location.href='index.jsp';");
		out.println("</script>");
	}
%>
</body>
</html>