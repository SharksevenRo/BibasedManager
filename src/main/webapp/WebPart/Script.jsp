<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- basic scripts -->
<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery||document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery.js'>"+ "<"+"/script>");
	</script>
<!-- <![endif]-->
<!--[if IE]>
	<script type="text/javascript">
	 	window.jQuery || document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery1x.js'>"+"<"+"/script>");
	</script>
<![endif]-->
<script type="text/javascript">
	if ("ontouchstart" in document.documentElement)
		document.write("<script src='${pageContext.request.contextPath }/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
</script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.scroller.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.colorpicker.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.fileinput.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.typeahead.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.wysiwyg.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.spinner.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.treeview.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.wizard.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/elements.aside.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.ajax-content.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.touch-drag.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.sidebar.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.submenu-hover.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.widget-box.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.settings.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.settings-rtl.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.settings-skin.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.widget-on-reload.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/ace/ace.searchbox-autocomplete.js"></script>
<script>
</script>