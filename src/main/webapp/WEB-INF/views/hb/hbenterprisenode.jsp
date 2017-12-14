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
<title>站点信息</title>
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
      href="${ctx}/assets-view/comm/select2-4.0.2/css/select2.min.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/tree/css/tree.css"/>
<link rel="stylesheet"
      href="${ctx}/assets-view/comm/bootstrapvalidator/css/bootstrapvalidator.min.css"/>
<style type="text/css">
    .select2-container .select2-selection--single {
        height: 34px !important;
        line-height: 34px;
    }

    .select2-container--default .select2-selection--single .select2-selection__rendered {
        line-height: 34px;
    }

    .select2-container--default .select2-selection--single .select2-selection__arrow {
        height: 34px;
    }
</style>
<body>
<div class="row"
     style="margin-right: 0px; margin-bottom: 0px;">
    <div class="col-lg-8 col-sm-8 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">站点列表</div>
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
    <div class="col-lg-4 col-sm-4 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">站点详情</div>
            <div class="panel-body"
                 style="height: 85%;overflow-y:scroll; ">
                <form id="enterpriseNodeForm"
                      method="post">
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;">站点编号
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       readonly
                                       id="nodeId"
                                       name="nodeId">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>站点MN
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="nodeMn"
                                       name="nodeMn">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>站点名称
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="property0"
                                       name="property0">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>站点类型
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="typeId"
                                    name="typeId">
                                <option></option>
                            </select>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>所属企业
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group">
                                <input class="form-control"
                                       style="width: 100%; display: none;"
                                       readonly
                                       id="enterpriseId"
                                       name="enterpriseId">
                                </input>
                                <input class="form-control"
                                       style="width: 100%;"
                                       readonly
                                       id="property1"
                                       name="property1">
                                </input>
                                <span class="input-group-btn">
                                <button class="btn btn-default"
                                        type="button"
                                        onclick="openEnterpriseWindow()">...</button>
                            </span>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>设备厂商
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="property8"
                                    name="property8">
                                <option></option>
                            </select>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>设备型号
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="property9"
                                    name="property9">
                                <option></option>
                            </select>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>坐标经度
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="nodeLongitude"
                                       name="nodeLongitude">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>坐标纬度
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="nodeLatitude"
                                       name="nodeLatitude">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>离线时长
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="nodeOfflineTarget"
                                       name="nodeOfflineTarget">
                                </input>
                            </div>
                        </div>
                    </div>
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;">站点备注
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="200"
                                       id="nodeDesc"
                                       name="nodeDesc">
                                </input>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-primary"
                        onclick="addEnterpriseNode()">
                    <span class="glyphicon glyphicon-plus"
                          aria-hidden="true"></span>&nbsp;新增
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="deleteEnterpriseNode()">
                    <span class="glyphicon glyphicon-remove"
                          aria-hidden="true"></span>&nbsp;删除
                </button>
                <button type="button"
                        class="btn btn-primary"
                        id="btnSaveEnterpriseNode"
                        onclick="saveEnterpriseNode()">
                    <span class="glyphicon glyphicon-ok"
                          aria-hidden="true"></span>&nbsp;保存
                </button>
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
<script src="${ctx}/assets-view/comm/select2-4.0.2/js/select2.full.min.js"></script>
<script src="${ctx}/assets-view/comm/bootstrapvalidator/js/bootstrapvalidator.min.js"></script>

<%@include file="../aplugin/treectrl.jsp" %>
<%@include file="../aplugin/enterprisewindow.jsp" %>

<script type="application/javascript">
    var pagePars = {
        modifyType: "I",
        enterpriseRegion: [],
        comCode: [],
    };

    var regionDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseNode';
    };


    regionDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
                            if (options.id == "所有") {
                                var treeData = [];

                                $.each(pagePars.enterpriseRegion, function (indexNode, node) {
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

                                    $.each(pagePars.enterpriseRegion, function (indexNode, node) {
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

                                    $.each(pagePars.enterpriseRegion, function (index, value) {
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

                                                        $.each(pagePars.enterpriseRegion, function (indexNode, node) {
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
                                data: ServerRequestPar(0, {}),
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
                                        var allCount = 0;

                                        pagePars.enterpriseRegion = res.data;
                                        $.each(pagePars.enterpriseRegion, function (index, value) {
                                            if (value.nodeId && value.nodeId != "") {
                                                allCount++;
                                            }
                                        });
                                        treeData.push({id: "所有", name: "所有 - [" + allCount + "]", type: "folder", isEnterprise: false,});

                                        $.each(pagePars.enterpriseRegion, function (index, value) {
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
                        )
                        ;
                    }
                },
                this._delay
            )
        }
    };

    jQuery(document).ready(function () {
        $("#typeId").select2({
            placeholder: "选择一个站点分类",
            allowClear: true,
            language: "zh-CN",
        });
        $("#property8").select2({
            placeholder: "选择一个设备厂商",
            allowClear: true,
            language: "zh-CN",
        });
        $("#property9").select2({
            placeholder: "选择一个设备型号",
            allowClear: true,
            language: "zh-CN",
        });

        $("#property8").on("change", function (e) {
            if ($("#property8").val() == "") {
                $("#property9").val(null).trigger("change");
            } else {
                var marking = "";

                $("#property9").html("");
                $.each(pagePars.comCode, function (index, value) {
                    if (value.codeType == "21" && value.property0 == $("#property8").val()) {
                        marking += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                    }
                });
                if (marking != "") {
                    $("#property9").append(marking);
                    $("#property9").val(null).trigger("change");
                }
            }
        });

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

        initComboData();
    });

    /**
     *
     */
    function initComboData() {
        $('#enterpriseNodeForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            submitHandler: function (validator, form, submitButton) {
                // Do nothing
            },
            fields: {
                nodeMn: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                    },
                },
                property0: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                    },
                },
                nodeLongitude: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                        regexp: {
                            regexp: /^([1-9][0-9]*)+(.[0-9]{1,10})?$/,
                            message: '此项只能录入数字...',
                        },
                    },
                },
                nodeLatitude: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                        regexp: {
                            regexp: /^([1-9][0-9]*)+(.[0-9]{1,10})?$/,
                            message: '此项只能录入数字...',
                        },
                    },
                },
                nodeOfflineTarget: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                        regexp: {
                            regexp: /^([1-9]{1,1})?$/,
                            message: '此项只能录入一位整数...',
                        },
                    },
                },
            },
        });

        $.ajax({
            type: "POST",
            url: "${ctx}/viewHbEnterpriseNodeCfg/refNodeType",
            cache: false,
            data: ServerRequestPar(0, {}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    var hbTypes = "";

                    $.each(res.data, function (index, value) {
                        hbTypes += "<option value='" + value.typeId + "'>" + value.typeName + "</option>";
                    });
                    if (hbTypes != "") {
                        $("#typeId").append(hbTypes);
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                callError(-900, "操作未完成，向服务器请求失败...");
            }
        });

        $.ajax({
            type: "POST",
            url: "${ctx}/viewComCodeConfig/refComCode",
            cache: false,
            data: ServerRequestPar(1, {codeType: "20,21", pageNumber: 1, pageSize: 2000,}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    var manufacturer = "";

                    pagePars.comCode = res.data;
                    $.each(pagePars.comCode, function (index, value) {
                        if (value.codeType == "20") {
                            manufacturer += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                        }
                    });
                    if (manufacturer != "") {
                        $("#property8").append(manufacturer);
                    }
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
    function openEnterpriseWindow() {
        __showEnerpriseWindow(callBackEnterpriseSelect);
    }

    /**
     *
     */
    function callBackEnterpriseSelect(selectItems, currentTreeData) {
        var selectItem = selectItems[0];

        $("#enterpriseId").val(selectItem.id);
        $("#property1").val(selectItem.name);
    }

    /**
     *
     *
     */
    function addEnterpriseNode() {
        $(':input', '#enterpriseNodeForm').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked');

        $("#typeId").val(null).trigger("change");
        $("#property8").val(null).trigger("change");
        $("#property9").val(null).trigger("change");
        $("#property9").html("");
        pagePars.modifyType = "I";

        $("#enterpriseNodeForm").data("bootstrapValidator").resetForm();
    }

    /**
     *
     *
     */
    function deleteEnterpriseNode() {

    }

    /**
     *
     *
     */
    function saveEnterpriseNode() {
        $("#btnSaveEnterpriseNode").attr('disabled', true);
        $("#enterpriseNodeForm").data("bootstrapValidator").validate();

        var check = $("#enterpriseNodeForm").data("bootstrapValidator").isValid();
        if (check) {
            var hbEnterpriseNode = $("#enterpriseNodeForm").serializeObject();
            var hbEnterpriseNodes = [];

            if (hbEnterpriseNode.typeId == "") {
                $("#btnSaveEnterpriseNode").attr('disabled', false);
                callError(-100, "请选择一个站点类型...！");
                return;
            }
            if (hbEnterpriseNode.enterpriseId == "") {
                $("#btnSaveEnterpriseNode").attr('disabled', false);
                callError(-100, "请选择站点所属企业...！");
                return;
            }
            if (hbEnterpriseNode.property8 == "") {
                $("#btnSaveEnterpriseNode").attr('disabled', false);
                callError(-100, "请选择设备厂商...！");
                return;
            }
            if (!hbEnterpriseNode.hasOwnProperty("property9") || hbEnterpriseNode.property9 == "") {
                $("#btnSaveEnterpriseNode").attr('disabled', false);
                callError(-100, "请选择设设备型号...！");
                return;
            }
            hbEnterpriseNode._type = pagePars.modifyType;
            hbEnterpriseNodes.push(hbEnterpriseNode);
            hbEnterpriseNode.nodeName = hbEnterpriseNode.property0;
            hbEnterpriseNode.property0 = "";
            hbEnterpriseNode.property1 = "";

            $.ajax({
                async: false,
                type: "POST",
                url: "${ctx}/viewHbEnterpriseNodeCfg/modifyEnterpriseNode",
                cache: false,
                data: ServerRequestPar(1, hbEnterpriseNodes),
                dataType: "json",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                success: function (res) {
                    $("#btnSaveEnterpriseNode").attr('disabled', false);
                    if (res.code != 0) {
                        callError(-999, res.message);
                    } else {
                        parent.refreshPage();
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $("#btnSaveEnterpriseNode").attr('disabled', false);
                    callError(-888, "服务器请求异常...！")
                }
            });
        } else {
            $("#btnSaveEnterpriseNode").attr('disabled', false);
            callError(-100, "录入信息有误，请检查录入信息...！");
        }
    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseNode') {
            addEnterpriseNode();
            if (items && items.length > 0) {
                var selectItem = items[0];
                var hbEnterpriseNode = {};

                $.each(pagePars.enterpriseRegion, function (index, node) {
                    if (selectItem.id == node.nodeId) {
                        hbEnterpriseNode = node;
                        hbEnterpriseNode.property0 = hbEnterpriseNode.nodeName;
                        hbEnterpriseNode.property1 = hbEnterpriseNode.hbEnterprise.enterpriseName;
                    }
                });

                $("#enterpriseNodeForm").initForm(hbEnterpriseNode);

                pagePars.modifyType = "U";
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

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    (function ($) {
        $.fn.extend({
            initForm: function (options) {
                //默认参数
                var defaults = {
                    jsonValue: options,
                    isDebug: false,   //是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
                }
                //设置参数
                var setting = defaults;
                var form = this;
                jsonValue = setting.jsonValue;
                //如果传入的json字符串，将转为json对象
                if ($.type(setting.jsonValue) === "string") {
                    jsonValue = $.parseJSON(jsonValue);
                }
                //如果传入的json对象为空，则不做任何操作
                if (!$.isEmptyObject(jsonValue)) {
                    var debugInfo = "";
                    $.each(jsonValue, function (key, value) {
                        //是否开启调试，开启将会把name value打印出来
                        if (setting.isDebug) {
                            console.log("name:" + key + "; value:" + value);
                            debugInfo += "name:" + key + "; value:" + value + " || ";
                        }
                        var formField = form.find("[name='" + key + "']");
                        if ($.type(formField[0]) === "undefined") {
                            if (setting.isDebug) {
                                //没找到指定name的表单
                                console.log("can not find name:[" + key + "] in form!!!");
                            }
                        } else {
                            var fieldTagName = formField[0].tagName.toLowerCase();
                            if (fieldTagName == "input") {
                                if (formField.attr("type") == "radio") {
                                    $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                                } else {
                                    formField.val(value);
                                }
                            } else if (fieldTagName == "select") {
                                //do something special
                                formField.val(value).trigger("change");
                            } else if (fieldTagName == "textarea") {
                                //do something special
                                formField.val(value);
                            } else {
                                formField.val(value);
                            }

                        }
                    })
                    if (setting.isDebug) {
                        console.log(debugInfo);
                    }
                }
                return form;    //返回对象，提供链式操作
            }
        });
    })(jQuery)
</script>
</body>
</html>
