<%@page import="projectD.ProjectDTO"%>
<%@page import="projectD.ProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");
String num = request.getParameter("num");
ProjectDAO dao = new ProjectDAO();
ProjectDTO dto = new ProjectDTO(Integer.parseInt(num), writer, title, content, null, 0);

dao.updateCommunity(dto);
response.sendRedirect("list.jsp");
%>
