<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>付款单据查询</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">


    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

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
    <script type="javascript">

    </script>
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
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                付款管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">付款单据管理</a></li>
                <li class="active">付款指令列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <%--  <button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/payment/paymentAddView.do'">
                                          <i class="fa fa-check"></i> 新建
                                    </button>--%>
                                   <%-- <button type="button" class="btn btn-default" title="删除" onclick="backPayment()">
                                        <i class="fa fa-trash-o"></i> 撤回
                                    </button>--%>
                                    <button type="button" class="btn btn-default" title="提交" onclick="">
                                        <i class="fa fa-check"></i> 提交
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="location.href='${pageContext.request.contextPath}/payment/findPaymentToBank.do'">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <%-- <div class="box-tools pull-right">
                             <div class="has-feedback">
                                 <input id="searchNo" type="text" class="form-control input-sm"
                                        placeholder="搜索账户号">
                                 <a class="glyphicon glyphicon-search form-control-feedback"
                                    href="javascript:search();"></a>
                             </div>
                         </div>--%>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <form method="post" id="form">
                            <table id="dataList"
                                   class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                <tr>
                                    <th class="sorting_desc"></th>
                                    <th class="sorting_desc">付款单号</th>
                                    <th class="sorting_asc sorting_asc_disabled">付款账户号</th>
                                    <th class="sorting_desc sorting_desc_disabled">付款账户名</th>
                                    <th class="sorting">付款金额</th>
                                    <th class="text-center sorting">收款账户名</th>
                                    <th class="text-center sorting">收款账户号</th>
                                    <th class="sorting">付款单据状态</th>
                                    <%--    <th class="text-center sorting">账户银行开户地</th>--%>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>


                                <c:forEach items="${pageInfo.list}" var="payment">

                                    <tr>
                                        <td><input id="ids" name="ids" type="checkbox" value="${payment.id}"></td>
                                        <td>${payment.paymentId}</td>
                                        <td>${payment.paymentAccountId.accountNo}</td>
                                        <td>${payment.paymentAccountId.accountName}</td>
                                        <td>${payment.paymentAmount}</td>
                                        <td>${payment.recName}</td>
                                        <td>${payment.recAccount}</td>
                                        <td>${payment.statement}</td>
                                            <%--	<td>${account.bankId.uniteCode}</td>
                                                <td>${account.bankId.location}</td>--%>

                                            <%--<td class="text-center">${account.productPrice }</td>--%>
                                            <%--<td>${account.productDesc }</td>--%>
                                            <%--<td class="text-center">${account.productStatusStr }</td>--%>
                                        <td class="text-center">
                                                <%--<a href="${pageContext.request.contextPath}/account/findById.do?id=${account.id}" class="btn bg-olive btn-xs">详情</a>--%>
                                            <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                                    data-target="#myModal"
                                                    onclick="findById(this.value)" value="${payment.paymentId}">
                                                详情
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <%--  付款单据详情模块化窗口modal-primary--%>
                                <div id="myModal" class="modal" role="dialog">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title">付款单据详情</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="box-body">
                                                    <div class="panel panel-default">
                                                        <div class="panel-heading">付款指令报文</div>
                                                        <div class="row data-type">
                                                            <div id="head"></div>
                                                            <div id="cmbsdkpgk">&lt;CMBSDKPGK&gt;</div>
                                                                <div id="info" class="col-md-offset-1">&lt;INFO&gt;</div>
                                                                    <div id="funnam" class="col-md-offset-2">&lt;FUNNAM&gt;
                                                                        <span id="funnam-text" ></span>&lt;/FUNNAM&gt;</div>
                                                                    <div id="DATTYP" class="col-md-offset-2">&lt;DATTYP&gt;
                                                                        <span id="DATTYP-text"></span>&lt;/DATTYP&gt;</div>
                                                                     <div id="LGNNAM" class="col-md-offset-2">&lt;LGNNAM&gt;
                                                                         <span id="LGNNAM-text"></span>&lt;/LGNNAM&gt;</div>
                                                                <div id="infoE" class="col-md-offset-1">&lt;/INFO&gt;</div>

                                                                <div id="SDKPAYRQX" class="col-md-offset-1">&lt;SDKPAYRQX&gt;</div>
                                                                    <div id="BUSCOD" class="col-md-offset-2">&lt;BUSCOD&gt;
                                                                        <span id="BUSCOD-text" ></span>&lt;/BUSCOD&gt;</div>
                                                                    <div id="BUSMOD" class="col-md-offset-2">&lt;BUSMOD&gt;
                                                                        <span id="BUSMOD-text"></span>&lt;/BUSMOD&gt;</div>
                                                                <div id="SDKPAYRQXE" class="col-md-offset-1">&lt;/SDKPAYRQX&gt;</div>

                                                                <div id="SDKPAYDTX" class="col-md-offset-1">&lt;SDKPAYDTX&gt;</div>
                                                                    <div id="YURREF" class="col-md-offset-2">&lt;YURREF&gt;
                                                                        <span id="YURREF-text" ></span>&lt;/YURREF&gt;</div>
                                                                    <div id="EPTDAT" class="col-md-offset-2">&lt;EPTDAT&gt;
                                                                        <span id="EPTDAT-text"></span>&lt;/EPTDAT&gt;</div>
                                                                    <div id="EPTTIM" class="col-md-offset-2">&lt;EPTTIM&gt;
                                                                        <span id="EPTTIM-text"></span>&lt;/EPTTIM&gt;</div>
                                                                    <div id="DBTACC" class="col-md-offset-2">&lt;DBTACC&gt;
                                                                        <span id="DBTACC-text"></span>&lt;/DBTACC&gt;</div>
                                                                    <div id="DBTBBK" class="col-md-offset-2">&lt;DBTBBK&gt;
                                                                        <span id="DBTBBK-text"></span>&lt;/DBTBBK&gt;</div>
                                                                    <div id="TRSAMT" class="col-md-offset-2">&lt;TRSAMT&gt;
                                                                        <span id="TRSAMT-text"></span>&lt;/TRSAMT&gt;</div>
                                                                    <div id="C_CCYNBR" class="col-md-offset-2">&lt;C_CCYNBR&gt;
                                                                        <span id="C_CCYNBR-text"></span>&lt;/C_CCYNBR&gt;</div>
                                                                    <div id="STLCHN" class="col-md-offset-2">&lt;STLCHN&gt;
                                                                        <span id="STLCHN-text"></span>&lt;/STLCHN&gt;</div>
                                                                    <div id="NUSAGE" class="col-md-offset-2">&lt;NUSAGE&gt;
                                                                        <span id="NUSAGE-text"></span>&lt;/NUSAGE&gt;</div>
                                                                    <div id="CRTACC" class="col-md-offset-2">&lt;CRTACC&gt;
                                                                        <span id="CRTACC-text"></span>&lt;/CRTACC&gt;</div>
                                                                    <div id="CRTNAM" class="col-md-offset-2">&lt;CRTNAM&gt;
                                                                        <span id="CRTNAM-text"></span>&lt;/CRTNAM&gt;</div>
                                                                    <div id="CRTBNK" class="col-md-offset-2">&lt;CRTBNK&gt;
                                                                        <span id="CRTBNK-text"></span>&lt;/CRTBNK&gt;</div>
                                                                    <div id="CRTPVC" class="col-md-offset-2">&lt;CRTPVC&gt;
                                                                        <span id="CRTPVC-text"></span>&lt;/CRTPVC&gt;</div>
                                                                    <div id="CRTCTY" class="col-md-offset-2">&lt;CRTCTY&gt;
                                                                        <span id="CRTCTY-text"></span>&lt;/CRTCTY&gt;</div>
                                                                    <div id="CRTSQN " class="col-md-offset-2">&lt;CRTSQN &gt;
                                                                        <span id="CRTSQN-text"></span>&lt;/CRTSQN &gt;</div>
                                                                    <div id="TRSTYP " class="col-md-offset-2">&lt;TRSTYP &gt;
                                                                        <span id="TRSTYP-text"></span>&lt;/TRSTYP &gt;</div>
                                                                <div id="SDKPAYDTXE" class="col-md-offset-1">&lt;/SDKPAYDTX&gt;</div>
                                                            <div id="cmbsdkpgkE">&lt;/SDKPAYDTX&gt;</div>
                                                        </div>
                                                    </div>
                                                </div>


                                            </div>
                                        </div>


                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline" data-dismiss="modal">关闭
                                        </button>
                                        <%--<button type="button" class="btn btn-outline" data-dismiss="modal">保存</button>--%>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                    </div>

                    <!-- /.modal-dialog -->

                    </form>
                </div>
                <!--
            <tfoot>
            <tr>
            <th>Rendering engine</th>
            <th>Browser</th>
            <th>Platform(s)</th>
            <th>Engine version</th>
            <th>CSS grade</th>
            </tr>
            </tfoot>-->
                </table>
                <!--数据列表/-->

                <!--工具栏-->
                <%--  <div class="box-tools pull-right">
                      <div class="has-feedback">
                          <input type="text" class="form-control input-sm"
                                 placeholder="搜索"> <span
                              class="glyphicon glyphicon-search form-control-feedback"></span>
                      </div>
                  </div>--%>
                <!--工具栏/-->

            </div>
            <!-- 数据表格 /-->



    <!-- /.box-body -->

    <!-- .box-footer-->
    <div class="box-footer">
        <div class="pull-left">
            <div class="form-group form-inline" onchange="changePageSize()">
                总共${pageInfo.pages}页，共${pageInfo.total}条数据。 每页
                <select class="form-control" id="changePageSize">
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                </select> 条
            </div>
        </div>

        <div class="box-tools pull-right">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/payment/findAll.do?page=1&size=${pageInfo.pageSize}"
                       aria-label="Previous">首页</a></li>
                <li>
                    <a href="${pageContext.request.contextPath}/payment/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
                </li>
                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                    <li>
                        <a href="${pageContext.request.contextPath}/payment/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
                    </li>
                </c:forEach>

                <li>
                    <a href="${pageContext.request.contextPath}/payment/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/payment/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                       aria-label="Next">尾页</a></li>
            </ul>
        </div>

    </div>
    <!-- /.box-footer-->


    </section>
    <!-- 正文区域 /-->

</div>
<!-- @@close -->
<!-- 内容区域 /-->

<!-- 底部导航 -->
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 1.0.8
    </div>
    <strong>Copyright &copy; duyu
    </strong> All rights reserved.
</footer>
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
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    <%
         String Message=(String) request.getAttribute("Message");
         if (Message!=null&&!"".equals(Message)){
             %>
    alert("<%=Message %>");
    <%
             }
            %>
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    function confirmPayment() {
        var url = '${pageContext.request.contextPath}/payment/confirmPayment.do';
        if (confirm("确定是否提交")) {
            $("#form").attr('action', url);
            $("#form").submit();
        }
    }

    function updatePayment() {
        var url = '${pageContext.request.contextPath}/payment/paymentUpdate.do';
        $("#form").attr('action', url);
        $("#form").submit();

    }

    function backPayment() {
        var url = '${pageContext.request.contextPath}/payment/paymentDelete.do';
        if (confirm("确定是否删除")) {
            $("#form").attr('action', url);
            $("#form").submit();
        }
    }

    function changePageSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();

        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/payment/findAll.do?page=1&size="
            + pageSize;
    }

    function findById(paymentId) {
        /* alert(id);*/
        $.ajax({
            url: '${pageContext.request.contextPath}/cmb/findById.do',//请求地址
            type: 'post',//请求类型
            contentType: "application/json;charset=utf-8",
            dataType: 'json',//后台返回数据类型
            data: {id: paymentId},//传入后台数据
            success: function (data) {
                /*     alert(eval(data));*/
                $("#head").text("<?xml version=\"1.0\" encoding = \"GBK\"?>");
                $("#funnam-text").text(eval(eval(data).infoId).funnam);
                $("#DATTYP-text").text(eval(eval(data).infoId).dattyp);
                $("#LGNNAM-text").text(eval(eval(data).infoId).lgnam);
                $("#BUSCOD-text").text(eval(eval(data).sdkPayRqxId).busCod);
                $("#BUSMOD-text").text(eval(eval(data).sdkPayRqxId).busMod);
                $("#YURREF-text").text(eval(eval(data).sdkPayDtxId).yurRef);
                $("#EPTDAT-text").text(eval(eval(data).sdkPayDtxId).eptDat);
                $("#EPTTIM-text").text(eval(eval(data).sdkPayDtxId).eptTim);
                $("#DBTACC-text").text(eval(eval(data).sdkPayDtxId).dbtAcc);
                $("#DBTBBK-text").text(eval(eval(data).sdkPayDtxId).c_dbtBbk);
                $("#TRSAMT-text").text(eval(eval(data).sdkPayDtxId).trsAmt);
                $("#C_CCYNBR-text").text(eval(eval(data).sdkPayDtxId).c_ccyNbr);
                $("#STLCHN-text").text(eval(eval(data).sdkPayDtxId).stlChn);
                $("#NUSAGE-text").text(eval(eval(data).sdkPayDtxId).nuSage);
                $("#CRTACC-text").text(eval(eval(data).sdkPayDtxId).crtAcc);
                $("#CRTNAM-text").text(eval(eval(data).sdkPayDtxId).crtNam);
                $("#CRTBNK-text").text(eval(eval(data).sdkPayDtxId).crtBnk);
                $("#CRTPVC-text").text(eval(eval(data).sdkPayDtxId).crtpvc);
                $("#CRTCTY-text").text(eval(eval(data).sdkPayDtxId).crtCty);
                $("#CRTSQN-text").text(eval(eval(data).sdkPayDtxId).crtSqn);
                $("#TRSTYP-text").text(eval(eval(data).sdkPayDtxId).trsTyp);
               /* Info infoId;
                private SdkPayRqx sdkPayRqxId;
                private SdkPayDtx sdkPayDtxId;*/
                /*$("#paymentId").val(eval(data).paymentId);
                $("#paymentDate").val(eval(data).paymentDate);
                $("#accountName").val(eval(eval(data).paymentAccountId).accountName);
                $("#accountNo").val(eval(eval(data).paymentAccountId).accountNo);
                $("#accountPurposeId").val(eval(eval(data).paymentAccountId).accountPurposeId);
                $("#currencyId").val(eval(eval(data).paymentAccountId).currencyid);
                $("#accountType").val(eval(eval(data).paymentAccountId).accountType);
                $("#paymentAmount").val(eval(data).paymentAmount);
                $("#bankName").val(eval(eval(eval(data).paymentAccountId).bankId).bankName);
                $("#uniteCode").val(eval(eval(eval(data).paymentAccountId).bankId).uniteCode);
                $("#bankProvince").val(eval(eval(eval(data).paymentAccountId).bankId).bankProvince);
                $("#bankCity").val(eval(eval(eval(data).paymentAccountId).bankId).bankCity);
                $("#recName").val(eval(data).recName);
                $("#recAccount").val(eval(data).recAccount);
                $("#recBankName").val(eval(data).recBankName);
                $("#recUniteCode").val(eval(data).recUniteCode);
                $("#recProvince").val(eval(data).recProvince);
                $("#reCity").val(eval(data).reCity);
                $("#memo").val(eval(data).memo);*/
            },
            error: function (data) {
                alert("数据服务异常");
            }
        })
    }

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>