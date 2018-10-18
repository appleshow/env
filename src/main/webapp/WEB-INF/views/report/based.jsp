<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2018/8/6
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>${title}</title>
    <meta name="description"
          content="Dashboard"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge"/>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8"/>
    <!--DataTables Styles-->
    <link rel="stylesheet"
          href="${ctx}/dataTables/Bootstrap-3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/DataTables-1.10.11/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/Responsive-2.0.2/css/responsive.bootstrap.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/Buttons-1.1.2/css/buttons.bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/Buttons-1.1.2/css/buttons.bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/Select-1.1.2/css/select.bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/dataTables/Editor-1.5.5/css/editor.bootstrap.min.css"/>
    <!--  -->
    <link rel="stylesheet"
          href="${ctx}/assets-view/comm/color.css"/>
    <link rel="stylesheet"
          href="${ctx}/assets/css/font-awesome.min.css"/>

    <style type="text/css">
        .table > tbody > tr > td, .table > tbody > tr > th {
            padding: 3px;
        }

        .table-bordered > tfoot > tr > td, .table-bordered > tfoot > tr > th,
        .table-bordered > thead > tr > td, .table-bordered > thead > tr > th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<!--#tbReport-->
<table class="table table-striped table-bordered display responsive nowrap"
       cellspacing="0"
       width="100%"
       name="tbReport"
       id="tbReport">
    <thead>
    <tr>
        <th colspan="16"
            style="text-align: center;"><h3><b>表 D-10 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;烟气排放连续监测小时平均值日报表</b></h3>
        </th>
    </tr>
    <tr>
        <th colspan="16"
            style="text-align: left;padding-left: 20%;"><span>排放源名称：</span>
        </th>
    </tr>
    <tr>
        <th colspan="16"
            style="text-align: left;padding-left: 20%;">
            <span>排放源编号：124567897845474547845454</span><span style="padding-left: 40%;">监测日期：2018年 08月 07日</span>
        </th>
    </tr>
    <tr>
        <th rowspan="2"
            style="text-align: center;vertical-align: middle;">时间
        </th>
        <th colspan="3"
            style="text-align: center;">颗粒物
        </th>
        <th colspan="3"
            style="text-align: center;">SO<sub>2</sub></th>
        <th colspan="3"
            style="text-align: center;">NO<sub>x</sub></th>
        <th style="text-align: center;">标态流量</th>
        <th style="text-align: center;">氧量</th>
        <th style="text-align: center;">烟温</th>
        <th style="text-align: center;">含湿量</th>
        <th style="text-align: center;">负荷</th>
        <th rowspan="2"
            style="text-align: center;vertical-align: middle;">备注
        </th>
    </tr>
    <tr>
        <th style="text-align: center;">mg/m<sup>3</sup></th>
        <th style="text-align: center;">折算 mg/m<sup>3</sup></th>
        <th style="text-align: center;">kg/h</th>
        <th style="text-align: center;">m/m<sup>2</sup></th>
        <th style="text-align: center;">折算 mg/m<sup>3</sup></th>
        <th style="text-align: center;">kg/h</th>
        <th style="text-align: center;">mg/m<sup>3</sup></th>
        <th style="text-align: center;">折算 mg/m<sup>3</sup></th>
        <th style="text-align: center;">kg/h</th>
        <th style="text-align: center;">m<sup>2</sup>/h</th>
        <th style="text-align: center;">%</th>
        <th style="text-align: center;">°C</th>
        <th style="text-align: center;">%</th>
        <th style="text-align: center;">%</th>
    </tr>
    </thead>
</table>
<!--#tbReport-->

<!-- 提示框 -->
<div class="modal fade"
     role="dialog"
     aria-labelledby="mwTitle"
     id="modal-warning">
    <div class="modal-dialog"
         role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button"
                        class="close"
                        data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h3 class="modal-title text-center">
                    <span class="label label-warning"
                          id="mwTitle"></span>
                </h3>
            </div>
            <div class="modal-body text-center"
                 id="mwMessage">
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-warning"
                        data-dismiss="modal">确定
                </button>
            </div>
        </div>
    </div>
</div>

<!-- DataTables Script -->
<script src="${ctx}/dataTables/jQuery-2.2.0/jquery-2.2.0.min.js"></script>
<script src="${ctx}/dataTables/Bootstrap-3.3.6/js/bootstrap.min.js"></script>
<script src="${ctx}/dataTables/DataTables-1.10.11/js/jquery.dataTables.min.js "></script>
<script src="${ctx}/dataTables/DataTables-1.10.11/js/dataTables.bootstrap.min.js"></script>
<script src="${ctx}/dataTables/Responsive-2.0.2/js/dataTables.responsive.min.js"></script>
<script src="${ctx}/dataTables/Responsive-2.0.2/js/responsive.bootstrap.min.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/dataTables.buttons.min.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.bootstrap.min.js"></script>
<script src="${ctx}/dataTables/Select-1.1.2/js/dataTables.select.min.js"></script>
<script src="${ctx}/dataTables/Editor-1.5.5/js/dataTables.editor.min.js"></script>
<script src="${ctx}/dataTables/Editor-1.5.5/js/editor.bootstrap.min.js"></script>
<!--  -->
<!-- Print Script -->
<script src="${ctx}/dataTables/JSZip-2.5.0/jszip.min.js"></script>
<script src="${ctx}/dataTables/pdfmake-0.1.18/build/pdfmake.min.js"></script>
<script src="${ctx}/dataTables/pdfmake-0.1.18/build/vfs_fonts.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.html5.min.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.print.js"></script>
<!--  -->
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>

<script type="application/javascript">
    var pagePars = {
        tbReport: {},
    };

    jQuery(document).ready(function () {
        pagePars.tbReport = new CommDataTables("#tbReport", null, initColumnInfo(), callError, null);
        pagePars.tbReport.buttons = "P";
        pagePars.tbReport.lengthInfo = {
            lengthMenu: [
                [
                    -1
                ], [
                    "全部"
                ]
            ],
            pageLength: -1
        };

        pagePars.tbReport.create(null, dataTableAjax);
    });

    /**
     *
     * @param data
     * @param callback
     * @param settings
     */
    function dataTableAjax(data, callback, settings) {
        var tableData = {
            draw: settings.iDraw,
            recordsTotal: 1,
            recordsFiltered: 1,
            data: [{c1: 0, c2: 99, c3: 0, c4: 0, c5: 44.5, c6: 0, c7: 0, c8: 0, c9: 0, c10: 0, c11: 0, c12: 0, c13: 0, c14: 0, c15: 0, c16: 0,}]
        };

        callback(tableData);
    }

    /**
     *
     */
    function initColumnInfo() {
        var tableColumnInfo = {};
        var columnInfo = {};

        columnInfo.name = "";
        columnInfo.primary = 0;
        columnInfo.update = 0;
        columnInfo.edit = 0;
        columnInfo.type = "text";
        columnInfo.lock = 0;
        columnInfo.sort = 0;
        columnInfo.hide = 0;
        columnInfo.align = 2;
        columnInfo.prtype = "T";

        tableColumnInfo["c1"] = columnInfo;
        tableColumnInfo["c2"] = columnInfo;
        tableColumnInfo["c3"] = columnInfo;
        tableColumnInfo["c4"] = columnInfo;
        tableColumnInfo["c5"] = columnInfo;
        tableColumnInfo["c6"] = columnInfo;
        tableColumnInfo["c7"] = columnInfo;
        tableColumnInfo["c8"] = columnInfo;
        tableColumnInfo["c9"] = columnInfo;
        tableColumnInfo["c10"] = columnInfo;
        tableColumnInfo["c11"] = columnInfo;
        tableColumnInfo["c12"] = columnInfo;
        tableColumnInfo["c13"] = columnInfo;
        tableColumnInfo["c14"] = columnInfo;
        tableColumnInfo["c15"] = columnInfo;
        tableColumnInfo["c16"] = columnInfo;


        return tableColumnInfo;
    }

    /**
     *
     * @param code
     * @param message
     */
    function callError(code, message) {
        $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
        $("#mwMessage").html(message);
        $("#modal-warning").modal("show");
    }
</script>
</body>
</html>
