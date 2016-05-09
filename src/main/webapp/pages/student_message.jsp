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
							<a href="javascript:void(0)">通知管理</a>
						</li>
					</ul>
					<jsp:include page="../WebPart/SearchBox.jsp"></jsp:include>
				</div>
				<!-- 主要内容 start -->
				<div class="page-content">
					<jsp:include page="../WebPart/Skin.jsp"></jsp:include>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<h3 class="header smaller lighter blue">所有通知</h3>

							<div class="table-header">通知列表</div>
							<th>
											<p class="text-center">
												<a class="blue buttongoods" href="javascript:void(0)"
													id="buttonadd" oper="add"> <i
													class="fa fa-plus-square-o bigger-150"><strong>发布通知</strong>
												</i> </a>
											</p>
										</th>
							<table id="sample-table-2" style="text-align: center" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>通知标题</th>
										<th>发布时间</th>
										<th>发布者</th>
										<th>接受对象</th>
									</tr>
								</thead>

								<tbody id="tbbody">
									
								</tbody>
							</table>
							<!-- PAGE CONTENT ENDS -->
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" role="dialog" id="content_show">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="gridSystemModalLabel">通知详情</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<!-- PAGE CONTENT BEGINS -->
							<p id="description">
							</p>		
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<input id="currentId" type="hidden" value="${sessionScope.user.teahcer }">
		<jsp:include page="../WebPart/CopyRight.jsp"></jsp:include>
	</div>
	<jsp:include page="../WebPart/Script.jsp"></jsp:include>
	<!-- page specific plugin scripts -->
	<script src="${pageContext.request.contextPath }/assets/js/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.ui.touch-punch.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.gritter.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/dataTables/jquery.dataTables.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/dataTables/jquery.dataTables.bootstrap.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/dataTables/extensions/TableTools/js/dataTables.tableTools.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/dataTables/extensions/ColVis/js/dataTables.colVis.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	jQuery(function($) {
		
		//获取数据
		function load(){
			debugger;
			$.ajax({
				type:'post',
				async:false,
				data:{'receiver.id':$("#currentId").val(),teavisible:1},
				url:"${pageContext.request.contextPath }/admin/notice/page",
				success:function(data){
					debugger;
					var content=$("#tbbody");
					var item="";
					if(data!=null&&data.length>0){
						
						for(var i=0;i<data.length;i++){
							var sender =data[i].sender;
							item+="<tr>"
							+"<td><a class=\"read\" id=\""+data[i].content+"\" href=\"javascript:void(0)\">"+data[i].title+"</td>"
							+"<td>"+data[i].time+"</td>"
							+"<td>"+sender.name+"</td>";
							if(data[i].teavisible==1){
								item+="<td>所有小组</td>";
							}else{
								item+="<td>"+teacher.name+"老师小组</td>"
							}
							item+="</tr>"
						}
						content.html("");
						content.append(item);
					}
					$(".read").each(function(){
						
						var obj=$(this);
						obj.click(function(){
							
							var content=obj.attr("id");
							$("#description").html("");
							$("#description").html(content);
							$('#content_show').modal({
								keyboard : true,
								backdrop : true,
								show : true,
								remote : false,
							});
						});
					});
				}
			});
			
		}
		load();
		$('.date-picker').datepicker({
			autoclose: true,
			todayHighlight: true,
			language: 'zh-CN'
		});
		var oTable1 = $('#sample-table-2').dataTable( {
		"aoColumns": [
	      {"bSortable" : false}, {"bSortable" : false},{"bSortable" : false}, {"bSortable" : false}
		] } );
		
		
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
				
		});
	
	
		$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
	
			var off2 = $source.offset();
			var w2 = $source.width();
	
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		}
	})
	</script>
</body>

</html>