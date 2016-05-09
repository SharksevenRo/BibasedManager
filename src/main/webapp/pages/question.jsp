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
					<div class="row">
						<div class="col-xs-12 col-sm-10 col-sm-offset-1">
											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-primary arrowed-in-right label-lg">
														<b>Today</b>
													</span>
												</div>

												<div class="timeline-items">
													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<img alt="Susan't Avatar" src="assets/avatars/avatar1.png" />
															<span class="label label-info label-sm">16:22</span>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="smaller">
																	<a href="#" class="blue">Susan</a>
																	<span class="grey">reviewed a product</span>
																</h5>

																<span class="widget-toolbar no-border">
																	<i class="icon-time bigger-110"></i>
																	16:22
																</span>

																<span class="widget-toolbar">
																	<a href="#" data-action="reload">
																		<i class="icon-refresh"></i>
																	</a>

																	<a href="#" data-action="collapse">
																		<i class="icon-chevron-up"></i>
																	</a>
																</span>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	Anim pariatur cliche reprehenderit, enim eiusmod
																	<span class="red">high life</span>

																	accusamus terry richardson ad squid &hellip;
																	<div class="space-6"></div>

																	<div class="widget-toolbox clearfix">
																		<div class="pull-left">
																			<i class="icon-hand-right grey bigger-125"></i>
																			<a href="#" class="bigger-110">Click to read &hellip;</a>
																		</div>

																		<div class="pull-right action-buttons">
																			<a href="#">
																				<i class="icon-ok green bigger-130"></i>
																			</a>

																			<a href="#">
																				<i class="icon-pencil blue bigger-125"></i>
																			</a>

																			<a href="#">
																				<i class="icon-remove red bigger-125"></i>
																			</a>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-food btn btn-success no-hover"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small hidden"></div>

															<div class="widget-body">
																<div class="widget-main">
																	Going to cafe for lunch
																	<div class="pull-right">
																		<i class="icon-time bigger-110"></i>
																		12:30
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-star btn btn-warning no-hover green"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="smaller">New logo</h5>

																<span class="widget-toolbar no-border">
																	<i class="icon-time bigger-110"></i>
																	9:15
																</span>

																<span class="widget-toolbar">
																	<a href="#" data-action="reload">
																		<i class="icon-refresh"></i>
																	</a>

																	<a href="#" data-action="collapse">
																		<i class="icon-chevron-up"></i>
																	</a>
																</span>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	Designed a new logo for our website. Would appreciate feedback.
																	<div class="space-6"></div>

																	<div class="widget-toolbox clearfix">
																		<div class="pull-right action-buttons">
																			<div class="space-4"></div>

																			<div>
																				<a href="#">
																					<i class="icon-heart red bigger-125"></i>
																				</a>

																				<a href="#">
																					<i class="icon-facebook blue bigger-125"></i>
																				</a>

																				<a href="#">
																					<i class="icon-reply light-green bigger-130"></i>
																				</a>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-beaker btn btn-default no-hover"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header hidden"></div>

															<div class="widget-body">
																<div class="widget-main"> Took the final exam. Phew! </div>
															</div>
														</div>
													</div>
												</div><!-- /.timeline-items -->
											</div><!-- /.timeline-container -->

											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-success arrowed-in-right label-lg">
														<b>Yesterday</b>
													</span>
												</div>

												<div class="timeline-items">
													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-beer btn btn-inverse no-hover"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="smaller">Haloween party</h5>

																<span class="widget-toolbar">
																	<i class="icon-time bigger-110"></i>
																	1 hour ago
																</span>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	<div class="clearfix">
																		<div class="pull-left">
																			Lots of fun at Haloween party.
																			<br />
																			Take a look at some pics:
																		</div>

																		<div class="pull-right">
																			<i class="icon-chevron-left blue bigger-110"></i>

																			&nbsp;
																			<img alt="Image 4" width="36" src="assets/images/gallery/thumb-4.jpg" />
																			<img alt="Image 3" width="36" src="assets/images/gallery/thumb-3.jpg" />
																			<img alt="Image 2" width="36" src="assets/images/gallery/thumb-2.jpg" />
																			<img alt="Image 1" width="36" src="assets/images/gallery/thumb-1.jpg" />
																			&nbsp;
																			<i class="icon-chevron-right blue bigger-110"></i>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-trophy btn btn-pink no-hover green"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="smaller">Lorum Ipsum</h5>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	Anim pariatur cliche reprehenderit, enim eiusmod
																	<span class="green bolder">high life</span>
																	accusamus terry richardson ad squid &hellip;
																</div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-food btn btn-success no-hover"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small hidden"></div>

															<div class="widget-body">
																<div class="widget-main"> Going to cafe for lunch </div>
															</div>
														</div>
													</div>

													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-bug btn btn-danger no-hover"></i>
														</div>

														<div class="widget-box">
															<div class="widget-header header-color-red2 widget-header-small">
																<h5 class="smaller">Critical security patch released</h5>

																<span class="widget-toolbar no-border">
																	<i class="icon-time bigger-110"></i>
																	9:15
																</span>

																<span class="widget-toolbar">
																	<a href="#" data-action="reload">
																		<i class="icon-refresh"></i>
																	</a>

																	<a href="#" data-action="collapse">
																		<i class="icon-chevron-up"></i>
																	</a>
																</span>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	Please download the new patch for maximum security.
																</div>
															</div>
														</div>
													</div>
												</div><!-- /.timeline-items -->
											</div><!-- /.timeline-container -->

											<div class="timeline-container">
												<div class="timeline-label">
													<span class="label label-grey arrowed-in-right label-lg">
														<b>May 17</b>
													</span>
												</div>

												<div class="timeline-items">
													<div class="timeline-item clearfix">
														<div class="timeline-info">
															<i class="timeline-indicator icon-leaf btn btn-primary no-hover green"></i>
														</div>

														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h5 class="smaller">Lorum Ipsum</h5>

																<span class="widget-toolbar no-border">
																	<i class="icon-time bigger-110"></i>
																	10:22
																</span>

																<span class="widget-toolbar">
																	<a href="#" data-action="reload">
																		<i class="icon-refresh"></i>
																	</a>

																	<a href="#" data-action="collapse">
																		<i class="icon-chevron-up"></i>
																	</a>
																</span>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	Anim pariatur cliche reprehenderit, enim eiusmod
																	<span class="blue bolder">high life</span>
																	accusamus terry richardson ad squid &hellip;
																</div>
															</div>
														</div>
													</div>
												</div><!-- /.timeline-items -->
											</div><!-- /.timeline-container -->
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