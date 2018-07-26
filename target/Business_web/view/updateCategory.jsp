<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>修改类别</h1>

	<form  action="CategoryServlet" methed="get"  >
	<input type="hidden" name = "operation"  value="3" />
	<input type="hidden" name = "id"  value="${category.id }"/>
	<table>
		
		<tr>
			<td>父类ID</td>
			<td>
			
			<select  name="parent_id" >
			<option value="${category.parent_id }">${category.parent_id }</option>
			<option value="12">12</option>
			<option value="22">22</option>
			<option value="33">33</option>
			<option value="44">44</option>
			</select>
				
			</td>		
		</tr>
		<tr>
			<td>类别名称</td>
			<td><input type="text" name="name" value="${category.name }" /></td>	
		</tr>
		<tr>
			<td>类别状态</td>
			<td><input type="text" name="status" value="${category.status }"/></td>	
		</tr>		
		<tr>
			<td>排序编号</td>
			<td><input type="text" name="sort_order" value="${category.sort_order }"/></td>	
		</tr>	
		
		
							
		<tr>
			<td><input type="submit" value="修改类别"/></td>
		</tr>
	
	</table>
	</form>
</body>
</html>