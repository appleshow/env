<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/17
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>分钟数据统计</title>
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
    <div class="col-lg-3 col-sm-3 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">站点列表</div>
            <div class="panel-body"
                 style="height: 92%;overflow-y:scroll; ">
                <input class="form-control"
                       style="width: 180px; display: none;"
                       readonly
                       id="nodeId"
                       name="nodeId">
                </input>
                <input class="form-control"
                       style="width: 180px; display: none;"
                       readonly
                       id="dataType"
                       name="dataType">
                </input>
                <div id="treeNode"
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
    <div class="col-lg-9 col-sm-9 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">
                <form class="form-inline">
                    <div class="form-group">
                        <div class="input-group">
                                        <span class="input-group-btn">
                                             <button class="btn btn-default"
                                                     type="button">起止时间</button>
                                        </span>
                            <div class='input-group date'
                                 id='dateTimeStr'>
                                <input type='text'
                                       class="form-control"
                                       style="width: 180px;"
                                       id="dateStr"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span> </span>
                            </div>
                            <div class='input-group date'
                                 id='dateTimeEnd'>
                                <input type='text'
                                       class="form-control"
                                       style="width: 180px;"
                                       id="dateEnd"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span> </span>
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
                 id="tableDiv">
                <table id="tbdataCur"
                       class="table table-striped table-bordered display nowrap"
                       cellspacing="0"
                       width="100%">
                    <thead>
                    <tr id="tbdataCurHC"></tr>
                    </thead>
                </table>
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

<%@include file="../aplugin/treectrl.jsp" %>

<script type="application/javascript">
    /**
     * 当前页面全局变量
     */
    var pagePars = {
        firstLoad: true,
        tableDataCur: undefined,
        // 是否需要重新数据表格
        enterpriseNode: [],
        pageTitle: '分钟数据统计',
        maxDateLen: 31,
    };
    var pageShowDataUrl = "${ctx}/comm/referPageShow";

    var DataSourceTree = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseNode';
    };

    DataSourceTree.prototype = {
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

    var treeDataNode = new DataSourceTree({
        data: [],
        delay: 400,
    });

    jQuery(document).ready(function () {
        // ******** 开始初始时间区间 ********
        $('#dateStr').val(( new Date() ).format("yyyy-MM-dd") + " 00:00:00");
        $('#dateEnd').val(( new Date() ).format("yyyy-MM-dd") + " 23:59:59");
        dateTimeDefualt();

        $('#dateTimeStr').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss',
        });
        $('#dateTimeEnd').datetimepicker({
            format: 'YYYY-MM-DD HH:mm:ss',
        });
        $("#dateTimeStr").on("dp.change", function (e) {
            $('#dateTimeEnd').data("DateTimePicker").minDate(e.date);
        });
        $("#dateTimeEnd").on("dp.change", function (e) {
            $('#dateTimeStr').data("DateTimePicker").maxDate(e.date);
        });

        // ******** 开始初始化站点列表 ********
        $('#treeNode').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: treeDataNode,
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });

        $("#dataType").val("2011");
        if ("${dataType}" == "m") {
            pagePars.pageTitle = "分钟数据统计";
            pagePars.maxDateLen = "31";
            $("#dataType").val("2051");
        } else if ("${dataType}" == "h") {
            pagePars.pageTitle = "小时数据统计";
            pagePars.maxDateLen = "31";
            $("#dataType").val("2061");
        }

        pagePars.tableDataCur = new CommDataTables("#tbdataCur", "#tbdataCurHC", ${pageId}, callError, pageShowDataUrl);
        pagePars.tableDataCur.serverInfo.referUrl = "${ctx}/viewHbNodeStatistic/refHbData";
        pagePars.tableDataCur.serverInfo.referControls.push(ControlPar("text", "nodeId", "", $("#nodeId")));
        pagePars.tableDataCur.serverInfo.referControls.push(ControlPar("text", "dataType", "", $("#dataType")));
        pagePars.tableDataCur.serverInfo.referControls.push(ControlPar("text", "dateStr", "", $("#dateStr")));
        pagePars.tableDataCur.serverInfo.referControls.push(ControlPar("text", "dateEnd", "", $("#dateEnd")));
        pagePars.tableDataCur.buttons = "P";
        pagePars.tableDataCur.scrollY = 72;
        pagePars.tableDataCur.create();

    })

    /**
     *
     */
    function refData() {
        var selectNodes = $('#treeNode').tree('selectedItems');
        if (selectNodes.length == 0) {
            callError(100, "请先选择一个站点...!!");
            return;
        }
        var momentStr = moment($('#dateStr').val());
        var momentEnd = moment($('#dateEnd').val());
        var timeLength = momentEnd.diff(momentStr, 'days') + 1;

        if (timeLength > pagePars.maxDateLen) {
            callError(100, "时间区间最大为【" + pagePars.maxDateLen + "天】，当前查询区间为：" + timeLength + "天...!!");
            return;
        }

        pagePars.tableDataCur.table.ajax.reload(null, false);
    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            if (items.length > 0) {
                $("#nodeId").val(items[0].id);
                document.title = pagePars.pageTitle + " - " + items[0].name;
            } else {
                $("#nodeId").val("");
            }
            refData();
        }
    }

    /*******************************************************************************************************************************************************************************************************
     * 错误提示框
     ******************************************************************************************************************************************************************************************************/
    function callError(code, message) {
        if (!pagePars.firstLoad) {
            $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;警告</span>');
            $("#mwMessage").html(message);
            $("#modal-warning").modal("show");
        } else {
            pagePars.firstLoad = false;
        }
    }

    /*******************************************************************************************************************************************************************************************************
     * 定义日期时间控件格式
     ******************************************************************************************************************************************************************************************************/
    function dateTimeDefualt() {
        moment.locale('en', {
            months: '一月_二月_三月_四月_五月_六月_七月_八月_九月_十月_十一月_十二月'.split('_'),
            monthsShort: '1月_2月_3月_4月_5月_6月_7月_8月_9月_10月_11月_12月'.split('_'),
            weekdays: '星期日_星期一_星期二_星期三_星期四_星期五_星期六'.split('_'),
            weekdaysShort: '周日_周一_周二_周三_周四_周五_周六'.split('_'),
            weekdaysMin: '日_一_二_三_四_五_六'.split('_'),
            longDateFormat: {
                LT: 'Ah点mm分',
                LTS: 'Ah点m分s秒',
                L: 'YYYY-MM-DD',
                LL: 'YYYY年MMMD日',
                LLL: 'YYYY年MMMD日Ah点mm分',
                LLLL: 'YYYY年MMMD日ddddAh点mm分',
                l: 'YYYY-MM-DD',
                ll: 'YYYY年MMMD日',
                lll: 'YYYY年MMMD日Ah点mm分',
                llll: 'YYYY年MMMD日ddddAh点mm分'
            },
            meridiemParse: /凌晨|早上|上午|中午|下午|晚上/,
            meridiemHour: function (hour, meridiem) {
                if (hour === 12) {
                    hour = 0;
                }
                if (meridiem === '凌晨' || meridiem === '早上' || meridiem === '上午') {
                    return hour;
                } else if (meridiem === '下午' || meridiem === '晚上') {
                    return hour + 12;
                } else {
                    // '中午'
                    return hour >= 11 ? hour : hour + 12;
                }
            },
            meridiem: function (hour, minute, isLower) {
                var hm = hour * 100 + minute;
                if (hm < 600) {
                    return '凌晨';
                } else if (hm < 900) {
                    return '早上';
                } else if (hm < 1130) {
                    return '上午';
                } else if (hm < 1230) {
                    return '中午';
                } else if (hm < 1800) {
                    return '下午';
                } else {
                    return '晚上';
                }
            },
            calendar: {
                sameDay: function () {
                    return this.minutes() === 0 ? '[今天]Ah[点整]' : '[今天]LT';
                },
                nextDay: function () {
                    return this.minutes() === 0 ? '[明天]Ah[点整]' : '[明天]LT';
                },
                lastDay: function () {
                    return this.minutes() === 0 ? '[昨天]Ah[点整]' : '[昨天]LT';
                },
                nextWeek: function () {
                    var startOfWeek, prefix;
                    startOfWeek = moment__default().startOf('week');
                    prefix = this.diff(startOfWeek, 'days') >= 7 ? '[下]' : '[本]';
                    return this.minutes() === 0 ? prefix + 'dddAh点整' : prefix + 'dddAh点mm';
                },
                lastWeek: function () {
                    var startOfWeek, prefix;
                    startOfWeek = moment__default().startOf('week');
                    prefix = this.unix() < startOfWeek.unix() ? '[上]' : '[本]';
                    return this.minutes() === 0 ? prefix + 'dddAh点整' : prefix + 'dddAh点mm';
                },
                sameElse: 'LL'
            },
            ordinalParse: /\d{1,2}(日|月|周)/,
            ordinal: function (number, period) {
                switch (period) {
                    case 'd' :
                    case 'D' :
                    case 'DDD' :
                        return number + '日';
                    case 'M' :
                        return number + '月';
                    case 'w' :
                    case 'W' :
                        return number + '周';
                    default :
                        return number;
                }
            },
            relativeTime: {
                future: '%s内',
                past: '%s前',
                s: '几秒',
                m: '1 分钟',
                mm: '%d 分钟',
                h: '1 小时',
                hh: '%d 小时',
                d: '1 天',
                dd: '%d 天',
                M: '1 个月',
                MM: '%d 个月',
                y: '1 年',
                yy: '%d 年'
            },
            week: {
                // GB/T 7408-1994《数据元和交换格式·信息交换·日期和时间表示法》与ISO 8601:1988等效
                dow: 1, // Monday is the first day of the week.
                doy: 4
                // The week that contains Jan 4th is the first week of the year.
            }
        });
    }
</script>
</body>
</html>
