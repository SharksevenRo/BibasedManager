<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" src="<%=basePath %>assets/js/jquery.js"></script>

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed');
		} catch (e) {
		}
	</script>
	<div class="navbar-container" id="navbar-container">
		<!-- #section:basics/sidebar.mobile.toggle -->
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>

		<!-- /section:basics/sidebar.mobile.toggle -->
		<div class="navbar-header pull-left">
			<!-- #section:basics/navbar.layout.brand -->
			<a href="javascript:void(0)" class="navbar-brand">
				<small>
					<i class="fa fa-leaf"></i>毕设管理后台
				</small>
			</a>
		</div>

		<!-- #section:basics/navbar.dropdown -->

		<!-- /section:basics/navbar.dropdown -->
	</div>
	<!-- /.navbar-container -->
</div>
<div class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
	<div class="modal-dialog modal-md" role="document" style="margin-top:300px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			    <h4 class="modal-title text-center" id="gridSystemModalLabel"><font id="topTittle" color="red"></font></h4>
			</div>
			<div class="modal-body" style="margin-bottom: 4px">
			    <div class="green">
			    	<span id="topName"></span>
			    </div>
			    <div id="topContent" style="text-indent: 2em;" class="pink">
			     
			    </div>
			    <div class="pull-right blue">
			    	<div class="pull-right">
				    	<span>时间：</span><label id="topTime"></label>
			    	</div>
			    	<div style="margin-right:4px" class="pull-right" id="apply">
			    		<span>申请人电话：</span>
			    		<label class="red" id="topTel"></label>
			    	</div>
			    </div>
			</div>
			<div class="modal-footer">
				<button id="modal-cancel" type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			    <button id="modal-confirm" type="button" class="btn btn-primary">确定</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript">
    
</script>
    
    
