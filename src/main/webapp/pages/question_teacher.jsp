<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	response.setHeader("Access-Control-Allow-Origin", "*");
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
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<link href="<%=basePath %>images/users_ico.ico" type="image/x-icon" rel="shortcut icon" />
		
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/fonts/font-awesome.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jquery-ui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/chosen.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/jquery.gritter.css" />
		
		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		
		<style type="text/css">
			.div{height:34px;line-height: 34px;}
		</style>
		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/ace-ie.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="${pageContext.request.contextPath }/assets/js/ace-extra.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
			<script src="${pageContext.request.contextPath }/assets/js/html5shiv.js"></script>
			<script src="${pageContext.request.contextPath }/assets/js/respond.js"></script>
		<![endif]-->
	</head>

<body class="no-skin">
	<jsp:include page="../WebPart/Head.jsp"></jsp:include>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check("main-container", "fixed");
			} catch (e) {}
		</script>
		<jsp:include page="../WebPart/Menu.jsp"></jsp:include>
		
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check("breadcrumbs", "fixed");
						} catch (e) {}
					</script>
					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="javascript:void(0)">毕设管理系统</a>
						</li>
						<li>
							<a href="javascript:void(0)">学生提问</a>
						</li>
					</ul>
					<jsp:include page="../WebPart/SearchBox.jsp"></jsp:include>
				</div>
				<!-- 主要内容 start -->
				<div class="page-content">
					<jsp:include page="../WebPart/Skin.jsp"></jsp:include>
					<div class="row" >
						<div class="col-sm-12">
								<div class="dd" class="col-sm-12" id="nestable">
									<ol class="dd-list" id="question_content">

									</ol>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<div class="modal fade" role="dialog" id="dialogshow">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="gridSystemModalLabel">回复学生</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<!-- PAGE CONTENT BEGINS -->
									<form id="taskInfo">
									<input name="sender.id" type="hidden" value="${sessionScope.user.id }">
									<input name="receiver.id" id="receiver" type="hidden" value="">
									<input name="parentId" type="hidden" id="parentId" value="">
									<div class="space-6"></div>
									<div class="div form-group col-md-12">
										<div class="col-md-10">
											<textarea class="form-control col-xs-10 col-md-8" id="" name="content" placeholder="回复问题"></textarea>
										</div>
									</div>
									
								<div >
									<div class="space-12"></div>
									<div style="margin-left:100px;margin-top:20px;">
										<button  id="questionSave" style="margin-left:10px" class="btn btn-info col-md-3" type="button">
											提问
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<input type="hidden" id="currentId" value="${sessionScope.user.id }"> 
		<jsp:include page="../WebPart/CopyRight.jsp"></jsp:include>
	</div>
	<jsp:include page="../WebPart/Script.jsp"></jsp:include>
	<!-- page specific plugin scripts -->
	<script src="${pageContext.request.contextPath }/assets/js/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.ui.touch-punch.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.nestable.min.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	jQuery(function($) {
		//获取数据
		function load(){
			debugger;
			$.ajax({
				type:'get',
				async:false,
				data:{'receiver.id':$("#currentId").val()},
				url:"${pageContext.request.contextPath }/admin/message/page",
				success:function(data){
					debugger;
					var content=$("#question_content");
					var item="";
					if(data!=null&&data.length>0){
						for(var i=0;i<data.length;i++){
							item+="<li class=\"dd-item\">"
							+"<div class=\"dd-handle\">"
							+data[i].time+" "+data[i].sender.name+"问：<font color=\"red\">"+data[i].content+"</font> "
							+	"<a class=\"blue reply pull-right\" id=\""+data[i].id+"\"  receiver=\""+data[i].sender.id+"\" href=\"#\">"
							+		"<i class=\"fa fa-paper-plane-o bigger-130\">回复</i>"
							+	"</a>"
						+"</div>";
							var child=data[i].child;
							if(child!=null&&child.length>0){
								item+="<ol class=\"dd-list\">";
								for(var j=0;j<child.length;j++){
									item+="<li class=\"dd-item\" >"
										+"<div class=\"dd-handle\" style=\"text-align:left\">"
										+child[j].time+" "+child[j].sender.name+"回复:<font color=\"red\">"+child[j].content+"</font>"
										+"<div class=\"pull-right action-buttons\">"
										+	"<a class=\"red reply\" id=\""+child[j].id+"\" href=\"#\">"
										+	"</a>"
										+"</div>"
									+"</div>"
									+"</li>"
									
								}
								item+="</ol>";
							}
							item+="</li>";
						}
						content.html("");
						content.append(item);
						
						$(".reply").each(
							function(){
								var obj=$(this);
								obj.click(
									function(){
										
										debugger;
										$("#parentId").val(obj.attr("id"));
										$("#receiver").val(obj.attr("receiver"));
										$("#questionSave").html("回复");
										$('#dialogshow').modal({
											keyboard : true,
											backdrop : true,
											show : true,
											remote : false,
										});
									}		
								);
							}		
						);
					}
				}
			});
			
		}
		load();
		
		$("#a_question").click(
			function(){
				$('#dialogshow').modal({
					keyboard : true,
					backdrop : true,
					show : true,
					remote : false,
				});
			}		
		);
		
		$("#questionSave").click(
			function(){
				debugger;
				if($("#questionSave").html()!="回复"){
					$("#parentId").val("");
				}
				$.ajax({
					type:'get',
					url:"${pageContext.request.contextPath}/admin/message/saveAjax",
					data: $("#taskInfo").serializeArray(),
					success:function(data){
						debugger;
						if(data.code==1){
							$('#dialogshow').modal('hide');
							load();
						}else{
							$('#dialogshow').modal('hide');
							alert(data.message);
						}
						
					}
				});
			}		
		);
		$('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true,
			language: 'zh-CN'
		});
	
	})
	</script>
</body>

</html>