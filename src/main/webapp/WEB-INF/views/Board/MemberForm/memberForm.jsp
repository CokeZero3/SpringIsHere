<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/"/>
<script type="text/javascript">
function SearchPostCode(url) {
	window.name = "우편번호 검색";
	window.open(url, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");	
}
</script>
<center>
<h3><font color="red">${msg }</font> </h3>

<!-- 인증번호 확인 추후 삭제 -->
세션정보 : ${sessionInfo }<br/>
인증 번호 : ${sessionInfo.authNum }
<form action="${home }membership/memberProc" method="post">
<table>
	<tr><td colspan="4" align="center"><hr/>필수사항<hr/></td></tr>
	<tr>
		<td align='right' height=40>아이디</td>
		<td>
			<input type=text name='id' placeholder='id 입력' value="${member.id }"/> 
		</td>
		<td colspan="2"><button formaction="${home }membership/isExistID">중복 확인</button></td>
	</tr>
	<tr>
		<td align='right' height=40>패스워드</td>
		<td>
			<input type=text name='pw' placeholder='pw 입력' value="${member.pw }"/> 
		</td>
		<td align='right'>패스워드 확인</td>
		<td>
			<input type=text name='pwOk' placeholder='pw 입력'/> 
		</td>
	</tr>
	<tr>
		<td align='right' height=40>E-Mail</td>
		<td>
			<input type=text name='email' placeholder='E-Mail 입력' value="${member.email }"/> 
		</td>
		<td colspan="2"><button formaction="${home }membership/reqAuthNum">인증번호 전송</button></td>
	</tr>
	<tr>
		<td align='right'>인증번호</td>
		<td>
			<input type=text name='authNum' placeholder='인증번호 입력'/> 
		</td>
		<td colspan="2"><button formaction="${home }membership/authNumConfirm">인증번호 확인</button></td>
	</tr>
	<tr><td colspan="4" align="center"><hr/>선택사항<hr/></td></tr>
	<tr>
		<td align='right'>우편번호</td>
		<td>
			<input type=text id="zipcode" name='zipcode' readonly="readonly" value="${member.zipcode }"/> 
		</td>
		<td colspan="2"><input type="button" onclick="SearchPostCode('${home}membership/searchPostCode');" value="우편번호 검색"/></td>
	</tr>
	<tr>
		<td align='right'>주소</td>
		<td colspan="3">
			<input type=text id='addr1' name='addr1' value="${member.addr1 }" readonly="readonly" style="width: 475px; "/> 
		</td>
	</tr>
	<tr>
		<td align='right'>상세주소</td>
		<td colspan="3">
			<input type=text name='addr2' value="${member.addr2 }" style="width: 475px; "/> 
		</td>
	</tr>
	<tr>
		<td align='right' width=120>성 별</td>
		<td colspan="3">
		<c:set var="mchk" value=""/>
		<c:set var="wchk" value=""/>
		<c:set var="nchk" value=""/>
		<c:choose>
			<c:when test='${member.gender eq "m" }'>
				<c:set var="mchk" value="checked"/>
				<c:set var="wchk" value=""/>
				<c:set var="nchk" value=""/>
			</c:when>
			<c:when test='${member.gender eq "w" }'>
				<c:set var="mchk" value=""/>
				<c:set var="wchk" value="checked"/>
				<c:set var="nchk" value=""/>
			</c:when>
			<c:otherwise>
				<c:set var="mchk" value=""/>
				<c:set var="wchk" value=""/>
				<c:set var="nchk" value="checked"/>
			</c:otherwise>
		</c:choose>
			<input type=radio name='gender' value='n' ${nchk }/>선택안함
			<input type=radio name='gender' value='m' ${mchk }/>남자
			<input type=radio name='gender' value='w' ${wchk }/>여자 
		</td>
	</tr>
	
	<tr>
		<td align='center' height=40 colspan=4>
			<input type=submit value='회원가입' style="width: 120px; "/>
			<input type=reset value='취소' style="width: 120px; "/>	 
		</td>
	</tr>
</table>
</form>
</center>