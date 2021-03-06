<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>付款单创建</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="../header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="../aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				付款管理 <small>付款表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/payment/findAll.do">付款管理</a></li>
				<li class="active">付款表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->
			<form action="${pageContext.request.contextPath}/payment/save.do"
				method="post" onsubmit="check()">
				<!-- 正文区域 -->
				<section class="content"> <!--产品信息-->

					<div class="panel panel-default">
						<div class="panel-heading">付款信息</div>
						<div class="row data-type">

							<div class="col-md-2 title">单据编号</div>
							<div class="col-md-4 data">
								<input type="text" id="paymentId" class="form-control"
									   placeholder="单据编号" value="${paymentId}" readonly name="paymentId">
							</div>

							<div class="col-md-2 title">付款帐户名</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="accountName"
									   value="${accountList.accountName}" readonly>
								<input type="hidden" value="${accountList.id}" name="accountId">
							</div>
							<div class="col-md-2 title">付款账号</div>
							<div class="col-md-4 data">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-search" onclick="location.href='${pageContext.request.contextPath}/payment/findAccountToPayment.do?paymentId=${paymentId}'"></i>
                                    </div>
                                    <input type="text" class="form-control" id="accountNo"
                                           value="${accountList.accountNo}" readonly>
                                </div>

							</div>
							<div class="col-md-2 title">金额</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="paymentAmount"
									   value="" name="amount" >
							</div>
							<div class="col-md-2 title">币种</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="currencyId"
									   value="${accountList.currencyid}" readonly >
							</div>
							<div class="col-md-2 title">账户用途</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control"
									   id="accountPurposeId" value="${accountList.accountPurposeId}" readonly>
							</div>
							<div class="col-md-2 title">账户性质</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="accountType"
									   value="${accountList.accountType}" readonly>
							</div>
							<div class="col-md-2 title">银行名称</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="bankName"
									   value="${accountList.bankId.bankName}" readonly>
							</div>
							<div class="col-md-2 title">银行联行号</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="uniteCode"
									   value="${accountList.bankId.uniteCode}" readonly>
							</div>
							<div class="col-md-2 title">银行所属省</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="bankProvince"
									   value="${accountList.bankId.bankProvince}" readonly>
							</div>
							<div class="col-md-2 title">银行所属市</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="bankCity"
									   value="${accountList.bankId.bankCity}" readonly>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">收款信息</div>
						<div class="row data-type">

							<div class="col-md-2 title">收款帐户名</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="recName"
									   value="" name="recName" >
							</div>
							<div class="col-md-2 title">收款账号</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="recAccount"
									   value=""  name="recAccount">
							</div>
							<div class="col-md-2 title">收款银行</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="recBankName"
									   value="" name="recBankName">
							</div>
							<div class="col-md-2 title">收款联行号</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="recUniteCode"
									   value=""  name="recUniteCode">
							</div>
							<div class="col-md-2 title">银行所属省</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control"
									   id="recProvince" value="" name="recProvince" >
							</div>
							<div class="col-md-2 title">银行所属市</div>
							<div class="col-md-4 data">
								<input type="text" class="form-control" id="reCity"
									   value="" name="reCity" >
							</div>

							<div class="col-md-2 title rowHeight2x">其他信息</div>
							<div class="col-md-10 data rowHeight2x">
								<textarea class="form-control" rows="3" id="memo" style="resize:none" name="memo"></textarea>
							</div>

						</div>
					</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="location.href='${pageContext.request.contextPath}/payment/findAll.do'">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
		</div>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 duyu
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->

	</div>


	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
        <%
         String Message=(String) request.getAttribute("Message");
         if (Message!=null&&!"".equals(Message)){
             %>
        alert("<%=Message %>");<%
		 }
		%>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}
	</script>


</body>

</html>