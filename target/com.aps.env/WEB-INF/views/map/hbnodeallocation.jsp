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
        body, html, #allmap {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
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

        .box-red {
            font-size: 12px;
            color: red;
            margin: 0px;
            animation: changeshadow-red 1s ease-in infinite;
            /* 其它浏览器兼容性前缀 */
            -webkit-animation: changeshadow-red 1s linear infinite;
            -moz-animation: changeshadow-red 1s linear infinite;
            -ms-animation: changeshadow-red 1s linear infinite;
            -o-animation: changeshadow-red 1s linear infinite;
        }

        @keyframes changeshadow-red {
            0% {
                text-shadow: 0 0 4px red;
            }
            50% {
                text-shadow: 0 0 40px red
            }
            100% {
                text-shadow: 0 0 4px red
            }
        }

        /* 添加兼容性前缀 */
        @-webkit-keyframes changeshadow-red {
            0% {
                text-shadow: 0 0 4px red
            }
            50% {
                text-shadow: 0 0 40px red
            }
            100% {
                text-shadow: 0 0 4px red
            }
        }

        @-moz-keyframes changeshadow-red {
            0% {
                text-shadow: 0 0 4px red
            }
            50% {
                text-shadow: 0 0 40px red
            }
            100% {
                text-shadow: 0 0 4px red
            }
        }

        @-ms-keyframes changeshadow-red {
            0% {
                text-shadow: 0 0 4px red
            }
            50% {
                text-shadow: 0 0 40px red
            }
            100% {
                text-shadow: 0 0 4px red
            }
        }

        @-o-keyframes changeshadow-red {
            0% {
                text-shadow: 0 0 4px red
            }
            50% {
                text-shadow: 0 0 40px red
            }
            100% {
                text-shadow: 0 0 4px red
            }
        }
    </style>
</head>
<body>
<div id="allmap"></div>
<!-- 定义遮盖层 -->
<div id="mask"></div>
<div class="maskBox"
     style="display: none">
    <img src="${ctx}/assets-view/comm/css/images/loading.gif"
         alt="数据加载中..."/>
    数据加载中 ...
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
<audio id="alarmVoice"
       loop="loop"
       src="${ctx}/assets-view/comm/alarm-voice.mp3">您的浏览器不支持 audio 元素
</audio>

<script src="${ctx}/dataTables/jQuery-2.2.0/jquery-2.2.0.min.js"></script>
<script src="${ctx}/dataTables/Bootstrap-3.3.6/js/bootstrap.min.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    showMask();
    var pagePars = {
        pause: false,
        currentNodeIndex: -1,
        alarmVoiceSilence: 30 * 60 * 1000, //30分钟
        loaded: false,
        map: undefined,
        mapZoomDefault: 12,
        enterpriseNode: [],
        infoWindows: {},
        nodeAlarmVoice: {},
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
                                                        subRegions.push({
                                                            regionName: regionTargets[regionIndex + 1],
                                                            regionCount: subRegionCount,
                                                        });
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
                                        treeData.push({
                                            id: "所有",
                                            name: "<b>所有站点</b> - [" + allCount + "]",
                                            type: "folder",
                                            isEnterprise: false,
                                        });

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
        window.setInterval(circulation, 1000 * 7);
    });

    // 百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=4bHlkDU3BDrBGjnLIDEzuLCjDdYhaun4&callback=init";
        document.body.appendChild(script);
    }

    function circulation() {
        try {
            if (pagePars.currentNodeIndex >= pagePars.enterpriseNode.length) {
                pagePars.currentNodeIndex = 0;
            } else if (pagePars.pause) {
            } else {
                pagePars.currentNodeIndex++;
            }
            $.each(pagePars.enterpriseNode, function (index, node) {
                if (index == pagePars.currentNodeIndex) {
                    var longitude = parseFloat(node.nodeLongitude);
                    var latitude = parseFloat(node.nodeLatitude);
                    pagePars.map.openInfoWindow(pagePars.infoWindows[node.nodeId], new BMap.Point(longitude, latitude));
                    if (pagePars.nodeAlarmVoice[node.nodeId].alarm) {
                        pagePars.pause = true;
                        try {
                            document.getElementById("alarmVoice").play();
                        } catch (e) {
                            console.log(e)
                        }
                    }
                }
            });
        } catch (e) {
            console.log(e);
        }
    }

    function mute(nodeId, guid) {
        if (guid && guid != "") {
            pagePars.nodeAlarmVoice[nodeId].guid = guid;
            pagePars.nodeAlarmVoice[nodeId].time = new Date();
        }

        document.getElementById("alarmVoice").pause();
        pagePars.pause = false;
        pagePars.nodeAlarmVoice[nodeId].alarm = false;
        pagePars.map.closeInfoWindow();
        init();
    }

    function init() {
        if (pagePars.pause) {
            return;
        }

        hideMask();
        showMask();
        $.ajax({
            type: "POST",
            url: "${ctx}/hbNodeMap/refHbNodeJoinLatestData",
            cache: false,
            data: ServerRequestPar(1, {dataType: 1,}),
            dataType: "json",
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            success: function (res) {
                if (res.code != 0) {
                    hideMask();
                    callError(res.code, res.message);
                } else {
                    drawMap(res);
                    hideMask();
                    if (!pagePars.loaded) {
                        pagePars.loaded = true;
                        window.setInterval(init, 1000 * 57 * 2);
                    }
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
        var nodeDataLatstOne = res.subJoinResponseData.data;
        var longitude = [], latitude = [], count = 0;

        map.clearOverlays();
        $.each(res.data, function (indexNode, node) {
            count++;
            var nodeTime = "";
            var nodeItems;
            var exceptionPar = false;
            if (typeof (node.nodeItem) === "undefined" || node.nodeItem === null) {
                nodeItems = {};
            } else {
                nodeItems = $.parseJSON(node.nodeItem);
            }
            var _longitude = parseFloat(node.nodeLongitude);
            var _latitude = parseFloat(node.nodeLatitude);

            var content = "";
            var itemCount = 0;

            if (!pagePars.nodeAlarmVoice[node.nodeId]) {
                pagePars.nodeAlarmVoice[node.nodeId] = {};
                pagePars.nodeAlarmVoice[node.nodeId].alarm = false;
                pagePars.nodeAlarmVoice[node.nodeId].checkStatus = true;
            }
            if (node.prflag == 1) {
                if (!pagePars.nodeAlarmVoice[node.nodeId].checkStatus) {
                    pagePars.nodeAlarmVoice[node.nodeId].checkStatus = true;
                }
                pagePars.nodeAlarmVoice[node.nodeId].online = true;
            } else {
                if (pagePars.nodeAlarmVoice[node.nodeId].checkStatus) {
                    pagePars.nodeAlarmVoice[node.nodeId].checkStatus = false;
                    pagePars.nodeAlarmVoice[node.nodeId].alarm = true;
                }
                pagePars.nodeAlarmVoice[node.nodeId].online = false;
            }
            for (var itemId in nodeItems) {
                nodeItems[itemId] = $.parseJSON(nodeItems[itemId]);
                if (nodeItems[itemId].itemMonitor == 1 && nodeItems[itemId].itemSelect == 1 && nodeItems[itemId].itemShowMain == 1) {
                    var itemValue = undefined;
                    var itemDataGuid = "";

                    itemCount++;
                    $.each(nodeDataLatstOne, function (indexData, data) {
                        if (data.nodeId == node.nodeId) {
                            nodeTime = data.dataTime;
                            itemDataGuid = data.dataGuid;
                            var nodeData = $.parseJSON(data.nodeData);
                            if (nodeData.hasOwnProperty(itemId)) {
                                itemValue = nodeData[itemId];
                            }
                        }
                    });

                    if (itemValue != undefined) {
                        var showTitle = "";

                        if (nodeItems[itemId].itemVmin != "" && parseFloat(nodeItems[itemId].itemVmin) > parseFloat(itemValue)) {
                            showTitle += '参数下限: ' + nodeItems[itemId].itemVmin;
                        } else if (nodeItems[itemId].itemVmax != "" && parseFloat(nodeItems[itemId].itemVmax) < parseFloat(itemValue)) {
                            showTitle += ' 参数上限: ' + nodeItems[itemId].itemVmax;
                        }
                        if (nodeItems[itemId].itemVala3 != "" && parseFloat(itemValue) > parseFloat(nodeItems[itemId].itemVala3)) {
                            showTitle += ' 三级阀值: ' + nodeItems[itemId].itemVala3;
                        } else if (nodeItems[itemId].itemVala2 != "" && parseFloat(itemValue) > parseFloat(nodeItems[itemId].itemVala2)) {
                            showTitle += ' 二级阀值: ' + nodeItems[itemId].itemVala2;
                        } else if (nodeItems[itemId].itemVala1 != "" && parseFloat(itemValue) > parseFloat(nodeItems[itemId].itemVala1)) {
                            showTitle += ' 一级阀值: ' + nodeItems[itemId].itemVala1;
                        }

                        if (showTitle != "") {
                            if (nodeItems[itemId].itemAlarm == 1) {
                                exceptionPar = true;
                                if (nodeItems[itemId].itemAlarmVoice && nodeItems[itemId].itemAlarmVoice == 1) {
                                    content += "<button class='btn btn-danger' type='button' style='width:200px;text-align: left' title='" + showTitle + "'>" + nodeItems[itemId].itemName + " <span class='badge box-red'>" + itemValue + nodeItems[itemId].itemUnit + "</span></button>";
                                    if (pagePars.nodeAlarmVoice[node.nodeId].alarm) {
                                    } else if (!pagePars.nodeAlarmVoice[node.nodeId].guid) {
                                        pagePars.nodeAlarmVoice[node.nodeId].alarm = true;
                                    } else if ((new Date()).getTime() - pagePars.nodeAlarmVoice[node.nodeId].time.getTime() >= pagePars.alarmVoiceSilence) {
                                        pagePars.nodeAlarmVoice[node.nodeId].alarm = true;
                                    }
                                } else {
                                    content += "<button class='btn btn-danger' type='button' style='width:200px;text-align: left' title='" + showTitle + "'>" + nodeItems[itemId].itemName + " <span class='badge'>" + itemValue + nodeItems[itemId].itemUnit + "</span></button>";
                                }
                            } else {
                                content += "<button class='btn btn-success' type='button' style='width:200px;text-align: left' title='" + showTitle + "'>" + nodeItems[itemId].itemName + " <span class='badge'>" + itemValue + nodeItems[itemId].itemUnit + "</span></button>";
                            }
                        } else {
                            content += "<button class='btn btn-default' type='button' style='width:200px;text-align: left'>" + nodeItems[itemId].itemName + " <span class='badge'>" + itemValue + nodeItems[itemId].itemUnit + "</span></button>";
                        }
                    } else {
                        content += "<button class='label label-default' type='button' style='width:200px;height: 35px;text-align: left'>" + nodeItems[itemId].itemName + "</button>";
                    }
                }
            }

            if (itemCount < 1) {
                itemCount = 0;
            } else {
                itemCount = 90 + (itemCount / 3) * 45;
            }

            longitude.push(_longitude);
            latitude.push(_latitude);

            // 创建标注
            var marker = new BMap.Marker(new BMap.Point(_longitude, _latitude));
            // 将标注添加到地图中
            map.addOverlay(marker);
            if (exceptionPar) {
                marker.setAnimation(BMAP_ANIMATION_BOUNCE);
            }
            var nodeStatus = "";
            if (!pagePars.nodeAlarmVoice[node.nodeId].online) {
                nodeStatus = "<sup><span class='badge' style='background-color: red;font-size:10px;'>离线</span></sup>";
            } else {
                nodeStatus = "<sup><span class='badge' style='background-color: green;font-size:10px;'>在线</span></sup>";
            }
            var title = "";
            if (pagePars.nodeAlarmVoice[node.nodeId].alarm) {
                title = "<div class='panel panel-default' style='margin-bottom:5px'>" +
                    "<div class='panel-heading'>" +
                    "<strong>" +
                    node.nodeName +
                    "</strong>" +
                    nodeStatus +
                    "<small>&nbsp&nbsp&nbsp&nbsp更新时间: " +
                    nodeTime +
                    "</small>" +
                    "<button class='btn btn-mini btn-warning' type='button' style='height:30px;font-size:12;text-align:center;float:right;' title='点击关闭报警声音' onclick='mute(" + node.nodeId + ",\"" + itemDataGuid + "\")'>静音</button>" +
                    "</div>" +
                    "</div>";
            } else {
                title = "<div class='panel panel-default' style='margin-bottom:5px'>" +
                    "<div class='panel-heading'>" +
                    "<strong>" +
                    node.nodeName +
                    "</strong>" +
                    nodeStatus +
                    "<small>&nbsp&nbsp&nbsp&nbsp更新时间: " +
                    nodeTime +
                    "</small>" +
                    "</div>" +
                    "</div>";
            }
            var opts = {
                width: 400, // 信息窗口宽度
                height: itemCount, // 信息窗口高度
                title: title,// 信息窗口标题
                enableMessage: true,// 设置允许信息窗发送短息
            };

            var infoWindow = new BMap.InfoWindow(content, opts); // 创建信息窗口对象
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

        map.addEventListener("zoomend", function () {
            pagePars.mapZoomDefault = this.getZoom();
        });

        longitude.sort();
        latitude.sort();
        count = parseInt(count / 2);

        if (count > 0) {
            map.centerAndZoom(new BMap.Point(longitude[count], latitude[count]), pagePars.mapZoomDefault);
        }
        map.enableScrollWheelZoom();

        createNodeTree(map);
    }

    /**
     *
     */
    function createNodeTree(map) {
        var html = '  <div class="panel panel-default"\n' +
            '             style="margin-bottom: 5px;">\n' +
            '            <div class="panel-heading">站点列表</div>\n' +
            '            <div class="panel-body"\n' +
            '                 style="height: 92%;overflow-y:scroll; ">\n' +
            '                <div id="enterpriseNode"\n' +
            '                     class="tree tree-folder-select tree-plus-minus tree-solid-line tree-unselectable">\n' +
            '                    <div class="tree-folder"\n' +
            '                         style="display: none;">\n' +
            '                        <div class="tree-folder-header">\n' +
            '                            <i class="fa fa-folder"></i>\n' +
            '                            <div class="tree-folder-name"></div>\n' +
            '                        </div>\n' +
            '                        <div class="tree-folder-content"></div>\n' +
            '                        <div class="tree-loader"\n' +
            '                             style="display: none;"></div>\n' +
            '                    </div>\n' +
            '                    <div class="tree-item"\n' +
            '                         style="display: none;">\n' +
            '                        <i class="tree-dot"></i>\n' +
            '                        <div class="tree-item-name"></div>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>';

        // 通过JavaScript的prototype属性继承于BMap.Control
        ZoomControl.prototype = new BMap.Control();

        // 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
        // 在本方法中创建个div元素作为控件的容器,并将其添加到地图容器中
        ZoomControl.prototype.initialize = function (map) {
            // 创建一个DOM元素
            var div = document.createElement("div");

            div.id = "treeDiv";
            div.style.width = '35vh';
            div.style.height = '55vh';

            // 添加DOM元素到地图中
            map.getContainer().appendChild(div);
            // 将DOM元素返回
            return div;
        };
        // 创建控件
        var myZoomCtrl = new ZoomControl();
        // 添加到地图当中
        map.addControl(myZoomCtrl);
        pagePars.map = map;

        $("#treeDiv").html(html);

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
        this.defaultOffset = new BMap.Size(5, 5);
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
        if (!pagePars.loaded) {
            $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
            $("#mwMessage").html(message);
            $("#modal-warning").modal("show");

        }
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
