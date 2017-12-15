<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/12/15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>站点权限</title>
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
    <link rel="stylesheet"
          href="${ctx}/datetimePicker/css/bootstrap-datetimepicker.min.css"/>
    <!--  -->
    <link rel="stylesheet"
          href="${ctx}/assets-view/comm/color.css"/>
    <link rel="stylesheet"
          href="${ctx}/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet"
          href="${ctx}/assets-view/comm/tree/css/tree.css"/>
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
    <div class="col-lg-2 col-sm-2 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">组织架构列表</div>
            <div class="panel-body"
                 style="height: 92%;overflow-y:scroll; ">
                <div id="tree-org"
                     class="tree tree-plus-minus tree-solid-line">
                    <div class="tree-folder"
                         style="display: none;">
                        <div class="tree-folder-header">
                            <i class="fa fa-folder"></i>
                            <div class="tree-folder-name"></div>
                        </div>
                        <div class="tree-folder-content"></div>
                        <div class="tree-loader"
                             style="display: none;"></div>
                    </div>
                    <div class="tree-item"
                         style="display: none;">
                        <i class="tree-dot"></i>
                        <div class="tree-item-name"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-10 col-sm-10 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">站点权限设置</div>
            <div class="panel-body"
                 style="height: 92%;overflow-y:scroll; ">
                <div class="row"
                     style="margin-right: 0px; margin-bottom: 0px;">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <input style="width: 100%; display: none;"
                               readonly
                               id="orgId"
                               name="orgId">
                        </input>
                        <table id="tbNodeAccess"
                               class="table table-striped table-bordered display responsive nowrap"
                               cellspacing="0"
                               width="100%">
                            <thead>
                            <tr id="tbNodeAccessHC">
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
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

<script type="application/javascript">
    /**
     * 当前页面全局变量
     */
    var pagePars = {
        firstLoad: true,
        tbNodeAccess: undefined,
        orgs: [],
    };
    var pageShowDataUrl = "${ctx}/comm/referPageShow";

    var DataSourceTree = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'org';
    };
    DataSourceTree.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                var farOrgId = 0;

                if (options.id != null) {
                    farOrgId = options.id;
                }

                $.ajax({
                    async: true,
                    type: "POST",
                    url: "${ctx}/viewHbNodeAccessCfg/refOrg",
                    cache: false,
                    data: ServerRequestPar(1, {
                        farOrgId: farOrgId
                    }),
                    dataType: "json",
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8'
                    },
                    success: function (res) {
                        if (res.code != 0) {
                            callback({
                                data: []
                            });
                        } else {
                            var treeData = [];

                            $.each(res.data, function (index, value) {
                                var item = {};

                                item.id = value.orgId;
                                item.name = value.orgName;
                                if (value.prgroup == "0") {
                                    item.type = 'item';
                                } else {
                                    item.type = 'folder';
                                }
                                treeData.push(item);
                            });

                            callback({
                                data: treeData
                            });

                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        callback({
                            data: []
                        });
                    }
                });
            }, this._delay)
        }
    };

    var treeDataNode = new DataSourceTree({
        data: [],
        delay: 400
    });

    jQuery(document).ready(function () {
        // ******** 开始初始化组织列表 ********
        $('#tree-org').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: treeDataNode,
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });
        // ******************** ==== ********************
        // ******** 查询组织信息 ********
        $.ajax({
            async: false,
            type: "POST",
            url: "${ctx}/viewHbNodeAccessCfg/refOrg",
            cache: false,
            data: ServerRequestPar(1, {
                farOrgId: '',
            }),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                } else {
                    pagePars.orgs = res.data;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }

        });

        // ******************** ==== ********************
        // ******** 开始初始化站点权限表格 ********
        pagePars.tbNodeAccess = new CommDataTables("#tbNodeAccess", "#tbNodeAccessHC", ${pageId}, callError, pageShowDataUrl);
        pagePars.tbNodeAccess.buttons = "EP";
        pagePars.tbNodeAccess.serverInfo.referUrl = "${ctx}/viewHbNodeAccessCfg/refNodeAccess";
        pagePars.tbNodeAccess.serverInfo.referControls.push(ControlPar("text", "orgId", "", $("#orgId")));
        pagePars.tbNodeAccess.serverInfo.modifyUrl = "${ctx}/viewHbNodeAccessCfg/modifyNodeAccess";

        pagePars.tbNodeAccess.columns["resourceTypeE"].render = function (data, type, row) {
            var fixData = data;

            if (type === 'display') {
                $.each(pagePars.orgs, function (index, org) {
                    if (org["orgId"] == data) {
                        fixData = org["orgName"];
                    }
                });
            }
            return fixData;
        };

        pagePars.tbNodeAccess.fields["resourceTypeE"].options = TransToOptions(pagePars.orgs, "orgId", "orgName");

        pagePars.tbNodeAccess.create();
        // ******************** ==== ********************
    });

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'org') {
            if (items && items.length > 0) {
                var selectItem = items[0];

                $("#orgId").val(selectItem.id);
            }

            pagePars.tbNodeAccess.table.ajax.reload(null, false);
        }
    }

    /**
     *
     */
    function callError(code, message) {
        if (!pagePars.firstLoad) {
            $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
            $("#mwMessage").html(message);
            $("#modal-warning").modal("show");
        } else {
            pagePars.firstLoad = false;
        }

    }
</script>
</body>
</html>
