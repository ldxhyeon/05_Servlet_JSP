<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>html문서 제목</title>
</head>
<body>
   <h3>page : ${pageValue}</h3>
  <h3>request : ${requestValue}</h3>
  <h3>session : ${sessionValue}</h3>
  <h3>application : ${applicationValue}</h3>
</body>
</html>