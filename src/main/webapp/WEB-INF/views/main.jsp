<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/9
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible"
          content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>污染源在线监测管理系统</title>
    <link rel="shortcut icon"
          href="${ctx}/assets-view/login/ico/favicon.png">
    <!--Basic Styles-->
    <link href="${ctx}/assets/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link href="${ctx}/assets/css/font-awesome.min.css"
          rel="stylesheet"/>
    <!--Beyond styles-->
    <link id="beyond-link"
          href="${ctx}/assets/css/beyond.min.css"
          rel="stylesheet"
          type="text/css"/>
    <link href="${ctx}/assets/css/animate.min.css"
          rel="stylesheet"/>
    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="${ctx}/assets/js/skins.min.js"></script>
    <style type="text/css">
        .page-header-fixed + .page-body {
            margin-top: 40px !important
        }

        .page-header.page-header-fixed + .page-body {
            margin-top: 40px
        }

        .page-body {
            background: #eee;
            padding: 0px 0px 0px
        }

        .page-header.page-header-fixed {
            position: fixed;
            right: 0;
            left: 224px;
            top: 45px;
            z-index: 998;
            margin-top: 0 !important
        }
    </style>
</head>
<!-- /Head -->
<!-- Body -->
<body>
<!-- Loading Container -->
<div class="loading-container">
    <div class="loader"></div>
</div>
<!--  /Loading Container -->
<!-- Navbar -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="navbar-container">
            <!-- Navbar Barnd -->
            <div class="navbar-header pull-left">
                <a href="#"
                   class="navbar-brand">
                    <small><img src="${ctx}/assets/img/logo.png"
                                alt=""/>
                    </small>
                </a>
            </div>
            <!-- /Navbar Barnd -->
            <!-- Sidebar Collapse -->
            <div class="sidebar-collapse"
                 id="sidebar-collapse">
                <i class="collapse-icon fa fa-bars"></i>
            </div>
            <!-- /Sidebar Collapse -->
            <!-- Account Area and Settings --->
            <div class="navbar-header pull-right">
                <div class="navbar-account">
                    <ul class="account-area">
                        <li id="person-m"></li>
                        <li><a class="login-area dropdown-toggle"
                               data-toggle="dropdown">
                            <div class="avatar"
                                 title="查看我的资料">
                                <img src="${ctx}/assets-view/main/css/images/user.png">
                            </div>
                            <section>
                                <h2>
                                    <span class="profile"><span id="lblUserName">&nbsp;您好，username &nbsp;&nbsp;&nbsp; </span></span>
                                </h2>
                            </section>
                        </a> <!--Login Area Dropdown-->
                            <ul class="pull-right dropdown-menu dropdown-arrow dropdown-login-area">
                                <li class="username"
                                    id="lblUserNameHide"><a>username</a></li>
                                <li class="email"><a id="lblUserId">登入帐号:userid</a></li>
                                <!--Avatar Area-->
                                <li>
                                    <div class="avatar-area">
                                        <img src="${ctx}/assets-view/main/css/images/user.png"
                                             class="avatar"> <span class="caption"></span>
                                    </div>
                                </li>
                                <!--Avatar Area-->
                                <li class="edit"><a href="#"
                                                    class="pull-right"
                                                    onclick="userSetting()">用户设置</a></li>
                                <!--Theme Selector Area-->
                                <li class="theme-area">
                                    <ul class="colorpicker"
                                        id="skin-changer">
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #5DB2FF;"
                                               rel="${ctx}/assets/css/skins/blue.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #2dc3e8;"
                                               rel="${ctx}/assets/css/skins/azure.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #03B3B2;"
                                               rel="${ctx}/assets/css/skins/teal.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #53a93f;"
                                               rel="${ctx}/assets/css/skins/green.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #FF8F32;"
                                               rel="${ctx}/assets/css/skins/orange.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #cc324b;"
                                               rel="${ctx}/assets/css/skins/pink.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #AC193D;"
                                               rel="${ctx}/assets/css/skins/darkred.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #8C0095;"
                                               rel="${ctx}/assets/css/skins/purple.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #0072C6;"
                                               rel="${ctx}/assets/css/skins/darkblue.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #585858;"
                                               rel="${ctx}/assets/css/skins/gray.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #474544;"
                                               rel="${ctx}/assets/css/skins/black.min.css"></a></li>
                                        <li><a class="colorpick-btn"
                                               href="#"
                                               style="background-color: #001940;"
                                               rel="${ctx}/assets/css/skins/deepblue.min.css"></a></li>
                                    </ul>
                                </li>
                                <!--/Theme Selector Area-->
                                <li class="dropdown-footer"><a href="#"
                                                               onclick="userOff()">注销</a></li>
                            </ul> <!--/Login Area Dropdown--></li>
                        <!-- /Account Area -->
                        <!--Note: notice that setting div must start right after account area list.
                 no space must be between these elements-->
                    </ul>
                    <!-- Settings -->
                    <!-- Settings -->
                </div>
            </div>
            <!-- /Account Area and Settings -->
        </div>
    </div>
</div>
<!-- /Navbar -->
<!-- Main Container -->
<div class="main-container container-fluid">
    <!-- Page Container -->
    <div class="page-container">
        <!-- Page Sidebar -->
        <div class="page-sidebar"
             id="sidebar">
            <!-- Page Sidebar Header-->
            <div class="sidebar-header-wrapper">
                <!--  <input type="text"
                         class="searchinput"/>
                  <i class="searchicon fa fa-search"></i>
                  <div class="searchhelper">检索页面</div> -->
            </div>
            <!-- /Page Sidebar Header -->
            <!-- Sidebar Menu -->
            <ul id="sidebarMenu"
                class="nav sidebar-menu">
            </ul>
            <!-- /Sidebar Menu -->
        </div>
        <!-- /Page Sidebar -->
        <!-- Page Content -->
        <div class="page-content">
            <!-- Page Breadcrumb -->
            <!-- /Page Breadcrumb -->
            <!-- Page Header -->
            <div class="page-header position-relative">
                <div class="header-title">
                    <h1 id=childeName>
                        <span class='glyphicon glyphicon-home'
                              aria-hidden='true'></span> 首页
                    </h1>
                </div>
                <!--Header Buttons-->
                <div class="header-buttons">
                    <a class="sidebar-toggler"
                       href="#"
                       title="隐藏/显示导航栏"> <i class="fa fa-arrows-h"></i>
                    </a> <a class="refresh"
                            id="refresh-toggler"
                            href="#"
                            onclick="refreshPage()"
                            title="刷新当前页面"> <i class="glyphicon glyphicon-refresh"></i>
                </a> <a class="fullscreen"
                        id="fullscreen-toggler"
                        href="#"
                        title="全屏/取消全屏"> <i class="glyphicon glyphicon-fullscreen"></i>
                </a>
                </div>
                <!--Header Buttons End-->
            </div>
            <!-- /Page Header -->
            <!-- Page Body -->
            <div class="page-body">
                <div class="embed-responsive"
                     id="childFrame">
                    <iframe id="childePage"
                            class="embed-responsive-item"></iframe>
                </div>
            </div>
            <!-- /Page Body -->
            <!-- /Page Content -->
        </div>
        <!-- /Page Container -->
        <!-- Main Container -->
    </div>
</div>
<div class="modal fade"
     id="modal-setting"
     tabindex="-1"
     role="dialog"
     aria-labelledby="mlSettingTitle">
    <div class="modal-dialog"
         role="document"
         style="width: 30%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button"
                        class="close"
                        data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title"
                    id="mlSettingTitle"></h4>
            </div>
            <div class="modal-body"
                 style="padding: 1px;">
                <div class="tabbable">
                    <ul class="nav nav-tabs tabs-flat"
                        id="tab-notes">
                        <li class="active"><a data-toggle="tab"
                                              href="#tab-p"> 修改密码 </a></li>
                    </ul>
                    <div class="tab-content tabs-flat">
                        <div id="tab-p"
                             class="tab-pane in active">
                                        <span class="input-icon icon-right"> <input type="password"
                                                                                    class="form-control"
                                                                                    id="pwo"
                                                                                    placeholder="请录入旧密码"> <i class="fa fa-key blue"></i>
                                        </span><span class="input-icon icon-right"> <input type="password"
                                                                                           class="form-control"
                                                                                           id="pwn1"
                                                                                           placeholder="请录入新密码"> <i class="fa fa-key blue"></i>
                                        </span><span class="input-icon icon-right"> <input type="password"
                                                                                           class="form-control"
                                                                                           id="pwn2"
                                                                                           placeholder="请确认新密码"> <i class="fa fa-key blue"></i>
                                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button"
                        class="btn btn-primary"
                        data-dismiss="modal"
                        onclick="saveSetting()">保存修改
                </button>
            </div>
        </div>
    </div>
</div>
<div id="modal-success"
     class="modal modal-message modal-success fade"
     style="display: none;"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <i class="glyphicon glyphicon-check"></i>
            </div>
            <div class="modal-title"
                 id="msTitle"></div>
            <div class="modal-body"
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
<div id="modal-warning"
     class="modal modal-message modal-warning fade"
     style="display: none;"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <i class="fa fa-warning"></i>
            </div>
            <div class="modal-title"
                 id="mwTitle"></div>
            <div class="modal-body"
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
<!--Basic Scripts-->
<script src="${ctx}/assets/js/jquery.min.js"></script>
<script src="${ctx}/assets/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/js/slimscroll/jquery.slimscroll.min.js"></script>
<!--Beyond Scripts-->
<script src="${ctx}/assets/js/bootbox/bootbox.js"></script>
<script src="${ctx}/assets-view/comm/comm.js"></script>
<script src="${ctx}/assets/js/md5.js"></script>
<script>
    var UNDEFINED = undefined;
    var pageid = "8", pageurl = "map/hbnodeallocation", pagename = "站点分布", pageicon = "fa fa-star";

    /* Sets Themed Colors Based on Themes */

    var themeprimary = getThemeColorFromCss('themeprimary');
    var themesecondary = getThemeColorFromCss('themesecondary');
    var themethirdcolor = getThemeColorFromCss('themethirdcolor');
    var themefourthcolor = getThemeColorFromCss('themefourthcolor');
    var themefifthcolor = getThemeColorFromCss('themefifthcolor');

    // Gets Theme Colors From Selected Skin To Use For Drawing Charts
    function getThemeColorFromCss(style) {
        var $span = $("<span></span>").hide().appendTo("body");
        $span.addClass(style);
        var color = $span.css("color");
        $span.remove();
        return color;
    }

    // Handle RTL SUpport for Changer CheckBox
    $("#skin-changer li a").click(function () {
        createCookie("current-skin", $(this).attr('rel'), 10);
        window.location.reload();
    });

    // Checks Not to Do rtl-support for Arabic and Persian Demo Pages

    var rtlchanger = document.getElementById('rtl-changer');

    if (location.pathname != "/index-rtl-fa.html" && location.pathname != "index-rtl-ar.html") {
        if (readCookie("rtl-support")) {
            switchClasses("pull-right", "pull-left");
            switchClasses("databox-right", "databox-left");
            switchClasses("item-right", "item-left");
            $('.navbar-brand small img').attr('src', 'assets/img/logo-rtl.png');
            if (rtlchanger != null)
                document.getElementById('rtl-changer').checked = true;
        } else {
            if (rtlchanger != null)
                rtlchanger.checked = false;
        }

        if (rtlchanger != null) {
            rtlchanger.onchange = function () {
                if (this.checked) {
                    createCookie("rtl-support", "true", 10);
                } else {
                    eraseCookie("rtl-support");
                }
                setTimeout(function () {
                    window.location.reload();
                }, 600);

            };
        }
    }
    /* Loading */
    $(window).load(function () {
        var inner = "", menus = [];
        var rate = 100 * ($(window).height() - 80) / ($(window).width() - 225) + "%";

        $("#childFrame").css("padding-bottom", rate);

        // 加载菜单
        $.ajax({
            type: "POST",
            url: "${ctx}/viewMain/personMenu",
            cache: false,
            dataType: "json",
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            success: function (res) {
                if (res.code != 0) {
                    $("#mwTitle").html("警告");
                    $("#mwMessage").html(res.message);
                    $("#modal-warning").modal("show");
                } else {
                    $obj("lblUserName").innerHTML = "&nbsp;您好，" + res.subJoinJson.userName + " &nbsp;&nbsp;&nbsp; ";
                    $obj("lblUserNameHide").innerHTML = res.subJoinJson.userName;
                    $obj("lblUserId").innerHTML = "登入帐号: " + res.subJoinJson.userId;

                    menus = res.data;
                    for (var index = 0; index < menus.length; index++) {
                        if (menus[index].farMenuId == 0) {
                            var innerTemp = getChildMenu(index, menus);
                            if (innerTemp.indexOf("menu-dropdown") > 0) {
                                inner += innerTemp;
                            }
                        }
                    }
                }
                $obj("sidebarMenu").innerHTML = inner;

                doPageLoad();
                /*
                 * inf = { type : 'QJ', prc : 'aps.com.dao.PageMain.refPersonMsg', };
                 * $.ajax({ type : "POST", url : url, cache : false, data : "inf=" +
                 * JSON.stringify(inf), dataType : "json", success : function(res) {
                 * if (res[0].p_e_code != 0) { } else { var html; if
                 * (parseInt(res[0].p_m_rows) <= 99) { html = "<a
                 * class='dropdown-toggle' data-toggle='dropdown' title='我的消息'
                 * href='#'> <i class='icon fa fa-envelope'></i> <span
                 * class='badge'>"; html += +res[0].p_m_rows; html += "</span></a>"; }
                 * else { html = "<a class='dropdown-toggle' data-toggle='dropdown'
                 * title='我的消息' href='#'> <i class='icon fa fa-envelope'></i> <span
                 * class='badge'>...</span></a>"; } html += "
                 * <ul class='pull-right dropdown-menu dropdown-arrow dropdown-messages'>";
                 * for (var index = 1; index < res.length; index++) { if
                 * (res[index].mtype == "F") { html += "<li><a href='#'> <img
                 * src='res/main/css/images/files.png' class='message-avatar'
                 * alt='"; } else { html += "<li><a href='#'> <img
                 * src='res/main/css/images/notes.png' class='message-avatar'
                 * alt='"; } html += res[index].mfrom; html += "'> <div
                 * class='message'><span class='message-sender'>"; html +=
                 * res[index].mfrom; html += "</span> <span class='message-time'>";
                 * if (res[index].mtime < 60) { html += res[index].mtime + " 分钟之前"; }
                 * else if (res[index].mtime < 1440) { html +=
                 * Math.round(res[index].mtime / 60) + " 小时之前"; } else { html +=
                 * Math.round(res[index].mtime / 1440) + " 天之前"; } html += "</span>
                 * <span class='message-subject'>"; html += res[index].mtitle; html += "</span>
                 * <span class='message-body'>"; html += res[index].mcontent; html += "</span></div></a></li>";
                 * if (index >= 5) { break; } } html += " </ul>"; }
                 * $("#person-m").html(html); doPageLoad(); }, error : function() { } })
                 */
            },
            error: function () {
            }
        });

        window.onresize = function () {
            var rate = 100 * ($(window).height() - 85) / ($(window).width() - 225) + "%";

            $("#childFrame").css("padding-bottom", rate);
        }

    });

    /* Account Area --> Setting Button */

    /* Toggle FullScreen */
    $('#fullscreen-toggler').on('click', function (e) {
        var element = document.documentElement;
        if (!$('body').hasClass("full-screen")) {

            $('body').addClass("full-screen");
            $('#fullscreen-toggler').addClass("active");
            if (element.requestFullscreen) {
                element.requestFullscreen();
            } else if (element.mozRequestFullScreen) {
                element.mozRequestFullScreen();
            } else if (element.webkitRequestFullscreen) {
                element.webkitRequestFullscreen();
            } else if (element.msRequestFullscreen) {
                element.msRequestFullscreen();
            }

        } else {

            $('body').removeClass("full-screen");
            $('#fullscreen-toggler').removeClass("active");

            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            }

        }
    });

    /* Handles Popovers */
    var popovers = $('[data-toggle=popover]');
    $.each(popovers, function () {
        $(this).popover(
            {
                html: true,
                template: '<div class="popover ' + $(this).data("class") + '"><div class="arrow"></div><h3 class="popover-title ' + $(this).data("titleclass")
                + '">Popover right</h3><div class="popover-content"></div></div>'
            });
    });

    var hoverpopovers = $('[data-toggle=popover-hover]');
    $.each(hoverpopovers, function () {
        $(this).popover(
            {
                html: true,
                template: '<div class="popover ' + $(this).data("class") + '"><div class="arrow"></div><h3 class="popover-title ' + $(this).data("titleclass")
                + '">Popover right</h3><div class="popover-content"></div></div>',
                trigger: "hover"
            });
    });

    /* Handles ToolTips */
    $("[data-toggle=tooltip]").tooltip({
        html: true
    });

    InitiateSideMenu();
    InitiateSettings();
    InitiateWidgets();

    function InitiateSideMenu() {

        // Sidebar Toggler
        $(".sidebar-toggler").on('click', function () {
            $("#sidebar").toggleClass("hide");
            $(".sidebar-toggler").toggleClass("active");
            return false;
        });
        // End Sidebar Toggler

        // Sidebar Collapse
        var b = $("#sidebar").hasClass("menu-compact");
        $("#sidebar-collapse").on('click', function () {
            if (!$('#sidebar').is(':visible'))
                $("#sidebar").toggleClass("hide");
            $("#sidebar").toggleClass("menu-compact");
            $(".sidebar-collapse").toggleClass("active");
            b = $("#sidebar").hasClass("menu-compact");

            if ($(".sidebar-menu").closest("div").hasClass("slimScrollDiv")) {
                $(".sidebar-menu").slimScroll({
                    destroy: true
                });
                $(".sidebar-menu").attr('style', '');
            }
            if (b) {
                $(".open > .submenu").removeClass("open");
            } else {
                if ($('.page-sidebar').hasClass('sidebar-fixed')) {
                    var position = (readCookie("rtl-support") || location.pathname == "/index-rtl-fa.html" || location.pathname == "index-rtl-ar.html") ? 'right' : 'left';
                    $('.sidebar-menu').slimscroll({
                        height: 'auto',
                        position: position,
                        size: '3px',
                        color: themeprimary
                    });
                }
            }
            // Slim Scroll Handle

        });
        // End Sidebar Collapse

        // Sidebar Menu Handle
        $(".sidebar-menu").on('click', function (e) {
            var menuLink = $(e.target).closest("a");
            if (!menuLink || menuLink.length == 0)
                return;
            if (!menuLink.hasClass("menu-dropdown")) {
                if (b && menuLink.get(0).parentNode.parentNode == this) {
                    var menuText = menuLink.find(".menu-text").get(0);
                    if (e.target != menuText && !$.contains(menuText, e.target)) {
                        return false;
                    }
                }
                return;
            }
            var submenu = menuLink.next().get(0);
            if (!$(submenu).is(":visible")) {
                var c = $(submenu.parentNode).closest("ul");
                if (b && c.hasClass("sidebar-menu"))
                    return;
                c.find("> .open > .submenu").each(function () {
                    if (this != submenu && !$(this.parentNode).hasClass("active"))
                        $(this).slideUp(200).parent().removeClass("open");
                });
            }
            if (b && $(submenu.parentNode.parentNode).hasClass("sidebar-menu"))
                return false;
            $(submenu).slideToggle(200).parent().toggleClass("open");
            return false;
        });
        // End Sidebar Menu Handle
    }

    function InitiateWidgets() {
        $('.widget-buttons *[data-toggle="maximize"]').on("click", function (event) {
            event.preventDefault();
            var widget = $(this).parents(".widget").eq(0);
            var button = $(this).find("i").eq(0);
            var compress = "fa-compress";
            var expand = "fa-expand";
            if (widget.hasClass("maximized")) {
                if (button) {
                    button.addClass(expand).removeClass(compress);
                }
                widget.removeClass("maximized");
                widget.find(".widget-body").css("height", "auto");
            } else {
                if (button) {
                    button.addClass(compress).removeClass(expand);
                }
                widget.addClass("maximized");
                maximize(widget);
            }
        });

        $('.widget-buttons *[data-toggle="collapse"]').on("click", function (event) {
            event.preventDefault();
            var widget = $(this).parents(".widget").eq(0);
            var body = widget.find(".widget-body");
            var button = $(this).find("i");
            var down = "fa-plus";
            var up = "fa-minus";
            var slidedowninterval = 300;
            var slideupinterval = 200;
            if (widget.hasClass("collapsed")) {
                if (button) {
                    button.addClass(up).removeClass(down);
                }
                widget.removeClass("collapsed");
                body.slideUp(0, function () {
                    body.slideDown(slidedowninterval);
                });
            } else {
                if (button) {
                    button.addClass(down).removeClass(up);
                }
                body.slideUp(slideupinterval, function () {
                    widget.addClass("collapsed");
                });
            }
        });

        $('.widget-buttons *[data-toggle="dispose"]').on("click", function (event) {
            event.preventDefault();
            var toolbarLink = $(this);
            var widget = toolbarLink.parents(".widget").eq(0);
            var disposeinterval = 300;
            widget.hide(disposeinterval, function () {
                widget.remove();
            });
        });
    }

    // Fullscreen Widget
    function maximize(widgetbox) {
        if (widgetbox) {
            var windowHeight = $(window).height();
            var headerHeight = widgetbox.find(".widget-header").height();
            widgetbox.find(".widget-body").height(windowHeight - headerHeight);
        }
    }

    /* Scroll To */
    function scrollTo(el, offeset) {
        var pos = (el && el.size() > 0) ? el.offset().top : 0;
        jQuery('html,body').animate({
            scrollTop: pos + (offeset ? offeset : 0)
        }, 'slow');
    }

    /* Show Notification */
    function Notify(message, position, timeout, theme, icon, closable) {
        toastr.options.positionClass = 'toast-' + position;
        toastr.options.extendedTimeOut = 0; // 1000;
        toastr.options.timeOut = timeout;
        toastr.options.closeButton = closable;
        toastr.options.iconClass = icon + ' toast-' + theme;
        toastr['custom'](message);
    }

    /* #region handle Settings */
    function InitiateSettings() {
        $('.navbar').addClass('navbar-fixed-top');

        $('.page-sidebar').addClass('sidebar-fixed');

        // Slim Scrolling for Sidebar Menu in fix state
        if (!$(".page-sidebar").hasClass("menu-compact")) {
            var position = (readCookie("rtl-support") || location.pathname == "/index-rtl-fa.html" || location.pathname == "index-rtl-ar.html") ? 'right' : 'left';
            $('.sidebar-menu').slimscroll({
                height: 'auto',
                position: position,
                size: '3px',
                color: themeprimary
            });
        }

        $('.page-header').addClass('page-header-fixed');
    }

    function setCookiesForFixedSettings() {
        createCookie("navbar-fixed-top", $('#checkbox_fixednavbar').is(':checked'), 100);
        createCookie("sidebar-fixed", $('#checkbox_fixedsidebar').is(':checked'), 100);
        createCookie("breadcrumbs-fixed", $('#checkbox_fixedbreadcrumbs').is(':checked'), 100);
        createCookie("page-header-fixed", $('#checkbox_fixedheader').is(':checked'), 100);

        var position = (readCookie("rtl-support") || location.pathname == "/index-rtl-fa.html" || location.pathname == "index-rtl-ar.html") ? 'right' : 'left';
        if ($('#checkbox_fixedsidebar').is(':checked')) {
            if (!$('.page-sidebar').hasClass('menu-compact')) {
                // Slim Scrolling for Sidebar Menu in fix state
                $('.sidebar-menu').slimscroll({
                    position: position,
                    size: '3px',
                    color: themeprimary,
                    height: 'auto',
                });
            }
        } else {
            if ($(".sidebar-menu").closest("div").hasClass("slimScrollDiv")) {
                $(".sidebar-menu").slimScroll({
                    destroy: true
                });
                $(".sidebar-menu").attr('style', '');
            }
        }
    }

    /* #endregion handle Settings */

    /* #region Get Colors */
    // Get colors from a string base on theme colors
    function getcolor(colorString) {
        switch (colorString) {
            case ("themeprimary"):
                return themeprimary;
            case ("themesecondary"):
                return themesecondary;
            case ("themethirdcolor"):
                return themethirdcolor;
            case ("themefourthcolor"):
                return themefourthcolor;
            case ("themefifthcolor"):
                return themefifthcolor;
            default:
                return colorString;
        }
    }

    /* #endregion Get Colors */

    // Switch Classes Function
    function switchClasses(firstClass, secondClass) {

        var firstclasses = document.getElementsByClassName(firstClass);

        for (i = firstclasses.length - 1; i >= 0; i--) {
            if (!hasClass(firstclasses[i], 'dropdown-menu')) {
                addClass(firstclasses[i], firstClass + '-temp');
                removeClass(firstclasses[i], firstClass);
            }
        }

        var secondclasses = document.getElementsByClassName(secondClass);

        for (i = secondclasses.length - 1; i >= 0; i--) {
            if (!hasClass(secondclasses[i], 'dropdown-menu')) {
                addClass(secondclasses[i], firstClass);
                removeClass(secondclasses[i], secondClass);
            }
        }

        tempClasses = document.getElementsByClassName(firstClass + '-temp');

        for (i = tempClasses.length - 1; i >= 0; i--) {
            if (!hasClass(tempClasses[i], 'dropdown-menu')) {
                addClass(tempClasses[i], secondClass);
                removeClass(tempClasses[i], firstClass + '-temp');
            }
        }
    }

    // Add Classes Function
    function addClass(elem, cls) {
        var oldCls = elem.className;
        if (oldCls) {
            oldCls += " ";
        }
        elem.className = oldCls + cls;
    }

    // Remove Classes Function
    function removeClass(elem, cls) {
        var str = " " + elem.className + " ";
        elem.className = str.replace(" " + cls, "").replace(/^\s+/g, "").replace(/\s+$/g, "");
    }

    // Has Classes Function
    function hasClass(elem, cls) {
        var str = " " + elem.className + " ";
        var testCls = " " + cls + " ";
        return (str.indexOf(testCls) != -1);
    }

    // Close loading
    function doPageLoad() {
        setTimeout(function () {
            $('.loading-container').addClass('loading-inactive');
            // $obj("childePage").src = "home.html";
            refreshPage();
        }, 1000);
    }

    // Through a menu
    function getChildMenu(farther, menus) {
        var haschild = false, show = false, url = "", inner = "";

        for (var index = 0; index < menus.length; index++) {
            if (!menus[index].hasOwnProperty("formId")) {
                show = true;
            } else {
                if (menus[index].hasOwnProperty("comForm") && menus[index].comForm != null) {
                    if (menus[index].comForm.hasOwnProperty("property0") && menus[index].comForm.property0 != null) {
                        show = true;
                    } else {
                        show = false;
                    }
                } else {
                    show = false;
                }
            }
            if (menus[index].farMenuId == menus[farther].menuId && show) {
                if (!haschild) {
                    haschild = true;
                    if (menus[farther].hasOwnProperty("comForm") && menus[farther].comForm != null) {
                        if (menus[farther].comForm.hasOwnProperty("property0") && menus[farther].comForm.property0 != null) {
                            url = menus[farther].comForm.property0;
                        } else {
                            url = "";
                        }
                    } else {
                        url = "";
                    }
                    inner = " <li><a href='#' onclick = 'showPage(" + '"' + url + '"' + ',"' + menus[farther].menuName + '"' + ',"' + menus[farther].menuId + '"' + ',"' + menus[farther].property0 + '"'
                        + ")' class='menu-dropdown'> <i class='menu-icon " + menus[farther].property0 + "'></i> <span class='menu-text'> " + menus[farther].menuName
                        + " </span> <i class='menu-expand'></i></a><ul class='submenu'>";
                }
                inner += getChildMenu(index, menus);
            }
        }
        if (haschild) {
            inner += " </ul></li>";
        } else {
            if (menus[farther].hasOwnProperty("comForm") && menus[farther].comForm != null) {
                if (menus[farther].comForm.hasOwnProperty("property0") && menus[farther].comForm.property0 != null) {
                    url = menus[farther].comForm.property0;
                } else {
                    url = "";
                }
            } else {
                url = "";
            }
            inner = "<li><a href='#' onclick = 'showPage(" + '"' + url + '"' + ',"' + menus[farther].menuName + '"' + ',"' + menus[farther].menuId + '"' + ',"' + menus[farther].property0 + '"'
                + ")'> <i class='menu-icon " + menus[farther].property0 + "'></i> <span class='menu-text'>" + menus[farther].menuName + "</span></a></li>";
        }

        return inner;
    }

    /**
     * @param url
     * @param name
     * @param id
     * @param icon
     */
    function showPage(url, name, id, icon) {
        if (pageid == id) {
            return;
        }
        pageid = id;
        pageurl = url;
        pagename = name;
        pageicon = icon;
        if (url != "undefined" && url != "") {
            $obj("childePage").src = "${ctx}/viewMain/showPage?url=" + url;
            $obj("childeName").innerHTML = " <span class='" + icon + "' aria-hidden='true'></span> " + name;
        }
    }

    /**
     *
     */
    function refreshPage() {
        if (pageurl != "undefined" && pageurl != "") {
            var localUrl = "${ctx}/viewMain/showPage?url=" + pageurl;

            $obj("childePage").src = localUrl;
            $obj("childeName").innerHTML = " <span class='" + pageicon + "' aria-hidden='true'></span> " + pagename;

        }
    }

    function userSetting() {
        $("#mlSettingTitle").html("用户设置");
        $("#pwo").val("");
        $("#pwn1").val("");
        $("#pwn2").val("");

        $('#modal-setting').modal({
            backdrop: 'static',
            keyboard: true
        });
    }

    /**
     *
     */
    function saveSetting() {
        if ($("#pwo").val() == "" || $("#pwn1").val() == "" || $("#pwn2").val() == "") {
            $("#mwTitle").html("警告");
            $("#mwMessage").html("密码不能为空！");
            $("#modal-warning").modal("show");

            return;
        } else if ($("#pwn1").val() != $("#pwn2").val()) {
            $("#mwTitle").html("警告");
            $("#mwMessage").html("两次新密码不一致！");
            $("#modal-warning").modal("show");

            return;
        } else if ($("#pwo").val().length < 3 || $("#pwn1").val().length < 3) {
            $("#mwTitle").html("警告");
            $("#mwMessage").html("密码长度不能小于3位！");
            $("#modal-warning").modal("show");

            return;
        }

        var url = "${ctx}/viewMainupdatePersonPSW";
        var inf = [
            {
                pswo: $.md5($("#pwo").val()),
                pswn: $("#pwn1").val()
            }
        ];

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
                    $("#mwTitle").html("警告");
                    $("#mwMessage").html(res.message);
                    $("#modal-warning").modal("show");
                } else {
                    $("#msTitle").html("操作成功");
                    $("#msMessage").html("用户密码修改成功！");
                    $("#modal-success").modal("show");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#mwTitle").html("警告");
                $("#mwMessage").html(JSON.stringify(XMLHttpRequest));
                $("#modal-warning").modal("show");
            }
        })

    }

    /**
     *
     */
    function userOff() {
        if (confirm("确定注销当前用户？") == false) {
            return;
        }
        location.href = "/env";
    }

    /**
     *
     */
    function reLoad(url) {
        window.location.href = url;
    }
</script>
</body>
<!--  /Body -->
</html>
