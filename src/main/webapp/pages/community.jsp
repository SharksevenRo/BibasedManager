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
							<a href="javascript:void(0)">小区管理</a>
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
							<h3 class="header smaller lighter blue">所有小区</h3>

							<div class="clearfix">
								<div class="pull-right tableTools-container"></div>
							</div>
							<div class="table-header">小区列表</div>
							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">
											<label class="pos-rel">
												<input type="checkbox" class="ace" />
												<span class="lbl"></span>
											</label>
										</th>
										<th class="hide"><small>ID</small></th>
										<th><small>小区编号</small></th>
										<th><small>小区名称</small></th>
										<th><small>所属公司</small></th>
										<th class="hide"><small>小区地址</small></th>
										<th><small>小区楼宇数(栋)</small></th>
										<th><small>小区总面积(m²)</small></th>
										<th><small>小区建筑面积(m²)</small></th>
										<th><small>小区绿化面积(m²)</small></th>
										<th class="hide"><small>小区开放时间</small></th>
										<th class="hide"><small>小区说明</small></th>
										<th><small>小区状态</small></th>
										<th class="center"><small>操作</small></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${requestScope.communityList}" var="trl" varStatus="status">
										<tr>
											<td class="center">
												<label class="pos-rel">
												<input type="checkbox" class="ace" />
												<span class="lbl"></span>
												</label>
											</td>
											<td class="hide">${trl.cmmId}</td>
											<td>${trl.cmmNo}</td>
											<td>
												<a href="${pageContext.request.contextPath }/building/allBuilding?menu=buildings+allBuildings&cmmId=${trl.cmmId}"
													data-toggle="tooltip" title="点击查看该小区楼宇信息"
												  data-placement="bottom" data-content="点击查看该小区楼宇信息">
														${trl.cmmName}
												</a>
											</td>
											<td><a class="companyPopover" href="javascript:void(0);" data-container="body" data-placement="bottom"
												data-content="公司名称：${trl.company.companyName}<br>
															  公司地址：${trl.company.companyAddress}<br>
															  公司电话：${trl.company.companyCeoTel}">${trl.company.companyName}</a>
											</td>
											<td class="hide">${trl.cmmAddress}</td>
											<td>${trl.cmmBuildMount}</td>
											<td>${trl.cmmArea}</td>
											<td>${trl.buildArea}</td>
											<td>${trl.greenArea}</td>
											<td class="hide">${fn:substring(trl.cmmTime,0,10) }</td>
											<td class="hide">${trl.cmmMsg}</td>
											<td id="cmmState${trl.cmmId}">
												<span class="label label-sm " name="cmmState${trl.cmmState}">${trl.cmmState}</span>
											</td>
											<td>
												<div class="hidden-sm hidden-xs action-buttons">
													<a class="green buttonCompany" href="javascript:void(0)" 
														name="${trl.cmmId}" cmmId="${trl.cmmId}" cmmNo="${trl.cmmNo}"
														cmmName="${trl.cmmName}" company="${trl.company.companyId}" 
														cmmAddress="${trl.cmmAddress}" cmmBuildMount="${trl.cmmBuildMount}"
														cmmArea="${trl.cmmArea}" buildArea="${trl.buildArea}"
														greenArea="${trl.greenArea}" cmmTime="${trl.cmmTime}"
														cmmMsg="${trl.cmmMsg}" cmmState="${trl.cmmState}" oper="modify">
														<i class="fa fa-pencil bigger-130">
															<small>修改</small>
														</i>
													</a>
													<a class="red buttonCompany" href="javascript:void(0)" name="${trl.cmmId}" oper="delete">
														<i id="cmmStateAction${trl.cmmId}" class="fa fa-toggle-off bigger-130" name="cmmStateAction${trl.cmmState}" state="${trl.cmmState}"></i>
													</a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- PAGE CONTENT ENDS -->
						</div>

						<div id="dialog-message" class="hide" style="width:405px">
							<form id="communityInfo" method="get">
								<!-- 隐藏域 -->
								<input type="hidden" name="cmmId" value="0" id="cmmId" />
								<input type="hidden" name="oper" value="" id="oper" />
								<input type="hidden" name="cmmState" value="0" id="cmmState" />
								<div id="form-div">
									<!-- 小区名称 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-0" class="col-sm-4 control-label no-padding-right">小区名称:</label>
										<div class="col-sm-8">
											<input id="form-field-0" type="text" name="cmmName" placeholder="小区名称" class="ab no-padding" />
										</div>
									</div>
									<!-- 所属公司 -->
									<div class="div form-group col-sm-12">
										<label for="company" class="col-sm-4 control-label no-padding-right">所属公司：</label>
										<div class="col-sm-8">
											<select class="chosen-select form-control no-padding" id="company" name="companyId"
												data-placeholder="所属公司">
											</select>
										</div>
									</div>
									<!-- 小区编号 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-2" class="col-sm-4 control-label no-padding-right">小区编号:</label>
										<div class="col-sm-8">
											<input id="form-field-2" type="text" name="cmmNo" placeholder="小区编号" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区地址 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-3" class="col-sm-4 control-label no-padding-right">小区地址:</label>
										<div class="col-sm-8">
											<input id="form-field-3" type="text" name="cmmAddress" placeholder="小区地址" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区楼宇数量-->
									<div class="div form-group col-sm-12">
										<label for="form-field-4" class="col-sm-4 control-label no-padding-right">楼宇数量:</label>
										<div class="col-sm-8">
											<input readonly="readonly" id="form-field-4" type="text" name="cmmBuildMount" placeholder="小区楼宇数量" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区面积 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-5" class="col-sm-4 control-label no-padding-right">小区面积:</label>
										<div class="col-sm-8">
											<input onkeyup="value=value.replace(/[^0-9|.]/g,'')" id="form-field-5" type="text" name="cmmArea" placeholder="小区面积" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区建筑面积 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-6" class="col-sm-4 control-label no-padding-right">建筑面积:</label>
										<div class="col-sm-8">
											<input onkeyup="value=value.replace(/[^0-9|.]/g,'')" id="form-field-6" type="text" name="buildArea" placeholder="小区建筑面积" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区绿化面积 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-7" class="col-sm-4 control-label no-padding-right">绿化面积:</label>
										<div class="col-sm-8">
											<input onkeyup="value=value.replace(/[^0-9|.]/g,'')" id="form-field-7" type="text" name="greenArea" placeholder="小区绿化面积" class="ab no-padding" />
										</div>
									</div>
									<!-- 小区开放 -->
									<div class="div form-group col-sm-12">
										<label for="form-field-8" class="col-sm-4 control-label no-padding-right">开放时间:</label>
										<div class="col-sm-8 input-icon input-icon-right">
											<input id="form-field-8" type="text" name="cmmTime" placeholder="小区开放时间" class="ab no-padding datepicker" />
											<i class="ace-icon fa fa-calendar"></i>
										</div>
									</div>
									<!-- 小区说明 -->
									<div class="form-group col-sm-12">
										<label for="form-field-9" class="col-sm-4 control-label no-padding-right">小区说明:</label>
										<div class="col-sm-8">
											<textarea id="form-field-9" class="ab autosize-transition form-control" name="cmmMsg" placeholder="小区说明" maxlength="100"></textarea>
										</div>
									</div>
								</div>

								<div class="hr hr-12 hr-double"></div>
								<!-- 错误提示 -->
								<div style="width:100%;text-align: center" id="error"></div>
								<!-- 按钮操作 -->
								<div>
									<button disabled id="communitySave" style="margin-left:10px" class="btn btn-info col-sm-5" type="button">
										<i class="ace-icon fa fa-check bigger-110"></i>
										修改
									</button>
									<button id="communityReset" style="margin-left:25px" class="btn btn-success col-sm-5" type="reset">
										<i class="ace-icon fa fa-check bigger-110"></i>
										重置
									</button>
								</div>
							</form>
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
		$(function(){
			$(".datepicker").datepicker();
			$("#communityReset").click(function(){
				$("#communitySave").attr("disabled",true);
			});
			//验证表单
			$("select").change(function(){
				var input=$(".ab");
				for(var i=0;i<input.length;i++){
					var item=input[i];
					if(item.value!=""&&i==input.length-1){
						$("#communitySave").attr("disabled",false);
					}else{
						$("#communitySave").attr("disabled",true);
					}
				}
			});
			$(".ab").keyup(function(){
				var input=$(".ab");
				for(var i=0;i<input.length;i++){
					var item=input[i];
					if(item.value!=""&&i==input.length-1){
						$("#communitySave").attr("disabled",false);
					}else{
						$("#communitySave").attr("disabled",true);
					}
				}
			});
			$("#form-field-6").blur(function(){
				debugger;
				var area=$("#form-field-5").val();
				var buildarea=$("#form-field-6").val();
				if(area!=""&&buildarea!=""){
					$("#form-field-7").val(parseFloat(area)-parseFloat(buildarea));
				}
			});
			//获取所有公司
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath }/company/getAllCompany",
				dataType : "json",
				async : false,
				/*这句可用可不用，没有影响*/
				contentType : "application/json; charset=utf-8",
				success : function(data) {
							$("#company").html("");
							var company = JSON.stringify(data.Company);
							var obj = JSON.parse(company);
							for ( var i = 0; i < obj.length; i++) {
								$("#company").append("<option value='"+obj[i].companyId+"'>"+ obj[i].companyName+ "</option>");
							}
						},
				error : function(XMLHttpRequest,textStatus, errorThrown) {
							alert(errorThrown);
						}
				});
		});
		$(document).ready(function(){						
			//图片上传 及数据保存 
			$("#communitySave").click(
				function() {
					var options = {
						url : "${pageContext.request.contextPath }/community/updateCommunity",
						dataType : "json",
						contentType : "application/json; charset=utf-8",
						success : function(data) {
									if (data == "1") {
										$("#adsRest").trigger("click");
										$("#dialog-message").dialog("close");
										window.location.reload();
									}
								}
						};
					// 提交表单 
					$("#communityInfo").ajaxSubmit(options);
			});
			//显示公司详细信息
			$(".companyPopover").popover({
				html : true,
				title : function() {
							return "公司详细信息";
				},
				content : function() {
							return "<div width='100px' height='100px'>"+
									+ $(this).attr("data-content")
									+ "'</div>";
							}
			});
			myEach();

			//图片上传框
			$("#id-input-file-3").ace_file_input({
										style : "well",
										btn_choose : "选择图片...",
										btn_change : null,
										no_icon : 'ace-icon fa fa-cloud-upload',
										droppable : true,
										thumbnail : "small" //large | fit
										//,icon_remove:null//set null, to hide remove/reset button
										/**,before_change:function(files, dropped) {
													//Check an example below
													//or examples/file-upload.html
													return true;
										}*/
										/**,before_remove : function() {
													return true;
										}*/
										,
										preview_error : function(filename, error_code) {
															//name of the file that failed
															//error_code values
															//1 = 'FILE_LOAD_FAILED',
															//2 = 'IMAGE_LOAD_FAILED',
															//3 = 'THUMBNAIL_FAILED'
															//alert(error_code);
										}}).on("change", function() {
												console.log($(this).data("ace_input_files"));
												console.log($(this).data("ace_input_method"));
			});
			var whitelist_ext, whitelist_mime;
			var btn_choose;
			var no_icon;
			btn_choose = "选择照片...";
			no_icon = "ace-icon fa fa-picture-o";
			whitelist_ext = [ "jpeg", "jpg", "png", "gif","bmp" ];
			whitelist_mime = [ "image/jpg", "image/jpeg","image/png", "image/gif", "image/bmp" ];
			var file_input = $("#id-input-file-3");
			file_input.ace_file_input("update_settings", {
								"btn_choose" : btn_choose,
								"no_icon" : no_icon,
								"allowExt" : whitelist_ext,
								"allowMime" : whitelist_mime
			});
		});

		function myEach() {
			$("span[name='cmmStatetrue']").each(function() {
				try {
					$(this).removeClass("label-warning");
				} catch (e) {}
				$(this).addClass("label-success");
				$(this).text("运营中");
			});
			$("span[name='cmmStatefalse']").each(function() {
				try {
					$(this).removeClass("label-success");
				} catch (e) {}
				$(this).addClass("label-warning");
				$(this).text("已停业");
			});
			$("i[name='cmmStateActiontrue']").each(function() {
				try {
					$(this).removeClass("fa-toggle-off");
				} catch (e) {}
				$(this).addClass("fa-toggle-on");
				$(this).text("停业");
			});
			$("i[name='cmmStateActionfalse']").each(function() {
				try {
					$(this).removeClass("fa-toggle-on");
				} catch (e) {}
				$(this).addClass("fa-toggle-off");
				$(this).text("运营");
			});
		}
		$(function(){
			$(".buttonCompany").click(function(){
				var obj=$(this);
				var oper = $(this).attr("oper");
				var cmmId = $(this).attr("name");
				if(oper == "modify"){
					$("#cmmId").val(cmmId);
					$("#oper").val(oper);
					$("#form-field-0").val($(this).attr("cmmName"));
					$("#company").val($(this).attr("company"));
					$("#form-field-2").val($(this).attr("cmmNo"));
					$("#form-field-3").val($(this).attr("cmmAddress"));
					$("#form-field-4").val($(this).attr("cmmBuildMount"));
					$("#form-field-5").val($(this).attr("cmmArea"));
					$("#form-field-6").val($(this).attr("buildArea"));
					$("#form-field-7").val($(this).attr("greenArea"));
					$("#form-field-8").val(new Date($(this).attr("cmmTime")).toLocaleDateString());
					$("#form-field-9").val($(this).attr("cmmMsg"));
					$("#cmmState").val($(this).attr("cmmState"));
				}
				if (oper == "delete") {
					var cmmState = $("#cmmStateAction"+cmmId).attr("state");
					$.ajax({
						cache : false,
						type : "POST",
						url : "${pageContext.request.contextPath }/community/updateCommunity",
						datatype : "json",
						data : {"cmmId" : cmmId,"oper" : oper},
						async : true,
						success : function(data) {
							if (data == "1") {
								if (cmmState == "true") {
									obj.siblings().attr("cmmState",false);
									$("td[id='cmmState"+ cmmId+ "'] span").attr("name","cmmStatefalse");
									$("i[id='cmmStateAction"+ cmmId+ "']").attr("name","cmmStateActionfalse");
									$("i[id='cmmStateAction"+ cmmId+ "']").attr("state","false");
								} else {
									obj.siblings().attr("cmmState",true);
									$("td[id='cmmState"+ cmmId+ "'] span").attr("name","cmmStatetrue");
									$("i[id='cmmStateAction"+ cmmId+ "']").attr("name","cmmStateActiontrue");
									$("i[id='cmmStateAction"+ cmmId+ "']").attr("state","true");
								}
								myEach();
							}
						},
						error : function(data) {
							alert("error");
						}
					});
				}
				else {
					var dialog = $("#dialog-message").removeClass("hide")
								.dialog({
										modal : true,
										title : (oper=="detaill")?"查看详细":(oper=="modify")?"修改小区信息":(oper=="add")?"添加小区":"确认删除小区",
										title_html : true,
										/* buttons: [{
											text: "关闭窗口",
											"class": "btn btn-minier",
											click: function() {
														$(this).dialog("close");
												}
											}, {
											text: "确定",
											"class": "btn btn-primary btn-minier",
											click: function() {
													var goods_type = "";
													$.ajax({
														type: "post",
														url: "../../seller/getAllGoodsType",
														enctype: 'multipart/form-data',
														data:$('#dialog-message').serialize(),//$("#dialog-message").serialize(),
														async: false,
														success: function(data) {
																var goods_types = JSON.stringify(data.TGoodstype);
																var obj = JSON.parse(goods_types);
																for (var i = 0; i < obj.length; i++) {
																	goods_type += obj[i].goodsTypeId + ":" + obj[i].goodsTypeName;
																	if (i < obj.length - 1) {
																		goods_type += ";";
																	}
																}
															}
													});
											}
											}] */
									});

				}
			});
			//initiate dataTables plugin
			var oTable1 = $("#dynamic-table").dataTable({
						bAutoWidth : false,
						"aoColumns" : [{"bSortable" : false}, null, {"bSortable" : false},
										 {"bSortable" : false}, {"bSortable" : false}, {"bSortable" : false}, 
										 null, null, null, 
										 null, null, {"bSortable" : false}, 
										 {"bSortable" : false},{"bSortable" : false}],
						"aaSorting" : [],
						//"sScrollY": "200px",
						"bPaginate" : true,
						//"sScrollX": "100%",
						//"sScrollXInner": "120%",
						//"bScrollCollapse": true,
						//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
						//you may want to wrap the table inside a "div.dataTables_borderWrap" element
						//"iDisplayLength": 50
			});
			//oTable1.fnAdjustColumnSizing();
			//TableTools settings
			TableTools.classes.container = "btn-group btn-overlap";
			TableTools.classes.print = {
				"body" : "DTTT_Print",
				"info" : "tableTools-alert gritter-item-wrapper gritter-info gritter-center white",
				"message" : "tableTools-print-navbar"
			};
			//initiate TableTools extension
			var tableTools_obj = new $.fn.dataTable.TableTools(
						oTable1,{
									"sSwfPath" : "${pageContext.request.contextPath }/assets/js/dataTables/extensions/TableTools/swf/copy_csv_xls_pdf.swf", //in Ace demo ../assets will be replaced by correct assets path
									"sRowSelector" : "td:not(:last-child)",
									"sRowSelect" : "multi",
									"fnRowSelected" : function(row) {
														//check checkbox when row is selected
														try {
															$(row).find('input[type=checkbox]').get(0).checked = true;
														} catch (e) {}
								},
						"fnRowDeselected" : function(row) {
												//uncheck checkbox
												try {
													$(row).find("input[type=checkbox]").get(0).checked = false;
												} catch (e) {}
											},
						"sSelectedClass" : "success",
						"aButtons" : [
										{
											"sExtends" : "copy",
											"sToolTip" : "复制到剪贴板",
											"sButtonClass" : "btn btn-white btn-primary btn-bold",
											"sButtonText" : "<i class='fa fa-copy bigger-110 pink'></i>",
											"fnComplete" : function() {
															this.fnInfo("<h3 class='no-margin-top smaller'>Table copied</h3>\<p>"+
																	"Copied "+(oTable1.fnSettings().fnRecordsTotal())+ "row(s) to the clipboard.</p>",1500);
															}
										},
										{
											"sExtends" : "xls",
											"sToolTip" : "导出Excel",
											"sButtonClass" : "btn btn-white btn-primary  btn-bold",
											"sCharSet" : "utf8",
											"sButtonText" : "<i class='fa fa-file-excel-o bigger-110 green'></i>"
										},
										{
											"sExtends" : "pdf",
											"sToolTip" : "Export to PDF",
											"sButtonClass" : "btn btn-white btn-primary  btn-bold",
											"sButtonText" : "<i class='fa fa-file-pdf-o bigger-110 red'></i>"
										},
										{
											"sExtends" : "print",
											"sToolTip" : "Print view",
											"sButtonClass" : "btn btn-white btn-primary  btn-bold",
											"sButtonText" : "<i class='fa fa-print bigger-110 grey'></i>",
											"sMessage" : "<div class='navbar navbar-default'><div class='navbar-header pull-left'><a class='navbar-brand' href='#'><small>Optional Navbar &amp; Text</small></a></div></div>",
											"sInfo" : "<h3 class='no-margin-top'>Print view</h3>\
											  <p>Please use your browser's print function to\
											  print this table.\
											  <br />Press <b>escape</b> when finished.</p>",
										}]
					});
			//we put a container before our table and append TableTools element to it
			$(tableTools_obj.fnContainer()).appendTo($(".tableTools-container"));
			//also add tooltips to table tools buttons
			//addding tooltips directly to "A" buttons results in buttons disappearing (weired! don't know why!)
			//so we add tooltips to the "DIV" child after it becomes inserted
			//flash objects inside table tools buttons are inserted with some delay (100ms) (for some reason)
			setTimeout(function() {
				$(tableTools_obj.fnContainer()).find("a.DTTT_button").each(
						function() {
							var div = $(this).find("> div");
							if (div.length > 0)
								div.tooltip({
									container : "body"
								});
							else
								$(this).tooltip({
									container : "body"
								});
						});
			}, 200);
			//ColVis extension
			var colvis = new $.fn.dataTable.ColVis(oTable1, {
				"buttonText" : "<i class='fa fa-search'></i>",
				"aiExclude" : [ 0, 6 ],
				"bShowAll" : true,
				//"bRestore": true,
				"sAlign" : "right",
				"fnLabel" : function(i, title, th) {
					return $(th).text(); //remove icons, etc
				}
			});
			//style it
			$(colvis.button()).addClass("btn-group")
							  .find("button")
							  .addClass("btn btn-white btn-info btn-bold");
			//and append it to our table tools btn-group, also add tooltip
			$(colvis.button()).prependTo(".tableTools-container .btn-group")
							  .attr("title", "选择要导出的数据列")
							  .tooltip({container : "body"});
			//and make the list, buttons and checkboxed Ace-like
			$(colvis.dom.collection).addClass("dropdown-menu dropdown-light dropdown-caret dropdown-caret-right")
									.find("li")
									.wrapInner("<a href='javascript:void(0)' />") //'A' tag is required for better styling
									.find("input[type=checkbox]")
									.addClass("ace").next()
									.addClass("lbl padding-8");
			//table checkboxes
			$("th input[type=checkbox], td input[type=checkbox]").prop("checked", false);
			//select/deselect all rows according to table header checkbox
			$("#dynamic-table > thead > tr > th input[type=checkbox]").eq(0)
																	  .on("click",function() {
																					var th_checked = this.checked; //checkbox inside "TH" table header
																					$(this).closest("table")
																				   		   .find("tbody > tr")
																				   		   .each(function(){
																									var row = this;
																									if (th_checked){
																										tableTools_obj.fnSelect(row);
																									}
																									else{
																										tableTools_obj.fnDeselect(row);
																								}});
							});
			//select/deselect a row when the checkbox is checked/unchecked
			$("#dynamic-table").on("click","td input[type=checkbox]",function() {
																		var row = $(this).closest("tr").get(0);
																		if (!this.checked){
																			tableTools_obj.fnSelect(row);
																		}
																		else{
																			tableTools_obj.fnDeselect($(this).closest("tr").get(0));
																		}});
			$(document).on("click", "#dynamic-table .dropdown-toggle",function(e) {
																		e.stopImmediatePropagation();
																		e.stopPropagation();
																		e.preventDefault();
																		});
			//And for the first simple table, which doesn't have TableTools or dataTables
			//select/deselect all rows according to table header checkbox
			var active_class = "active";
			$("#simple-table > thead > tr > th input[type=checkbox]").eq(0)
																	 .on("click",function() {
																					var th_checked = this.checked; //checkbox inside "TH" table header
																					$(this).closest("table")
																						   .find("tbody > tr")
																						   .each(function() {
																									var row = this;
																									if (th_checked)
																										$(row).addClass(active_class)
																											  .find("input[type=checkbox]").eq(0)
																											  .prop("checked", true);
																									else
																										$(row).removeClass(active_class)
																											  .find("input[type=checkbox]").eq(0)
																											  .prop("checked", false);});
					});
			//select/deselect a row when the checkbox is checked/unchecked
			$("#simple-table").on("click", "td input[type=checkbox]",function() {
																		var $row = $(this).closest("tr");
																		if (this.checked)
																			$row.addClass(active_class);
																		else
																			$row.removeClass(active_class);});
			/********************************/
			//add tooltip for small view action buttons in dropdown menu
			$("[data-rel='tooltip']").tooltip({
				placement : tooltip_placement
			});
			//tooltip placement on right or left
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest("table");
				var off1 = $parent.offset();
				var w1 = $parent.width();
				var off2 = $source.offset();
				//var w2 = $source.width();
				if (parseInt(off2.left) < parseInt(off1.left)+ parseInt(w1 / 2))
					return "right";
				return "left";
			}
		});
		//chosen plugin inside a modal will have a zero width because the select element is originally hidden
		//and its width cannot be determined.
		//so we set the width after modal is show
				/* $('#modal-form').on('shown.bs.modal', function () {
					if(!ace.vars['touch']) {
						$(this).find('.chosen-container').each(function(){
							$(this).find('a:first-child').css('width' , '210px');
							$(this).find('.chosen-drop').css('width' , '210px');
							$(this).find('.chosen-search input').css('width' , '200px');
						});
					}
				}); */
				/**
				//or you can activate the chosen plugin after modal is shown
				//this way select element becomes visible with dimensions and chosen works as expected
				$('#modal-form').on('shown', function () {
					$(this).find('.modal-chosen').chosen();
				})
				*/
		/* if(!ace.vars['touch']) {
					$('.chosen-select').chosen({allow_single_deselect:true}); 
					//resize the chosen on window resize
			
					$(window)
					.off('resize.chosen')
					.on('resize.chosen', function() {
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					}).trigger('resize.chosen');
					//resize chosen on sidebar collapse/expand
					$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
						if(event_name != 'sidebar_collapsed') return;
						$('.chosen-select').each(function() {
							 var $this = $(this);
							 $this.next().css({'width': $this.parent().width()});
						})
					});
			
			
					$('#chosen-multiple-style .btn').on('click', function(e){
						var target = $(this).find('input[type=radio]');
						var which = parseInt(target.val());
						if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
						 else $('#form-field-select-4').removeClass('tag-input-style');
					});
				} */
	</script>
</body>

</html>