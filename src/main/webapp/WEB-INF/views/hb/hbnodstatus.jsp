<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/12/17
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<title>站点状态</title>
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
<!--  -->
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/color.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/select2-4.0.2/css/select2.min.css"/>
<style type="text/css">
    .table > tbody > tr > td, .table > tbody > tr > th {
        padding: 3px;
    }

    .table-bordered > tfoot > tr > td, .table-bordered > tfoot > tr > th,
    .table-bordered > thead > tr > td, .table-bordered > thead > tr > th {
        border: 1px solid black;
    }

    .select2-container .select2-selection--single {
        height: 34px !important;
        line-height: 34px;
    }

    .select2-container--default .select2-selection--single .select2-selection__rendered {
        line-height: 34px;
    }

    .select2-container--default .select2-selection--single .select2-selection__arrow {
        height: 34px;
    }
</style>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <div class="row">
            <div class="col-lg-4 col-sm-4 col-xs-12">
                <div class="form-group"
                     style="margin-bottom: 6px;">
                    <div class="controls">
                        <div class="input-group">
                                                  <span class="input-group-btn">
                                                       <button class="btn btn-default"
                                                               type="button">监测时间</button>
                                                  </span> <select class="form-control"
                                                                  style="width: 200px;"
                                                                  id="hours">
                            <option value="1">最近1小时</option>
                            <option value="2">最近2小时</option>
                            <option value="4">最近4小时</option>
                            <option value="6">最近6小时</option>
                            <option value="12">最近12小时</option>
                            <option value="24">最近24小时</option>
                        </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="panel-body">
        <table id="table-nodestatus"
               class="table table-striped table-bordered display nowrap"
               cellspacing="0"
               width="100%">
            <thead>
            <tr id="table-nodestatus-columns">
            </tr>
            </thead>
        </table>
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
<script src="${ctx}/assets-view/comm/select2-4.0.2/js/select2.full.min.js"></script>
<script src="${ctx}/assets-view/comm/select2-4.0.2/js/i18n/zh-CN.js"></script>
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>
<script type="application/javascript">
    //页面全局变量
    var pagePars = {
        // Grid表格
        tableHbNodeStatus: undefined,
    }
    var pageShowDataUrl = "${ctx}/comm/referPageShow";

    jQuery(document).ready(function () {
        $("#hours").select2({
            placeholder: "选择监测时间",
            allowClear: true,
            language: "zh-CN"
        });

        pagePars.tableHbNodeStatus = new CommDataTables("#table-nodestatus", "#table-nodestatus-columns", ${pageId}, callError, pageShowDataUrl);
        pagePars.tableHbNodeStatus.buttons = "P";
        pagePars.tableHbNodeStatus.scrollY = 72;
        // *********************************
        pagePars.tableHbNodeStatus.create(null, datatableRefAjax);

        $('#hours').on('select2:select', function (evt) {
            pagePars.tableHbNodeStatus.table.ajax.reload(null, false);
        });
    });

    /**
     *
     * @param data
     * @param callback
     * @param settings
     * @returns
     */
    function datatableRefAjax(data, callback, settings) {
        var tableData = {
            draw: settings.iDraw,
            recordsTotal: 0,
            recordsFiltered: 0,
            data: []
        };

        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbNodeStatus/refNodeStatus",
            cache: false,
            data: ServerRequestPar(1, {
                hours: $("#hours").val(),
            }),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callback(tableData);
                    callError(res.code, res.message);
                } else {
                    tableData.recordsTotal = res.totalCount;
                    tableData.recordsFiltered = res.totalCount;

                    $.each(res.data, function (index, lineData) {
                        if (lineData.hasOwnProperty("exceptionPars")) {
                            var exceptionParString = "";

                            $.each(lineData.exceptionPars, function (indexExceptionPar, exceptionPar) {
                                var titleInfo = lineData.dataCount + "条记录中：";
                                var detail = false;

                                if (exceptionPar.valueMinCount > 0) {
                                    if (detail) {
                                        titleInfo += " ;" + exceptionPar.valueMinCount + "条超下限";
                                    } else {
                                        detail = true;
                                        titleInfo += exceptionPar.valueMinCount + "条超下限";
                                    }
                                }
                                if (exceptionPar.valueMaxCount > 0) {
                                    if (detail) {
                                        titleInfo += " ;" + exceptionPar.valueMaxCount + "条超上限";
                                    } else {
                                        detail = true;
                                        titleInfo += exceptionPar.valueMaxCount + "条超上限";
                                    }
                                }
                                if (exceptionPar.valueAla1Count > 0) {
                                    if (detail) {
                                        titleInfo += " ;" + exceptionPar.valueAla1Count + "条超一级阀值";
                                    } else {
                                        detail = true;
                                        titleInfo += exceptionPar.valueAla1Count + "条超一级阀值";
                                    }
                                }
                                if (exceptionPar.valueAla2Count > 0) {
                                    if (detail) {
                                        titleInfo += " ;" + exceptionPar.valueAla2Count + "条超二级阀值";
                                    } else {
                                        detail = true;
                                        titleInfo += exceptionPar.valueAla2Count + "条超二级阀值";
                                    }
                                }
                                if (exceptionPar.valueAla3Count > 0) {
                                    if (detail) {
                                        titleInfo += " ;" + exceptionPar.valueAla3Count + "条超三级阀值";
                                    } else {
                                        detail = true;
                                        titleInfo += exceptionPar.valueAla3Count + "条超三级阀值";
                                    }
                                }

                                if (exceptionPar.hbTypeItemNode.itemAlarm == 1) {
                                    exceptionParString += ' <kbd style="background:red" title="' + titleInfo + '">' + exceptionPar.hbTypeItemNode.itemName + '</kbd>';
                                } else {
                                    exceptionParString += ' <kbd style="background:green" title="' + titleInfo + '">' + exceptionPar.hbTypeItemNode.itemName + '</kbd>';
                                }
                                //exceptionParString += ' <button type="button" class="btn btn-sm btn-danger" title="' + titleInfo + '">' + exceptionPar.hbTypeItemNode.itemName + '</button>'
                            });

                            lineData.nodeStatus = "<kbd style='background:red'>离线</kbd>";
                            lineData.exceptionPars = exceptionParString;
                            lineData.DT_RowId = "_" + index;

                            tableData.data.push(lineData);
                        } else {
                            lineData.nodeStatus = "<kbd style='background:red'>离线</kbd>";
                            lineData.DT_RowId = "_" + index;

                            tableData.data.push(lineData);
                        }
                    });

                    refData(tableData, callback);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
                callback(tableData);
            }

        });
    }

    function refData(tableData, callback) {
        $.ajax({
            type: "get",
            url: "http://${nioServer}/getOnlineClient",
            data: {},
            success: function (res) {
                $.each(res, function (indexStatus, status) {
                    $.each(tableData.data, function (indexData, lineData) {
                        if (lineData.dataFrom == status) {
                            lineData.nodeStatus = "<kbd style='background:green'>在线</kbd>";
                        }
                    });
                });
                callback(tableData);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callback(tableData);
            }

        });
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
