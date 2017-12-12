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
<title>企业信息</title>
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
    <div class="col-lg-4 col-sm-4 col-xs-12">
        <div class="panel panel-default"
             style="margin-bottom: 5px;">
            <div class="panel-heading">企业详情</div>
            <div class="panel-body"
                 style="height: 85%;overflow-y:scroll; ">
                <form id="enterpriseForm"
                      method="post">
                    <div class="row"
                         style="padding-top: 5px">
                        <div class="col-lg-4 col-sm-4 col-xs-4"
                             style="margin-right: 0px;padding-right: 0px">
                            <button class="btn btn-default"
                                    type="button"
                                    style="width: 100%; text-align: right;">企业编号
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       readonly
                                       id="enterpriseId"
                                       name="enterpriseId">
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
                                    style="width: 100%; text-align: right;"><span style="color: red;">* </span>企业名称
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="60"
                                       id="enterpriseName"
                                       name="enterpriseName">
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
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>行政区划
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group">
                                <input class="form-control"
                                       style="width: 100%;"
                                       readonly
                                       id="enterpriseRegionDesc"
                                       name="enterpriseRegionDesc">
                                </input>
                                <span class="input-group-btn">
                                <button class="btn btn-default"
                                        type="button"
                                        onclick="openRegionWindow()">...</button>
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
                                    style="width: 100%; text-align: right;"><span style="color: red">* </span>所属行业
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="enterpriseTrade"
                                    name="enterpriseTrade">
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
                                    style="width: 100%; text-align: right;">所属类型
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="enterpriseType"
                                    name="enterpriseType">
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
                                    style="width: 100%; text-align: right;">危化分类
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="enterpriseCmlLevel"
                                    name="enterpriseCmlLevel">
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
                                    style="width: 100%; text-align: right;">危化等级
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <select class="form-control"
                                    style="width: 100%;"
                                    id="enterpriseCmlGrade"
                                    name="enterpriseCmlGrade">
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
                                    style="width: 100%; text-align: right;">危化存量
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group">
                                <div class="input-group-btn">
                                    <div class="btn-group">
                                        <button type="button"
                                                class="btn btn-default dropdown-toggle"
                                                data-toggle="dropdown"
                                                aria-haspopup="true"
                                                aria-expanded="false">
                                            <span id="unitName">选择单位</span><span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu"
                                            id="dropdownUnit">
                                        </ul>
                                    </div>
                                </div>
                                <input class="form-control"
                                       maxlength="10"
                                       id="enterpriseCmlAmount"
                                       name="enterpriseCmlAmount">
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
                                    style="width: 100%; text-align: right;">企业地址
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px;">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="100"
                                       id="enterpriseAddress"
                                       name="enterpriseAddress">
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
                                    style="width: 100%; text-align: right;">法人代表
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="10"
                                       id="enterpriseLegalPerson"
                                       name="enterpriseLegalPerson">
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
                                    style="width: 100%; text-align: right;">法人联系电话
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="11"
                                       id="enterpriseLegalPhone"
                                       name="enterpriseLegalPhone">
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
                                    style="width: 100%; text-align: right;">环保联系人
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="10"
                                       id="enterpriseEnvPerson"
                                       name="enterpriseEnvPerson">
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
                                    style="width: 100%; text-align: right;">环保联系人电话
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="11"
                                       id="enterpriseEnvPhone"
                                       name="enterpriseEnvPhone">
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
                                    style="width: 100%; text-align: right;">企业网址
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="30"
                                       id="enterpriseUrl"
                                       name="enterpriseUrl">
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
                                    style="width: 100%; text-align: right;">企业备注
                            </button>
                        </div>
                        <div class="col-lg-8 col-sm-8 col-xs-8"
                             style="margin-left: 0px;padding-left: 0px">
                            <div class="input-group"
                                 style="width: 100%;">
                                <input class="form-control"
                                       maxlength="200"
                                       id="enterpriseDesc"
                                       name="enterpriseDesc">
                                </input>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-primary"
                        onclick="addEnterprise()">
                    <span class="glyphicon glyphicon-plus"
                          aria-hidden="true"></span>&nbsp;新增
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="deleteEnterprise()">
                    <span class="glyphicon glyphicon-remove"
                          aria-hidden="true"></span>&nbsp;删除
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="saveEnterprise()">
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
<%@include file="../aplugin/regionwindow.jsp" %>

<script type="application/javascript">
    var pagePars = {
        modifyType: "I",
        selectUnitId: undefined,
        enterpriseRegion: [],
        comCode: [],
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
                            }else{
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

                                        pagePars.enterpriseRegion = res.data;
                                        treeData.push({id: "所有", name: "所有 - [" + res.data.length + "]", type: "folder",});

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

    jQuery(document).ready(function () {
        $("#enterpriseType").select2({
            placeholder: "选择一个企业分类",
            allowClear: true,
            language: "zh-CN"
        });
        $("#enterpriseTrade").select2({
            placeholder: "选择一个企业等级",
            allowClear: true,
            language: "zh-CN"
        });
        $("#enterpriseCmlLevel").select2({
            placeholder: "选择一个危化分类",
            allowClear: true,
            language: "zh-CN"
        });
        $("#enterpriseCmlGrade").select2({
            placeholder: "选择一个危化等级",
            allowClear: true,
            language: "zh-CN"
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
        $('#enterpriseForm').bootstrapValidator({
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
                enterpriseName: {
                    validators: {
                        notEmpty: {
                            message: '此项不能为空...',
                        },
                    },
                },
                enterpriseCmlAmount: {
                    validators: {
                        regexp: {
                            regexp: /^([1-9][0-9]*)+(.[0-9]{1,2})?$/,
                            message: '此项只能录入数字...',
                        },
                    },
                },
                enterpriseLegalPhone: {
                    validators: {
                        digits: {
                            message: '此项只能录入数字...',
                        },
                        stringLength: {
                            min: 8,
                            max: 11,
                            message: '此项长度必须在8到11位之间...',
                        },
                    },
                },
                enterpriseEnvPhone: {
                    validators: {
                        digits: {
                            message: '此项只能录入数字...',
                        },
                        stringLength: {
                            min: 8,
                            max: 11,
                            message: '此项长度必须在8到11位之间...',
                        },
                    },
                },
                enterpriseUrl: {
                    validators: {
                        uri: {
                            message: '此项只能录入有误...',
                        },
                    },
                },
            }
        });

        $.ajax({
            type: "POST",
            url: "${ctx}/viewComCodeConfig/refComCode",
            cache: false,
            data: ServerRequestPar(1, {codeType: "19,22,24,25,26", pageNumber: 1, pageSize: 2000,}),
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    callError(res.code, res.message);
                } else {
                    var enterpriseTrade = "";
                    var enterpriseType = "";
                    var enterpriseCmlLevel = "";
                    var enterpriseCmlGrade = "";
                    var dropdownUnit = "";

                    pagePars.comCode = res.data;
                    $.each(pagePars.comCode, function (index, value) {
                        if (value.codeType == "22") {
                            enterpriseTrade += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                        }
                        if (value.codeType == "19") {
                            enterpriseType += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                        }
                        if (value.codeType == "24") {
                            enterpriseCmlLevel += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                        }
                        if (value.codeType == "25") {
                            enterpriseCmlGrade += "<option value='" + value.codeId + "'>" + value.codeName + "</option>";
                        }
                        if (value.codeType == "26") {
                            dropdownUnit += "<li><a href='#' onclick='selectUnit(\"" + value.codeId + "\",\"" + value.codeName + "\")'>" + value.codeName + "</a></li>";
                        }
                    });
                    if (enterpriseTrade != "") {
                        $("#enterpriseTrade").append(enterpriseTrade);
                    }
                    if (enterpriseType != "") {
                        $("#enterpriseType").append(enterpriseType);
                    }
                    if (enterpriseCmlLevel != "") {
                        $("#enterpriseCmlLevel").append(enterpriseCmlLevel);
                    }
                    if (enterpriseTrade != "") {
                        $("#enterpriseCmlGrade").append(enterpriseCmlGrade);
                    }
                    if (dropdownUnit != "") {
                        $("#dropdownUnit").append(dropdownUnit);
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
    function openRegionWindow() {
        __showRegionWindow(callBackRegionSelect);
    }

    /**
     *
     */
    function callBackRegionSelect(selectItems, currentTreeData) {
        var selectItem = selectItems[0];

        $("#enterpriseRegionDesc").val(formartRegion(currentTreeData, selectItem.farRegionId) + "/" + selectItem.name + "(" + selectItem.id + ")");
    }

    /**
     *
     */
    function formartRegion(regionData, farRegionId) {
        var regionName = "";
        for (var index = 0; index < regionData.length; index++) {
            if (regionData[index].regionId == farRegionId) {
                regionName = formartRegion(regionData, regionData[index].farRegionId) + "/" + regionData[index].regionName + regionName;
                break;
            }
        }
        return regionName;
    }

    /**
     *
     *
     */
    function addEnterprise() {
        $(':input', '#enterpriseForm').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked');

        $("#enterpriseType").val(null).trigger("change");
        $("#enterpriseTrade").val(null).trigger("change");
        $("#enterpriseCmlLevel").val(null).trigger("change");
        $("#enterpriseCmlGrade").val(null).trigger("change");

        $("#unitName").html("选择单位");
        pagePars.selectUnitId = undefined;
        pagePars.modifyType = "I";

        $("#enterpriseForm").data("bootstrapValidator").resetForm();

    }

    /**
     *
     *
     */
    function deleteEnterprise() {

    }

    /**
     *
     *
     */
    function saveEnterprise() {
        $("#enterpriseForm").data("bootstrapValidator").validate();

        var check = $("#enterpriseForm").data("bootstrapValidator").isValid();
        if (check) {
            var hbEnterprise = $("#enterpriseForm").serializeObject();
            var hbEnterprises = [];

            if (hbEnterprise.property0 == "") {
                callError(-100, "请选择一个行政区划...！");
                return;
            }
            if (hbEnterprise.enterpriseTrade == "") {
                callError(-100, "请选择一个所属行业...！");
                return;
            }
            if (hbEnterprise.enterpriseCmlAmount != "" && pagePars.selectUnitId == undefined) {
                callError(-100, "请选择请选择危化存量单位...！");
                return;
            }

            hbEnterprise._type = pagePars.modifyType;
            hbEnterprise.enterpriseCmlUnit = pagePars.selectUnitId;
            hbEnterprises.push(hbEnterprise);
            $.ajax({
                async: false,
                type: "POST",
                url: "${ctx}/viewHbEnterpriseCfg/modifyEnterprise",
                cache: false,
                data: ServerRequestPar(1, hbEnterprises),
                dataType: "json",
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                success: function (res) {
                    if (res.code != 0) {
                        callError(-999, res.message);
                    } else {
                        parent.refreshPage();
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    callError(-888, "服务器请求异常...！")
                }
            });
        } else {
            callError(-100, "录入信息有误，请检查录入信息...！");
        }
    }

    /**
     *
     */
    function treeSelectItem(items, dataSource) {
        if (dataSource._dataType == 'enterpriseRegion') {
            if (items && items.length > 0) {
                var selectItem = items[0];
                var hbEnterprise = {};

                $.each(pagePars.enterpriseRegion, function (index, enterprise) {
                    if (selectItem.id == enterprise.enterpriseId) {
                        hbEnterprise = enterprise;
                    }
                });

                $("#enterpriseForm").initForm(hbEnterprise);
                $.each(pagePars.comCode, function (index, value) {
                    if (value.codeType == "26" && value.codeId == hbEnterprise.enterpriseCmlUnit) {
                        $("#unitName").html(value.codeName);
                        pagePars.selectUnitId = value.codeId;
                    }
                });

                pagePars.modifyType = "U";
            } else {
                addEnterprise();
            }
        }
    }

    /**
     *
     */
    function selectUnit(unitId, unitName) {
        $("#unitName").html(unitName);
        pagePars.selectUnitId = unitId;
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
