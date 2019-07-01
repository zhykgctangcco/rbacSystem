<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看角色</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
      <table   width=90%  boder=1>
          <tr>
             <td>用户邮箱 </td>
              <td>昵称 </td> 
              <td>操作</td>
          </tr>
          <c:forEach items="${userList}"  var="user">
           <tr>
           <td> ${user.email} </td>
           <td> ${user.nickname}</td>
           <td>
                <a href="toUserList.action?param=toUpdateRole&id=${user.id}">分配角色</a>
            </td>
              </tr>
          </c:forEach>
      </table>
</body>


<script type="text/javascript">
	$(function(){
		var message = "${message}";
		if(message.length>0){
			alert(message);
		}
	});
</script>
</html>