<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${codeDesc}</title>
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
<div class="panel panel-default">
    <div class="panel-heading">
        <div class="form-group"
             style="margin-bottom: 6px;">
            <div class="controls">
                <div class="input-group">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default"
                                                type="button">${codeName}
                                        </button>
                                    </span>
                    <input class="form-control"
                           style="width: 200px;"
                           id="codeName">
                    </input>
                </div>
            </div>
        </div>
    </div>
    <div class="panel-body">
        <table id="table-comcode"
               class="table table-striped table-bordered display responsive nowrap"
               cellspacing="0"
               width="100%">
            <thead>
            <tr id="table-comcode-columns">
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
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>

<script>
    var tableComCode;
    var comCodeEnterprise = [];
    var pageShowDataUrl = "${ctx}/comm/referPageShow";

    jQuery(document).ready(function () {
        if ('${pageId}' == '21') {
            getComCodeEnterprice();
        }

        tableComCode = new CommDataTables("#table-comcode", "#table-comcode-columns", ${pageId}, callError, pageShowDataUrl);
        tableComCode.serverInfo.referUrl = "${ctx}/viewComCodeConfig/refComCode";
        if ('${pageId}' != '1') {
            tableComCode.serverInfo.referControls.push(ControlPar("real", "codeType", "${pageId}", ""));
        }
        tableComCode.serverInfo.referControls.push(ControlPar("text", "codeName", "", $("#codeName")));
        tableComCode.serverInfo.modifyUrl = "${ctx}/viewComCodeConfig/modifyComCode";

        tableComCode.scrollY = 72;
        // ***** Add information to Column *****
        if ('${pageId}' == '21') {
            tableComCode.columns["property0"].render = function (data, type, row) {
                var fixData = data;

                if (type == 'display') {
                    $.each(comCodeEnterprise, function (index, value) {
                        if (value["codeId"] == data) {
                            fixData = value["codeName"];
                        }
                    });
                }

                return fixData;
            };
        }
        // *********************************
        // ***** Add information to Field *****
        if ('${pageId}' == '21') {
            tableComCode.fields["property0"].options = TransToOptions(comCodeEnterprise, "codeId", "codeName");
        }
        tableComCode.fields["codeType"].options = [{
            label: '${pageId}',
            value: '${pageId}',
        }];
        // *********************************
        tableComCode.create();
    });

    function getComCodeEnterprice() {
        $.ajax({
            async: false,
            type: "POST",
            url: "${ctx}/viewComCodeConfig/refComCode",
            cache: false,
            data: ServerRequestPar(1, {codeType: '20', pageNumber: 1, pageSize: 2000,}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    comCodeEnterprise = res.data;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        });
    }

    function callError(code, message) {
        $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
        $("#mwMessage").html(message);
        $("#modal-warning").modal("show");
    }

</script>
</body>
</html>
