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
             <td>角色名称 </td>
              <td>角色信息描述 </td> 
              <td>操作</td>
          </tr>
          <c:forEach items="${roleList}"  var="role">
           <tr>
           <td> ${role.rolename} </td>
           <td> ${role.description}</td>
           <td>
                <a href="toRoleList.action?param=toUpdatePrivilege&id=${role.id}">分配权限</a>
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