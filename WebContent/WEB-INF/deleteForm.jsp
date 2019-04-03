<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gb" method="post">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
				<td><a href="./addlist.jsp">메인으로 돌아가기</a></td>
			</tr>
		</table>
		<input type='text' name="a" value="delete">
		<input type='text' name="no" value="<%=request.getParameter("no")%>">
	</form>
</body>
</html>