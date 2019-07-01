<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
  table{
	  width:30%;
	  border:1px solid #F00;
	  margin:15%  auto;
	  padding:5px;
  }
  table tr td{
    padding :5px;
    text-aligh:center;
  }
</style>
</head>

<body>
    <form action="" method="post">
     <table >
         <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" id="username" placeholder="请输入邮箱"/> 
            </td>
            <td id="resultUsername"></td>
         </tr>
         <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password" id="password" placeholder="请输入密码"/> 
            </td>
            <td id="resultPassword"></td>
         </tr>
         <tr>
            <td colspan=2 align=center>
                <input type="button"  value="提交"/> 
            </td>
         </tr>
     </table>
     </form>
</body>
<script type="text/javascript">
	$(function(){
		var message = "${message}";
		if(message.length>0){
			alert(message);
		}
		var flag1=false;
		$("input[name='username']").blur(function () {
			 if($(this).val() == "" || $.trim($(this).val()).length == 0){
				 $("#resultUsername").html("邮箱不能为空！");
				  $("#resultUsername").css("color","red");
				  flag1=false;
			 }else{
				 $("#resultUsername").html("");
				 flag1=true;
			 }
			 
		}).focus(function () {
			$(this).val("");
			$("#resultUsername").html("");
		});
		var flag2=false;
		$("input[name='password']").blur(function () {
			 if($(this).val() == "" || $.trim($(this).val()).length == 0){
				 $("#resultPassword").html("密码不能为空！");
				  $("#resultPassword").css("color","red");
				  flag2=false;
			 }else{
				 $("#resultPassword").html("");
				 flag2=true;
			 }
		}).focus(function () {
			$(this).val("");
			$("#resultPassword").html("");
		});
		
		
		$("input[type='button']").click(function () {
			if(flag1 &&flag2){
				$("form").attr("action","doUserLogin.action?param=login");
				$("form").submit();
			}
		});
	});
</script>
<script language="javascript">
        //防止页面后退
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
 </script>
</html>