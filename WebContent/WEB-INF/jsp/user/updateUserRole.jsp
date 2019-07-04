<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改权限</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
         <form action="">
         <input type="hidden" value="${userId}"/>
          <c:forEach items="${roles}"  var="role">
            <input  type="checkbox"  value="${role.id}"
              <c:forEach items="${userRoles}"  var="userRole">
              <c:if test="${userRole.id==role.id}">
                    checked
                </c:if>
              </c:forEach>
            /> ${role.rolename}<br/>
          </c:forEach>
          
          <br/><br/><br/>
               <input  type="button" value="提交"/>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="toUserList.action?param=userList">返回</a>
          </form>
</body>
<script type="text/javascript">
		$("input[type='button']").click(function(){
			var str="";
			$("input:checkbox").each(function(){
			    if($(this).is(":checked")){
			        str +=$(this).val()+","
			    }
			});
			var userId='${userId}';
			
			location.href="toUserList.action?param=doUpdateRole&userId="+userId+"&str="+str;
		});
		

</script>
</html>