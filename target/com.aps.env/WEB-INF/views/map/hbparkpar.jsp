<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/17
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>站点分布</title>
</head>
<meta name="description"
      content="Dashboard"/>
<meta name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible"
      content="IE=edge"/>
<meta http-equiv="Content-Type"
      content="text/html; charset=utf-8"/>
<link rel="stylesheet"
      href="${ctx}/dataTables/Bootstrap-3.3.6/css/bootstrap.min.css"/>
<!--  -->
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/color.css"/>
<link rel="stylesheet"
      href="${ctx}/assets/css/font-awesome.min.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/tree/css/tree.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/select2-4.0.2/css/select2.min.css"/>

<link rel="stylesheet"
      href="http://api.map.baidu.com/library/heatmapOverlay/1.4/src/heatmapOverlay_min.css"/>
<link rel="stylesheet"
      href="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css"/>

<style type="text/css">
    #allmap {
        width: 100%;
        height: 100%;
        overflow: hidden;
        margin: 0;
        font-family: "微软雅黑";
    }

    dl, dt, dd, ul, li {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    p {
        font-size: 12px;
    }

    dt {
        font-size: 14px;
        font-family: "微软雅黑";
        font-weight: bold;
        border-bottom: 1px dotted #000;
        padding: 5px 0 5px 5px;
        margin: 5px 0;
    }

    dd {
        padding: 5px 0 0 5px;
    }

    li {
        line-height: 28px;
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

    .maskBox {
        position: absolute;
        width: 130px;
        left: 50%;
        height: auto;
        z-index: 100;
        background-color: #fff;
        border: 1px #ddd solid;
        padding: 1px;
    }

    #mask {
        background-color: #666;
        position: absolute;
        z-index: 99;
        left: 0;
        top: 0;
        display: none;
        width: 100%;
        height: 100%;
        opacity: 0.5;
        filter: alpha(opacity=50);
        -moz-opacity: 0.5;
    }
</style>
</head>
<body>
<div class="row"
     style="margin-right: 0px; margin-bottom: 0px;">
    <div class="col-lg-3 col-sm-3 col-xs-12"
         style="padding-right: 0px">
        <div class="row"
             style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">园区列表</div>
                    <div class="panel-body"
                         style="height: 45%;overflow-y:scroll; "
                         id="treeParkDiv">
                        <div id="treePark"
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
        </div>
        <div class="row"
             style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">站点列表</div>
                    <div class="panel-body"
                         style="height: 40%;overflow-y:scroll; ">
                        <div id="enterpriseNode"
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
        </div>
    </div>
    <div class="col-lg-9 col-sm-9 col-xs-12"
         style="padding-left: 0px">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">
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
                            <option value="24"
                                    selected>最近24小时
                            </option>
                        </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel-body"
                 style="height: 90%; margin: 0;padding: 0;">
                <div id="allmap"></div>
            </div>
        </div>
    </div>
</div>
<!-- 定义遮盖层 -->
<div id="mask"></div>
<div class="maskBox"
     style="display: none">
    <img src="${ctx}/assets-view/comm/css/images/loading.gif"
         alt="数据加载中..."/>
    数据加载中 ...
</div>

<div class="modal fade"
     tabindex="-1"
     role="dialog"
     aria-labelledby="polySelectModalTitle"
     id="polySelectModal">
    <div class="modal-dialog"
         role="document"
         style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"
                    id="polySelectModalTitle">区域内包含站点信息</h4>
            </div>
            <div class="modal-body">
                <div style="height:200px;overflow:auto; "
                     id="polySelectModeBody"></div>
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-primary"
                        onclick="polySeletCacnel()">
                    <span class="glyphicon glyphicon-remove"
                          aria-hidden="true"></span>&nbsp;取消
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="polySeletOk()">
                    <span class="glyphicon glyphicon-ok"
                          aria-hidden="true"></span>&nbsp;确定
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade"
     tabindex="-1"
     role="dialog"
     aria-labelledby="node-modal"
     id="nodeMoalConfirm">
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
                <h4 class="modal-title">&nbsp;&nbsp;&nbsp;确认</h4>
            </div>
            <div class="modal-body">
                <p id="nodeMoalConfirmBody"></p>
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-default"
                        data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"
                          aria-hidden="true"></span>&nbsp;取消
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="confirmOK()">
                    <span class="glyphicon glyphicon-ok"
                          aria-hidden="true"></span>&nbsp;确定
                </button>
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
<script src="${ctx}/dataTables/jQuery-2.2.0/jquery-2.2.0.min.js"></script>
<script src="${ctx}/dataTables/Bootstrap-3.3.6/js/bootstrap.min.js"></script>

<script src="${ctx}/assets-view/comm/select2-4.0.2/js/select2.full.min.js"></script>
<script src="${ctx}/assets-view/comm/select2-4.0.2/js/i18n/zh-CN.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    showMask();

    var pagePars = {
        map: undefined,
        enterpriseNode: [],
        hbPark: [],
        marker: undefined,
        selectParkParValue: undefined,
        heatmapOverlay: undefined,
        polygonShow: undefined,
    };

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

    var parkDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'park';
    };

    parkDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
                            var selectPark = undefined;
                            pagePars.hbPark.forEach(function (park) {
                                if (park.parkGuid == options.id) {
                                    selectPark = park;
                                }
                            });

                            var selectParkPars = {};
                            var vertx = [], verty = [];
                            var parkPath = $.parseJSON(selectPark.parkPath);
                            parkPath.forEach(function (par) {
                                vertx.push(par.longitude);
                                verty.push(par.latitude);
                            });

                            pagePars.enterpriseNode.forEach(function (node) {
                                var longitude = parseFloat(node.nodeLongitude);
                                var latitude = parseFloat(node.nodeLatitude);

                                if (pnpoly(parkPath.length, vertx, verty, longitude, latitude)) {
                                    if (node.hasOwnProperty("nodeItem")) {
                                        var nodeItem = node.nodeItem;
                                        for (var itemId in nodeItem) {
                                            var itemInfo = nodeItem[itemId];
                                            if (itemInfo.itemMonitor == 1 && itemInfo.itemSelect == 1) {
                                                var newItemId = itemId + "*" + selectPark.parkGuid;
                                                if (selectParkPars.hasOwnProperty(newItemId)) {
                                                    selectParkPars[newItemId].nodeIds += ";" + node.nodeId + "";
                                                    selectParkPars[newItemId].nodeMns += ";" + node.nodeMn + "";
                                                    selectParkPars[newItemId].itemVsta = itemInfo.hasOwnProperty("itemVsta") && itemInfo.itemVsta > selectParkPars[newItemId].itemVsta ? itemInfo.itemVsta : selectParkPars[newItemId].itemVsta;
                                                    if (!selectParkPars[newItemId]["nodePoint"].hasOwnProperty(node.nodeId)) {
                                                        selectParkPars[newItemId]["nodePoint"][node.nodeId] = {};
                                                        selectParkPars[newItemId]["nodePoint"][node.nodeId].longitude = parseFloat(node.nodeLongitude);
                                                        selectParkPars[newItemId]["nodePoint"][node.nodeId].latitude = parseFloat(node.nodeLatitude);
                                                    }
                                                } else {
                                                    selectParkPars[newItemId] = {};
                                                    selectParkPars[newItemId].itemId = itemInfo.itemId;
                                                    selectParkPars[newItemId].itemName = itemInfo.itemName;
                                                    selectParkPars[newItemId].itemVsta = itemInfo.hasOwnProperty("itemVsta") ? itemInfo.itemVsta : 0;
                                                    selectParkPars[newItemId].itemUnit = itemInfo.itemUnit;
                                                    selectParkPars[newItemId].nodeIds = node.nodeId + "";
                                                    selectParkPars[newItemId].nodeMns = node.nodeMn + "";
                                                    selectParkPars[newItemId].nodePoint = {};
                                                    selectParkPars[newItemId]["nodePoint"][node.nodeId] = {};
                                                    selectParkPars[newItemId]["nodePoint"][node.nodeId].longitude = parseFloat(node.nodeLongitude);
                                                    selectParkPars[newItemId]["nodePoint"][node.nodeId].latitude = parseFloat(node.nodeLatitude);
                                                }
                                            }
                                        }
                                    }
                                }
                            });

                            var treeData = [];
                            for (var itemId in selectParkPars) {
                                var item = {};
                                var itemInfo = selectParkPars[itemId];

                                item.id = itemId
                                item.name = itemInfo.itemName;
                                item.itemVsta = itemInfo.itemVsta;
                                item.itemUnit = itemInfo.itemUnit;
                                item.parkGuid = selectPark.parkGuid;
                                item.itemId = itemInfo.itemId;
                                item.nodeIds = itemInfo.nodeIds;
                                item.nodeMns = itemInfo.nodeMns;
                                item.nodePoint = itemInfo.nodePoint;
                                item.type = 'item';

                                treeData.push(item);
                            }

                            callback({
                                data: treeData
                            });
                        } else {
                        }
                    } else {
                        $.ajax({
                                type: "POST",
                                url: '${ctx}/hbParkCfg/refHbPark',
                                cache: false,
                                data: ServerRequestPar(1, {byPerson: "0",}),
                                dataType: "json",
                                headers: {
                                    'Content-Type': 'application/json;charset=utf-8'
                                },
                                success: function (res) {
                                    if (res.code != 0) {
                                        pagePars.hbNodes = [];
                                        callback({
                                            data: []
                                        });
                                    } else {
                                        var treeData = [];

                                        pagePars.hbPark = res.data;
                                        $.each(pagePars.hbPark, function (index, value) {
                                            var item = {};

                                            item.id = value.parkGuid;
                                            item.name = value.parkName;
                                            item.type = 'folder';

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

        $('#treePark').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: new parkDataSource({
                data: [],
                delay: 400
            }),
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });

        $("#hours").select2({
            placeholder: "选择监测时间",
            allowClear: true,
            language: "zh-CN"
        });

        $('#hours').on('select2:select', function (evt) {
            var selectItems = $('#treePark').tree('selectedItems');

            if (selectItems && selectItems.length > 0) {
                treeSelectItem(selectItems, {_dataType: 'park'});
            }
        });

        loadJScript();
    });

    // 百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=4bHlkDU3BDrBGjnLIDEzuLCjDdYhaun4&callback=init";
        document.body.appendChild(script);
    }

    /**
     *
     */
    function init() {
        <!--加载鼠标绘制工具-->
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js";
        document.body.appendChild(script);

        $.ajax({
            type: "POST",
            url: '${ctx}/viewHbEnterpriseNodeCfg/refEnterpriseNode',
            cache: false,
            data: ServerRequestPar(1, {byPerson: "1",}),
            dataType: "json",
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            success: function (res) {
                if (res.code != 0) {
                    hideMask();
                    callError(res.code, res.message);
                } else {
                    drawMap(res);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                hideMask();
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        });
    }

    /**
     *
     * @param address
     * @param res
     * @returns
     */
    function drawMap(res) {
        // 百度地图API功能
        var map = new BMap.Map("allmap", {enableMapClick: false});
        var longitude = [], latitude = [], count = 0;

        $.each(res.data, function (indexNode, node) {
            count++;
            var _longitude = parseFloat(node.nodeLongitude);
            var _latitude = parseFloat(node.nodeLatitude);

            longitude.push(_longitude);
            latitude.push(_latitude);
        });

        longitude.sort();
        latitude.sort();
        count = parseInt(count / 2);

        if (count > 0) {
            map.centerAndZoom(new BMap.Point(longitude[count], latitude[count]), 12);
        }
        map.enableScrollWheelZoom();
        pagePars.map = map;

        if (!isSupportCanvas()) {
            callError(100, '热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能...!!');
            return;
        }
        //绘制工具
        setTimeout(function () {
            try {
                initHeatmapOverlay();
                hideMask();
            } catch (e) {
                pagePars.heatmapOverlay = undefined;
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.heatmapOverlay == undefined) {
                try {
                    initHeatmapOverlay();
                    hideMask();
                } catch (e) {
                    pagePars.heatmapOverlay = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.heatmapOverlay == undefined) {
                try {
                    initHeatmapOverlay();
                    hideMask();
                } catch (e) {
                    pagePars.heatmapOverlay = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.heatmapOverlay == undefined) {
                try {
                    initHeatmapOverlay();
                    hideMask();
                } catch (e) {
                    pagePars.heatmapOverlay = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.heatmapOverlay == undefined) {
                try {
                    initHeatmapOverlay();
                    hideMask();
                } catch (e) {
                    pagePars.heatmapOverlay = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.heatmapOverlay == undefined) {
                try {
                    initHeatmapOverlay();
                    hideMask();
                } catch (e) {
                    hideMask();
                    callError(-100, "初始化失败...!!");
                }
            }
        }, 2000);
    }

    /**
     *
     */
    function initHeatmapOverlay() {
        var heatmapOverlay = new BMapLib.HeatmapOverlay({"radius": 20});
    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            if (undefined != pagePars.marker) {
                pagePars.map.closeInfoWindow();
                pagePars.map.removeOverlay(pagePars.marker);
                pagePars.marker = undefined;
            }
            if (items && items.length > 0) {
                pagePars.enterpriseNode.forEach(function (node) {
                    if (node.nodeId == items[0].id) {
                        var longitude = parseFloat(node.nodeLongitude);
                        var latitude = parseFloat(node.nodeLatitude);

                        // 创建标注
                        var marker = new BMap.Marker(new BMap.Point(longitude, latitude));
                        pagePars.map.addOverlay(marker);
                        pagePars.marker = marker;
                        marker.addEventListener("click", function (e) {
                            var itemName = undefined, itemUnit = undefined, itemValue = undefined;
                            if (undefined != pagePars.selectParkParValue) {
                                itemName = pagePars.selectParkParValue.selectItem.name;
                                itemUnit = pagePars.selectParkParValue.selectItem.itemUnit;
                                itemValue = pagePars.selectParkParValue.nodeParValue[node.nodeMn].value;
                            }

                            var opts = {
                                width: 400, // 信息窗口宽度
                                height: 0, // 信息窗口高度
                                title: "<div class='panel panel-default' style='margin-bottom:5px'><div class='panel-heading'><strong>" + node.nodeName + "</strong>" + (undefined != itemName ? (" [" + itemName + " : " + itemValue + itemUnit + "] ") : " " ) + "<small> " + node.hbEnterprise.enterpriseName + "</small></div></div>", // 信息窗口标题
                                enableMessage: true,// 设置允许信息窗发送短息
                            };

                            var p = e.target;
                            var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
                            var infoWindow = new BMap.InfoWindow("", opts); // 创建信息窗口对象
                            pagePars.map.openInfoWindow(infoWindow, point); // 开启信息窗口
                        });
                    }
                });
            }
        }
        if (dataSource._dataType == "park") {
            if (undefined != pagePars.marker) {
                pagePars.map.closeInfoWindow();
                pagePars.map.removeOverlay(pagePars.marker);
                pagePars.marker = undefined;
            }
            if (undefined != pagePars.polygonShow) {
                pagePars.map.removeOverlay(pagePars.polygonShow);
                pagePars.polygonShow = undefined;
            }
            if (undefined != pagePars.heatmapOverlay) {
                pagePars.map.removeOverlay(pagePars.heatmapOverlay);
                pagePars.heatmapOverlay = undefined;
            }
            pagePars.selectParkParValue = undefined;
            if (items && items.length > 0) {
                showMask();
                pagePars.selectParkParValue = {};
                pagePars.selectParkParValue["selectItem"] = items[0];
                $.ajax({
                    type: "POST",
                    url: '${ctx}/hbParkCfg/refHbParkDataByPar',
                    cache: false,
                    data: ServerRequestPar(1, {nodeId: items[0].nodeIds, nodeMn: items[0].nodeMns, dataType: '2061', hours: $("#hours").val(),}),
                    dataType: "json",
                    headers: {'Content-Type': 'application/json;charset=utf-8'},
                    success: function (res) {
                        if (res.code != 0) {
                            hideMask();
                            callError(res.code, res.message);
                        } else {
                            showHeatmapOverlay(res.data, items[0].itemId, items[0].nodePoint, items[0].itemVsta);
                            hideMask();
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        hideMask();
                        callError(-900, "操作未完成，向服务器请求失败...");
                    }
                });

                var selectPark = undefined;
                var parkGuid = items[0].parkGuid;

                pagePars.hbPark.forEach(function (park) {
                    if (park.parkGuid == parkGuid) {
                        selectPark = park;
                    }
                });
                if (undefined != selectPark && selectPark.hasOwnProperty("parkPath")) {
                    var parkPath = $.parseJSON(selectPark.parkPath);
                    var points = [];

                    $.each(parkPath, function (indexParkPoint, parkPoint) {
                        points.push(new BMap.Point(parkPoint.longitude, parkPoint.latitude));
                    });

                    var polygon = new BMap.Polygon(points, {strokeColor: "blue", strokeWeight: 2, strokeOpacity: 0.5});  //创建多边形

                    pagePars.map.addOverlay(polygon);
                    pagePars.polygonShow = polygon;
                }
            }
        }
    }


    /**
     *
     */
    function confirmOK() {
    }

    //判断浏览区是否支持canvas
    function isSupportCanvas() {
        var elem = document.createElement('canvas');
        return !!(elem.getContext && elem.getContext('2d'));
    }

    /**
     *
     */
    function showHeatmapOverlay(data, itemId, nodePoint, itemVsta) {
        var nodeParValue = {};

        data.forEach(function (lineData) {
            if (lineData.hasOwnProperty("nodeData")) {
                var nodeData = $.parseJSON(lineData.nodeData);
                if (nodeData.hasOwnProperty(itemId)) {
                    if (nodeParValue.hasOwnProperty(lineData.nodeMn)) {
                        nodeParValue[lineData.nodeMn].sumValue += parseFloat(nodeData[itemId]);
                        nodeParValue[lineData.nodeMn].count++;
                    } else {
                        nodeParValue[lineData.nodeMn] = {};
                        nodeParValue[lineData.nodeMn].sumValue = parseFloat(nodeData[itemId]);
                        nodeParValue[lineData.nodeMn].count = 1;
                    }
                }
            }
        });

        var maxValue = 0;
        var points = [];
        for (var nodeMn in nodeParValue) {
            nodeParValue[nodeMn].value = (nodeParValue[nodeMn].sumValue / nodeParValue[nodeMn].count).toFixed(2);
            if (nodeParValue[nodeMn].value > maxValue) {
                maxValue = nodeParValue[nodeMn].value;
            }
            var point = {};
            point.lng = nodePoint[nodeMn].longitude;
            point.lat = nodePoint[nodeMn].latitude;
            point.count = nodeParValue[nodeMn].value;

            points.push(point);
        }

        pagePars.heatmapOverlay = new BMapLib.HeatmapOverlay({"radius": 50});
        pagePars.map.addOverlay(pagePars.heatmapOverlay);
        pagePars.heatmapOverlay.setDataSet({data: points, max: itemVsta == 0 ? maxValue : itemVsta});
        pagePars.selectParkParValue["nodeParValue"] = nodeParValue;
    }

    /**
     *
     */
    function setGradient() {
        /*格式如下所示:
       {
             0:'rgb(102, 255, 0)',
             .5:'rgb(255, 170, 0)',
             1:'rgb(255, 0, 0)'
       }*/
        var gradient = {};
        var colors = document.querySelectorAll("input[type='color']");
        colors = [].slice.call(colors, 0);
        colors.forEach(function (ele) {
            gradient[ele.getAttribute("data-key")] = ele.value;
        });
        pagePars.heatmapOverlay.setOptions({"gradient": gradient});
    }

    /**
     *
     */
    function pnpoly(nvert, vertx, verty, testx, testy) {
        var i, j, c = false;
        for (i = 0, j = nvert - 1; i < nvert; j = i++) {
            if (((verty[i] > testy) != (verty[j] > testy)) && (testx < (vertx[j] - vertx[i]) * (testy - verty[i]) / (verty[j] - verty[i]) + vertx[i])) {
                c = !c;
            }
        }
        return c;
    }

    /**
     *
     */
    function ServerRequestPar(parCount, inPars) {
        var par = {
            parCount: parCount,
            inPar: inPars
        };

        return JSON.stringify(par).replace(/%/g, "%25").replace(/\&/g, "%26").replace(/\+/g, "%2B");
    }

    /**
     *
     * @param code
     * @param message
     * @returns
     */
    function callError(code, message) {
        $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
        $("#mwMessage").html(message);
        $("#modal-warning").modal("show");
    }

    /******************************************************************************
     * 显示遮盖层
     *******************************************************************************/
    function showMask() {
        $("#mask").css({
            display: "block",
            height: $(document).height()
        });
        var box = $('.maskBox');
        box.css({
            //设置弹出层距离左边的位置
            left: ($("body").width() - box.width()) / 2 - 20 + "px",
            //设置弹出层距离上面的位置
            top: ($(window).height() - box.height()) / 2 + $(window).scrollTop() + "px",
            display: "block"
        });
    }

    /******************************************************************************
     * 隐藏显示遮盖层
     *******************************************************************************/
    function hideMask() {
        $("#mask,.maskBox").css("display", "none");
    }
</script>
</body>
</html>
