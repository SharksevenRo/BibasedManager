<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default">
	<script type="text/javascript">
		try {
			ace.settings.check('navbar', 'fixed')
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

			<!-- /section:basics/navbar.layout.brand -->

			<!-- #section:basics/navbar.toggle -->

			<!-- /section:basics/navbar.toggle -->
		</div>

		<!-- #section:basics/navbar.dropdown -->
		<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a href="charge.aspx">
								<i class="ace-icon fa fa-tasks"></i>
								<span>费用</span>
								<!-- <span class="badge badge-grey">4</span> -->
							</a>

						</li>

						<li class="green">
							<a  href="notice.aspx">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span>通知</span>
								<span class="badge badge-success">5</span>
							</a>

						</li>

						<li class="purple">
							<a href="about.aspx">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span>关于</span>
							</a>
						</li>



						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="http://ace.zcdreams.comassets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									张三
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="info.aspx">
										<i class="ace-icon fa fa-user"></i>
										个人消息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="index.aspx">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

		<!-- /section:basics/navbar.dropdown -->
	</div>
	<!-- /.navbar-container -->
</div>
<!-- <script language="javascript">
     var t = null;
    t = setTimeout(time,1000);//开始执行
    function time()
    {
       clearTimeout(t);//清除定时器
       dt = new Date();
       var h=dt.getHours();
       var m=dt.getMinutes();
       var s=dt.getSeconds();
       document.getElementById("timeShow").innerHTML =  "现在的时间为："+h+" 时 "+m+" 分 "+s+" 秒  ";
       t = setTimeout(time,1000); //设定定时器，循环执行             
    } 
  </script> -->