<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
	<script type="text/javascript">
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<!-- #section:basics/sidebar.layout.shortcuts -->
			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>

			<!-- /section:basics/sidebar.layout.shortcuts -->
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- /.sidebar-shortcuts -->

	<ul class="nav nav-list">
		<c:forEach items="${sessionScope.menus}" var="menu">
		<c:if test="${menu.child!=null }">
			<li id="dashboard" class="">
			<a href="${menu.functionUrl }" class="dropdown-toggle">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text">${menu.name }</span>
				<b class="arrow"></b>
			</a>
			<b cite="arrow"></b>
			
				<ul class="submenu">
					<c:forEach items="${menu.child}" var="child">
						<li name="menu11" class="">
						<a href="${child.functionUrl }">
							<i class="menu-icon fa fa-caret-right"></i>${child.name }
						 </a>
						</li>
					</c:forEach>
				</ul>
			
			</li>
		</c:if>
		<c:if test="${menu.child==null }">
			<li id="dashboard" class="">
			<a href="${menu.functionUrl }" class="">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text">${menu.name }</span>
				<b class="arrow"></b>
				</a>
				<b cite="arrow"></b>
			</li>
		</c:if>
		</c:forEach>
	</ul>
	<!-- /.nav-list -->

	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
	</script>
</div>

<!-- /section:basics/sidebar -->
