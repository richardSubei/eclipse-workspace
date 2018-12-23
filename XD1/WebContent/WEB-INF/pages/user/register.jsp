<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../base/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="${ctx }/css/amazeui.min.css" />
		<script type="text/javascript" src="${ctx }/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${ctx }/js/amazeui.min.js"></script>
		<link rel="stylesheet" href="${ctx }/css/regedit.css" />
		<link rel="stylesheet" href="${ctx }/css/sui.css" />
		<script type="text/javascript" src="${ctx }/js/sui.js"></script>
		<title>许多零食注册</title>
		<style>
				.bottomLine{
				border-bottom: 1px solid #ccc;
				border-top: 1px solid #ccc;
				padding-top:8px;
				/*padding-bottom:10px;*/
				
			}
			.bot {
				margin-bottom: 50px;
				/*text-align: center;*/
				color: #7b6f5b;
			}
			
			.radio-pretty.checked > span:before {
				color: #f88600;
			}
			
			input {
				height: 62px;
			}
				.radio-pretty span:before {
		    margin-right: 2px;
		    vertical-align: -4px;
		    font-size: 20px;
		    color: #bdbdbd;
		    margin-left: -2px;
		}
		</style>
		<script type="text/javascript">
			var smsCode = "";	
			//检查手机号码格式
			function checkPhone(){ 
				var userPhone = document.getElementById("userPhone").value;
    			if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(userPhone))){
    				document.getElementById("showPhoneTips").style.display = "block";
        			document.getElementById("userPhone").focus(); 
        			return false; 
    			} else {
    				document.getElementById("showPhoneTips").style.display = "none";
    			} 
			} 	
			//ajax请求短信验证码
			function sendSmsCode() {
				var userPhone = document.getElementById("userPhone").value;
				var loader = new net.AjaxRequest("${ctx }/sendSmsCode.action" , dealSmsCode, onerror, "POST", "userPhone=" + userPhone);	
			}
			//请求成功
			function dealSmsCode() {
				smsCode = this.req.responseText;
			}
			//ajax请求失败
			function onerror() {
				alert("啊哦，出错了，请重新再试一遍吧");
			}
			//校验验证码输入是否正确
			function checkSmsCode() {
				var inputSmsCode = document.getElementById("inputSmsCode");
				var smsCodeInput = inputSmsCode.value;
				if(smsCode != smsCodeInput && smsCode != "") {
					document.getElementById("showSmsTips").style.display = "block";
					inputSmsCode.focus();
				} else {
					document.getElementById("showSmsTips").style.display = "none";
				}	
			}
			//去设置用户信息
			function toSetUserMessage() {
				document.getElementById("setUserMessage").click();
			}
			//ajax提交表单
			function submitForm() {
				$.ajax({
	                cache: true,
	                type: "POST",
	                url: "register.action",
	                data:$('#userForm').serialize(),
	                async: false,
	                error: function(request) {
	                    alert("Connection error");
	                },
	                success: function(data) {
	                    /* var result = this.req.responseText;
	                    alert(result); */
	                    document.getElementById("registerSuccess").click();
	                    var userName = document.getElementById("userName").value;
	                    document.getElementById("successTips").innerHTML = userName + "注册成功";
	                }
	            });
			}
			
			function toLogin() {
				window.location.href = "${ctx }/toLogin.action";
			}
		</script>
	</head>

	<body>
		<div class="am-g" style="margin-top: 25px;">
			<div class="logo"> <img src="img/logo.png" /> </div>
		</div>
		<div class="am-g">
			<div  style="width: 999px;margin: 0 auto;font-size: 14px;"> <span style="float: right;color: #333333;">我已注册，马上<span style="color: #F88600;">登录</span></span>
			</div>
		</div>
		<form action="register.action" method="post" id="userForm">
		<div class="am-g content" style="margin-top: 12px;">
			<div data-am-widget="tabs" class="am-tabs am-tabs-d2">
				<ul class="am-tabs-nav am-cf" style="margin-top: 74px;">
					<li class="" style="max-width: 95px; margin-left: 100px;"></li>
					<li class="am-active"><a href="[data-tab-panel-0]"><span class="am-badge am-round am-badge-warning-active "style="vertical-align: middle;margin-top:-4px;">1</span>设置登录名</a></li>
					<li class=""><a href="[data-tab-panel-1]" id="setUserMessage"><span class="am-badge  am-round"style="vertical-align: middle;margin-top:-4px;">2</span>设置用户信息</a></li>
					<li class=""><a href="[data-tab-panel-2]" id="registerSuccess"><span class="am-badge  am-round"style="vertical-align: middle;margin-top:-4px;">3</span>注册成功</a></li>
					<li class="" style="    max-width: 95px;margin-right: 100px;"></li>
				</ul>
				
				<div class="am-tabs-bd" style="margin-top: 59px;margin-left: -20px;">
					<div data-tab-panel-0 class="am-tab-panel am-active">
						<div class="am-g">
							<div class="am-u-sm-7 am-u-sm-offset-3 "> <span class="left1"></span> <input type="text" id="userPhone" name="userPhone" onblur="checkPhone" placeholder="请输入您的手机号" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 528px" /> </div>
							<div class="am-u-sm-1 am-u-end" style="padding: 10px;"> <span class="right" style="display: none;"></span> </div>
						</div>
 						<span id="showPhoneTips" style="display: none; margin-left:30%">请输入正确的手机格式</span>
						<div class="am-g" style="margin-top: 37px;">
							<div class="am-u-sm-4 am-u-sm-offset-3" style="padding-right: 0rem;"> <span class="left2"></span><input id="inputSmsCode" onblur="checkSmsCode()" type="text" placeholder="请输入短信验证码" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 55px;width: 360px;" /> </div>
							<div class="am-u-sm-3 am-u-end" style="padding-left: 0rem;"> <button type="button" id="send" class="am-btn am-btn-default" style="width: 190px; float: left;height: 62px;" onclick="sendSmsCode()">获取短信验证码</button> </div>
						</div>
 						<span id="showSmsTips" style="display: none; margin-left:30%">验证码输入错误</span>

						<div class="am-g" style="margin-top:50px;">
							<div class="am-u-sm-7 am-u-sm-offset-3 "> <button type="button" onclick="toSetUserMessage()" class="am-btn am-btn-warning" style="width: 528px;padding: 20px;border: 1px rgba(187, 187, 187, 0.5) solid;"><font style="font-size: 20px;font-weight: bold;">下一步</font></button> </div>
						</div>
					</div>
					<!--设置用户信息-->
					<div data-tab-panel-1 class="am-tab-panel ">
						<div class="am-g">
							<div class="am-u-sm-6 am-u-sm-offset-3 "> <span class="left3"></span> <input type="text"  id="userName" name="userName" placeholder="给自己起一个零食界的外号吧" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 59px;width: 100%" /> </div>
						</div>
						<div class="am-g" style="margin-top: 36px;">
							<div class="am-u-sm-6 am-u-sm-offset-3 "> <span class="left3"></span> <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 59px;width: 100%" /> </div>
						</div>
						<div class="am-g" style="margin-top: 36px;">
							<div class="am-u-sm-6 am-u-sm-offset-3 "> <span class="left3"></span> <input type="password" id="rePassword" placeholder="请再次输入密码" class="am-form-field" style="margin: auto;display: block;float: left;padding-left: 59px;width: 100%" /> </div>
						</div>
						<div class="am-g" style="margin-top: 21px;">
							<!-- <form class="sui-form"> -->
								<div class="am-u-sm-7 am-u-sm-offset-3" style="padding-right: 0rem;"> <label class="checkbox-pretty inline checked"> <input type="checkbox" checked="checked"><span style="font-size: 12px;color: #878787;">同意<a>《许多零食家的协议》</a> <a>《支付宝协议》</a></span> </label> </div>
							<!-- </form> -->
						</div>
						<div class="am-g" style="margin-top: 58px;margin-bottom: 80px;">
							<div class="am-u-sm-6 am-u-sm-offset-3 "><input type="button" onclick="submitForm()" class="am-btn am-btn-warning" style="width: 100%;height: 62px;font-size: 20px;font-weight: bold;border: 1px rgba(187, 187, 187, 0.5) solid;" value="确认"/></div>
						</div>
					</div>
					<!--成功-->
					<div data-tab-panel-2 class="am-tab-panel ">
						<!--<div class="am-g"> <div class="am-u-sm-12" style="text-align: center;"> <img src="img/lion.png" /> </div> </div>-->
						<div class="am-g" style="margin-top: 90px;">
							<div class="am-u-sm-6 am-u-sm-offset-3 " style="    text-align: center;">
								<h2 id="successTips" style="color: #8F8F8F;font-size: 20px;"></h2> </div>
						</div>
						<div class="am-g" style="line-height:14px;margin-top: 12px;">
							<div class="am-u-sm-6 am-u-sm-offset-5 "> <a style="font-size: 14px;color: #4689cb;margin-top: 4px;">买啦赠送您50买豆，点击查看</a> </div>
						</div>
						<div class="am-g" style="margin-top: 176px;margin-bottom: 124px;">
							<div class="am-u-sm-6 am-u-sm-offset-3 "> <button type="button" onclick="toLogin()" class="am-btn am-btn-warning" style="width: 100%;height: 62px;font-size: 20px;font-weight: bold;border: 1px rgba(187, 187, 187, 0.5)B solid;">完成</button> </div>
						</div>
					</div>
				</div>
		
			</div>
		</div>
		</form>
			<div class="am-g " style="margin-top: 81px;text-align: center;font-size: 12px;">
			<div class="bottomLine" style="margin:0 auto;width:700px;height: 35px;">
			<span style="float: left;word-spacing:0.52rem;    text-align: center;    width: 100%;">关于我们 | 联系我们 | 商家入驻 | 友情链接 | 站点地图 | 手机商城 | 销售联盟 | 商城社区 | 企业文化 | 帮助中心 
			</span>
			</div>
	    </div>	
			<div class="am-g">
			<div class="bot ">
				<div  style="margin:0 auto;width:700px;height: 30px;">
				<p style="font-size: 12px;float: left;">© &nbsp;2005-2016 买啦网 版权所有 ，并保留所有权利 <span style="margin-left: 30px;">买啦 Tel ：4008125181 </span><span style="margin-left: 30px;">E-mai：maila@163.com</span> </p>
			</div>
			</div>
		</div>
	</body>

</html>