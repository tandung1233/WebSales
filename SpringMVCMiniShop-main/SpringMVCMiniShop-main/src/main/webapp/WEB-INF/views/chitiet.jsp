<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1>Trang chi tiết ${id}</h1>
	<h1>${name}</h1> --%>
	
	<h1>Trang chi tiet</h1>
	${nv.getTenNhanVien()}<br>
	${nv.getDiaChi()}<br>
	${nv.getTuoi()}<br>
</body>
</html>