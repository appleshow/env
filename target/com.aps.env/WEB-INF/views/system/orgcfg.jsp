<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/10
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
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
</head>
<body onLoad="pageLoad()">
<div class="easyui-layout"
     data-options="fit:true">
    <div data-options="region:'north',split:false"
         style="height: 35px; background: #B3DFDA; padding: 0px; overflow: hidden">
        <div class="easyui-panel"
             style="width: 100%; height: 36px; padding: 0px; background-color: #F4F4F4"
             data-options="border:true">
            <div id="toolbar">
                <table>
                    <tr>
                        <td><a href="javascript:orgRef()"
                               class="easyui-linkbutton"
                               data-options="iconCls:'icon-reload',plain:true">查询</a></td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td><a href="javascript:orgEdit()"
                               class="easyui-linkbutton"
                               data-options="iconCls:'icon-edit',plain:true">编辑</a></td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td><a href="javascript:orgAdd()"
                               class="easyui-linkbutton"
                               data-options="iconCls:'icon-add',plain:true">新增</a></td>
                        <td>
                            <div class="datagrid-btn-separator"></div>
                        </td>
                        <td><a href="javascript:orgDel()"
                               class="easyui-linkbutton"
                               data-options="iconCls:'icon-remove',plain:true">删除</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div data-options="region:'center'"
         style="padding: 0px; background: #eee;">
        <ul id="treeOrg"
            class="easyui-tree"
            data-options="animate:true,lines:true"></ul>
    </div>
</div>
<div id="orgModiy"
     class="easyui-window"
     title="组织架构管理"
     data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,iconCls:'icon-edit'"
     style="width: 360px; height: 186px; padding: 0px;">
    <div class="easyui-panel"
         style="width: 100%; height: 30px; padding: 5px; background-color: #E0ECFF"
         data-options="border:true">
        <span id="modifyTitle"
              style="color: blue; font-size: 12pt"></span>
        <input id="far_org_id"
               type="text"
               style="width: 20px; visibility: hidden">
    </div>
    <div class="easyui-panel"
         style="width: 100%; height: 40px; padding: 5px;"
         data-options="border:true">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:selectOrgName()"
                                                            class="easyui-linkbutton c6"
                                                            style="width: 90px">组织架构名称:</a>
        <input id="org_name"
               class="easyui-textbox"
               style="width: 140px; height: 28px">
    </div>
    <div class="easyui-panel"
         style="width: 100%; height: 40px; padding: 5px;"
         data-options="border:true">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:selectOrgSeq()"
                                                            class="easyui-linkbutton c6"
                                                            style="width: 90px">组织架构排序:</a>
        <input id="org_seq"
               class="easyui-textbox"
               style="width: 140px; height: 28px">
    </div>
    <div class="easyui-panel"
         style="width: 100%; height: 40px; padding: 5px;"
         data-options="border:true">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="javascript:modifyOK()"
           class="easyui-linkbutton c6"
           style="width: 60px">确定</a> <a href="javascript:modifyCancel()"
                                         class="easyui-linkbutton c6"
                                         style="width: 60px">取消</a>
    </div>
</div>
<script>
    // ************************
    // 窗体 全局变量定义
    // ************************
    var modifytype = null;

    /**
     * 窗体 启动 事件
     */
    function pageLoad() {
        pageIni();
    }

    // 初始化 Grid
    function pageIni() {

        // 初始化treeOrg
        $("#treeOrg").tree({
            animate: true,
            checkbox: false,
            cascadeCheck: false,
            lines: true,
            dnd: false
        });

    }

    /**
     * 查询组织架构
     */
    function orgRef() {

        var url = "${ctx}/viewOrgConfig/referOrg";
        var inf = {};

        $('#treeOrg').tree('loadData', []);

        // 加载ORG
        $.ajax({
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
                    for (var icnt = 0; icnt < res.data.length; icnt++) {
                        if (res.data[icnt].farOrgId == 0) {
                            $('#treeOrg').tree('append', {
                                parent: null,
                                data: [
                                    {
                                        id: 'node' + res.data[icnt].orgId,
                                        text: res.data[icnt].orgName,
                                        attributes: res.data[icnt].prflag,
                                    }
                                ]
                            });
                        } else {
                            $('#treeOrg').tree('append', {
                                parent: $('#treeOrg').tree("find", "node" + res.data[icnt].farOrgId).target,
                                data: [
                                    {
                                        id: 'node' + res.data[icnt].orgId,
                                        text: res.data[icnt].orgName,
                                        attributes: res.data[icnt].prflag
                                    }
                                ]
                            });
                        }
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $smsg(textStatus != null ? textStatus : errorThrown, "E", XMLHttpRequest.status);
            }
        });
    }

    /**
     * 编辑组织架构
     */
    function orgEdit() {
        var selectnode = $('#treeOrg').tree('getSelected');

        if (selectnode == null) {
            $smsg("请选择一个组织架构结点...!!", "E", -100);
        } else {
            modifytype = "U";
            $obj("far_org_id").value = replace(selectnode.id, "node", "");
            $('#org_name').textbox('setValue', selectnode.text);
            $('#org_seq').textbox('setValue', selectnode.attributes);
            $("#modifyTitle").html("&nbsp;&nbsp;&nbsp;编辑组织架构：<" + selectnode.text + ">");
            $('#orgModiy').window('open');
            $("#org_name").textbox("textbox").focus();
            $("#org_name").textbox("textbox").select();
        }
    }

    /**
     * 新增组织架构
     */
    function orgAdd() {
        var selectnode = $('#treeOrg').tree('getSelected');

        if (selectnode == null) {
            $smsg("请选择一个组织架构结点...!!", "E", -100);
        } else {
            modifytype = "I";
            $obj("far_org_id").value = replace(selectnode.id, "node", "");
            $('#org_name').textbox('setValue', "");
            $('#org_seq').textbox('setValue', "");
            $("#modifyTitle").html("&nbsp;&nbsp;&nbsp;新增组织架构到：<" + selectnode.text + ">");
            $('#orgModiy').window('open');
            $("#org_name").textbox("textbox").focus();
        }
    }

    /**
     * 删除组织架构
     */
    function orgDel() {
        var selectnode = $('#treeOrg').tree('getSelected');

        if (selectnode == null) {
            $smsg("请选择一个组织架构结点...!!", "E", -100);
        } else {
            var orgid = replace(selectnode.id, "node", "");
            modifytype = "D";
            $cmsg("确定删除组织架构：" + selectnode.text + " ..??", function (bok) {
                if (bok) {
                    var url = "${ctx}/viewOrgConfig/modifyOrg";
                    var inf = {
                        parCount: 1,
                        inPar: [
                            {
                                _type: modifytype,
                                orgId: orgid
                            }
                        ]
                    };
                    $.ajax({
                        type: "POST",
                        url: url,
                        cache: false,
                        data: JSON.stringify(inf),
                        dataType: "json",
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8'
                        },
                        success: function (res) {
                            if (res.code != 0) {
                                $smsg(res.message, "E", res.code);
                            } else {
                                orgRef();
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $smsg(textStatus != null ? textStatus : errorThrown, "E", XMLHttpRequest.status);
                        }
                    });
                }
            });
        }
    }

    /**
     *
     */
    function selectOrgName() {
        $("#org_name").textbox("textbox").focus();
        $("#org_name").textbox("textbox").select();
    }

    /**
     *
     */
    function selectOrgSeq() {
        $("#org_seq").textbox("textbox").focus();
        $("#org_seq").textbox("textbox").select();
    }

    /**
     *
     */
    function modifyOK() {
        var selectnode = $('#treeOrg').tree('getSelected');
        var orgnameo = selectnode.text, orgseqo = selectnode.attributes;
        var orgnamen = $("#org_name").textbox("getValue"), orgseqn = $("#org_seq").textbox("getValue");
        var orgid = $obj("far_org_id").value;

        if (orgnameo != null || orgnameo != orgnamen || orgseqo != orgseqn) {
            var url = "${ctx}/viewOrgConfig/modifyOrg";
            var inf = {};

            if (modifytype == "U" || modifytype == "D") {
                inf = {
                    parCount: 1,
                    inPar: [
                        {
                            _type: modifytype,
                            orgId: orgid,
                            orgName: orgnamen,
                            prflag: orgseqn
                        }
                    ]
                };
            } else {
                inf = {
                    parCount: 1,
                    inPar: [
                        {
                            _type: modifytype,
                            farOrgId: orgid,
                            orgName: orgnamen,
                            prflag: orgseqn
                        }
                    ]
                };
            }

            $.ajax({
                type: "POST",
                url: url,
                cache: false,
                data: JSON.stringify(inf),
                dataType: "json",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                success: function (res) {
                    if (res.code != 0) {
                        $smsg(res.message, "E", res.code);
                    } else {
                        $('#orgModiy').window('close');
                        orgRef();
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $smsg(textStatus != null ? textStatus : errorThrown, "E", XMLHttpRequest.status);
                }
            });
        }
    }

    /**
     *
     */
    function modifyCancel() {
        $('#orgModiy').window('close');
    }
</script>
</body>
</html>