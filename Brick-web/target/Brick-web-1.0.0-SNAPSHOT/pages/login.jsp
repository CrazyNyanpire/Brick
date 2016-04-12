<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <%--<%@include file="/commons/metas.jsp"%>--%>
        <title>设备管理</title>
        <%@include file="/commons/statics.jsp"%>
<link rel="stylesheet" href="/css/animate.min.css">
<style type="text/css">
*   .* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0;
	padding: 0;
	background-image:url(/images/background/background.png);
	background-repeat: no-repeat;
  	background-size: 100%;
}
.logo {
  width: 84%;
  margin: 0 auto;
  margin-top: 4%;
}

.logo img {
	width: 160px;
	overflow: hidden;
}
#loginFormId{
  position: absolute;
  top: 25%;
  right: 11%;;
  width: 370px;
  height: 330px;
  background-color: hsla(0, 0%, 100%, 0.6);
  border-radius: 10px;
  /*box-shadow: 0px 0px 10px #fff;*/
  border:1px solid #ddd;
  z-index:10;
}
#loginFormId input{
	  width: 100%;
	  height: 45px;
	  font-size: 18px;
	  font-weight: bold;
	  color: #777;
}
#loginFormId button,form-group{
	height:50px;
}
#fugai{
	  width: 100%;
	  height:450px;
	  background-image: url(/images/background/background.png);
	  background-size: 100%;
	  background-repeat: no-repeat;
	  filter: blur(10px);
	  -webkit-filter: blur(10px);
	  background-position: 30%,0,0,0;
	  z-index: -1;
	  margin-top: 1%;
}
#article{
	position:absolute;
	z-index:10;
	font-family: 微软雅黑;
	top: 36%;
  	left: 10%;
}
.input-group-addon,.form-control{
	border-radius: 0px;	
}
@media (min-width: 1400px) {
#fugai{
  height:600px;
  background-position-y: 33%;
}
#loginFormId{
	right:17%;
}
#article{
	left: 11%;
}
}
</style>
<script type = "text/javascript">
var contextPath = '${pageContext.request.contextPath}';
(function($) {
	$.fn.typewriter = function() {
		this.each(function() {
			var $ele = $(this), str = $ele.html(), progress = 0;
			$ele.html('');
			var timer = setInterval(function() {
				var current = str.substr(progress, 1);
				if (current == '<') {
					progress = str.indexOf('>', progress) + 1;
				} else {
					progress++;
				}
				$ele.html(str.substring(0, progress) + (progress & 1 ? '_' : ''));
				if (progress >= str.length) {
					clearInterval(timer);
				}
			}, 75);
		});
		return this;
	};
})(jQuery);
</script>
</head>
<% response.setHeader("login","login"); %>
<body>
<div>
	<div class="head login"></div>
	<div class="logo">
		<img src="images/logo.png"/>
	</div>
	<div id="article">
		<p style="color:#3399cc;font-size:40px;">设备管理系统</p>
		<p style="color:#FFF;;font-size:30px;">Equipment Manage System</p>
	</div>
	<FORM id="loginFormId" class="form-horizontal" action="login" method="post">
		<div class="form-group input-group" style="width: 76%;margin: 0 auto;margin-top: 16%;">
                  <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                  <input type="text" class="form-control" placeholder="userName"  name="username" id="j_username" value="">
		</div>
              <div class="form-group input-group" style="width: 76%;margin: 0 auto;margin-top: 4%;">
                  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                  <input type="password" name="password" id="j_password" class="form-control" placeholder="passWord" value=""/>
              </div>
                            <div class="form-group input-group" style="width: 76%;margin: 0 auto;">
<p style="color: crimson;">默认密码为888888</p>
              </div>
		<div class="form-group input-group" style="width: 76%;margin: 45px auto;">
			<button type="button"  style="font-size:20px!important;border-radius: 0px;" class="btn btn-primary btn-block" id="loginBtn">LOGIN</button>
		</div>
	</FORM>
	<div id="fugai">
	</div>
	<script>
    $(function(){
    	$("#article").typewriter();
    	$("#loginFormId").addClass('animated flipInY');
     	var btnLogin = $('#loginBtn');
    	var form = $('#loginFormId');
        $('body').keydown(function(e) {
            if (e.keyCode == 13) {
            	dologin();
            }
        });
        btnLogin.on('click',function() {
        	dologin();
        });
        
	    var dologin = function() {
	        var userNameElement = $("#j_username");
	        var passwordElement = $("#j_password");
	        var username = userNameElement.val();
	        var password = passwordElement.val();
	        if (!Validation.notNull($('body'), userNameElement, username, '用户名不能为空')) {
	            return false;
	        }
	        if (!Validation.notNull($('body'), passwordElement, password, '密码不能为空')) {
	            return false;
	        }
	        btnLogin.attr('disabled', 'disabled').html('Is landing...');
    		var param = form.serialize();
        	$.ajax({
        		url: contextPath+"/login.koala",
        		dataType: "json",
        		data: param,
        		type: "POST",
        		success: function(data){
        			if(data.success){
/*         				$('#loginFormId').message({
        					type: 'success',
        					content:  '登录成功！'
        				}); */
        				window.location.href=contextPath+"/index.koala";
        			}else{
        				btnLogin.removeAttr('disabled').html('登录');
        				$('#loginFormId').message({
        					type: 'error',
        					content: data.errorMessage
        				});
        				refreshCode();
        			}
        		}
        	});
		};
		});
		
		function refreshCode() {
			$("#checkCode").attr("src","jcaptcha.jpg?time="+new Date().getTime());
		}
		
	</script>
	</div>
</body>
</html>
