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
<title>站点管理</title>
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
            <div class="panel-body">
                <div id="tree-node"
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
            <div class="panel-heading">企业信息</div>
            <div class="panel-body"
                 style="height: 90%;overflow-y:scroll; ">
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
                        <input class="form-control"
                               style="width: 100%;"
                               readonly
                               id="enterpriseId"
                               name="enterpriseId">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="60"
                               id="enterpriseName"
                               name="enterpriseName">
                        </input>
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
                                   id="enterpriseRegion"
                                   name="enterpriseRegion">
                            </input>
                            <span class="input-group-btn">
                                <button class="btn btn-default"
                                        type="button">...</button>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="10"
                               id="enterpriseCmlAmount"
                               name="enterpriseCmlAmount">
                        </input>
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
                         style="margin-left: 0px;padding-left: 0px">
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="100"
                               id="enterpriseAddress"
                               name="enterpriseAddress">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="10"
                               id="enterpriseLegalPerson"
                               name="enterpriseLegalPerson">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="11"
                               id="enterpriseLegalPhone"
                               name="enterpriseLegalPhone">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="10"
                               id="enterpriseEnvPerson"
                               name="enterpriseEnvPerson">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="11"
                               id="enterpriseEnvPhone"
                               name="enterpriseEnvPhone">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="30"
                               id="enterpriseUrl"
                               name="enterpriseUrl">
                        </input>
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
                        <input class="form-control"
                               style="width: 100%;"
                               maxlength="200"
                               id="enterpriseDesc"
                               name="enterpriseDesc">
                        </input>
                    </div>
                </div>
            </div>
        </div>
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

<script type="application/javascript">

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

        initComboData();
    });

    /**
     *
     */
    function initComboData() {
        $.ajax({
            async: false,
            type: "POST",
            url: "${ctx}/viewComCodeConfig/refComCode",
            cache: false,
            data: ServerRequestPar(1, {codeType: "19,22,24,25", pageNumber: 1, pageSize: 2000,}),
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

                    $.each(res.data, function (index, value) {
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
