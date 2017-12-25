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
<title>日志信息</title>
<meta name="description"
      content="Dashboard"/>
<meta name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible"
      content="IE=edge"/>
<meta http-equiv="Content-Type"
      content="text/html; charset=utf-8"/>
<!--DataTables Styles-->
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
      href="${ctx}/datetimePicker/css/bootstrap-datetimepicker.min.css"/>
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
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <form class="form-inline">
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-btn">
                         <button class="btn btn-default"
                                 type="button">站点名称</button>
                    </span>
                    <input class="form-control"
                           style="width: 180px; display: none;"
                           readonly
                           id="nodeId"
                           name="nodeId">
                    </input>
                    <input class="form-control"
                           style="width: 250px;"
                           readonly
                           id="showNodeName"
                           name="showNodeName">
                    </input>
                    <span class="input-group-btn">
                <button class="btn btn-default"
                        type="button"
                        onclick="openNodeWindow()">...</button>
            </span>
                </div>
            </div>
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
            <div class="form-group"
                 id="refChart">
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
    <div class="panel-body">
        <div id="tableDiv">
            <table id="tbdataCur"
                   class="table table-striped table-bordered display responsive nowrap"
                   cellspacing="0"
                   width="100%">
                <thead id="tbdataCurHC">
                </thead>
            </table>
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

<script src="${ctx}/datetimePicker/js/moment.min.js"></script>
<script src="${ctx}/datetimePicker/js/bootstrap-datetimepicker.min.js"></script>

<!--  -->
<script src="${ctx}/assets-view/comm/commDataTables.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>
<%@include file="../aplugin/nodepersonwindow.jsp" %>

<script type="application/javascript">
    var pagePars = {
        selectNode: undefined,
        tableDataCur: undefined,
        pageTitle: '日志信息',
        maxDateLen: 7,
        dataType: '3020',
    };


    jQuery(document).ready(function () {
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


        if ("${dataType}" == "m") {
            pagePars.pageTitle = "分钟数据";
            pagePars.maxDateLen = "7";
            pagePars.dataType = "2051";
        } else if ("${dataType}" == "h") {
            pagePars.pageTitle = "小时数据";
            pagePars.maxDateLen = "31";
            pagePars.dataType = "2061";
        }
    })

    /**
     *
     * @returns
     */
    function createtableDivHis() {
        pagePars.tableDataCur = new CommDataTables("#tbdataCur", "#tbdataCurHC", createColumnInfo(), callError);
        pagePars.tableDataCur.scrollY = 72;
        pagePars.tableDataCur.buttons = "P";
        pagePars.tableDataCur.lengthInfo = {
            lengthMenu: [[50, 100, 300], ["50条", "100条", "300条"]],
            pageLength: 50
        };
        // ***** Add information to Column *****
        // *********************************
        // ***** Add information to Field *****
        // *********************************

        pagePars.tableDataCur.create(null, datatableRefAjax);
    }

    /**
     *
     * @param nodeMN
     * @returns
     */
    function createColumnInfo() {
        var tableColumnInfo = {};
        var innerHtml = "<tr>";

        $("#tableDiv").empty();
        $("#tableDiv").html(' <table id="tbdataCur" class="table table-striped table-bordered display nowrap" cellspacing="0" width="100%"> <thead id="tbdataCurHC"></thead></table>');

        tableColumnInfo.nodeName = {
            name: "站点名称",
            primary: 0,
            update: 0,
            edit: 0,
            type: "text",
            lock: 0,
            sort: 0,
            hide: 0,
            align: 0,
            prtype: "T"
        };
        innerHtml += "<th>站点名称</th>";
        tableColumnInfo.dataTime = {
            name: "监测时间",
            primary: 0,
            update: 0,
            edit: 0,
            type: "text",
            lock: 0,
            sort: 1,
            hide: 0,
            align: 0,
            prtype: "T"
        };
        innerHtml += "<th>监测时间</th>";
        innerHtml += "</tr>";

        if (pagePars.selectNode.hasOwnProperty("nodeItem")) {
            innerHtml = "<tr>";
            innerHtml += "<th>站点名称</th>";
            innerHtml += "<th>监测时间</th>";

            pagePars.selectNode.nodeItem = $.parseJSON(pagePars.selectNode.nodeItem);
            for (var item in pagePars.selectNode.nodeItem) {
                var nodePar = $.parseJSON(pagePars.selectNode.nodeItem[item]);

                pagePars.selectNode.nodeItem[item] = nodePar;
                if (nodePar.itemLog == 1 && nodePar.itemSelect == 1) {
                    var columnInfo = {};

                    columnInfo.name = nodePar.itemName;
                    columnInfo.primary = 0;
                    columnInfo.update = 0;
                    columnInfo.edit = 0;
                    columnInfo.type = "text";
                    columnInfo.lock = 0;
                    columnInfo.sort = 0;
                    columnInfo.hide = 0;
                    columnInfo.align = 2;
                    columnInfo.prtype = "T";

                    tableColumnInfo["_" + nodePar.itemId] = columnInfo;

                    innerHtml += "<th>" + nodePar.itemName + (nodePar.itemUnit ? " (<small>" + nodePar.itemUnit + "</small>)" : "") + "</th>";
                }
            }

            innerHtml += "</tr>";
        }

        $("#tbdataCurHC").html(innerHtml);

        return tableColumnInfo;
    }

    /**
     *
     * @param data
     * @param callback
     * @param settings
     * @returns
     */
    function datatableRefAjax(data, callback, settings) {
        var tableData = {
            draw: settings.iDraw,
            recordsTotal: 0,
            recordsFiltered: 0,
            data: []
        };

        if (pagePars.selectNode == undefined) {
            callback(tableData);
            return;
        }
        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbDataHis/refHbDataHis",
            cache: false,
            data: ServerRequestPar(1, {
                nodeId: pagePars.selectNode.nodeId,
                nodeMn: pagePars.selectNode.nodeMn,
                dataType: pagePars.dataType,
                dateStr: $('#dateStr').val(),
                dateEnd: $('#dateEnd').val(),
                pageNumber: data.length == -1 ? 0 : data.start / data.length + 1,
                pageSize: data.length == -1 ? 0 : data.length
            }),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    tableData.recordsTotal = res.totalCount;
                    tableData.recordsFiltered = res.totalCount;

                    $.each(res.data, function (index, dataHis) {
                        if (dataHis.hasOwnProperty("nodeData")) {
                            var lineData = $.parseJSON(dataHis.nodeData);
                            var nodeItem = pagePars.selectNode.nodeItem;

                            for (var item in nodeItem) {
                                if (nodeItem[item].itemLog == 1 && nodeItem[item].itemSelect == 1) {
                                    if (lineData.hasOwnProperty(item) && lineData[item] != "") {
                                        var showValue = "";
                                        var showTitle = "";

                                        if (nodeItem[item].itemVmin != "" && parseFloat(nodeItem[item].itemVmin) > parseFloat(lineData[item])) {
                                            showValue = "<span class='badge' title='参数下限: " + nodeItem[item].itemVmin + "'><small>下</small></span>";
                                            showTitle += '参数下限: ' + nodeItem[item].itemVmin;
                                        } else if (nodeItem[item].itemVmax != "" && parseFloat(nodeItem[item].itemVmax) < parseFloat(lineData[item])) {
                                            showValue = "<span class='badge' title='参数上限: " + nodeItem[item].itemVmax + "'><small>上</small></span>";
                                            showTitle += ' 参数上限: ' + nodeItem[item].itemVmax;
                                        }
                                        if (nodeItem[item].itemVala3 != "" && parseFloat(lineData[item]) > parseFloat(nodeItem[item].itemVala3)) {
                                            showValue += "<span class='badge' title='三级阀值: " + nodeItem[item].itemVala3 + "'><small>三</small></span>";
                                            showTitle += ' 三级阀值: ' + nodeItem[item].itemVala3;
                                        } else if (nodeItem[item].itemVala2 != "" && parseFloat(lineData[item]) > parseFloat(nodeItem[item].itemVala2)) {
                                            showValue += "<span class='badge' title='二级阀值: " + nodeItem[item].itemVala2 + "'><small>二</small></span>";
                                            showTitle += ' 二级阀值: ' + nodeItem[item].itemVala2;
                                        } else if (nodeItem[item].itemVala1 != "" && parseFloat(lineData[item]) > parseFloat(nodeItem[item].itemVala1)) {
                                            showValue += "<span class='badge' title='一级阀值: " + nodeItem[item].itemVala1 + "'><small>一</small></span>";
                                            showTitle += ' 一级阀值: ' + nodeItem[item].itemVala1;
                                        }

                                        if (showValue != "") {
                                            if (nodeItem[item].itemAlarm == 1) {
                                                lineData["_" + item] = showValue + '<kbd style="background:red">' + lineData[item] + '</kbd>';
                                            } else {
                                                lineData["_" + item] = '<kbd style="background:green" title="' + showTitle + '">' + lineData[item] + '</kbd>';
                                            }
                                        } else {
                                            lineData["_" + item] = lineData[item];
                                        }
                                    }
                                }
                            }

                            lineData.DT_RowId = "_" + index;
                            lineData.nodeName = pagePars.selectNode.nodeName;
                            lineData.dataTime = dataHis.dataTime;

                            tableData.data.push(lineData);
                        }
                    });
                }
                callback(tableData);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
                callback(tableData);
            }

        });

    }

    /**
     *
     */
    function refData() {
        if (pagePars.selectNode == undefined) {
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
        document.title = pagePars.pageTitle + " - " + pagePars.selectNode.nodeName;
        pagePars.tableDataCur.table.ajax.reload(null, false);
    }

    /**
     *
     */
    function openNodeWindow() {
        __showNodePersonWindow(callBackNodeSelect);
    }

    /**
     *
     * @param selectItems
     * @param currentTreeData
     */
    function callBackNodeSelect(selectItems, currentTreeData) {
        var selectItem = selectItems[0];
        var nodes = $.extend(true, [], currentTreeData);

        if (pagePars.selectNode == undefined || pagePars.selectNode.nodeId != selectItem.id) {
            $("#showNodeName").val(selectItem.name);
            $.each(nodes, function (index, node) {
                if (node.nodeId == selectItem.id) {
                    pagePars.selectNode = node;
                }
            });
            document.title = "日志信息 - " + pagePars.selectNode.nodeName;
            createtableDivHis();
        }

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
