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
<style type="text/css">
    #allmap {
        width: 100%;
        height: 100%;
        overflow: hidden;
        margin: 0;
        font-family: "微软雅黑";
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
                         style="height: 45%;overflow-y:scroll; ">
                        <input class="form-control"
                               style="width: 180px; display: none;"
                               readonly
                               id="nodeId"
                               name="nodeId">
                        </input>
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
                                 type="button">站点类型</button>
                    </span>
                            <div class="input-group"
                                 style="width: 200px">
                                <input class="form-control"
                                       readonly
                                       id="typeName"
                                       name="typeName">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <button type="button"
                                    class="btn btn-primary"
                                    onclick="refData()">
                                <span class="glyphicon glyphicon-search"
                                      aria-hidden="true"></span> &nbsp;&nbsp;查询&nbsp;&nbsp;
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-body"
                 style="height: 90%;">
                <div id="allmap"></div>
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
    var pagePars = {
            map: undefined,
            enterpriseNode: [],
            infoWindows: {},
        }
    ;
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
        loadJScript();
    });

    // 百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=4bHlkDU3BDrBGjnLIDEzuLCjDdYhaun4&callback=init";
        document.body.appendChild(script);
    }

    function init() {
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

        $.ajax({
            type: "POST",
            url: "${ctx}/hbNodeMap/refHbNodeJoinLatestData",
            cache: false,
            data: ServerRequestPar(1, {dataType: 0,}),
            dataType: "json",
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    drawMap(res);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
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

</script>
</body>
</html>
