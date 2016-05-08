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
					<jsp:include page="../WebPart/Skin.jsp"></jsp:include>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<h3 class="header smaller lighter blue">所有课题</h3>

							<div class="table-header">课题列表</div><th>
											<p class="text-center">
												<a class="blue buttongoods" href="javascript:void(0)"
													id="buttonadd" oper="add"> <i
													class="fa fa-plus-square-o bigger-150"><strong>添加课题</strong>
												</i> </a>
											</p>
										</th>
							<table id="sample-table-2" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>课题编号</th>
										<th>课题名称</th>
										<th>详情</th>
										<th>截止时间</th>
										<th>学生</th>
										<th class="center">操作</th>
									</tr>
								</thead>

								<tbody id="tbbody">
									
								</tbody>
							</table>
							<!-- PAGE CONTENT ENDS -->
						</div>
							<div class="modal fade" role="dialog" id="dialogshow">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="gridSystemModalLabel">添加课题</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<!-- PAGE CONTENT BEGINS -->
									<form id="taskInfo">
										<input name="id" type="hidden" id="input_task_id">
									<!-- 课题名称 -->
									<div class="div form-group col-md-12">
										<label for="form-field-2" class="col-sm-2 control-label no-padding-right">课题名称:</label>
										<div class="col-sm-10">
											<input id="input_task_name" type="text" name="name" placeholder="课题名称" class="form-control col-xs-10 col-md-8" />
										</div>
									</div>
									<!-- 课题地址 -->
									<div class="space-6"></div>
									<div class="div form-group col-md-12">
										<label for="form-field-3" class="col-md-2 control-label no-padding-right">课题详情:</label>
										<div class="col-md-10">
											<textarea class="form-control col-xs-10 col-md-8" id="input_task_description" name="description" placeholder="课题详情"></textarea>
										</div>
									</div>
									<div class="div form-group col-md-12">
										<div class="space-6"></div>
										<label for="form-field-8" class="col-md-2 control-label no-padding-right date-picker">截止时间:</label>
										<div class="col-md-10 input-icon input-icon-right">
											<input id="datepicker" name="limitime" type="text" class="a form-control date-picker" placeholder="截止时间" />
										</div>
									</div>
									
								<div >
									<div class="space-12"></div>
									<div style="margin-left:100px;margin-top:20px;">
										<button  id="taskSave" style="margin-left:10px" class="btn btn-info col-md-3" type="button">
											添加
										</button>
										<button id="communityReset" style="margin-left:25px" class="btn btn-success col-md-3" type="reset">
											重置
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
					</div>
				</div>
			</div>
		</div>
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
			$.ajax({
				type:'get',
				url:"${pageContext.request.contextPath }/admin/task/page",
				success:function(data){
					debugger;
					var content=$("#tbbody");
					var item="";
					if(data!=null&&data.length>0){
						
						for(var i=0;i<data.length;i++){
							var stu=data[i].owner;
							item+="<tr>"
							+"<td>"+data[i].id+"</td>"
							+"<td>"+data[i].name+"</td>"
							+"<td>"+data[i].description+"</td>"
							+"<td>"+data[i].limitime+"</td>";
							if(stu==null){
								item+="<td>还未确定</td>";
							}else{
								item+="<td>"+stu.name+"</td>"
							}
							
							item+="<td>"
							+"<div class=\"hidden-sm hidden-xs action-buttons\">"
							+"<a class=\"green btn_task\" href=\"javascript:void(0)\"" 
							+"id=\""+data[i].id+"\" name=\""+data[i].name+"\" description=\""+data[i].description+"\""
							+" limitime=\""+data[i].limitime+"\" oper=\"modify\">"
							+	"<i class=\"fa fa-pencil bigger-150\">"
							+		"<small>修改</small>"
							+	"</i>"
							+"</a>"
							+"<a class=\"red btn_task\" id=\""+data[i].id+"\" href=\"javascript:void(0)\" name=\""+data[i].id+"\" oper=\"delete\">"
							+"<i class=\"fa fa-trash-o bigger-150\">删除</i>"
							+"</a>"
						+"</div>"
							+"</td>"
						+"</tr>"
						}
						content.html("");
						content.append(item);
					}
					$(".btn_task").each(
							
						function(){
							var obj=$(this);
							obj.click(
								function(){
									var oper=obj.attr("oper");
									
									if(oper=='delete'){
										var id=obj.attr("id")
										$.ajax({
											type:'get',
											url:"${pageContext.request.contextPath }/admin/task/deleteAjax",
											async:false,
											data:{id:id},
											success:function(data){
												if(data.code==1){
													debugger;
													load();
												}else{
													alert(data.message);
												}
											}
										});
									}else if(oper=='modify'){
										debugger;
										var time=obj.attr("limitime");
										var strs=time.split("-");
										time=strs[1]+"/"+strs[2]+"/"+strs[0];
										$("#input_task_id").val(obj.attr("id"));
										$("#input_task_name").val(obj.attr("name"));
										$("#input_task_description").html(obj.attr("description"));
										$("#datepicker").val(time);
										$("#taskSave").html("修改");
										$('#dialogshow').modal({
											keyboard : true,
											backdrop : true,
											show : true,
											remote : false,
										});
									}
								}		
							);
						}		
					);
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
	      {"bSortable" : false}, {"bSortable" : false},{"bSortable" : false}, {"bSortable" : false},{"bSortable" : false},{"bSortable" : false}
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
		
		$("#buttonadd").click(function(){
			
			$('#dialogshow').modal({
				keyboard : true,
				backdrop : true,
				show : true,
				remote : false,
			});
			
		});
		
		$("#taskSave").click(
			function(){
				
				var oper =$("#taskSave").html();
				var url;
				if(oper=="修改"){
					url="${pageContext.request.contextPath }/admin/task/updateAjax";
				}else{
					$("#input_task_id").val("");
					url="${pageContext.request.contextPath }/admin/task/saveAjax";
				}
				$.ajax({
					type:'get',
					url:url,
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
	})
	</script>
</body>

</html>