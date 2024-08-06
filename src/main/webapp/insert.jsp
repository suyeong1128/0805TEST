<%@page import="projectD.ProjectDTO"%>
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
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

ProjectDAO dao = new ProjectDAO();
ProjectDTO dto = new ProjectDTO(writer, title, content);
dao.insertCommunity(dto);
response.sendRedirect("list.jsp");
%>
</body>
</html>