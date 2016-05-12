<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>毕设管理系统</title>

		<meta name="description" content="毕设管理系统登录 " />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<link href="images/users_ico.ico" type="image/x-icon" rel="shortcut icon" />
		
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.css" />
		<link rel="stylesheet" href="plugins/fonts/font-awesome.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/ace-fonts.css" />
		
		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.css" />
		
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.css" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-rtl.css" />
		
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-ie.css" />
		<![endif]-->
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		
		<!--[if lt IE 9]>
			<script src="assets/js/html5shiv.js"></script>
			<script src="assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout blur-login">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="space-150"><br><br></div>
							<div class="center">
								<h2>
									<i class="ace-icon fa fa-windows blue"></i>
									<span class="red"></span>
									<span class="white" id="id-text2">毕设管理系统</span>
								</h2>
							</div>
	
							<div class="space-150"><br><br><br></div>
	
							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i> 请输入登录信息
											</h4>
											<div class="space-8"></div>
											<form id="form_login" method="post" action="<%=basePath %>/user/login">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control check" required="required" name="code" id="adminName" placeholder="工号或学号" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control check" required="required" name="password" id="adminPassword" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
	
													<div class="space"></div>
	
													<div class="clearfix">
	
														<button id="btnlogin" type="submit" class="width-35 pull-right btn btn-primary" data-loading-text="登录..." autocomplete="off">
															<span class="bigger-110">登录 </span>
														</button>
													</div>
	
													<div class="space-4"></div>
												</fieldset>
											</form>
										</div>
										<!-- /.widget-main -->
										<div class="toolbar clearfix">
											<div class="center">
												<a href="javacript:void(0)" data-target="#signup-box" class="user-signup-link">注册</a>
											</div>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.login-box -->
	
								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="ace-icon fa fa-key"></i> 重置密码
											</h4>
	
											<div class="space-6"></div>
											<p>输入你重置密码的邮箱</p>
	
											<form id="mailForm" method="post" action="<%=basePath %>admin/adminMailSumit">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input onblur="checkEmail(this)" onkeyup="checkEmail(this)" type="email" class="form-control required" placeholder="重置密码的电子邮箱" name="email"/>
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
	
													<div class="clearfix">
														<button disabled id="btnSend" type="submit" class="width-35 pull-right btn btn-sm btn-danger">
															<span class="bigger-110">发送</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div>
										<!-- /.widget-main -->
	
										<div class="toolbar center">
											<a href="javascript:void(0)" data-target="#login-box" class="back-to-login-link">
												返回登录
											</a>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.forgot-box -->
	
								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i> 注册
											</h4>
	
											<div class="space-6"></div>
											<p>输入你的详细信息以注册：</p>
	
											<form  method="post" action="<%=basePath %>/user/register ">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="code" type="number" required="required" class="form-control" placeholder="工号或学号" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="name" type="text" required="required" class="form-control" placeholder="名字" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="phone" type="phone" required="phone" class="form-control" placeholder="联系方式" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="password" type="password" required="required" class="form-control" placeholder="密码" />
															<i class="ace-icon fa fa-lock"></i>
														</span> 
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input name="repassword" type="password" class="form-control" required="required" placeholder="重复密码" />
															<i class="ace-icon fa fa-retweet"></i>
															</span>
														</label>
													<div class="control-group">
														<input name="roleId" type="radio" class="ace" value="1"/>
														<span class="lbl"> 学生 </span>
														<input name="roleId" type="radio" class="ace" value="3"/>
														<span class="lbl"> 老师</span>
														<input name="roleId" type="radio" class="ace" value="4"/>
														<span class="lbl"> 辅导员</span>
													</div>
													<div class="space-24"></div>
													<div class="clearfix">
														<button type="reset" class="width-45 pull-left btn btn-sm btn-info">
															<span class="bigger-110">重置</span>
														</button>
	
														<button type="submit" style="margin-left: 10px" class="width-45 pull-right btn btn-sm btn-success">
															<span class="bigger-110">注册</span>
														</button>
													</div>
												</fieldset>
											</form>
										</div>
	
										<div class="toolbar center">
											<a href="javascript:void(0)" data-target="#login-box"
												class="back-to-login-link"> <i
												class="ace-icon fa fa-arrow-left"></i> 返回登陆 </a>
										</div>
									</div>
									<!-- /.widget-body -->
								</div>
								<!-- /.signup-box -->
							</div>
							<!-- /.position-relative -->
	
							<div class="navbar-fixed-top align-right">
								<br /> &nbsp; 
								<a id="btn-login-dark" href="javascript:void(0)">黑色</a> &nbsp; 
								<span class="blue">/</span> &nbsp; 
								<a id="btn-login-blur" href="javascript:void(0)">蓝色</a> &nbsp; 
								<span class="blue">/</span> &nbsp; 
								<a id="btn-login-light" href="javascript:void(0)">高亮</a> &nbsp; &nbsp; &nbsp;
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.main-content -->
		</div>
		<!-- /.main-container -->
	
		<!-- basic scripts -->
	
		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery
					|| document.write("<script src='assets/js/jquery.js'>"
							+ "<"+"/script>");
		</script>

		<!-- <![endif]-->
	
		<!--[if IE]>
			<script type="text/javascript">
			 window.jQuery || document.write("<script src='assets/js/jquery1x.js'>"+"<"+"/script>");
			</script>
		<![endif]-->
		<script type="text/javascript">
			if ('ontouchstart' in document.documentElement)
				document.write("<script src='assets/js/jquery.mobile.custom.js'>"
						+ "<"+"/script>");
		</script>
		<script type="text/javascript" src="assets/js/jquery.gritter.js"></script>
		<script src="assets/js/jquery-ui.custom.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.js"></script>
		<script src="assets/js/bootbox.js"></script>
		<script src="assets/js/jquery.validate.js"></script>
		<script src="assets/js/jquery.easypiechart.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/jquery.validate.min.js"></script>
		<script src="assets/js/jquery.metadata.js"></script>
		<script src="<%=basePath %>js/validate_message.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">	
			function formCheck(){
				var input=$(".check");
				for(var i=0;i<input.length;i++){
					var item=input[i];
					if(item.value!=""){
						if(i==input.length-1){
							$("#btnlogin").attr("disabled",false);
						}else{
							continue;
						}
					}else{
						$("#btnlogin").attr("disabled",true);
						break;
					}
				}
			}
			function checkEmail(obj){
		    	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		    	var email=$.trim(obj.value);
		    	if(!reg.exec(email)){
					obj.focus();
					$("#btnSend").attr("disabled",true);
					return false;
		    	}
		    	$("#btnSend").attr("disabled",false);
		    	return true;
		    }
			$(function() {
				$(".check").keyup(function(){
					formCheck();
				});
				if("${requestScope.errors}"!=""){
					if("${requestScope.errors}"=="修改成功！"){
						$.gritter.add({
									title : "操作成功!",
									text : "${requestScope.errors}",
									sticky : false,
									time : 3000,
									speed : 10,
									position : "center",
									class_name : "gritter-success"
						});
					}else{
						$.gritter.add({
									title : "出错啦!",
									text : "${requestScope.errors}",
									sticky : false,
									time : 3000,
									speed : 10,
									position : "center",
									class_name : "gritter-light"
						});
					}
					if("${requestScope.errors}".lastIndexOf("邮箱", 0)!=-1){
						$("#login-box").removeClass("visible");
						$("#forgot-box").addClass("visible");
					}
				}
				$("[rel=drevil]").popover(
					{
						trigger : "manual",
						placement : "bottom", //placement of the popover. also can use top, bottom, left or right
						title : '<div style="text-align:center; color:red; text-decoration:underline; font-size:14px;"> Muah ha ha</div>', //this is the top title bar of the popover. add some basic css
						html : 'true', //needed to show html of course
						content : '<div id="popOverBox"><img src="http://www.hd-report.com/wp-content/uploads/2008/08/mr-evil.jpg" width="251" height="201" /></div>', //this is the content of the html box. add the image here or anything you want really.
						animation : false
					}).on("mouseenter",function() {
										var _this = this;
										$(this).popover("show");
										$(this).siblings(".popover").on("mouseleave",function() {
												$(_this).popover("hide");
										});
								}).on("mouseleave", function() {
														var _this = this;
														setTimeout(function() {
															if (!$(".popover:hover").length) {
																$(_this).popover("hide");
															}
														}, 100);
				});
			});
			$(document).ready(function() {
				$("#form_login").validate();
				$("[data-toggle='popover']").popover();
				$("#gritter-notice-wrapper").mouseleave(function() {
					$("#btnlogin span").html("登录");
					$("#btnlogin").removeClass("disabled");
					$("gritter-notice-wrapper").remove();
				});
			});
	
			jQuery(function($) {
				$(document).on("click", ".toolbar a[data-target]", function(e) {
					e.preventDefault();
					var target = $(this).data("target");
					$(".widget-box.visible").removeClass("visible");//hide others
					$(target).addClass("visible");//show target
				});
			});
	
			//you don't need this, just used for changing background
			jQuery(function($) {
				$("#id-text").attr("class", "white");
				$("#id-company-text").attr("class", "light-blue");
				
				$("#btn-login-dark").on('click', function(e) {
					$('body').attr('class', 'login-layout');
					$('#id-text2').attr('class', 'white');
					$('#id-company-text').attr('class', 'blue');
					e.preventDefault();
				});
				$("#btn-login-light").on('click', function(e) {
					$('body').attr('class', 'login-layout light-login');
					$('#id-text2').attr('class', 'grey');
					$('#id-company-text').attr('class', 'blue');
					e.preventDefault();
				});
				$("#btn-login-blur").on('click', function(e) {
					$('body').attr('class', 'login-layout blur-login');
					$('#id-text2').attr('class', 'white');
					$('#id-company-text').attr('class', 'light-blue');
					e.preventDefault();
				});
	
			});
		</script>
	</body>
</html>

