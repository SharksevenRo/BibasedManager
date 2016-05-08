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
							<a href="javascript:void(0)">课题管理</a>
						</li>
					</ul>
					<jsp:include page="../WebPart/SearchBox.jsp"></jsp:include>
				</div>
				<!-- 主要内容 start -->
			<div class="page-content">
								<!-- #section:settings.box -->

								<!-- /section:settings.box -->
								<div class="page-header">
									<h1>
										文档上传 <small> <i
											class="ace-icon fa fa-angle-double-right"></i> 文档上传</small>
									</h1>
								</div>
								<!-- /.page-header -->

								<div class="row">
									<div class="col-xs-12">
										<div>
											<form action="../dummy.html" class="dropzone" id="dropzone">
												<div class="fallback">
													<input name="file" type="file" multiple="" />
												</div>
											</form>
										</div>

								</div>
									<!-- /.col -->
								</div>
								<!-- /.row -->
							</div>
			</div>
		</div>
		<jsp:include page="../WebPart/CopyRight.jsp"></jsp:include>
	</div>
	<jsp:include page="../WebPart/Script.jsp"></jsp:include>
	<!-- page specific plugin scripts -->
	<!-- page specific plugin scripts -->
	<script src="${pageContext.request.contextPath }/assets/js/dropzone.js"></script>
	<!-- ace scripts -->
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.scroller.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.colorpicker.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.fileinput.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.typeahead.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.wysiwyg.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.spinner.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.treeview.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.wizard.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/elements.aside.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/ace/ace.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.ajax-content.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.touch-drag.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.sidebar.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.submenu-hover.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.widget-box.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.settings.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.settings-rtl.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.settings-skin.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.widget-on-reload.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/ace/ace.searchbox-autocomplete.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			try {
				Dropzone.autoDiscover = false;
				var myDropzone = new Dropzone(
						"#dropzone",
						{
							paramName : "file", // The name that will be used to transfer the file
							maxFilesize : 1024, // MB
							url : "${pageContext.request.contextPath}/admin/meadia/upload",
							addRemoveLinks : true,
							dictDefaultMessage : '<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> 拖拽文件</span> 上传 \
				<span class="smaller-80 grey">(或点我)</span> <br /> \
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
							dictResponseError : '上传文件时出错!',
							//change the previewTemplate to use Bootstrap progress bars
							previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
							success:function (obj,data){
								$("#warn_content").html("");
								$("#warn_content").append("上传成功");
								$("#warn_dialog").modal({
									keyboard: true,
									backdrop: true,
									show: true,
									remote: false,
								});
								return true;
							},
							error:function (obj,data){
								
								debugger;
								var json=JSON.parse(data);
								$("#warn_content").html("");
								$("#warn_content").append("<span>上传出错，请查看错误回馈文件，在回馈文件的基础上根据错误提示修改在上传</span><br>");
								
								if(json.fileName!=null){
									window.location.href="${pageContext.request.contextPath}/excel/error/download?fileName="+json.fileName;
								
								}else{
									$("#warn_content").append("上传成功");
								}
								$("#warn_dialog").modal({
									keyboard: true,
									backdrop: true,
									show: true,
									remote: false,
								});
								return false;
							},
						});
				$(document).one('ajaxloadstart.page', function(e) {
					try {
						myDropzone.destroy();
					} catch (e) {
					}
				});
			} catch (e) {
				alert('Dropzone.js 不支持老版本的浏览器');
			}
		});
	</script>
</body>

</html>