<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 가입</h1>

	<!-- form : 양식이 제출될 때 보낼 URL 과 
	데이터를 전송할 HTTP 메서드를 지정하는것.
	 -->
  <form action="/el_jstl2" method="POST">
    <table>
      <tr>
        <td>아이디 : </td>
        <td><input type="text" name="inputId"></td>
      </tr>
      <tr>
        <td>비밀번호 : </td>
        <td><input type="password" name="inputPw"></td>
      </tr>
      <tr>
        <td>비밀번호 확인 : </td>
        <td><input type="password" name="inputPwCheck"></td>
      </tr>
      <tr>
        <td>이름 : </td>
        <td><input type="text" name="inputName"></td>
      </tr>
      <tr>
        <td>나이 : </td>
        <td><input type="number" name="inputAge"></td>
      </tr>
      <tr>
        <td></td>
        <td><button type="submit">회원 가입</button></td>
      </tr>

    </table>
  </form>
  
</body>
</html>