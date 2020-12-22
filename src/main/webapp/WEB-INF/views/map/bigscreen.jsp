<%--
  Created by IntelliJ IDEA.
  User: gliu8
  Date: 12/18/2020
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>大屏显示</title>
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

        #allmap {
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

        .box {
            overflow: auto;
            width: 100%;
            height: 100%;
            background: #fafafa;
            border: 0px solid #ccc;
            margin: 0px;
            padding: 0px;
        }

        .box-pie {
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            margin-left: auto;
            margin-right: auto;
        }

        .box-pie1 {
            width: 100%;
            height: 100%;
            top: 0px;
            bottom: 0px;
            left: 0px;
            right: 0px;
            margin-left: auto;
            margin-right: auto;
        }

        .line {
            margin: 5px;
            width: 98%;
            height: 98%;
            background: #fff;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>
<div class="row"
     style="margin-right: 0px; margin-bottom: 0px;">
    <div class="col-lg-3 col-sm-3 col-xs-12" style="padding-right: 0px;">
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">含煤废水量</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;margin: 0px;padding: 0px;">
                        <div class="row" style="margin: 0px;padding: 0px; width: 100%;height: 60%;">
                            <div class="box-pie" id="pieHMSL" style="width: 100%;height: 100%;"></div>
                        </div>
                        <div class="row" style="margin: 0px;padding: 0px;height: 40%;">
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeHMSL0" style="width: 100%;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeHMSL1" style="width: 100%;;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeHMSL2" style="width: 100%;;height: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">环保用水量</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;margin: 0px;padding: 0px;">
                        <div class="row" style="margin: 0px;padding: 0px; width: 100%;height: 60%;">
                            <div class="box-pie" id="pieHBYSL" style="width: 100%;height: 100%;"></div>
                        </div>
                        <div class="row" style="margin: 0px;padding: 0px;height: 40%;">
                            <div class="col-lg-6 col-sm-6 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeHBYSL0" style="width: 100%;height: 100%;"></div>
                            </div>
                            <div class="col-lg-6 col-sm-6 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeHBYSL1" style="width: 100%;;height: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">岸电用电量</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;margin: 0px;padding: 0px;">
                        <div class="row" style="margin: 0px;padding: 0px; width: 100%;height: 50%;">
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL0" style="width: 100%;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL1" style="width: 100%;;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL2" style="width: 100%;;height: 100%;"></div>
                            </div>
                        </div>
                        <div class="row" style="margin: 0px;padding: 0px;height: 50%;">
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL3" style="width: 100%;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL4" style="width: 100%;;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeADYDL5" style="width: 100%;;height: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6 col-sm-6 col-xs-12" style="padding-left: 0px;padding-right: 0px;">
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">厂区地图</div>
                    <div class="panel-body"
                         style="height: 57%;overflow-y:scroll; margin: 0;padding: 0;"
                         id="cqdtDiv">
                        <div id="allmap"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">粉尘今日曲线图</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll; margin: 0px; padding: 0px"
                         id="fcqrqxtDiv">
                        <div class="box"
                             id="lineCurBox">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-3 col-sm-3 col-xs-12" style="padding-left: 0px;padding-right: 0px;">
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">所有设备状态</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;">
                        <div id="sysbztDiv"
                             style="margin: 0px;padding: 0px;float: left;"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">外排水量</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;margin: 0px;padding: 0px;">
                        <div class="row" style="margin: 0px;padding: 0px; width: 100%;height: 60%;">
                            <div class="box-pie" id="pieWPSL" style="width: 100%;height: 100%;"></div>
                        </div>
                        <div class="row" style="margin: 0px;padding: 0px;height: 40%;">
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeWPSL0" style="width: 100%;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeWPSL1" style="width: 100%;;height: 100%;"></div>
                            </div>
                            <div class="col-lg-4 col-sm-4 col-xs-12" style="margin: 0px;padding: 0px;">
                                <div class="box-pie" id="gaugeWPSL2" style="width: 100%;;height: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" style="margin-right: 0px; margin-bottom: 0px;">
            <div class="col-lg-12 col-sm-12 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">水位信息</div>
                    <div class="panel-body"
                         style="height: 25%;overflow-y:scroll;margin: 0px;padding: 0px;">
                        <div class="row" style="margin: 0px;padding: 0px; width: 100%;height: 100%;">
                            <div class="box-pie" id="columnSWXX" style="width: 100%;height: 100%;"></div>
                        </div>
                    </div>
                </div>
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
<script src="${ctx}/datetimePicker/js/moment.min.js"></script>
<script src="${ctx}/datetimePicker/js/bootstrap-datetimepicker.min.js"></script>
<!--  -->
<!-- Print Script -->
<script src="${ctx}/dataTables/JSZip-2.5.0/jszip.min.js"></script>
<script src="${ctx}/dataTables/pdfmake-0.1.18/build/pdfmake.min.js"></script>
<script src="${ctx}/dataTables/pdfmake-0.1.18/build/vfs_fonts.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.html5.min.js"></script>
<script src="${ctx}/dataTables/Buttons-1.1.2/js/buttons.print.min.js"></script>
<!--  -->
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>
<!--  -->
<script src="${ctx}/assets-view/comm/highcharts/js/highcharts.8.2.2.js"></script>
<script src="${ctx}/assets-view/comm/highcharts/js/highcharts-more.js"></script>
<script src="${ctx}/assets-view/comm/highcharts/js/solid-gauge.js"></script>
<script src="${ctx}/assets-view/comm/highcharts/js/highcharts-zh_CN.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    showMask();

    var pagePars = {
        pause: false,
        currentNodeIndex: -1,
        alarmVoiceSilence: 30 * 60 * 1000, //30分钟
        loaded: false,
        map: undefined,
        mapZoomDefault: 18,
        enterpriseNode: [],
        infoWindows: {},
        nodeAlarmVoice: {},
        nodeInfo: [],
        nodeDataInfo: [],

        colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#42A07B", "#DDDF0D", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
        selectNode: undefined,
        selectNodeChanged: true,
        nodeLine: undefined,
        dateStr: (new Date()).format("yyyy-MM-dd") + " 00:00:00",
        dateEnd: (new Date()).format("yyyy-MM-dd") + " 23:59:59",
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
                                    if (node.nodeId && node.nodeId != "" && node.nodeName.indexOf("粉尘") != -1) {
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
                                        if (options.id == node.enterpriseId && node.nodeName.indexOf("粉尘") != -1) {
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
                                                            if (node.enterpriseId == value.enterpriseId && value.nodeId && value.nodeId != "" && node.nodeName.indexOf("粉尘") != -1) {
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
                                                        if (value.nodeId && value.nodeId != "" && value.nodeName.indexOf("粉尘") != -1) {
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
                                                if (value.nodeName.indexOf("粉尘") != -1) {
                                                    allCount++;
                                                }
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
                                                if (value.nodeId && value.nodeId != "" && value.nodeName.indexOf("粉尘") != -1) {
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
        // window.setInterval(circulation, 1000 * 7);
    });

    // 百度地图API功能
    function loadJScript() {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=4bHlkDU3BDrBGjnLIDEzuLCjDdYhaun4&callback=init";
        document.body.appendChild(script);
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
                    pagePars.nodeInfo = res.data;
                    pagePars.nodeDataInfo = res.subJoinResponseData.data;

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

    function drawMap(res) {
        // 百度地图API功能
        var map = new BMap.Map("allmap", {enableMapClick: false});
        var nodeDataLatestOne = res.subJoinResponseData.data;
        var longitude = [], latitude = [], count = 0;

        map.clearOverlays();
        $.each(res.data, function (indexNode, node) {
            if (!pagePars.nodeAlarmVoice[node.nodeId]) {
                pagePars.nodeAlarmVoice[node.nodeId] = {};
                pagePars.nodeAlarmVoice[node.nodeId].alarm = false;
                pagePars.nodeAlarmVoice[node.nodeId].checkStatus = true;
                pagePars.nodeAlarmVoice[node.nodeId].nodeName = node.nodeName;
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

            if (node.nodeName.indexOf("粉尘") > 0) {
                count++;
                var nodeTime = "";
                var nodeItems;
                var exceptionPar = false;
                if (typeof (node.nodeItem) === "undefined" || node.nodeItem === null) {
                    nodeItems = {};
                } else {
                    nodeItems = $.parseJSON(node.nodeItem);
                    node.nodeItem = nodeItems;
                }
                var _longitude = parseFloat(node.nodeLongitude);
                var _latitude = parseFloat(node.nodeLatitude);

                var content = "";
                var itemCount = 0;

                for (var itemId in nodeItems) {
                    nodeItems[itemId] = $.parseJSON(nodeItems[itemId]);
                    if (nodeItems[itemId].itemMonitor == 1 && nodeItems[itemId].itemSelect == 1 && nodeItems[itemId].itemShowMain == 1) {
                        var itemValue = undefined;
                        var itemDataGuid = "";

                        itemCount++;
                        $.each(nodeDataLatestOne, function (indexData, data) {
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
                        // "<button class='btn btn-mini btn-warning' type='button' style='height:30px;font-size:12;text-align:center;float:right;' title='点击关闭报警声音' onclick='mute(" + node.nodeId + ",\"" + itemDataGuid + "\")'>静音</button>" +
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
            }
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

    function createNodeTree(map) {
        var html = '  <div class="panel panel-default"\n' +
            '             style="margin-bottom: 5px;">\n' +
            '            <div class="panel-heading">粉尘站点列表</div>\n' +
            '            <div class="panel-body"\n' +
            '                 style="height: 92%;overflow-y:scroll;">\n' +
            '                <div id="enterpriseNode"\n' +
            '                     style="font-size: x-small;"' +
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
            div.style.width = '25vh';
            div.style.height = '30vh';

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

        showHMSL();
        showHBYSL();
        showADYDL();
        showNodeStatus();
        showWPSL();
        showSWXX();
    }

    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            if (items && items.length > 0) {
                $.each(pagePars.enterpriseNode, function (index, node) {
                    if (node.nodeId == items[0].id) {
                        var longitude = parseFloat(node.nodeLongitude);
                        var latitude = parseFloat(node.nodeLatitude);

                        pagePars.map.openInfoWindow(pagePars.infoWindows[items[0].id], new BMap.Point(longitude, latitude));

                        pagePars.selectNode = node;
                        initChar();
                        refCharData();
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

    function initChar() {
        var node = pagePars.selectNode;
        var nodeItems = node.nodeItem;
        var yAxis = [], series = [], pars = [], parNames = [], parUnits = [], parCount = 0;

        pagePars.nodeLine = {
            nodeId: node.nodeId,
            nodeName: node.nodeName,
            label: []
        };

        if (!(typeof (nodeItems) === "undefined" || nodeItems === null)) {
            //nodeItems = $.parseJSON(nodeItems);
            parCount = -1;
            for (var item in nodeItems) {
                // nodeItems[item] = $.parseJSON(nodeItems[item]);
                if (nodeItems[item].itemMonitor == 1 && nodeItems[item].itemSelect == 1) {
                    var parName = nodeItems[item].itemName;
                    var parUnit = nodeItems[item].hasOwnProperty("itemUnit") ? nodeItems[item].itemUnit : "";

                    parCount++;
                    pagePars.nodeLine[item] = [];
                    pars.push(item);
                    parNames.push(parName);
                    parUnits.push(parUnit);
                    yAxis.push({
                        gridLineWidth: 1,
                        labels: {
                            enabled: false,
                            format: '{value}',
                            style: {
                                color: pagePars.colors[parCount]
                            }
                        },
                        title: {
                            enabled: false,
                            text: '',
                            style: {
                                color: pagePars.colors[parCount]
                            }
                        },
                        opposite: false,
                    });
                    series.push({
                        name: parName,
                        type: 'spline',
                        yAxis: parCount,
                        data: [],
                        tooltip: {
                            valueSuffix: parUnit,
                        },
                        marker: {
                            enabled: false
                        },
                    });
                }
            }
        }

        pagePars.nodeLine.chart = null;
        pagePars.nodeLine.par = pars;
        pagePars.nodeLine.parName = parNames;
        pagePars.nodeLine.parUnit = parUnits;
        pagePars.nodeLine.parCount = parCount + 1;
        pagePars.nodeLine.yAxis = yAxis;
        pagePars.nodeLine.series = series;
    }

    function refCharData() {
        var momentStr = moment(pagePars.dateStr);
        var momentEnd = moment(pagePars.dateEnd);
        var timeLength = momentEnd.diff(momentStr, 'days');
        var dataType = "";

        if (timeLength < 0) {
            callError(100, "录入参数 -起止时间- 有误...!!");
            return;
        } else if (timeLength == 0) {
            if (momentEnd.diff(momentStr, 'hours') == 0) {
                dataType = "2011";
            } else {
                dataType = "2051";
            }
        } else if (timeLength <= 2) {
            dataType = "2051";
        } else {
            dataType = "2061";
        }

        $("#lineCurBox").empty();
        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbDataHis/refHbDataHis",
            cache: false,
            data: ServerRequestPar(1, {
                nodeId: pagePars.selectNode.nodeId,
                nodeMn: pagePars.selectNode.nodeMn,
                dataType: dataType,
                dateStr: pagePars.dateStr,
                dateEnd: pagePars.dateEnd
            }),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    var html = "";

                    //html += '<div class="panel panel-default subbox">';
                    //html += '<div class="panel-heading">' + pagePars.nodeLine.nodeName + '</div>';
                    html += '<div class="line" id = "line' + pagePars.nodeLine.nodeId + '"></div>';
                    //html += '</div>';

                    $("#lineCurBox").html(html);

                    pagePars.nodeLine.chart = new Highcharts.Chart({
                        credits: {
                            // text : '嘉臣光电科技有限公司',
                            // href : 'http://www.grasun-opt.com/'
                            text: '',
                            href: '#'
                        },
                        chart: {
                            renderTo: "line" + pagePars.nodeLine.nodeId,
                            zoomType: 'xy'
                        },
                        title: {
                            text: pagePars.nodeLine.nodeName + ' - 今日曲线'
                        },
                        /*
                        subtitle: {
                            text: "【" + pagePars.dateStr + " ~ " + pagePars.dateEnd + "】"
                        },
                         */
                        navigation: {
                            buttonOptions: {
                                enabled: false
                            }
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        xAxis: [{
                            title: {
                                text: '',
                                style: {
                                    color: pagePars.colors[10]
                                }
                            },
                            type: 'datetime',
                            tickInterval: res.rowCount / 6,
                            categories: []
                        }],
                        yAxis: pagePars.nodeLine.yAxis,
                        tooltip: {
                            crosshairs: true,
                            shared: true
                        },
                        series: pagePars.nodeLine.series,
                    });

                    pagePars.nodeLine.label = [];
                    $.each(pagePars.nodeLine.par, function (index, value) {
                        pagePars.nodeLine[value] = [];
                    });

                    $.each(res.data, function (index, value) {
                        pagePars.nodeLine.label.push(value.dataTime);
                        if (value.hasOwnProperty("nodeData")) {
                            var nodeData = $.parseJSON(value.nodeData);

                            $.each(pagePars.nodeLine.par, function (index, par) {
                                if (nodeData.hasOwnProperty(par)) {
                                    pagePars.nodeLine[par].push(parseFloat(nodeData[par]));
                                } else {
                                    pagePars.nodeLine[par].push(0);
                                }
                            });
                        }
                    });

                    pagePars.nodeLine.chart.xAxis[0].setCategories(pagePars.nodeLine.label);
                    $.each(pagePars.nodeLine.par, function (index, par) {
                        pagePars.nodeLine.chart.series[index].setData(pagePars.nodeLine[par]);
                    });

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        });
    }

    function showHMSL() {
        var cumulativeFlowSum = 0;
        var pieData = [];
        $.each(pagePars.nodeInfo, function (index, node) {
            if (node.nodeName.indexOf("海轮码头") >= 0
                || node.nodeName.indexOf("内档泊位") >= 0
                || node.nodeName.indexOf("驳船泊位") >= 0) {

                var cumulativeFlowName = null, realFlowName = null;
                var cumulativeFlowUnit = null, realFlowUnit = null;
                var cumulativeFlow = 0, realFlow = 0, realFlowMax = 200;
                var nodeItem = $.parseJSON(node.nodeItem);
                for (var item in nodeItem) {
                    var itemInfo = $.parseJSON(nodeItem[item]);
                    if (itemInfo.itemName.indexOf("累计流量") >= 0) {
                        cumulativeFlowName = item;
                        cumulativeFlowUnit = itemInfo.itemUnit;
                    }
                    if (itemInfo.itemName.indexOf("实时流量") >= 0) {
                        realFlowName = item;
                        realFlowUnit = itemInfo.itemUnit;
                        if (itemInfo.itemVmax) {
                            realFlowMax = parseFloat(itemInfo.itemVmax);
                        }
                    }
                }
                $.each(pagePars.nodeDataInfo, function (count, data) {
                    if (data.nodeId == node.nodeId) {
                        var nodeData = $.parseJSON(data.nodeData);
                        if (cumulativeFlowName && nodeData[cumulativeFlowName]) {
                            cumulativeFlow = parseFloat(nodeData[cumulativeFlowName]);
                            cumulativeFlowSum += cumulativeFlow;
                        }
                        if (realFlowName && nodeData[realFlowName]) {
                            realFlow = parseFloat(nodeData[realFlowName]);
                        }
                    }
                })

                pieData.push({
                    name: node.nodeName + "-<b>" + cumulativeFlow + "</b>" + cumulativeFlowUnit,
                    nameOriginal: node.nodeName,
                    cumulativeFlow: cumulativeFlow,
                    cumulativeFlowUnit: cumulativeFlowUnit,
                    realFlow: realFlow,
                    realFlowUnit: realFlowUnit,
                    realFlowMax: realFlowMax,
                });
            }
        })
        if (cumulativeFlowSum > 0) {
            $.each(pieData, function (index, value) {
                value.y = value.cumulativeFlow * 100 / cumulativeFlowSum;
            })
        }

        Highcharts.chart('pieHMSL', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: null
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            legend: {
                enabled: false
            },
            navigation: {
                buttonOptions: {
                    enabled: false
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: '占比',
                colorByPoint: true,
                data: pieData
            }]
        });

        $.each(pieData, function (index, value) {
            Highcharts.chart('gaugeHMSL' + index, {
                credits: {
                    // text : '嘉臣光电科技有限公司',
                    // href : 'http://www.grasun-opt.com/'
                    text: '',
                    href: '#'
                },
                chart: {
                    type: 'gauge',
                    plotBackgroundColor: null,
                    plotBackgroundImage: null,
                    plotBorderWidth: 0,
                    plotShadow: false
                },
                title: {
                    text: value.nameOriginal,
                    floating: true,
                    verticalAlign: 'top',
                    style: {
                        fontSize: 10,
                        fontWeight: 'bold'
                    }
                },
                navigation: {
                    buttonOptions: {
                        enabled: false
                    }
                },
                pane: {
                    startAngle: -150,
                    endAngle: 150,
                    background: [{
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#FFF'],
                                [1, '#333']
                            ]
                        },
                        borderWidth: 0,
                        outerRadius: '109%'
                    }, {
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#333'],
                                [1, '#FFF']
                            ]
                        },
                        borderWidth: 1,
                        outerRadius: '107%'
                    }, {
                        // default background
                    }, {
                        backgroundColor: '#DDD',
                        borderWidth: 0,
                        outerRadius: '105%',
                        innerRadius: '103%'
                    }]
                },
                // the value axis
                yAxis: {
                    min: 0,
                    max: value.realFlowMax,
                    minorTickInterval: 'auto',
                    minorTickWidth: 1,
                    minorTickLength: 10,
                    minorTickPosition: 'inside',
                    minorTickColor: '#666',
                    tickPixelInterval: 30,
                    tickWidth: 2,
                    tickPosition: 'inside',
                    tickLength: 10,
                    tickColor: '#666',
                    labels: {
                        step: 5,
                        rotation: 'auto'
                    },
                    title: {
                        text: null
                    },
                    plotBands: [{
                        from: 0,
                        to: value.realFlowMax * 0.3,
                        color: '#DDDF0D' // yellow
                    }, {
                        from: value.realFlowMax * 0.3,
                        to: value.realFlowMax * 0.7,
                        color: '#55BF3B' // green
                    }, {
                        from: value.realFlowMax * 0.7,
                        to: value.realFlowMax,
                        color: '#DF5353' // red
                    }]
                },
                series: [{
                    name: '实时流量',// value.nameOriginal,
                    data: [{
                        dataLabels: {
                            enabled: true,
                            align: 'center',
                            style: {
                                fontWeight: 'bold'
                            },
                            verticalAlign: 'top',
                            overflow: 'none',
                            crop: false,
                            allowOverlap: true
                        },
                        y: value.realFlow
                    }],//value.gauge,
                    tooltip: {
                        valueSuffix: ' ' + value.realFlowUnit
                    },
                    dataLabels: {
                        enabled: true
                    }
                }]
            });
        })
    }

    function showHBYSL() {
        var cumulativeFlowSum = 0;
        var pieData = [];
        $.each(pagePars.nodeInfo, function (index, node) {
            if (node.nodeName.indexOf("环保用水") >= 0) {
                var cumulativeFlowName = null, realFlowName = null, electricName = null;
                var cumulativeFlowUnit = null, realFlowUnit = null, electricUnit = null;
                var cumulativeFlow = 0, realFlow = 0, electric = 0, realFlowMax = 200, electricMax = 200;
                var nodeItem = $.parseJSON(node.nodeItem);
                for (var item in nodeItem) {
                    var itemInfo = $.parseJSON(nodeItem[item]);
                    if (itemInfo.itemName.indexOf("累计流量") >= 0) {
                        cumulativeFlowName = item;
                        cumulativeFlowUnit = itemInfo.itemUnit;
                    }
                    if (itemInfo.itemName.indexOf("实时流量") >= 0) {
                        realFlowName = item;
                        realFlowUnit = itemInfo.itemUnit;
                        if (itemInfo.itemVmax) {
                            realFlowMax = parseFloat(itemInfo.itemVmax);
                        }
                    }
                    if (itemInfo.itemName.indexOf("电流") >= 0) {
                        electricName = item;
                        electricUnit = itemInfo.itemUnit;
                        if (itemInfo.itemVmax) {
                            electricMax = parseFloat(itemInfo.itemVmax);
                        }
                    }
                }
                $.each(pagePars.nodeDataInfo, function (count, data) {
                    if (data.nodeId == node.nodeId) {
                        var nodeData = $.parseJSON(data.nodeData);
                        if (cumulativeFlowName && nodeData[cumulativeFlowName]) {
                            cumulativeFlow = parseFloat(nodeData[cumulativeFlowName]);
                            cumulativeFlowSum += cumulativeFlow;
                        }
                        if (realFlowName && nodeData[realFlowName]) {
                            realFlow = parseFloat(nodeData[realFlowName]);
                        }
                        if (electricName && nodeData[electricName]) {
                            electric = parseFloat(nodeData[electricName]);
                        }
                    }
                })

                pieData.push({
                    name: node.nodeName + "-<b>" + cumulativeFlow + "</b>" + cumulativeFlowUnit,
                    nameOriginal: node.nodeName,
                    cumulativeFlow: cumulativeFlow,
                    cumulativeFlowUnit: cumulativeFlowUnit,
                    realFlow: realFlow,
                    realFlowUnit: realFlowUnit,
                    realFlowMax: realFlowMax,
                    electric: electric,
                    electricUnit: electricUnit,
                    electricMax: electricMax,
                });
            }
        })
        if (cumulativeFlowSum > 0) {
            $.each(pieData, function (index, value) {
                value.y = value.cumulativeFlow * 100 / cumulativeFlowSum;
            })
        }

        Highcharts.chart('pieHBYSL', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: null
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            legend: {
                enabled: true
            },
            /*
            legend: {
                layout: 'horizontal',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            }, */
            navigation: {
                buttonOptions: {
                    enabled: false
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false,
                        crop: true,
                        verticalAlign: 'middle',
                        padding: 0,
                        x: 0,
                        y: 0
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: '占比',
                colorByPoint: true,
                data: pieData
            }]
        });

        var value = pieData[0];
        Highcharts.chart('gaugeHBYSL0', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                type: 'gauge',
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false
            },
            title: {
                text: value.nameOriginal,
                floating: true,
                verticalAlign: 'top',
                style: {
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            navigation: {
                buttonOptions: {
                    enabled: false
                }
            },
            pane: {
                startAngle: -150,
                endAngle: 150,
                background: [{
                    backgroundColor: {
                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, '#FFF'],
                            [1, '#333']
                        ]
                    },
                    borderWidth: 0,
                    outerRadius: '109%'
                }, {
                    backgroundColor: {
                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, '#333'],
                            [1, '#FFF']
                        ]
                    },
                    borderWidth: 1,
                    outerRadius: '107%'
                }, {
                    // default background
                }, {
                    backgroundColor: '#DDD',
                    borderWidth: 0,
                    outerRadius: '105%',
                    innerRadius: '103%'
                }]
            },
            // the value axis
            yAxis: {
                min: 0,
                max: value.realFlowMax,
                minorTickInterval: 'auto',
                minorTickWidth: 1,
                minorTickLength: 10,
                minorTickPosition: 'inside',
                minorTickColor: '#666',
                tickPixelInterval: 30,
                tickWidth: 2,
                tickPosition: 'inside',
                tickLength: 10,
                tickColor: '#666',
                labels: {
                    step: 5,
                    rotation: 'auto'
                },
                title: {
                    text: null
                },
                plotBands: [{
                    from: 0,
                    to: value.realFlowMax * 0.3,
                    color: '#DDDF0D' // yellow
                }, {
                    from: value.realFlowMax * 0.3,
                    to: value.realFlowMax * 0.7,
                    color: '#55BF3B' // green
                }, {
                    from: value.realFlowMax * 0.7,
                    to: value.realFlowMax,
                    color: '#DF5353' // red
                }]
            },
            series: [{
                name: '实时流量',//value.nameOriginal,
                data: [{
                    dataLabels: {
                        enabled: true,
                        align: 'center',
                        style: {
                            fontWeight: 'bold'
                        },
                        verticalAlign: 'top',
                        overflow: 'none',
                        crop: false,
                        allowOverlap: true
                    },
                    y: value.realFlow
                }],//value.gauge,
                tooltip: {
                    valueSuffix: ' ' + value.realFlowUnit
                },
                dataLabels: {
                    enabled: true
                }
            }]
        });

        Highcharts.chart('gaugeHBYSL1', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                type: 'gauge',
                plotBackgroundColor: null,
                plotBackgroundImage: null,
                plotBorderWidth: 0,
                plotShadow: false
            },
            title: {
                text: value.nameOriginal,
                floating: true,
                verticalAlign: 'top',
                style: {
                    fontSize: 10,
                    fontWeight: 'bold'
                }
            },
            navigation: {
                buttonOptions: {
                    enabled: false
                }
            },
            pane: {
                startAngle: -150,
                endAngle: 150,
                background: [{
                    backgroundColor: {
                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, '#FFF'],
                            [1, '#333']
                        ]
                    },
                    borderWidth: 0,
                    outerRadius: '109%'
                }, {
                    backgroundColor: {
                        linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                        stops: [
                            [0, '#333'],
                            [1, '#FFF']
                        ]
                    },
                    borderWidth: 1,
                    outerRadius: '107%'
                }, {
                    // default background
                }, {
                    backgroundColor: '#DDD',
                    borderWidth: 0,
                    outerRadius: '105%',
                    innerRadius: '103%'
                }]
            },
            // the value axis
            yAxis: {
                min: 0,
                max: value.electricMax,
                minorTickInterval: 'auto',
                minorTickWidth: 1,
                minorTickLength: 10,
                minorTickPosition: 'inside',
                minorTickColor: '#666',
                tickPixelInterval: 30,
                tickWidth: 2,
                tickPosition: 'inside',
                tickLength: 10,
                tickColor: '#666',
                labels: {
                    step: 5,
                    rotation: 'auto'
                },
                title: {
                    text: null
                },
                plotBands: [{
                    from: 0,
                    to: value.electricMax * 0.3,
                    color: '#DDDF0D' // yellow
                }, {
                    from: value.electricMax * 0.3,
                    to: value.electricMax * 0.7,
                    color: '#55BF3B' // green
                }, {
                    from: value.electricMax * 0.7,
                    to: value.electricMax,
                    color: '#DF5353' // red
                }]
            },
            series: [{
                name: '实时电流',//value.nameOriginal,
                data: [{
                    dataLabels: {
                        enabled: true,
                        align: 'center',
                        style: {
                            fontWeight: 'bold'
                        },
                        verticalAlign: 'top',
                        overflow: 'none',
                        crop: false,
                        allowOverlap: true
                    },
                    y: value.electric
                }],//value.gauge,
                tooltip: {
                    valueSuffix: ' ' + value.electricUnit
                },
                dataLabels: {
                    enabled: true
                }
            }]
        });
    }

    function showADYDL() {
        var pieData = [];
        $.each(pagePars.nodeInfo, function (index, node) {
            if (node.nodeName.indexOf("岸电用电") >= 0) {
                var nodeData = null;
                $.each(pagePars.nodeDataInfo, function (count, data) {
                    if (data.nodeId == node.nodeId) {
                        nodeData = $.parseJSON(data.nodeData);
                    }
                })
                if (nodeData) {
                    var nodeItem = $.parseJSON(node.nodeItem);
                    for (var item in nodeItem) {
                        var itemInfo = $.parseJSON(nodeItem[item]);
                        if (itemInfo.itemName.indexOf("电压UA") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                        if (itemInfo.itemName.indexOf("电压UB") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                        if (itemInfo.itemName.indexOf("电压UC") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                        if (itemInfo.itemName.indexOf("电流IA") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                        if (itemInfo.itemName.indexOf("电流IB") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                        if (itemInfo.itemName.indexOf("电流IC") >= 0) {
                            pieData.push({
                                name: itemInfo.itemName,
                                value: nodeData[item] ? parseFloat(nodeData[item]) : 0,
                                unit: itemInfo.itemUnit,
                                max: itemInfo.itemVmax ? parseFloat(itemInfo.itemVmax) : 380
                            });
                        }
                    }
                }
            }
        })

        $.each(pieData, function (index, value) {
            Highcharts.chart('gaugeADYDL' + index, {
                credits: {
                    // text : '嘉臣光电科技有限公司',
                    // href : 'http://www.grasun-opt.com/'
                    text: '',
                    href: '#'
                },
                chart: {
                    type: 'gauge',
                    plotBackgroundColor: null,
                    plotBackgroundImage: null,
                    plotBorderWidth: 0,
                    plotShadow: false
                },
                title: {
                    text: value.name,
                    floating: true,
                    verticalAlign: 'top',
                    style: {
                        fontSize: 10,
                        fontWeight: 'bold'
                    }
                },
                navigation: {
                    buttonOptions: {
                        enabled: false
                    }
                },
                pane: {
                    startAngle: -150,
                    endAngle: 150,
                    background: [{
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#FFF'],
                                [1, '#333']
                            ]
                        },
                        borderWidth: 0,
                        outerRadius: '109%'
                    }, {
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#333'],
                                [1, '#FFF']
                            ]
                        },
                        borderWidth: 1,
                        outerRadius: '107%'
                    }, {
                        // default background
                    }, {
                        backgroundColor: '#DDD',
                        borderWidth: 0,
                        outerRadius: '105%',
                        innerRadius: '103%'
                    }]
                },
                // the value axis
                yAxis: {
                    min: 0,
                    max: value.max,
                    minorTickInterval: 'auto',
                    minorTickWidth: 1,
                    minorTickLength: 10,
                    minorTickPosition: 'inside',
                    minorTickColor: '#666',
                    tickPixelInterval: 30,
                    tickWidth: 2,
                    tickPosition: 'inside',
                    tickLength: 10,
                    tickColor: '#666',
                    labels: {
                        step: 5,
                        rotation: 'auto'
                    },
                    title: {
                        text: null
                    },
                    plotBands: [{
                        from: 0,
                        to: value.max * 0.3,
                        color: '#DDDF0D' // yellow
                    }, {
                        from: value.max * 0.3,
                        to: value.max * 0.7,
                        color: '#55BF3B' // green
                    }, {
                        from: value.max * 0.7,
                        to: value.max,
                        color: '#DF5353' // red
                    }]
                },
                series: [{
                    name: value.name,// value.nameOriginal,
                    data: [{
                        dataLabels: {
                            enabled: true,
                            align: 'center',
                            style: {
                                fontWeight: 'bold'
                            },
                            verticalAlign: 'top',
                            overflow: 'none',
                            crop: false,
                            allowOverlap: true
                        },
                        y: value.value
                    }],//value.gauge,
                    tooltip: {
                        valueSuffix: ' ' + value.unit
                    },
                    dataLabels: {
                        enabled: true
                    }
                }]
            });
        })
    }

    function showNodeStatus() {
        var statusHtml = "";
        $("#sysbztDiv").html("");
        for (var nodeId in pagePars.nodeAlarmVoice) {
            if (!pagePars.nodeAlarmVoice[nodeId].online) {
                statusHtml += "<span class='badge' style='background-color: red;font-size:small;margin-right: 5px;margin-top: 5px;'>" + pagePars.nodeAlarmVoice[nodeId].nodeName + "</span>";
            } else {
                statusHtml += "<span class='badge' style='background-color: green;font-size:small;margin-right: 5px;margin-top: 5px;'>" + pagePars.nodeAlarmVoice[nodeId].nodeName + "</span>";
            }
        }
        $("#sysbztDiv").html(statusHtml);
    }

    function showWPSL() {
        var cumulativeFlowSum = 0;
        var pieData = [];
        $.each(pagePars.nodeInfo, function (index, node) {
            if (node.nodeName.indexOf("生活污水") >= 0
                || node.nodeName.indexOf("渗灰池水") >= 0
                || node.nodeName.indexOf("船舶生活污水") >= 0) {

                var cumulativeFlowName = null, realFlowName = null;
                var cumulativeFlowUnit = null, realFlowUnit = null;
                var cumulativeFlow = 0, realFlow = 0, realFlowMax = 200;
                var nodeItem = $.parseJSON(node.nodeItem);
                for (var item in nodeItem) {
                    var itemInfo = $.parseJSON(nodeItem[item]);
                    if (itemInfo.itemName.indexOf("累计流量") >= 0) {
                        cumulativeFlowName = item;
                        cumulativeFlowUnit = itemInfo.itemUnit;
                    }
                    if (itemInfo.itemName.indexOf("实时流量") >= 0) {
                        realFlowName = item;
                        realFlowUnit = itemInfo.itemUnit;
                        if (itemInfo.itemVmax) {
                            realFlowMax = parseFloat(itemInfo.itemVmax);
                        }
                    }
                }
                $.each(pagePars.nodeDataInfo, function (count, data) {
                    if (data.nodeId == node.nodeId) {
                        var nodeData = $.parseJSON(data.nodeData);
                        if (cumulativeFlowName && nodeData[cumulativeFlowName]) {
                            cumulativeFlow = parseFloat(nodeData[cumulativeFlowName]);
                            cumulativeFlowSum += cumulativeFlow;
                        }
                        if (realFlowName && nodeData[realFlowName]) {
                            realFlow = parseFloat(nodeData[realFlowName]);
                        }
                    }
                })

                pieData.push({
                    name: node.nodeName + "-<b>" + cumulativeFlow + "</b>" + cumulativeFlowUnit,
                    nameOriginal: node.nodeName,
                    cumulativeFlow: cumulativeFlow,
                    cumulativeFlowUnit: cumulativeFlowUnit,
                    realFlow: realFlow,
                    realFlowUnit: realFlowUnit,
                    realFlowMax: realFlowMax,
                });
            }
        })
        if (cumulativeFlowSum > 0) {
            $.each(pieData, function (index, value) {
                value.y = value.cumulativeFlow * 100 / cumulativeFlowSum;
            })
        }

        Highcharts.chart('pieWPSL', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: null
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            legend: {
                enabled: false
            },
            navigation: {
                buttonOptions: {
                    enabled: false
                }
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: '占比',
                colorByPoint: true,
                data: pieData
            }]
        });

        $.each(pieData, function (index, value) {
            Highcharts.chart('gaugeWPSL' + index, {
                credits: {
                    // text : '嘉臣光电科技有限公司',
                    // href : 'http://www.grasun-opt.com/'
                    text: '',
                    href: '#'
                },
                chart: {
                    type: 'gauge',
                    plotBackgroundColor: null,
                    plotBackgroundImage: null,
                    plotBorderWidth: 0,
                    plotShadow: false
                },
                title: {
                    text: value.nameOriginal,
                    floating: true,
                    verticalAlign: 'top',
                    style: {
                        fontSize: 10,
                        fontWeight: 'bold'
                    }
                },
                navigation: {
                    buttonOptions: {
                        enabled: false
                    }
                },
                pane: {
                    startAngle: -150,
                    endAngle: 150,
                    background: [{
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#FFF'],
                                [1, '#333']
                            ]
                        },
                        borderWidth: 0,
                        outerRadius: '109%'
                    }, {
                        backgroundColor: {
                            linearGradient: {x1: 0, y1: 0, x2: 0, y2: 1},
                            stops: [
                                [0, '#333'],
                                [1, '#FFF']
                            ]
                        },
                        borderWidth: 1,
                        outerRadius: '107%'
                    }, {
                        // default background
                    }, {
                        backgroundColor: '#DDD',
                        borderWidth: 0,
                        outerRadius: '105%',
                        innerRadius: '103%'
                    }]
                },
                // the value axis
                yAxis: {
                    min: 0,
                    max: value.realFlowMax,
                    minorTickInterval: 'auto',
                    minorTickWidth: 1,
                    minorTickLength: 10,
                    minorTickPosition: 'inside',
                    minorTickColor: '#666',
                    tickPixelInterval: 30,
                    tickWidth: 2,
                    tickPosition: 'inside',
                    tickLength: 10,
                    tickColor: '#666',
                    labels: {
                        step: 5,
                        rotation: 'auto'
                    },
                    title: {
                        text: null
                    },
                    plotBands: [{
                        from: 0,
                        to: value.realFlowMax * 0.3,
                        color: '#DDDF0D' // yellow
                    }, {
                        from: value.realFlowMax * 0.3,
                        to: value.realFlowMax * 0.7,
                        color: '#55BF3B' // green
                    }, {
                        from: value.realFlowMax * 0.7,
                        to: value.realFlowMax,
                        color: '#DF5353' // red
                    }]
                },
                series: [{
                    name: '实时流量',// value.nameOriginal,
                    data: [{
                        dataLabels: {
                            enabled: true,
                            align: 'center',
                            style: {
                                fontWeight: 'bold'
                            },
                            verticalAlign: 'top',
                            overflow: 'none',
                            crop: false,
                            allowOverlap: true
                        },
                        y: value.realFlow
                    }],//value.gauge,
                    tooltip: {
                        valueSuffix: ' ' + value.realFlowUnit
                    },
                    dataLabels: {
                        enabled: true
                    }
                }]
            });
        })
    }

    function showSWXX() {
        var columnData = [];
        var unit = null;
        $.each(pagePars.nodeInfo, function (index, node) {
            if (node.nodeName.indexOf("雨水池") >= 0
                || node.nodeName.indexOf("含煤废水池") >= 0) {

                var parName = null, value = 0;
                var nodeItem = $.parseJSON(node.nodeItem);
                for (var item in nodeItem) {
                    var itemInfo = $.parseJSON(nodeItem[item]);
                    if (itemInfo.itemName.indexOf("水位高度") >= 0) {
                        parName = item;
                        if (!unit && itemInfo.itemUnit) {
                            unit = itemInfo.itemUnit;
                        }
                    }
                }
                $.each(pagePars.nodeDataInfo, function (count, data) {
                    if (data.nodeId == node.nodeId) {
                        var nodeData = $.parseJSON(data.nodeData);
                        if (parName && nodeData[parName]) {
                            value = parseFloat(nodeData[parName]);
                        }
                    }
                })

                var data = [];
                data.push(value);
                columnData.push({
                    name: node.nodeName,
                    data: data
                });
            }
        })

        console.log(JSON.stringify(columnData));

        Highcharts.chart('columnSWXX', {
            credits: {
                // text : '嘉臣光电科技有限公司',
                // href : 'http://www.grasun-opt.com/'
                text: '',
                href: '#'
            },
            chart: {
                type: 'column'
            },
            title: {
                text: null
            },
            xAxis: {
                categories: ['现在'],
                crosshair: true
            },
            yAxis: {
                min: 0,
                title: {
                    text: '水位 (' + unit + ')'
                }
            },
            tooltip: {
                shared: true,
                useHTML: true
            },
            plotOptions: {
                column: {
                    borderWidth: 0
                }
            },
            series: columnData
        });
    }

    function ServerRequestPar(parCount, inPars) {
        var par = {
            parCount: parCount,
            inPar: inPars
        };

        return JSON.stringify(par).replace(/%/g, "%25").replace(/\&/g, "%26").replace(/\+/g, "%2B");
    }

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
