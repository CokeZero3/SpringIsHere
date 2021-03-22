<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
<!--
function setParentAddr1(zipcode, addr){
    opener.document.getElementById("zipcode").value = zipcode;
    opener.document.getElementById("addr1").value = addr;
    window.close();
}
//-->
</script>
<style type="text/css">
.list_over {overflow:auto;  background-color:pink; }
.list_out { background-color:#FFFFFF; }
</style>

</head>
<body>
<form action="${home }membership/searchZipcode" method="post">
<h3>
	동면<input type="text" name="addr"/>
	<input type="submit" value="우편번호 검색"/>
</h3>
</form>

<br/>
<c:forEach var="zip" items="${zipcodeLst }">
<c:set var="zipcode" value="${zip.zipcode }"/>
<c:set var="address" value="${zip.sido } ${zip.sigungu } ${zip.ubmyeun } ${zip.dong1 } ${zip.dong2 } ${zip.ri }"/>
<div onmouseover="this.className='list_over'" 
onmouseout="this.className='list_out'"
onclick="setParentAddr1('${zipcode}', '${address}');">
${zipcode} ${address }<br/>
</div>
</c:forEach>

</body>
</html>