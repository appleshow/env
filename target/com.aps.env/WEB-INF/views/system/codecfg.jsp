<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/10
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>公共代码管理</title>
    <meta name="keywords"
          content="keyword1,keyword2,keyword3">
    <meta name="description"
          content="公共代码管理">
    <meta name="content-type"
          content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="${ctx}/assets-view/jquery/css/icon.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/jquery/css/easyui.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/jquery/css/color.css">
    <script type="text/javascript"
            src="${ctx}/assets-view/jquery/jquery.min.js"></script>
    <script type="text/javascript"
            src="${ctx}/assets-view/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${ctx}/assets-view/comm/comm.js"></script>
    <script type="text/javascript"
            src="${ctx}/assets-view/comm/datagrid.js"></script>
    <script type="text/javascript"
            src="${ctx}/assets-view/system/codecfg.js"></script>
</head>
<body onLoad="pageLoad()">
<div class="easyui-layout"
     data-options="fit:true">
    <div data-options="region:'north',split:false"
         style="height: 40px; background: #B3DFDA; padding: 0px; overflow: hidden">
        <table style="padding: 3px; width: 100%; height: 100%,; border: 0">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><a href="javascript:selectCodeType()"
                       class="easyui-linkbutton c6"
                       style="width: 70px">代码标识:</a><input
                        id="code_type"
                        class="easyui-textbox"
                        style="width: 80px; height: 28px"> <a
                        href="javascript:selectCodeName()"
                        class="easyui-linkbutton c6"
                        style="width: 70px">代码名称:</a><input id="code_name"
                                                            class="easyui-textbox"
                                                            style="width: 100px; height: 28px"></td>
            </tr>
        </table>
    </div>
    <div data-options="region:'center'"
         style="padding: 0px; background: #eee;">
        <table id="dgCode">
        </table>
    </div>
</div>
<script>
    /**
     * Grid控件
     */
    var dgCode = null;

    /**
     * 窗体 启动 事件
     */
    function pageLoad() {
        pageIni();
    }

    // 初始化 Grid
    function pageIni() {
        var pg = null;

        /***************************************************************************************************************************************************************************************************
         * 初始化Grid 代码
         **************************************************************************************************************************************************************************************************/
        dgCode = new comDataGrid("dgCode", 1, false, true);

        // 初始化Grid列
        // grid.setHeadCol(rowindex,colid, colname, colwidth, valign,irowspan,icolspan, bsort, bfrozen, bresizable, osorter, ostyler, oedit,oformat,bprimery, bnecessary,binput, bhidden)

        dgCode.setHeadCol(1, "codeType", "代码标识", 80, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, true, true, true, false);
        dgCode.setHeadCol(1, "codeValue", "代码值", 80, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, true, true, true, false);
        dgCode.setHeadCol(1, "codeName", "代码名称", 160, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, false, true, false);
        dgCode.setHeadCol(1, "codeDesc", "代码描述", 160, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);
        dgCode.setHeadCol(1, "codeIndex", "代码索引", 60, "right", 0, 0, false, false, true, null, null, {
            type: 'numberbox'
        }, null, false, false, true, false);
        dgCode.setHeadCol(1, "codeSeq", "代码排序", 60, "right", 0, 0, false, false, true, null, null, {
            type: 'numberbox'
        }, null, false, false, true, false);
        dgCode.setHeadCol(1, "prflag", "标志", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, true, false, false, true);
        dgCode.setHeadCol(1, "prgroup", "分组", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);
        dgCode.setHeadCol(1, "prtype", "分类", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);

        dgCode.dbinf.query = {
            url: "${ctx}/viewCodeConfig/referCode",
            inpar: [{
                type: "jtext",
                name: "codeType",
                crtl: $('#code_type')
            }, {
                type: "jtext",
                name: "codeName",
                crtl: $('#code_name')
            },]
        };

        dgCode.dbinf.modify = {
            url: "${ctx}/viewCodeConfig/modifyCode",
        };

        // 初始化Grid属性
        dgCode.Grid.datagrid({
            nowrap: true,
            rownumbers: true,
            fit: true,
            fitColumns: false,
            singleSelect: true,
            autoSizeColumn: true,
            autoRowHeight: false,
            checkOnSelect: false,
            selectOnCheck: false,
            remoteSort: false,
            // idField : 'ROWINDEX',
            pagination: true,
            pageList: [50, 100, 500],
            pageSize: 100,
            loadMsg: "信息处理中，请等待 ...",

            frozenColumns: dgCode.aryheadcols.bfrozen,
            columns: dgCode.aryheadcols.ufrozen,

            loadFilter: function (res) {
                var data = {
                    total: 0,
                    rows: []
                };

                if (res == null) {
                } else {
                    // 查询成功
                    if (res.code != 0) {
                        $smsg(res.message, "E", res.code);
                    } else {
                        data.total = res.rowcount;
                        data.rows = res.data;
                    }
                }

                return data;
            },

            onBeforeLoad: function () {
                if (dgCode.canedit) {
                    if (dgCode.ineditrows != null || dgCode.updaterows != null || dgCode.insertrows != null || dgCode.deleterows != null) {
                        if ($cwmsg("数据未提交，忽略继续操作...??")) {
                            dgCode.ineditrows = null;
                            dgCode.insertrows = null;
                            dgCode.updaterows = null;
                            dgCode.deleterows = null;

                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            },

            onClickRow: function (rowIndex, rowData) {
                dgCode.crtrow = rowIndex;
            },

            onDblClickRow: function (rowIndex, rowData) {
                dgCode.crtrow = rowIndex;
                if (codeEERow(true)) {
                    dgCode.crteditrowdata = JSON.stringify(rowData);
                    dgCode.BEditRow();
                }
            },

            toolbar: [{
                text: '查询',
                disabled: false,
                iconCls: 'icon-reload',
                handler: function () {
                    dgCode.doRefer();
                }
            }, '-', {
                text: '保存',
                disabled: false,
                iconCls: 'icon-save',
                handler: function () {
                    if (codeEERow(true)) {
                        dgCode.doModify();
                    }
                }
            }, "-", {
                text: '新增',
                disabled: false,
                iconCls: 'icon-add',
                handler: function () {
                    if (codeEERow(true)) {
                        dgCode.doInsert(null, []);
                    }
                }
            }, '-', {
                text: '删除',
                disabled: false,
                iconCls: 'icon-remove',
                handler: function () {
                    if (codeEERow(true)) {
                        dgCode.doDelete(null);
                    }
                }
            }, '-', {
                text: '撤销',
                disabled: false,
                iconCls: 'icon-undo',
                handler: function () {
                    dgCode.doCancel(null);
                }
            }],
        });

        pg = dgCode.Grid.datagrid("getPager");
        if (pg) {
            $(pg).pagination({
                total: 0
            });
        }
    }

    /**
     * 结束行编辑
     */
    function codeEERow(showmsg) {
        if (dgCode.crteditrow != null) {
            if (dgCode.Grid.datagrid("validateRow", dgCode.crteditrow)) {
                if (instr(dgCode.ineditrows, fmtindex(dgCode.crteditrow)) >= 0) {
                    dgCode.Grid.datagrid("endEdit", dgCode.crteditrow);
                    // 判断数据是否更新
                    var crtdata = dgCode.Grid.datagrid("getRows");

                    if (instr(dgCode.insertrows, fmtindex(dgCode.crteditrow)) >= 0 || instr(dgCode.updaterows, fmtindex(dgCode.crteditrow)) >= 0
                        || JSON.stringify(crtdata[dgCode.crteditrow]) != dgCode.crteditrowdata) {
                        dgCode.EEditRow();
                    } else {
                        dgCode.delModifyRow("E");
                    }
                }
                return true;
            } else {
                if (showmsg)
                    $smsg("请先完成上次操作...!!", "I");
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * 查询条件 代码标识
     */
    function selectCodeType() {
        $("#code_type").textbox("textbox").focus();
        $("#code_type").textbox("textbox").select();
    }

    /**
     * 查询条件 代码名称
     */
    function selectCodeName() {
        $("#code_name").textbox("textbox").focus();
        $("#code_name").textbox("textbox").select();
    }

</script>
</body>
</html>