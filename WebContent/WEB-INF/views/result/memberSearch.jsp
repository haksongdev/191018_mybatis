<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>조회</title>
</head>
<body>

<h3>회원 정보 검색 </h3>
${error}
<form action="memberSearch.do" method="post">
   ID : <input type="text"  name="id" />
  <input type="submit"  value="검색" />
  <input type="hidden" name="job" value="search" />
</form>
<h3>검색 결과</h3>
	
	<%
	    String result = (String)request.getAttribute("result");
	    if(result!=null) {
	    	out.print(result+"<p>");
	    }else{
	%>
		    <h3>
			${member.id } / ${member.passwd } / ${member.name } / ${member.mail }
			</h3>
    <%} %>
    
    <%@ include file="home.jsp" %>
</body>
</html>