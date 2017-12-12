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
     aria-labelledby="#__windowRegionTitle"
     id="__windowRegion">
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
                    id="__windowRegionTitle"></h4>
            </div>
            <div class="modal-body">
                <div style="height:300px;overflow:auto; ">
                    <div id="__treeRegion"
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
                        onclick="__regionSelected()">
                    <span class="glyphicon glyphicon-ok"
                          aria-hidden="true"></span>&nbsp;确定
                </button>
            </div>
        </div>
    </div>
</div>
<script type="application/javascript">
    var __regionDataSource = function (options) {
        this._data = options.data;
        this._delay = options.delay;
        this._dataType = 'enterpriseWindow';
    };
    var __regionWindowPar = {
        loaded: false,
        regionWindowCallBack: undefined,
        currentTreeData: [],
    };

    __regionDataSource.prototype = {
        data: function (options, callback) {
            setTimeout(function () {
                    if (options.id != null) {
                        if (options.type === "folder") {
                            $.ajax({
                                type: "POST",
                                url: '${ctx}/viewComCodeConfig/refComRegion',
                                cache: false,
                                data: ServerRequestPar(1, {
                                    farRegionId: options.id,
                                }),
                                dataType: "json",
                                headers: {
                                    'Content-Type': 'application/json;charset=utf-8'
                                },
                                success: function (res) {
                                    if (res.code != 0) {
                                        callback({
                                            data: []
                                        });
                                    } else {
                                        var treeData = [];

                                        $.merge(__regionWindowPar.currentTreeData, res.data);
                                        $.each(res.data, function (index, value) {
                                            var item = {};

                                            item.id = value.regionId;
                                            item.name = value.regionName;
                                            item.type = value.prgroup == "1" ? 'folder' : 'item';
                                            item.farRegionId = value.farRegionId;

                                            treeData.push(item);
                                        });

                                        callback({
                                            data: treeData
                                        });

                                    }

                                },
                                error: function (XMLHttpRequest, textStatus, errorThrown) {
                                    callback({
                                        data: []
                                    });
                                }
                            });
                        } else {

                        }
                    } else {
                        $.ajax({
                            type: "POST",
                            url: '${ctx}/viewComCodeConfig/refComRegion',
                            cache: false,
                            data: ServerRequestPar(1, {
                                farRegionId: 0,
                            }),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json;charset=utf-8'
                            },
                            success: function (res) {
                                if (res.code != 0) {
                                    callback({
                                        data: []
                                    });
                                } else {
                                    var treeData = [];

                                    $.merge(__regionWindowPar.currentTreeData, res.data);
                                    $.each(res.data, function (index, value) {
                                        var item = {};

                                        item.id = value.regionId;
                                        item.name = value.regionName;
                                        item.type = value.prgroup == "1" ? 'folder' : 'item';
                                        item.farRegionId = value.farRegionId;

                                        treeData.push(item);
                                    });

                                    callback({
                                        data: treeData
                                    });

                                }

                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {
                                callback({
                                    data: []
                                });
                            }
                        });
                    }
                }, this._delay
            )
        }
    };

    var __treeRegionDataSource = new __regionDataSource({
        data: [],
        delay: 400
    });

    /**
     *初始化
     */
    function __initRegionWidinow() {
        $('#__windowRegion').modal({
            backdrop: 'static',
            keyboard: true,
            show: false,
        });

        $('#__treeRegion').tree({
            cacheItems: true,
            selectable: true,
            multiSelect: false,
            dataSource: __treeRegionDataSource,
            loadingHTML: '<div class="tree-loading"><i class="fa fa-rotate-right fa-spin"></i></div>',
        });
    }

    /**
     *
     */
    function __regionSelected() {
        var selectItems = $('#__treeRegion').tree('selectedItems');

        if (selectItems && selectItems.length > 0 && __regionWindowPar.regionWindowCallBack != undefined) {
            __regionWindowPar.regionWindowCallBack(selectItems, __regionWindowPar.currentTreeData);
            $('#__windowRegion').modal('hide');
        } else {
            $("#__windowRegionTitle").html("<span style='color: red'>请选择一个行政区划...</span>");
        }
    }

    /**
     * 显示行政区划弹窗
     * @private
     */
    function __showRegionWindow(callBackFunction) {
        if (!__regionWindowPar.loaded) {
            __initRegionWidinow();

            try {
                if (callBackFunction && typeof (eval(callBackFunction)) == "function") {
                    __regionWindowPar.regionWindowCallBack = callBackFunction;
                }
            } catch (e) {
            }
            __regionWindowPar.loaded = true;
        }
        $("#__windowRegionTitle").html("行政区划选择");
        $('#__windowRegion').modal('show');
    }
</script>
