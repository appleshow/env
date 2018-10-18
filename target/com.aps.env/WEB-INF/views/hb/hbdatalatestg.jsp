<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/20
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <title></title>
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
    <div class="col-lg-3 col-sm-3 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">站点列表</div>
            <div class="panel-body"
                 style="height: 92%;overflow-y:scroll; ">
                <div id="enterpriseNode"
                     class="tree tree-folder-select tree-plus-minus tree-solid-line tree-unselectable">
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
    <div class="col-lg-9 col-sm-9 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading"
                 id="dataGridTitle">实时数据
            </div>
            <div class="panel-body"
                 style="height: 92%; ">
                <div class="row"
                     style="margin-right: 0px; margin-bottom: 0px;">
                    <div class="col-lg-12 col-sm-12 col-xs-12">
                        <input style="width: 100%; display: none;"
                               readonly
                               id="nodeId"
                               name="nodeId">
                        </input>
                        <!--#tbNodeData-->
                        <table id="tbNodeData"
                               class="table table-striped table-bordered display responsive nowrap"
                               cellspacing="0"
                               width="100%">
                            <thead>
                            <tr id="tbNodeDataHC">
                            </tr>
                            </thead>
                        </table>
                        <!--#tbNodeData-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    var pagePars = {
        firstLoad: true,
        tbNodeData: undefined,
        selectNodeId: undefined,
        enterpriseNode: [],
    };
    var pageShowDataUrl = "${ctx}/comm/referPageShow";

    var nodeDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseNode';
    };


    nodeDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
                            if (options.id == "所有") {
                                var treeData = [];

                                $.each(pagePars.enterpriseNode, function (indexNode, node) {
                                    if (node.nodeId && node.nodeId != "") {
                                        var item = {};

                                        item.id = node.nodeId;
                                        item.name = node.nodeName;
                                        item.type = 'item';
                                        item.isEnterprise = false;

                                        treeData.push(item);
                                    }
                                });

                                callback({
                                    data: treeData
                                });
                            } else {
                                if (options.isEnterprise) {
                                    var treeData = [];

                                    $.each(pagePars.enterpriseNode, function (indexNode, node) {
                                        if (options.id == node.enterpriseId) {
                                            var item = {};

                                            item.id = node.nodeId;
                                            item.name = node.nodeName;
                                            item.type = 'item';
                                            item.isEnterprise = false;

                                            treeData.push(item);
                                        }
                                    });

                                    callback({
                                        data: treeData
                                    });
                                } else {
                                    var treeData = [];
                                    var subRegions = [];
                                    var subRegionName = "";
                                    var subRegionIndex = -1, subRegionCount = 0;
                                    var enterpriseId = 0;

                                    $.each(pagePars.enterpriseNode, function (index, value) {
                                        var regionDesc = value.hbEnterprise.enterpriseRegionDesc;
                                        var regionTargets = regionDesc.split("(");

                                        regionDesc = regionTargets[0];
                                        regionTargets = regionDesc.split("/");

                                        for (var regionIndex = 1; regionIndex < regionTargets.length; regionIndex++) {
                                            if (options.id == regionTargets[regionIndex]) {
                                                if (regionIndex + 1 == regionTargets.length) {
                                                    if (enterpriseId != value.hbEnterprise.enterpriseId) {
                                                        var item = {};
                                                        var nodeCount = 0;

                                                        enterpriseId = value.hbEnterprise.enterpriseId;
                                                        item.id = value.hbEnterprise.enterpriseId;
                                                        item.name = value.hbEnterprise.enterpriseName;
                                                        item.type = 'folder';
                                                        item.isEnterprise = true;

                                                        $.each(pagePars.enterpriseNode, function (indexNode, node) {
                                                            if (node.enterpriseId == value.enterpriseId && value.nodeId && value.nodeId != "") {
                                                                nodeCount++;
                                                            }
                                                        });
                                                        item.name = item.name + " - [" + nodeCount + "]";
                                                        treeData.push(item);
                                                    }
                                                } else {
                                                    if (subRegionName != regionTargets[regionIndex + 1]) {
                                                        subRegionName = regionTargets[regionIndex + 1];
                                                        subRegionIndex++;
                                                        if (value.nodeId && value.nodeId != "") {
                                                            subRegionCount = 1;
                                                        } else {
                                                            subRegionCount = 0;
                                                        }
                                                        subRegions.push({regionName: regionTargets[regionIndex + 1], regionCount: subRegionCount,});
                                                    } else {
                                                        if (value.nodeId && value.nodeId != "") {
                                                            subRegionCount++;
                                                            subRegions[subRegionIndex].regionCount = subRegionCount;
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    });

                                    $.each(subRegions, function (index, value) {
                                        var item = {};

                                        item.id = value.regionName;
                                        item.name = value.regionName + " - [" + value.regionCount + "]";
                                        item.type = 'folder';
                                        item.isEnterprise = false;

                                        treeData.push(item);
                                    });
                                    callback({
                                        data: treeData
                                    });
                                }
                            }
                        } else {

                        }
                    } else {
                        $.ajax({
                                type: "POST",
                                url: '${ctx}/viewHbEnterpriseNodeCfg/refEnterpriseNode',
                                cache: false,
                                data: ServerRequestPar(1, {byPerson: "1",}),
                                dataType: "json",
                                headers: {
                                    'Content-Type': 'application/json;charset=utf-8'
                                },
                                success: function (res) {
                                    if (res.code != 0) {
                                        pagePars.enterpriseNode = [];
                                        callback({
                                            data: []
                                        });
                                    } else {
                                        var treeData = [];
                                        var regions = [];
                                        var regionName = "";
                                        var regionIndex = -1, regionCount = 0;
                                        var allCount = 0;

                                        pagePars.enterpriseNode = res.data;
                                        $.each(pagePars.enterpriseNode, function (index, value) {
                                            if (value.nodeId && value.nodeId != "") {
                                                allCount++;
                                                if (value.hasOwnProperty("nodeItem")) {
                                                    value.nodeItem = $.parseJSON(value.nodeItem);
                                                    for (var item in value.nodeItem) {
                                                        value.nodeItem[item] = $.parseJSON(value.nodeItem[item]);
                                                    }
                                                }
                                            }
                                        });
                                        treeData.push({id: "所有", name: "<b>所有站点</b> - [" + allCount + "]", type: "folder", isEnterprise: false,});

                                        $.each(pagePars.enterpriseNode, function (index, value) {
                                            var regionDesc = value.hbEnterprise.enterpriseRegionDesc;
                                            var regionTargets = regionDesc.split("(");

                                            regionDesc = regionTargets[0];
                                            regionTargets = regionDesc.split("/");

                                            if (regionName != regionTargets[1]) {
                                                regionName = regionTargets[1];
                                                regionIndex++;
                                                if (value.nodeId && value.nodeId != "") {
                                                    regionCount = 1;
                                                } else {
                                                    regionCount = 0;
                                                }
                                                regions.push({regionName: regionName, regionCount: regionCount,});
                                            } else {
                                                if (value.nodeId && value.nodeId != "") {
                                                    regionCount++;
                                                    regions[regionIndex].regionCount = regionCount;
                                                }
                                            }
                                        });
                                        $.each(regions, function (index, value) {
                                            var item = {};

                                            item.id = value.regionName;
                                            item.name = value.regionName + " - [" + value.regionCount + "]";
                                            item.type = 'folder';
                                            item.isEnterprise = false;

                                            treeData.push(item);
                                        });

                                        callback({
                                            data: treeData
                                        });
                                    }
                                },
                                error:

                                    function (XMLHttpRequest, textStatus, errorThrown) {
                                        callback({
                                            data: []
                                        });
                                    }
                            }
                        );
                    }
                },
                this._delay
            )
        }
    };

    jQuery(document).ready(function () {
        $('#enterpriseNode').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: new nodeDataSource({
                data: [],
                delay: 400
            }),
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });

        pagePars.tbNodeData = new CommDataTables("#tbNodeData", "#tbNodeDataHC", ${pageId}, callError, pageShowDataUrl);
        pagePars.tbNodeData.buttons = "P";
        pagePars.tbNodeData.lengthInfo = {
            lengthMenu: [
                [
                    -1
                ], [
                    "全部"
                ]
            ],
            pageLength: -1
        };

        pagePars.tbNodeData.create(null, dataTableAjax);
    });

    /**
     *
     */
    function dataTableAjax(data, callback, settings) {
        var tableData = {
            draw: settings.iDraw,
            recordsTotal: 0,
            recordsFiltered: 0,
            data: []
        };

        if (pagePars.selectNodeId != undefined) {
            var nodeArray = $.extend(true, [], pagePars.enterpriseNode);

            $.each(nodeArray, function (index, node) {
                if (node.nodeId == pagePars.selectNodeId && node.hasOwnProperty("nodeItem")) {
                    $.ajax({
                            type: "POST",
                            url: '${ctx}/viewHbDataLGrid/refHbDataLatest',
                            cache: false,
                            data: ServerRequestPar(1, {nodeId: node.nodeId,}),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json;charset=utf-8'
                            },
                            success: function (res) {
                                if (res.code != 0) {
                                    callback(tableData);
                                } else {
                                    var nodeData = $.parseJSON(res.data[0].nodeData);
                                    var rowId = 0;
                                    var nodeItem = node.nodeItem;

                                    for (var item in nodeItem) {
                                        if (nodeItem[item].itemMonitor == 1 && nodeItem[item].itemSelect == 1) {
                                            var dataLine = nodeItem[item];
                                            var itemValue = nodeData.hasOwnProperty(item) ? nodeData[item] : undefined;
                                            var alarm = false;

                                            rowId++;
                                            dataLine.DT_RowId = "_" + rowId;
                                            dataLine.itemValue = itemValue;
                                            dataLine.dataTime = itemValue ? res.data[0].dataTime : "";

                                            if (itemValue != undefined) {
                                                if (parseFloat(dataLine.itemVmin) > parseFloat(itemValue)) {
                                                    dataLine.itemVmin = '<kbd style="background:red">' + dataLine.itemVmin + '</kbd>';
                                                    alarm = true;
                                                }
                                                if (parseFloat(dataLine.itemVmax) < parseFloat(itemValue)) {
                                                    dataLine.itemVmax = '<kbd style="background:red">' + dataLine.itemVmax + '</kbd>';
                                                    alarm = true;
                                                }

                                                if (parseFloat(dataLine.itemVala3) < parseFloat(itemValue)) {
                                                    dataLine.itemVala3 = '<kbd style="background:red">' + dataLine.itemVala3 + '</kbd>';
                                                    alarm = true;
                                                } else if (parseFloat(dataLine.itemVala2) < parseFloat(itemValue)) {
                                                    dataLine.itemVala2 = '<kbd style="background:red">' + dataLine.itemVala2 + '</kbd>';
                                                    alarm = true;
                                                } else if (parseFloat(dataLine.itemVala1) < parseFloat(itemValue)) {
                                                    dataLine.itemVala1 = '<kbd style="background:red">' + dataLine.itemVala1 + '</kbd>';
                                                    alarm = true;
                                                }
                                            }
                                            if (alarm) {
                                                if (nodeItem[item].itemAlarm == 1) {
                                                    dataLine.itemValue = '<kbd style="background:red">' + dataLine.itemValue + '</kbd>';
                                                } else {
                                                    dataLine.itemValue = '<kbd style="background:green">' + dataLine.itemValue + '</kbd>';
                                                }
                                            }

                                            tableData.data.push(dataLine);
                                            tableData.recordsTotal++;
                                            tableData.recordsFiltered++;
                                        }
                                    }

                                    callback(tableData);
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                callback(tableData);
                            }
                        }
                    );
                }
            });
        } else {
            callback(tableData);
        }
    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            if (items && items.length > 0) {
                pagePars.selectNodeId = items[0].id;
                $("#dataGridTitle").html(items[0].name + " - 实时数据");
            } else {
                pagePars.selectNodeId = undefined;
                $("#dataGridTitle").html("实时数据");
            }

            pagePars.tbNodeData.table.ajax.reload(null, false);
        }
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
