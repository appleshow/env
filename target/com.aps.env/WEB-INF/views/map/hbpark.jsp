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
      href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
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
                <form class="form-inline">
                    <div class="form-group">
                        <div class="input-group">
                    <span class="input-group-btn">
                         <button class="btn btn-default"
                                 type="button">园区名称</button>
                    </span>
                            <div class="input-group"
                                 style="width: 200px">
                                <input class="form-control"
                                       id="parkName"
                                       name="parkName">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <button type="button"
                                    class="btn btn-primary"
                                    id="btnAdd"
                                    onclick="addPark()">
                                <span class="glyphicon glyphicon-plus"
                                      aria-hidden="true"></span> &nbsp;&nbsp;新增&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <button type="button"
                                    class="btn btn-primary"
                                    id="btnDel"
                                    onclick="delPark()">
                                <span class="glyphicon glyphicon-remove"
                                      aria-hidden="true"></span> &nbsp;&nbsp;删除&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <button type="button"
                                    class="btn btn-primary"
                                    id="btnEdit"
                                    onclick="editPark()">
                                <span class="glyphicon glyphicon-edit"
                                      aria-hidden="true"></span> &nbsp;&nbsp;编辑&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <button type="button"
                                    class="btn btn-primary"
                                    id="btnSave"
                                    onclick="savePark()">
                                <span class="glyphicon glyphicon-ok"
                                      aria-hidden="true"></span> &nbsp;&nbsp;保存&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                </form>
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

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    showMask();

    var pagePars = {
        map: undefined,
        enterpriseNode: [],
        hbPark: [],
        infoWindows: {},
        selectPark: undefined,
        styleOptions: {
            strokeColor: "red",    //边线颜色。
            fillColor: "white",      //填充颜色。当参数为空时，圆形将没有填充效果。
            strokeWeight: 3,       //边线的宽度，以像素为单位。
            strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
            fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
            strokeStyle: 'solid' //边线的样式，solid或dashed。
        },
        drawingManager: undefined,
        overlay: undefined,
        polygonShow: undefined,
        overlayPaths: [],
        modifyType: "I",
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
                                            item.type = 'item';

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
        $("#parkName").attr({"readonly": true});
        $("#btnDel").attr({"disabled": true});
        $("#btnEdit").attr({"disabled": true});
        $("#btnSave").attr({"disabled": true});

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
        script.src = "http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js";
        document.body.appendChild(script);

        <!--加载检索信息窗口-->
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js";
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

            // 创建标注
            var marker = new BMap.Marker(new BMap.Point(_longitude, _latitude));
            // 将标注添加到地图中
            map.addOverlay(marker);

            var opts = {
                width: 400, // 信息窗口宽度
                height: 0, // 信息窗口高度
                title: "<div class='panel panel-default' style='margin-bottom:5px'><div class='panel-heading'><strong>" + node.nodeName + "</strong><small> " + node.hbEnterprise.enterpriseName + "</small></div></div>", // 信息窗口标题
                enableMessage: true,// 设置允许信息窗发送短息
            };

            var infoWindow = new BMap.InfoWindow("", opts); // 创建信息窗口对象
            pagePars.infoWindows[node.nodeId] = infoWindow;

            marker.addEventListener("click", function (e) {
                var p = e.target;

                $.each(pagePars.enterpriseNode, function (index, node) {
                    var longitude = parseFloat(node.nodeLongitude);
                    var latitude = parseFloat(node.nodeLatitude);
                    if (p.getPosition().lng == longitude && p.getPosition().lat == latitude) {
                        pagePars.map.openInfoWindow(pagePars.infoWindows[node.nodeId], new BMap.Point(longitude, latitude));
                    }
                });
            });

        });

        longitude.sort();
        latitude.sort();
        count = parseInt(count / 2);

        if (count > 0) {
            map.centerAndZoom(new BMap.Point(longitude[count], latitude[count]), 12);
        }
        map.enableScrollWheelZoom();
        pagePars.map = map;

        //绘制工具
        setTimeout(function () {
            try {
                initDrawingManager();
                hideMask();
            } catch (e) {
                pagePars.drawingManager = undefined;
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.drawingManager == undefined) {
                try {
                    initDrawingManager();
                    hideMask();
                } catch (e) {
                    pagePars.drawingManager = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.drawingManager == undefined) {
                try {
                    initDrawingManager();
                    hideMask();
                } catch (e) {
                    pagePars.drawingManager = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.drawingManager == undefined) {
                try {
                    initDrawingManager();
                    hideMask();
                } catch (e) {
                    pagePars.drawingManager = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.drawingManager == undefined) {
                try {
                    initDrawingManager();
                    hideMask();
                } catch (e) {
                    pagePars.drawingManager = undefined;
                }
            }
        }, 2000);
        setTimeout(function () {
            if (pagePars.drawingManager == undefined) {
                try {
                    initDrawingManager();
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
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            if (items && items.length > 0) {
                $.each(pagePars.enterpriseNode, function (index, node) {
                    if (node.nodeId == items[0].id) {
                        var longitude = parseFloat(node.nodeLongitude);
                        var latitude = parseFloat(node.nodeLatitude);

                        pagePars.map.openInfoWindow(pagePars.infoWindows[items[0].id], new BMap.Point(longitude, latitude));
                    }
                });
            } else {
                pagePars.map.closeInfoWindow();
            }
        }
        if (dataSource._dataType == "park") {
            if (undefined != pagePars.polygonShow) {
                pagePars.map.removeOverlay(pagePars.polygonShow);
            }
            if (items && items.length > 0) {
                var selectPark = undefined;

                $.each(pagePars.hbPark, function (index, park) {
                    if (park.parkGuid == items[0].id) {
                        selectPark = park;
                    }
                });
                if (undefined != selectPark && selectPark.hasOwnProperty("parkPath")) {
                    var parkPath = $.parseJSON(selectPark.parkPath);
                    var points = [];
                    var maxLongitude = -999, minLongitude = 99999, maxLatitude = -999, minLatitude = 99999;

                    $.each(parkPath, function (indexParkPoint, parkPoint) {
                        var longitudeTemp = parseFloat(parkPoint.longitude);
                        var latitudeTemp = parseFloat(parkPoint.latitude);

                        if (maxLongitude < longitudeTemp) {
                            maxLongitude = longitudeTemp;
                        }
                        if (minLongitude > longitudeTemp) {
                            minLongitude = longitudeTemp;
                        }
                        if (maxLatitude < latitudeTemp) {
                            maxLatitude = latitudeTemp;
                        }
                        if (minLatitude > latitudeTemp) {
                            minLatitude = latitudeTemp;
                        }
                        points.push(new BMap.Point(parkPoint.longitude, parkPoint.latitude));
                    });

                    var polygon = new BMap.Polygon(points, {strokeColor: "blue", strokeWeight: 2, strokeOpacity: 0.5});  //创建多边形

                    pagePars.map.centerAndZoom(new BMap.Point(minLongitude + (maxLongitude - minLongitude) / 2.0, minLatitude + (maxLatitude - minLatitude) / 2.0), 12);
                    pagePars.map.addOverlay(polygon);
                    pagePars.polygonShow = polygon;
                    pagePars.selectPark = selectPark;

                    $("#parkName").val(selectPark.parkName);
                    $("#parkName").attr({"readonly": true});

                    $("#btnAdd").attr({"disabled": true});
                    $("#btnEdit").attr({"disabled": false});
                    $("#btnDel").attr({"disabled": false});
                    $("#btnSave").attr({"disabled": true});
                } else {
                    $("#parkName").val("");
                    $("#btnAdd").attr({"disabled": false});
                    $("#btnDel").attr({"disabled": true});
                    $("#btnEdit").attr({"disabled": true});
                    $("#btnSave").attr({"disabled": true});

                    pagePars.selectPark = undefined;
                    pagePars.polygonShow = undefined;
                }
            } else {
                $("#parkName").val("");
                $("#btnAdd").attr({"disabled": false});
                $("#btnDel").attr({"disabled": true});
                $("#btnEdit").attr({"disabled": true});
                $("#btnSave").attr({"disabled": true});

                pagePars.selectPark = undefined;
                pagePars.polygonShow = undefined;
            }
        }
    }

    /**
     *
     */
    function overlayComplete(e) {
        pagePars.overlay = e.overlay;
        pagePars.drawingManager.close();

        var pathSelect = pagePars.overlay.getPath();
        var vertx = [], verty = [];
        var polySelectNode = {};
        var html = "";

        pagePars.overlayPaths = [];
        $.each(pathSelect, function (index, path) {
            var pathTemp = {};

            pathTemp.longitude = path.lng;
            pathTemp.latitude = path.lat;
            pagePars.overlayPaths.push(pathTemp);

            vertx.push(path.lng);
            verty.push(path.lat);
        });

        $.each(pagePars.enterpriseNode, function (index, node) {
            var longitude = parseFloat(node.nodeLongitude);
            var latitude = parseFloat(node.nodeLatitude);

            if (pnpoly(pathSelect.length, vertx, verty, longitude, latitude)) {
                if (!polySelectNode.hasOwnProperty(node.hbEnterprise.enterpriseName)) {
                    polySelectNode[node.hbEnterprise.enterpriseName] = [];
                }
                polySelectNode[node.hbEnterprise.enterpriseName].push(node.nodeName);
            }
        });
        for (var enterpriseName in polySelectNode) {
            html += '<p><h6>所属企业：<b>' + enterpriseName + '</b></h6>';
            $.each(polySelectNode[enterpriseName], function (index, nodeName) {
                html += '<p><h7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + nodeName + '</h7></p>';
            });
            html += '</p>';
        }

        $("#polySelectModeBody").html(html);
        $('#polySelectModal').modal({
            backdrop: 'static',
            keyboard: true
        });

    }

    /**
     *
     */
    function initDrawingManager() {
        pagePars.drawingManager = new BMapLib.DrawingManager(pagePars.map, {
            isOpen: false, //是否开启绘制模式
            enableDrawingTool: true, //是否显示工具栏
            drawingMode: BMAP_DRAWING_POLYGON,//绘制模式  多边形
            drawingToolOptions: {
                anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
                offset: new BMap.Size(5, 5), //偏离值
                drawingModes: [
                    //BMAP_DRAWING_MARKER,
                    //BMAP_DRAWING_CIRCLE,
                    //BMAP_DRAWING_POLYLINE,
                    //BMAP_DRAWING_POLYGON,
                    //BMAP_DRAWING_RECTANGLE
                ],
            },
            circleOptions: pagePars.styleOptions, //圆的样式
            polylineOptions: pagePars.styleOptions, //线的样式
            polygonOptions: pagePars.styleOptions, //多边形的样式
            rectangleOptions: pagePars.styleOptions, //矩形的样式
        });
        pagePars.drawingManager.addEventListener('overlaycomplete', overlayComplete);
    }

    /**
     *
     */
    function addPark() {
        if (pagePars.overlay != undefined) {
            pagePars.map.removeOverlay(pagePars.overlay);
            pagePars.overlay = undefined;
            pagePars.overlayPaths = [];
        }
        pagePars.drawingManager.setDrawingMode(BMAP_DRAWING_POLYGON);
        pagePars.drawingManager.open();
        pagePars.selectPark = undefined;
        if ("I" == pagePars.modifyType) {
        } else {
            $("#parkName").val("");
            pagePars.modifyType = "I";
        }

        $("#parkName").attr({"readonly": false});

        $("#btnEdit").attr({"disabled": true});
        $("#btnDel").attr({"disabled": true});
        $("#btnSave").attr({"disabled": true});
    }

    /**
     *
     */
    function delPark() {
        $("#nodeMoalConfirmBody").html("将删除园区：<b>" + pagePars.selectPark.parkName + "</b>...??")
        $('#nodeMoalConfirm').modal({
            backdrop: 'static',
            keyboard: true
        });
    }

    /**
     *
     */
    function confirmOK() {
        $("#nodeMoalConfirm").modal('hide');
        pagePars.modifyType = "D";
        savePark();
    }

    /**
     *
     */
    function editPark() {
        if (pagePars.overlay != undefined) {
            pagePars.map.removeOverlay(pagePars.overlay);
            pagePars.overlay = undefined;
            pagePars.overlayPaths = [];
        }
        pagePars.drawingManager.setDrawingMode(BMAP_DRAWING_POLYGON);
        pagePars.drawingManager.open();

        $("#parkName").attr({"readonly": false});
        $("#btnSave").attr({"disabled": false});
        pagePars.modifyType = "U";
    }

    /**
     *
     */
    function savePark() {
        if ("" == $("#parkName").val() && "D" != pagePars.modifyType) {
            callError(-100, "园区名称不能为空...!!");
            return;
        }
        if (undefined == pagePars.overlay && "I" == pagePars.modifyType) {
            callError(-100, "请设定一个区域...!!");
            return;
        }
        var hbPark = {};
        var hbParks = [];

        hbPark._type = pagePars.modifyType;
        if ("I" != pagePars.modifyType) {
            hbPark.parkGuid = pagePars.selectPark.parkGuid;
        }
        hbPark.parkName = $("#parkName").val();
        if (undefined != pagePars.overlay) {
            hbPark.parkPath = JSON.stringify(pagePars.overlayPaths);
        }

        hbParks.push(hbPark);

        $("#btnSave").attr({"disabled": true});

        $.ajax({
            async: false,
            type: "POST",
            url: "${ctx}/hbParkCfg/modifyHbPark",
            cache: false,
            data: ServerRequestPar(1, hbParks),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    $("#btnSave").attr({"disabled": false});
                    callError(-999, res.message);
                } else {
                    $("#parkName").val("");
                    $("#parkName").attr({"readonly": true});
                    $("#btnAdd").attr({"disabled": false});
                    $("#btnDel").attr({"disabled": true});
                    $("#btnEdit").attr({"disabled": true});
                    $("#btnSave").attr({"disabled": true});
                    pagePars.selectPark = undefined;
                    if (undefined != pagePars.overlay) {
                        pagePars.map.removeOverlay(pagePars.overlay);
                        pagePars.overlay = undefined;
                    }
                    if (undefined != pagePars.polygonShow) {
                        pagePars.map.removeOverlay(pagePars.polygonShow);
                        pagePars.polygonShow = undefined;
                    }

                    $("#treeParkDiv").html("");
                    $("#treeParkDiv").html('<div id="treePark"\n' +
                        '                             class="tree tree-plus-minus tree-solid-line">\n' +
                        '                            <div class="tree-folder"\n' +
                        '                                 style="display: none;">\n' +
                        '                                <div class="tree-folder-header">\n' +
                        '                                    <i class="fa fa-folder"></i>\n' +
                        '                                    <div class="tree-folder-name"></div>\n' +
                        '                                </div>\n' +
                        '                                <div class="tree-folder-content"></div>\n' +
                        '                                <div class="tree-loader"\n' +
                        '                                     style="display: none;"></div>\n' +
                        '                            </div>\n' +
                        '                            <div class="tree-item"\n' +
                        '                                 style="display: none;">\n' +
                        '                                <i class="tree-dot"></i>\n' +
                        '                                <div class="tree-item-name"></div>\n' +
                        '                            </div>\n' +
                        '                        </div>');
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
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#btnSave").attr({"disabled": false});
                callError(-888, "服务器请求异常...！")
            }
        });
    }

    /**
     *
     */
    function polySeletCacnel() {
        $("#polySelectModal").modal('hide');

        if (pagePars.overlay != undefined) {
            pagePars.map.removeOverlay(pagePars.overlay);
            pagePars.overlay = undefined;
        }
        pagePars.drawingManager.setDrawingMode(BMAP_DRAWING_POLYGON);
        pagePars.drawingManager.open();
    }

    /**
     *
     */
    function polySeletOk() {
        $("#polySelectModal").modal('hide');

        $("#btnSave").attr({"disabled": false});
    }

    // 定义一个控件类,即function
    function ZoomControl() {
        // 默认停靠位置和偏移量
        this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
        this.defaultOffset = new BMap.Size(10, 10);
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
