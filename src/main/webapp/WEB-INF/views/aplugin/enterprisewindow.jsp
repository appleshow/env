<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/21
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<div class="modal fade"
     tabindex="-1"
     role="dialog"
     aria-labelledby="#__windowEnerpriseTitle"
     id="__windowEnerprise">
    <div class="modal-dialog"
         style="max-height: 300px;"
         role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button"
                        class="close"
                        data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"
                    id="__windowEnerpriseTitle"></h4>
            </div>
            <div class="modal-body">
                <div style="height:300px;overflow:auto; ">
                    <div id="__treeEnerprise"
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
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-default"
                        data-dismiss="modal">
                    <span class="glyphicon glyphicon-remove"
                          aria-hidden="true"></span>&nbsp;取消
                </button>
                <button type="button"
                        class="btn btn-primary"
                        onclick="__EnerpriseSelected()">
                    <span class="glyphicon glyphicon-ok"
                          aria-hidden="true"></span>&nbsp;确定
                </button>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript">
    var __EnerpriseDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseWindow';
    };
    var __EnerpriseWindowPar = {
        loaded: false,
        EnerpriseWindowCallBack: undefined,
        currentTreeData: [],
    };

    __EnerpriseDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
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
                                            item._dataType = 'enterpriseRegion';

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
                }, this._delay
            )
        }
    }

    var __treeDataSource = new __EnerpriseDataSource({
        data: [],
        delay: 400
    });

    /**
     *初始化
     */
    function __initEnerpriseWidinow() {
        $('#__windowEnerprise').modal({
            backdrop: 'static',
            keyboard: true,
            show: false,
        });

        $('#__treeEnerprise').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: __treeDataSource,
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });
    }

    /**
     *
     */
    function __EnerpriseSelected() {
        var selectItems = $('#__treeEnerprise').tree('selectedItems');

        if (selectItems && selectItems.length > 0 && __EnerpriseWindowPar.EnerpriseWindowCallBack != undefined) {
            __EnerpriseWindowPar.EnerpriseWindowCallBack(selectItems, __EnerpriseWindowPar.currentTreeData);
            $('#__windowEnerprise').modal('hide');
        } else {
            $("#__windowEnerpriseTitle").html("<span style='color: red'>请选择一个行企业...</span>");
        }
    }

    /**
     * 显示行政区划弹窗
     * @private
     */
    function __showEnerpriseWindow(callBackFunction) {
        if (!__EnerpriseWindowPar.loaded) {
            __initEnerpriseWidinow();

            try {
                if (callBackFunction && typeof (eval(callBackFunction)) == "function") {
                    __EnerpriseWindowPar.EnerpriseWindowCallBack = callBackFunction;
                }
            } catch (e) {
            }
            __EnerpriseWindowPar.loaded = true;
        }
        $("#__windowEnerpriseTitle").html("企业选择");
        $('#__windowEnerprise').modal('show');
    }
</script>
