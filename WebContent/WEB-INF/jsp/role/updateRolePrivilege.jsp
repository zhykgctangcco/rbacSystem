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
         <input type="hidden" value="${roleId}"/>
          <c:forEach items="${privilegs}"  var="privileg">
            <input  type="checkbox"  value="${privileg.id}"
              <c:forEach items="${rolePrivileges}"  var="rprivileg">
              <c:if test="${rprivileg.id==privileg.id}">
                    checked
                </c:if>
              </c:forEach>
            /> ${privileg.privilegename}<br/>
          </c:forEach>
          
          <br/><br/><br/>
               <input  type="button" value="提交"/>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="toRoleList.action?param=rolelist">返回</a>
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
			var roleId=${roleId};
			/* $("form").attr("action","toRoleList.action?param=doUpdatePrivilege&roleId="+roleId+"&str="+str);
			$("form").submit(); */
			location.href="toRoleList.action?param=doUpdatePrivilege&roleId="+roleId+"&str="+str;
		});
		

</script>
</html>