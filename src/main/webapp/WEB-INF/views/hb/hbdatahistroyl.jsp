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
<title>历史曲线</title>
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
      href="${ctx}/datetimePicker/css/bootstrap-datetimepicker.min.css"/>
<!--  -->
<!--  -->
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/color.css"/>
<link rel="stylesheet"
      href="${ctx}/assets/css/font-awesome.min.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/tree/css/tree.css"/>
<style type="text/css">
    .box {
        overflow: auto;
        width: 100%;
        height: 85%;
        background: #fafafa;
        border: 0px solid #ccc;
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
        <div class="box"
             id="lineCurBox">
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

<script src="${ctx}/datetimePicker/js/moment.min.js"></script>
<script src="${ctx}/datetimePicker/js/bootstrap-datetimepicker.min.js"></script>
<!--  -->
<script src="${ctx}/assets-view/comm/highcharts/js/highcharts.js"></script>
<script src="${ctx}/assets-view/comm/highcharts/js/exporting.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>
<%@include file="../aplugin/nodepersonwindow.jsp" %>

<script type="application/javascript">
    var pagePars = {
        colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#514F78", "#42A07B", "#9B5E4A", "#72727F", "#1F949A", "#82914E", "#86777F", "#42A07B", "#DDDF0D", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
        selectNode: undefined,
        selectNodeChanged: true,
        nodeLine: undefined,
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

    })

    /**
     *
     */
    function refData() {
        if (pagePars.selectNode == undefined) {
            callError(100, "请先选择一个站点...!!");
            return;
        }
        if (pagePars.selectNodeChanged) {
            initChar();
            pagePars.selectNodeChanged = false;
        }
        refCharData();
    }

    /**
     *
     * @returns
     */
    function initChar() {
        var node = pagePars.selectNode;
        var nodeItems = node.nodeItem;
        var yAxis = [], series = [], pars = [], parNames = [], parUnits = [], parCount = 0;

        pagePars.nodeLine = {
            nodeId: node.nodeId,
            nodeName: node.nodeName,
            label: []
        };
        if (!( typeof ( nodeItems ) === "undefined" || nodeItems === null )) {
            nodeItems = $.parseJSON(nodeItems);
            parCount = -1;
            for (var item in nodeItems) {
                nodeItems[item] = $.parseJSON(nodeItems[item]);
                if (nodeItems[item].itemSelect == 1) {
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

    /**
     *
     * @returns
     */
    function refCharData() {
        var momentStr = moment($('#dateStr').val());
        var momentEnd = moment($('#dateEnd').val());
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
                dateStr: $('#dateStr').val(),
                dateEnd: $('#dateEnd').val()
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
                            text: pagePars.nodeLine.nodeName + ' - 历史曲线'
                        },
                        subtitle: {
                            text: "【" + $('#dateStr').val() + " ~ " + $('#dateEnd').val() + "】"
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
            pagePars.selectNodeChanged = true;
            $("#showNodeName").val(selectItem.name);
            $.each(nodes, function (index, node) {
                if (node.nodeId == selectItem.id) {
                    pagePars.selectNode = node;
                }
            });

            refData();
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
