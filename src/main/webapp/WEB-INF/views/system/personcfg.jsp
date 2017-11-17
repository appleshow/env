<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/10
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <title>用户管理</title>
    <meta name="keywords"
          content="keyword1,keyword2,keyword3">
    <meta name="description"
          content="用户管理">
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
                <td><a href="javascript:selectUserID()"
                       class="easyui-linkbutton c6"
                       style="width: 70px">用户工号:</a>
                    <input id="user_id"
                           class="easyui-textbox"
                           style="width: 80px; height: 28px">
                    <a href="javascript:selectUserName()"
                       class="easyui-linkbutton c6"
                       style="width: 70px">用户姓名:</a>
                    <input id="user_name"
                           class="easyui-textbox"
                           style="width: 100px; height: 28px">
                </td>
            </tr>
        </table>
    </div>
    <div data-options="region:'center'"
         style="padding: 0px; background: #eee;">
        <table id="dgUser">
        </table>
    </div>
</div>
<script>
    // ************************
    // 窗体 全局变量定义
    // ************************
    var orgcombdata = [];
    var orgtreedata = null;

    /**
     * Grid控件
     */
    var dgUser = null;

    /**
     * 窗体 启动 事件
     */
    function pageLoad() {
        pageIni();
    }

    // 初始化 Grid
    function pageIni() {

        // 取得COM_ORG数据
        var url = "${ctx}/viewPersonConfig/referOrg";
        var inf = {};

        $.ajax({
            async: false,
            type: "POST",
            url: url,
            cache: false,
            data: ServerRequestPar(0, inf),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    $smsg(res.message, "E", res.code);
                } else {
                    orgcombdata = res.data;
                    orgtreedata = Json2Tree(res.data, "orgId", "farOrgId", "orgName", 0, 0);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $smsg(textStatus != null ? textStatus : errorThrown, "E", XMLHttpRequest.status);
            }
        });

        var pg = null;

        /***************************************************************************************************************************************************************************************************
         * 初始化Grid 用戶
         **************************************************************************************************************************************************************************************************/
        dgUser = new comDataGrid("dgUser", 1, false, true);

        // 初始化Grid列
        // grid.setHeadCol(rowindex,colid, colname, colwidth, valign,irowspan,icolspan, bsort, bfrozen, bresizable, osorter, ostyler, oedit,oformat,bprimery, bnecessary,binput, bhidden)
        dgUser.setHeadCol(1, "personId", "ID", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox'
        }, null, false, false, true, true);
        dgUser.setHeadCol(1, "userId", "工号", 60, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, true, true, false);
        dgUser.setHeadCol(1, "userName", "姓名", 80, "left", 0, 0, false, false, true, null, null, {
            type: 'validatebox',
            options: {
                required: true
            }
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "userOrg", "所属组织", 160, "left", 0, 0, false, false, true, null, null, {
            type: 'combotree',
            options: {
                animate: false,
                checkbox: false,
                cascadeCheck: false,
                lines: true,
                dnd: false,
                required: true,
                data: orgtreedata
            }
        }, fmtUserOrg, false, false, true, false);
        dgUser.setHeadCol(1, "prflag", "是否有效", 60, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "prtype", "管理员", 60, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "resPsw", "重置密码", 60, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "userSex", "性别", 50, "center", 0, 0, false, false, true, null, null, {
            type: 'checkbox',
            options: {
                on: '1',
                off: '0'
            }
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "userTel", "电话", 100, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "userAddr", "地址", 140, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);
        dgUser.setHeadCol(1, "userEmail", "邮箱", 140, "left", 0, 0, false, false, true, null, null, {
            type: 'text'
        }, null, false, false, true, false);

        dgUser.dbinf.query = {
            url: "${ctx}/viewPersonConfig/referPerson",
            inpar: [
                {
                    type: "jtext",
                    name: "userId",
                    crtl: $('#user_id')
                }, {
                    type: "jtext",
                    name: "userName",
                    crtl: $('#user_name')
                },
            ]
        };

        dgUser.dbinf.modify = {
            url: "${ctx}/viewPersonConfig/modifyPerson",
        };

        // 初始化Grid属性
        dgUser.Grid.datagrid({
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

            frozenColumns: dgUser.aryheadcols.bfrozen,
            columns: dgUser.aryheadcols.ufrozen,

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
                if (dgUser.canedit) {
                    if (dgUser.ineditrows != null || dgUser.updaterows != null || dgUser.insertrows != null || dgUser.deleterows != null) {
                        if ($cwmsg("数据未提交，忽略继续操作...??")) {
                            dgUser.ineditrows = null;
                            dgUser.insertrows = null;
                            dgUser.updaterows = null;
                            dgUser.deleterows = null;

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
                dgUser.crtrow = rowIndex;
            },

            onDblClickRow: function (rowIndex, rowData) {
                dgUser.crtrow = rowIndex;
                if (personEERow(true)) {
                    dgUser.crteditrowdata = JSON.stringify(rowData);
                    dgUser.BEditRow();
                }
            },

            toolbar: [
                {
                    text: '查询',
                    disabled: false,
                    iconCls: 'icon-reload',
                    handler: function () {
                        dgUser.doRefer();
                    }
                }, '-', {
                    text: '保存',
                    disabled: false,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (personEERow(true)) {
                            dgUser.doModify();
                        }
                    }
                }, "-", {
                    text: '新增',
                    disabled: false,
                    iconCls: 'icon-add',
                    handler: function () {
                        if (personEERow(true)) {
                            dgUser.doInsert(null, []);
                        }
                    }
                }, '-', {
                    text: '删除',
                    disabled: false,
                    iconCls: 'icon-remove',
                    handler: function () {
                        if (personEERow(true)) {
                            dgUser.doDelete(null);
                        }
                    }
                }, '-', {
                    text: '撤销',
                    disabled: false,
                    iconCls: 'icon-undo',
                    handler: function () {
                        dgUser.doCancel(null);
                    }
                }
            ],
        });

        pg = dgUser.Grid.datagrid("getPager");
        if (pg) {
            $(pg).pagination({
                total: 0
            });
        }

    }

    /**
     * 结束行编辑
     */
    function personEERow(showmsg) {
        if (dgUser.crteditrow != null) {
            if (dgUser.Grid.datagrid("validateRow", dgUser.crteditrow)) {
                if (instr(dgUser.ineditrows, fmtindex(dgUser.crteditrow)) >= 0) {
                    dgUser.Grid.datagrid("endEdit", dgUser.crteditrow);
                    // 判断数据是否更新
                    var crtdata = dgUser.Grid.datagrid("getRows");

                    if (instr(dgUser.insertrows, fmtindex(dgUser.crteditrow)) >= 0 || instr(dgUser.updaterows, fmtindex(dgUser.crteditrow)) >= 0
                        || JSON.stringify(crtdata[dgUser.crteditrow]) != dgUser.crteditrowdata) {
                        dgUser.EEditRow();
                    } else {
                        dgUser.delModifyRow("E");
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
    function selectUserID() {
        $("#user_id").textbox("textbox").focus();
        $("#user_id").textbox("textbox").select();
    }

    /**
     * 查询条件 代码名称
     */
    function selectUserName() {
        $("#user_name").textbox("textbox").focus();
        $("#user_name").textbox("textbox").select();
    }

    /**
     * 格式化组织
     *
     * @param value
     */
    function fmtUserOrg(value) {
        for (var icnt = 0; icnt < orgcombdata.length; icnt++) {
            if (orgcombdata[icnt].orgId == value)
                return orgcombdata[icnt].orgName;
        }
        return value;
    }
</script>
</body>
</html>
