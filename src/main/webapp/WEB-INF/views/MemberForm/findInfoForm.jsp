<!-- findInfoForm.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/"/>
<center>
<form action="${home }membership/findInfoProc" method="post">
<table>
	<c:set var="btnName" value="아이디 검색"/>
	<c:if test='${path eq "/membership/searchPW" }'>
		<c:set var="btnName" value="패스워드 검색"/>
		<tr>
			<td>ID : </td>
			<td><input type=text name='id' placeholder='id 입력'/></td>
		</tr>
	</c:if>
	<tr>
		<td>이메일 : </td>
		<td><input type=text name='email' placeholder='email 입력'/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="${btnName }"/>
		</td>
	</tr>
</table>
</form>
</center>










