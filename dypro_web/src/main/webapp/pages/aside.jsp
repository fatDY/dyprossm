<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>
            <security:authorize access="hasRole('ADMIN')">
			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>


				<ul class="treeview-menu">
					<li id="system-setting">

						<a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a>

					</li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/permission/findAll.do">
							<i class="fa fa-circle-o"></i> 资源权限管理
					</a></li>

					<%--<li id="system-setting">
						<a
						href="${pageContext.request.contextPath}/sysLog/findAll.do"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a>
					</li>--%>
				</ul>

			</li>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')||hasRole('ACCOUNT')||hasRole('BANK')">
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<security:authorize access="hasRole('ADMIN')||hasRole('BANK')">
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/bank/findAll.do?page=1&size=10"> <i
							class="fa fa-circle-o"></i> 银行管理
					</a></li></security:authorize>
					<security:authorize access="hasRole('ADMIN')||hasRole('ACCOUNT')">
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/account/findAll.do?page=1&size=10">
							<i class="fa fa-circle-o"></i> 账户管理
					</a></li>
					</security:authorize>


				</ul></li>
            </security:authorize>
			<security:authorize access="hasRole('ADMIN')||hasRole('PAYADD')||hasRole('PAYSEND')||hasRole('PAYACT')">
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>付款管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<security:authorize access="hasRole('ADMIN')||hasRole('PAYADD')">
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/payment/findAll.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 付款单据管理
					</a></li>
					</security:authorize>
					<security:authorize access="hasRole('ADMIN')||hasRole('PAYACT')">
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/payment/findAllConfirm.do?page=1&size=5"> <i
							class="fa fa-circle-o"></i> 付款单据复核
					</a></li></security:authorize>
					<security:authorize access="hasRole('ADMIN')||hasRole('PAYSEND')">
						<li id="system-setting"><a
								href="${pageContext.request.contextPath}/payment/findPaymentToBank.do?page=1&size=5"> <i
								class="fa fa-circle-o"></i> 付款单据指令管理
						</a></li>
					</security:authorize>





				</ul></li>
			</security:authorize>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>