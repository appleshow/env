<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/10
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>站点参数</title>
    <meta name="description"
          content="Dashboard"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge"/>
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8"/>
    <!--DataTables Styles-->
    <link rel="stylesheet"
          href="${ctx}/dataTables/Bootstrap-3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/DataTables-1.10.11/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/Responsive-2.0.2/css/responsive.bootstrap.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/Buttons-1.1.2/css/buttons.bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/Buttons-1.1.2/css/buttons.bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/Select-1.1.2/css/select.bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/dataTables/Editor-1.5.5/css/editor.bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/comm/tree/css/tree.css"/>
    <!--  -->
    <link rel="stylesheet"
          href="${ctx}/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/assets-view/comm/color.css"/>
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
<div class="row"
     style="margin-right: 0px; margin-bottom: 0px;">
    <div class="col-lg-12 col-sm-12 col-xs-12">
        <div class="widget flat radius-bordered">
            <div class="widget-body">
                <div class="row">
                    <div class="col-lg-1 col-sm-1 col-xs-4"
                         style="margin-right: 0px;padding-right: 0px">
                        <button class="btn btn-default"
                                type="button"
                                style="width: 100%; text-align: right;">站点名称
                        </button>
                    </div>
                    <div class="col-lg-2 col-sm-2 col-xs-8"
                         style="margin-left: 0px;padding-left: 0px">
                        <div class="input-group">
                            <input class="form-control"
                                   style="width: 100%; display: none;"
                                   readonly
                                   id="nodeId"
                                   name="nodeId">
                            </input>
                            <input class="form-control"
                                   style="width: 100%;"
                                   readonly
                                   id="nodeName"
                                   name="nodeName">
                            </input>
                            <span class="input-group-btn">
                                <button class="btn btn-default"
                                        type="button"
                                        onclick="openNodeWindow()">...</button>
                            </span>
                        </div>
                    </div>
                    <div class="col-lg-1 col-sm-1 col-xs-4"
                         style="margin-right: 0px;padding-right: 0px">
                        <button class="btn btn-default"
                                type="button"
                                style="width: 100%; text-align: right;">站点类型
                        </button>
                    </div>
                    <div class="col-lg-2 col-sm-2 col-xs-8"
                         style="margin-left: 0px;padding-left: 0px">
                        <div class="input-group"
                             style="width: 100%;">
                            <input class="form-control"
                                   readonly
                                   id="typeName"
                                   name="typeName">
                            </input>
                        </div>
                    </div>
                    <div class="col-lg-1 col-sm-1 col-xs-4"
                         style="margin-right: 0px;padding-right: 0px">
                        <button class="btn btn-default"
                                type="button"
                                style="width: 100%; text-align: right;">所属企业
                        </button>
                    </div>
                    <div class="col-lg-2 col-sm-2 col-xs-8"
                         style="margin-left: 0px;padding-left: 0px">
                        <div class="input-group"
                             style="width: 100%;">
                            <input class="form-control"
                                   readonly
                                   id="enterpriseName"
                                   name="enterpriseName">
                            </input>
                        </div>
                    </div>
                </div>
                <table id="tableNodeItem"
                       class="table table-striped table-bordered display responsive nowrap"
                       cellspacing="0"
                       width="100%">
                    <thead>
                    <tr id="tableNodeItemColums">
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade"
     role="dialog"
     aria-labelledby="msTitle"
     id="modal-success">
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
                    <span class="label label-success"
                          id="msTitle"></span>
                </h3>
            </div>
            <div class="modal-body text-center"
                 id="msMessage"></div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-success"
                        data-dismiss="modal">确定
                </button>
            </div>
        </div>
    </div>
</div>
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
                 id="mwMessage"></div>
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
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.print.min.js"></script>
<!--  -->
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>
<%@include file="../aplugin/nodewindow.jsp" %>

<script>
    var tableNodeItem;
    var pageShowDataUrl = "${ctx}/comm/referPageShow";
    var pagePar = {onLoadRefer: true,};

    jQuery(document).ready(function () {
        tableNodeItem = new CommDataTables("#tableNodeItem", "#tableNodeItemColums", ${pageId}, callError, pageShowDataUrl);
        tableNodeItem.serverInfo.referUrl = "${ctx}/viewHbNodeItemCfg/referHbTypeItem";
        tableNodeItem.serverInfo.referControls.push(ControlPar("text", "nodeId", "", $("#nodeId")));
        tableNodeItem.serverInfo.modifyUrl = "${ctx}/viewHbNodeItemCfg/modifyHbNode";

        tableNodeItem.lengthInfo = {
            lengthMenu: [
                [
                    -1
                ], [
                    "全部"
                ]
            ],
            pageLength: -1
        };
        tableNodeItem.scrollY = 75;
        tableNodeItem.buttons = "EP";

        // ***** Add information to Column *****
        // *********************************
        // ***** Add information to Field *****
        // *********************************

        tableNodeItem.create();
    });

    /**
     *
     */
    function openNodeWindow() {
        __showNodeWindow(callBackNodeSelect);
    }

    /**
     *
     * @param selectItems
     * @param currentTreeData
     */
    function callBackNodeSelect(selectItems, currentTreeData) {
        var selectItem = selectItems[0];

        $("#nodeId").val(selectItem.id);
        $("#nodeName").val(selectItem.name);

        $.each(currentTreeData, function (index, item) {
            if (item.nodeId && item.nodeId == $("#nodeId").val()) {
                $("#typeName").val(item.hbType.typeName);
                $("#enterpriseName").val(item.hbEnterprise.enterpriseName);
            }
        });

        document.title = "站点参数（" + selectItem.name + "）"
        tableNodeItem.table.ajax.reload(null, false);
    }

    /**
     *
     * @param code
     * @param message
     */
    function callError(code, message) {
        if (!pagePar.onLoadRefer) {
            $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
            $("#mwMessage").html(message);
            $("#modal-warning").modal("show");
        } else {
            pagePar.onLoadRefer = false;
        }
    }

</script>
</body>
</html>