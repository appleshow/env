<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/10
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <title>界面管理</title>
    <meta name="keywords"
          content="keyword1,keyword2,keyword3">
    <meta name="description"
          content="界面管理">
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
                <td><a href="javascript:selectPrgroup()"
                       class="easyui-linkbutton c6"
                       style="width: 70px">界面组别:</a>
                    <input id="prgroup"
                           class="easyui-textbox"
                           style="width: 80px; height: 28px">
                    <a href="javascript:selectFormName()"
                       class="easyui-linkbutton c6"
                       style="width: 70px">界面名称:</a>
                    <input id="form_name"
                           class="easyui-textbox"
                           style="width: 100px; height: 28px"></td>
            </tr>
        </table>
        <div style="display: none">
            <input id="form_id"
                   type="text"
                   style="width: 20px; visibility: hidden"
                   value=''>
        </div>
    </div>
    <div data-options="region:'center'"
         style="padding: 0px; background: #eee;">
        <div class="easyui-layout"
             data-options="fit:true">
            <div data-options="region:'north',split:true"
                 style="height: 400px; padding: 1px; overflow: hidden">
                <table id="dgPage">
                </table>
            </div>
            <div data-options="region:'center'"
                 style="padding: 0px; background: #eee;">
                <table id="dgPageCTL">
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    // ************************
    // 窗体 全局变量定义
    // ************************
    var formctldata = [];

    /**
     * Grid控件
     */
    var dgPage = null;
    var dgPageCTL = null;

    /**
     * 窗体 启动 事件
     */
    function pageLoad() {
        pageIni();
    }

    // 初始化 Grid
    function pageIni() {

        // 取得FORM_CTL数据
        var url = "${ctx}/viewFormConfig/referFormCtlType";
        var inf = {codeType: '1', pageNumber: 1, pageSize: 2000,};
        $.ajax({
            async: false,
            type: "POST",
            url: url,
            cache: false,
            data: ServerRequestPar(1, inf),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    $smsg(res.message, "E", res.code);
                } else {
                    formctldata = res.data;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $smsg(textStatus != null ? textStatus : errorThrown, "E", XMLHttpRequest.status);
            }
        });

        var pg = null;

        /***************************************************************************************************************************************************************************************************
         * 初始化Grid 界面
         **************************************************************************************************************************************************************************************************/
        dgPage = new comDataGrid("dgPage", 1, true, true);
        // 初始化Grid列
        // grid.setHeadCol(rowindex,colid, colname, colwidth, valign,irowspan,icolspan, bsort, bfrozen, bresizable, osorter, ostyler, oedit,oformat,bprimery, bnecessary,binput, bhidden)

        dgPage.setHeadCol(1, "formId", "编码", 40, "left", 0, 0, false, false, true, null, null, null, null, false, false, true, false);
        dgPage.setHeadCol(1, "formName", "界面名称", 180, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, false, true, false);
        dgPage.setHeadCol(1, "prgroup", "界面组别", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox'
        }, null, false, false, true, false);
        dgPage.setHeadCol(1, "property0", "界面路径", 450, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, false, true, false);
        dgPage.setHeadCol(1, "formProc", "后台过程", 200, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox'
        }, null, false, false, true, false);
        dgPage.setHeadCol(1, "formFdsg", "前台设计人", 80, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox'
        }, null, false, false, true, false);
        dgPage.setHeadCol(1, "formBdsg", "后台设计人", 80, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox'
        }, null, false, false, true, false);

        dgPage.dbinf.query = {
            url: "${ctx}/viewFormConfig/referForm",
            inpar: [
                {
                    type: "jtext",
                    name: "prgroup",
                    crtl: $('#prgroup')
                }, {
                    type: "jtext",
                    name: "formName",
                    crtl: $('#form_name')
                },
            ]
        };

        dgPage.dbinf.modify = {
            url: "${ctx}/viewFormConfig/modifyForm",
        };

        // 初始化Grid属性
        dgPage.Grid.datagrid({
            nowrap: true,
            rownumbers: true,
            fit: true,
            fitColumns: false,
            singleSelect: true,
            autoSizeColumn: true,
            autoRowHeight: false,
            checkOnSelect: true,
            selectOnCheck: true,
            remoteSort: false,
            singleSelect: true,
            // idField : 'ROWINDEX',
            pagination: true,
            pageList: [
                50, 100, 500
            ],
            pageSize: 100,
            loadMsg: "信息处理中，请等待 ...",

            frozenColumns: dgPage.aryheadcols.bfrozen,
            columns: dgPage.aryheadcols.ufrozen,

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
                if (dgPage.canedit) {
                    if (dgPage.ineditrows != null || dgPage.updaterows != null || dgPage.insertrows != null || dgPage.deleterows != null) {
                        if ($cwmsg("数据未提交，忽略继续操作...??")) {
                            dgPage.ineditrows = null;
                            dgPage.insertrows = null;
                            dgPage.updaterows = null;
                            dgPage.deleterows = null;

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

            onCheck: function (rowIndex, rowData) {
                dgPage.crtrow = rowIndex;
            },

            onClickRow: function (rowIndex, rowData) {
                dgPage.crtrow = rowIndex;
            },

            onDblClickRow: function (rowIndex, rowData) {
                dgPage.crtrow = rowIndex;
                if (pageEERow(true)) {
                    dgPage.crteditrowdata = JSON.stringify(rowData);
                    dgPage.BEditRow();
                }
            },

            toolbar: [
                {
                    text: '查询',
                    disabled: false,
                    iconCls: 'icon-reload',
                    handler: function () {
                        dgPage.doRefer();
                    }
                }, '-', {
                    text: '保存',
                    disabled: false,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (pageEERow(true)) {
                            dgPage.doModify();
                        }
                    }
                }, "-", {
                    text: '新增',
                    disabled: false,
                    iconCls: 'icon-add',
                    handler: function () {
                        if (pageEERow(true)) {
                            dgPage.doInsert(null, []);
                        }
                    }
                }, '-', {
                    text: '删除',
                    disabled: false,
                    iconCls: 'icon-remove',
                    handler: function () {
                        if (pageEERow(true)) {
                            dgPage.doDelete(null);
                        }
                    }
                }, '-', {
                    text: '撤销',
                    disabled: false,
                    iconCls: 'icon-undo',
                    handler: function () {
                        dgPage.doCancel(null);
                    }
                }
            ],
        });

        pg = dgPage.Grid.datagrid("getPager");
        if (pg) {
            $(pg).pagination({
                total: 0
            });
        }

        /***************************************************************************************************************************************************************************************************
         * 初始化Grid 界面控件
         **************************************************************************************************************************************************************************************************/
        dgPageCTL = new comDataGrid("dgPageCTL", 1, false, true);

        // 初始化Grid列
        // grid.setHeadCol(rowindex,colid, colname, colwidth, valign,irowspan,icolspan, bsort, bfrozen, bresizable, osorter, ostyler, oedit,oformat,bprimery, bnecessary,binput, bhidden)

        dgPageCTL.setHeadCol(1, "formId", "ID", 80, "left", 0, 0, false, false, true, null, null, null, null, false, false, true, true);
        dgPageCTL.setHeadCol(1, "formName", "界面名称", 160, "left", 0, 0, false, false, true, null, null, null, null, false, true, false, false);
        dgPageCTL.setHeadCol(1, "rightId", "功能标识", 120, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, true, false, true, false);
        dgPageCTL.setHeadCol(1, "rightInf", "功能描述", 200, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, false, true, false);
        dgPageCTL.setHeadCol(1, "prtype", "功能类型", 220, "left", 0, 0, false, false, true, null, null, {
            type: 'combobox',
            options: {
                required: true,
                editable: false,
                panelHeight: 'auto',
                valueField: 'codeId',
                textField: 'codeName',
                data: formctldata
            }
        }, fmtFormCtl, false, false, true, false);
        dgPageCTL.setHeadCol(1, "rea", "锁定", 40, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgPageCTL.setHeadCol(1, "r1", "备用1", 40, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgPageCTL.setHeadCol(1, "r2", "备用2", 40, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgPageCTL.setHeadCol(1, "r3", "备用3", 40, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);

        dgPageCTL.dbinf.query = {
            url: "${ctx}/viewFormConfig/referFormRight",
            inpar: [
                {
                    type: "text",
                    name: "formId",
                    crtl: $obj("form_id")
                }
            ]
        };

        dgPageCTL.dbinf.modify = {
            url: "${ctx}/viewFormConfig/modifyFormRight",
        };

        // 初始化Grid属性
        dgPageCTL.Grid.datagrid({
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
            pageList: [
                50, 100, 500
            ],
            pageSize: 100,
            loadMsg: "信息处理中，请等待 ...",

            frozenColumns: dgPageCTL.aryheadcols.bfrozen,
            columns: dgPageCTL.aryheadcols.ufrozen,

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
                        var formName = $obj("form_name").value;

                        data.total = res.rowcount;
                        for (var index = 0; index < res.data.length; index++) {
                            res.data[index]["formName"] = formName;
                        }
                        data.rows = res.data;
                    }
                }

                return data;
            },

            onBeforeLoad: function () {
                if (dgPageCTL.canedit) {
                    if (dgPageCTL.ineditrows != null || dgPageCTL.updaterows != null || dgPageCTL.insertrows != null || dgPageCTL.deleterows != null) {
                        if ($cwmsg("数据未提交，忽略继续操作...??")) {
                            dgPageCTL.ineditrows = null;
                            dgPageCTL.insertrows = null;
                            dgPageCTL.updaterows = null;
                            dgPageCTL.deleterows = null;

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
                dgPageCTL.crtrow = rowIndex;
            },

            onDblClickRow: function (rowIndex, rowData) {
                dgPageCTL.crtrow = rowIndex;
                if (pageCTLEERow(true)) {
                    dgPageCTL.crteditrowdata = JSON.stringify(rowData);
                    dgPageCTL.BEditRow();
                }
            },

            toolbar: [
                {
                    text: '查询',
                    disabled: false,
                    iconCls: 'icon-reload',
                    handler: function () {
                        var selectrows = dgPage.Grid.datagrid("getChecked");

                        if (selectrows.length == 0) {
                            $smsg("请先选择一个界面...!!", "I");
                        } else {
                            $obj("form_id").value = selectrows[0].formId;
                            $obj("form_name").value = selectrows[0].formName;
                            dgPageCTL.doRefer();
                        }
                    }
                }, '-', {
                    text: '保存',
                    disabled: false,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (pageCTLEERow(true)) {
                            dgPageCTL.doModify();
                        }
                    }
                }, "-", {
                    text: '新增',
                    disabled: false,
                    iconCls: 'icon-add',
                    handler: function () {
                        if (pageCTLEERow(true)) {
                            var selectrows = dgPage.Grid.datagrid("getChecked");

                            if (selectrows.length == 0) {
                                $smsg("请先选择一个界面...!!", "I");
                            } else {
                                $obj("form_id").value = selectrows[0].formId;
                                $obj("form_name").value = selectrows[0].formName;
                                dgPageCTL.doInsert(null, {
                                    formId: $obj("form_id").value,
                                    formName: $obj("form_name").value
                                });

                                // SetCellValue(dgPageCTL, dgPageCTL.crteditrow, "form_id", $obj("form_id").value);
                                // SetCellValue(dgPageCTL, dgPageCTL.crteditrow, "form_name", $obj("form_name").value);
                            }
                        }
                    }
                }, '-', {
                    text: '删除',
                    disabled: false,
                    iconCls: 'icon-remove',
                    handler: function () {
                        if (pageCTLEERow(true)) {
                            dgPageCTL.doDelete(null);
                        }
                    }
                }, '-', {
                    text: '撤销',
                    disabled: false,
                    iconCls: 'icon-undo',
                    handler: function () {
                        dgPageCTL.doCancel(null);
                    }
                }
            ],
        });

        pg = dgPageCTL.Grid.datagrid("getPager");
        if (pg) {
            $(pg).pagination({
                total: 0
            });
        }
    }

    /**
     * 结束行编辑
     */
    function pageEERow(showmsg) {
        if (dgPage.crteditrow != null) {
            if (dgPage.Grid.datagrid("validateRow", dgPage.crteditrow)) {
                if (instr(dgPage.ineditrows, fmtindex(dgPage.crteditrow)) >= 0) {
                    dgPage.Grid.datagrid("endEdit", dgPage.crteditrow);
                    // 判断数据是否更新
                    var crtdata = dgPage.Grid.datagrid("getRows");

                    if (instr(dgPage.insertrows, fmtindex(dgPage.crteditrow)) >= 0 || instr(dgPage.updaterows, fmtindex(dgPage.crteditrow)) >= 0
                        || JSON.stringify(crtdata[dgPage.crteditrow]) != dgPage.crteditrowdata) {
                        dgPage.EEditRow();
                    } else {
                        dgPage.delModifyRow("E");
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
     * 结束行编辑
     */
    function pageCTLEERow(showmsg) {
        if (dgPageCTL.crteditrow != null) {
            if (dgPageCTL.Grid.datagrid("validateRow", dgPageCTL.crteditrow)) {
                if (instr(dgPageCTL.ineditrows, fmtindex(dgPageCTL.crteditrow)) >= 0) {
                    dgPageCTL.Grid.datagrid("endEdit", dgPageCTL.crteditrow);
                    // 判断数据是否更新
                    var crtdata = dgPageCTL.Grid.datagrid("getRows");

                    if (instr(dgPageCTL.insertrows, fmtindex(dgPageCTL.crteditrow)) >= 0 || instr(dgPageCTL.updaterows, fmtindex(dgPageCTL.crteditrow)) >= 0
                        || JSON.stringify(crtdata[dgPageCTL.crteditrow]) != dgPageCTL.crteditrowdata) {
                        dgPageCTL.EEditRow();
                    } else {
                        dgPageCTL.delModifyRow("E");
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
    function selectPrgroup() {
        $("#prgroup").textbox("textbox").focus();
        $("#prgroup").textbox("textbox").select();
    }

    /**
     * 查询条件 代码名称
     */
    function selectFormName() {
        $("#form_name").textbox("textbox").focus();
        $("#form_name").textbox("textbox").select();
    }

    /**
     * 格式化窗体控件
     *
     * @param value
     */
    function fmtFormCtl(value) {
        for (var icnt = 0; icnt < formctldata.length; icnt++) {
            if (formctldata[icnt].codeId == value)
                return formctldata[icnt].codeName;
        }
        return value;
    }
</script>
</body>
</html>