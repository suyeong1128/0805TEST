<%@page import="projectD.ProjectDAO"%>
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
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String ssn  = request.getParameter("ssn");
String phone = request.getParameter("phone");
ProjectDAO dao = new ProjectDAO();

boolean registrationSuccess = dao.memberJoin(name, ssn, phone);

if (registrationSuccess) {
    out.println("<script type='text/javascript'>");
    out.println("alert('회원가입 성공! 환영합니다, " + name + "');");
    out.println("window.location.href = 'login.jsp';"); // 로그인 페이지로 리다이렉트
    out.println("</script>");
} else {
    out.println("<script type='text/javascript'>");
    out.println("alert('회원가입 실패! 다시 시도해 주세요.');");
    out.println("window.location.href = 'register.jsp';"); // 회원가입 페이지로 리다이렉트
    out.println("</script>");
}
%>
</body>
</html>