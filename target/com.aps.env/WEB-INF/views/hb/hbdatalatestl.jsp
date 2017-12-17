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
<title>实时曲线</title>
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
<!--  -->
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/color.css"/>
<link rel="stylesheet"
      href="${ctx}/assets/css/font-awesome.min.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/tree/css/tree.css"/>
<style type="text/css">
    .box {
        position: absolute;
        overflow: auto;
        width: 95%;
        height: 90%;
        background: #fafafa;
        border: 0px solid #ccc;
    }

    .subbox {
        margin: 10px;
        width: 550px;
        height: 250px;
        background: #fff;
        border: 1px solid #ccc;
        float: left;
    }

    .line {
        position: absolute;
        margin: 5px;
        width: 540px;
        height: 195px;
        background: #fff;
        border: 1px solid #ccc;
    }
</style>
<body>
<div class="row"
     style="margin-right: 0px; margin-bottom: 0px;">
    <div class="col-lg-3 col-sm-3 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">企业列表</div>
            <div class="panel-body"
                 style="height: 92%;overflow-y:scroll; ">
                <div id="enterpriseRegion"
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
                 id="dataLineTitle">站点实时曲线
            </div>
            <div class="panel-body"
                 style="height: 92%;"
                 id="lineCur">
                <div class="box"
                     id="lineCurBox"></div>
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

<script src="${ctx}/dataTables/jQuery-2.2.0/jquery-2.2.0.min.js"></script>
<script src="${ctx}/dataTables/Bootstrap-3.3.6/js/bootstrap.min.js"></script>

<script src="${ctx}/assets-view/comm/highcharts/js/highcharts.js"></script>
<script src="${ctx}/assets-view/comm/highcharts/js/exporting.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    var pagePars = {
        colors: [
            "#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F",
            "#42A07B", "#DDDF0D", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"
        ],
        enterpriseRegion: [],
        nodeLines: [],
    };

    var regionDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseRegion';
    };

    regionDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
                            if (options.id == "所有") {
                                var treeData = [];

                                $.each(pagePars.enterpriseRegion, function (index, value) {
                                    var item = {};
                                    item.id = value.enterpriseId;
                                    item.name = value.enterpriseName;
                                    item.type = 'item';

                                    treeData.push(item);
                                });
                                callback({
                                    data: treeData
                                });
                            } else {
                                var treeData = [];
                                var subRegions = [];
                                var subRegionName = "";
                                var subRegionIndex = -1, subRegionCount = 0;

                                $.each(pagePars.enterpriseRegion, function (index, value) {
                                    var regionDesc = value.enterpriseRegionDesc;
                                    var regionTargets = regionDesc.split("(");

                                    regionDesc = regionTargets[0];
                                    regionTargets = regionDesc.split("/");

                                    for (var regionIndex = 1; regionIndex < regionTargets.length; regionIndex++) {
                                        if (options.id == regionTargets[regionIndex]) {
                                            if (regionIndex + 1 == regionTargets.length) {
                                                var item = {};
                                                item.id = value.enterpriseId;
                                                item.name = value.enterpriseName;
                                                item.type = 'item';

                                                treeData.push(item);
                                            } else {
                                                if (subRegionName != regionTargets[regionIndex + 1]) {
                                                    subRegionName = regionTargets[regionIndex + 1];
                                                    subRegionIndex++;
                                                    subRegionCount = 1;
                                                    subRegions.push({regionName: regionTargets[regionIndex + 1], regionCount: subRegionCount,});
                                                } else {
                                                    subRegionCount++;
                                                    subRegions[subRegionIndex].regionCount = subRegionCount;
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

                                    treeData.push(item);
                                });
                                callback({
                                    data: treeData
                                });
                            }
                        } else {

                        }
                    } else {
                        $.ajax({
                                type: "POST",
                                url: '${ctx}/viewHbEnterpriseCfg/refEnterprise',
                                cache: false,
                                data: ServerRequestPar(1, {byPerson: "1",}),
                                dataType: "json",
                                headers: {
                                    'Content-Type': 'application/json;charset=utf-8'
                                },
                                success: function (res) {
                                    if (res.code != 0) {
                                        pagePars.enterpriseRegion = [];
                                        callback({
                                            data: []
                                        });
                                    } else {
                                        var treeData = [];
                                        var regions = [];
                                        var regionName = "";
                                        var regionIndex = -1, regionCount = 0;

                                        pagePars.enterpriseRegion = res.data;
                                        treeData.push({id: "所有", name: "<b>所有企业</b> - [" + res.data.length + "]", type: "folder",});

                                        $.each(pagePars.enterpriseRegion, function (index, value) {
                                            var regionDesc = value.enterpriseRegionDesc;
                                            var regionTargets = regionDesc.split("(");

                                            regionDesc = regionTargets[0];
                                            regionTargets = regionDesc.split("/");

                                            if (regionName != regionTargets[1]) {
                                                regionName = regionTargets[1];
                                                regionIndex++;
                                                regionCount = 1;
                                                regions.push({regionName: regionName, regionCount: regionCount,});
                                            } else {
                                                regionCount++;
                                                regions[regionIndex].regionCount = regionCount;
                                            }
                                        });
                                        $.each(regions, function (index, value) {
                                            var item = {};

                                            item.id = value.regionName;
                                            item.name = value.regionName + " - [" + value.regionCount + "]";
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
                        )
                        ;
                    }
                },
                this._delay
            )
        }
    };

    /**
     *
     */
    jQuery(document).ready(function () {
        $('#enterpriseRegion').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: new regionDataSource({
                data: [],
                delay: 400
            }),
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });
    });

    /**
     *
     */
    function refHbNode(enterpriseId) {
        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbDataLLine/refHbNode",
            cache: false,
            data: ServerRequestPar(1, {enterpriseId: enterpriseId,}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    $("#lineCurBox").html("");
                    callError(res.code, res.message);
                } else {
                    var html = "";

                    $.each(res.data, function (index, value) {
                        html += '<div class="panel panel-default subbox">';
                        html += '<div class="panel-heading">' + value.nodeName + '</div>';
                        html += '<div class="panel-body line" id = "line' + value.nodeId + '"></div>';
                        html += '</div>';
                    });

                    $("#lineCurBox").html(html);

                    $.each(res.data, function (index, value) {
                        if (value.hasOwnProperty("nodeMn")) {
                            var nodeItems = value.nodeItem;
                            var yAxis = [], series = [], pars = [], parNames = [], parUnits = [], parCount = 0;

                            pagePars.nodeLines[value.nodeId] = {
                                nodeId: value.nodeId,
                                nodeName: value.nodeName,
                                label: []
                            };
                            if (!(typeof (nodeItems) === "undefined" || nodeItems === null)) {
                                nodeItems = $.parseJSON(nodeItems);
                                parCount = -1;
                                res.data[index].nodeItem = nodeItems;
                                for (var item in nodeItems) {
                                    nodeItems[item] = $.parseJSON(nodeItems[item]);
                                    if (nodeItems[item].itemSelect == 1) {
                                        var parName = nodeItems[item].itemName;
                                        var parUnit = nodeItems[item].hasOwnProperty("itemUnit") ? nodeItems[item].itemUnit : '';

                                        parCount++;
                                        pagePars.nodeLines[value.nodeId][item] = [];
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

                            var chart = new Highcharts.Chart({
                                credits: {
                                    // text : '嘉臣光电科技有限公司',
                                    // href : 'http://www.grasun-opt.com/'
                                    text: '',
                                    href: '#'
                                },
                                chart: {
                                    renderTo: "line" + value.nodeId,
                                    zoomType: 'xy'
                                },
                                title: {
                                    text: '-实时曲线-'
                                },
                                legend: {
                                    layout: 'vertical',
                                    align: 'right',
                                    verticalAlign: 'middle',
                                    borderWidth: 0
                                },
                                xAxis: [
                                    {
                                        title: {
                                            text: '',
                                            style: {
                                                color: pagePars.colors[10]
                                            }
                                        },
                                        type: 'datetime',
                                        tickInterval: 200,
                                        categories: []
                                    }
                                ],
                                yAxis: yAxis,
                                tooltip: {
                                    crosshairs: true,
                                    shared: true
                                },
                                series: series,
                            });

                            pagePars.nodeLines[value.nodeId].chart = chart;
                            pagePars.nodeLines[value.nodeId].par = pars;
                            pagePars.nodeLines[value.nodeId].parName = parNames;
                            pagePars.nodeLines[value.nodeId].parUnit = parUnits;
                            pagePars.nodeLines[value.nodeId].parCount = parCount + 1;
                        }
                    });

                    refDataCur(enterpriseId);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        });

    }

    /**
     *
     */
    function refDataCur(enterpriseId) {
        for (var node in pagePars.nodeLines) {
            pagePars.nodeLines[node].label = [];
            $.each(pagePars.nodeLines[node].par, function (index, value) {
                pagePars.nodeLines[node][value] = [];
            });
        }

        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbDataLLine/refHbDataLatest",
            cache: false,
            data: ServerRequestPar(1, {enterpriseId: enterpriseId,}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    $.each(res.data, function (index, value) {
                            pagePars.nodeLines[value.nodeId].label.push(value.dataTime);
                            if (value.hasOwnProperty("nodeData") && value.nodeData != "") {
                                var nodeData = $.parseJSON(value.nodeData);

                                value.nodeData = nodeData;
                                $.each(pagePars.nodeLines[value.nodeId].par, function (index, par) {
                                    // pagePars.nodeLines[value.nodeId][par].push(Math.random()*10);
                                    if (nodeData.hasOwnProperty(par)) {
                                        pagePars.nodeLines[value.nodeId][par].push(parseFloat(nodeData[par]));
                                    } else {
                                        pagePars.nodeLines[value.nodeId][par].push(0);
                                    }
                                });
                            }
                        }
                    );

                    for (var node in pagePars.nodeLines) {
                        pagePars.nodeLines[node].chart.xAxis[0].setCategories(pagePars.nodeLines[node].label);
                        $.each(pagePars.nodeLines[node].par, function (index, par) {
                            pagePars.nodeLines[node].chart.series[index].setData(pagePars.nodeLines[node][par]);
                        });
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        })
        ;

    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseRegion') {
            pagePars.nodeLines = [];
            if (items && items.length > 0) {
                var selectItem = items[0];

                $("#dataLineTitle").html(selectItem.name + " - 站点实时曲线");
                refHbNode(selectItem.id);
            } else {
                $("#lineCurBox").html("");
            }
        }
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
     */
    function callError(code, message) {
        $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
        $("#mwMessage").html(message);
        $("#modal-warning").modal("show");
    }

</script>
</body>
</html>
