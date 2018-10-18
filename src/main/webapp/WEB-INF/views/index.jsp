<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/11/8
  Time: 22:14
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
    <title>系统登入</title>
    <!-- CSS -->
    <link rel="stylesheet"
          href="${ctx}/assets-view/login/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/login/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/login/css/form-elements.css">
    <link rel="stylesheet"
          href="${ctx}/assets-view/login/css/style.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon"
          href="${ctx}/assets-view/login/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          sizes="144x144"
          href="${ctx}/assets-view/login/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          sizes="114x114"
          href="${ctx}/assets-view/login/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          sizes="72x72"
          href="${ctx}/assets-view/login/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="${ctx}/assets-view/login/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1>
                        <strong>环境监测设备与数据</strong> 管理系统
                    </h1>
                    <div class="description">
                        <p>
                            <!--    <a href="http://www.grasun-opt.com/" target="_black">XXXXXXXX公司</a> -->
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <p>欢迎使用</p>
                            <h3>
                                <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请登入</b>
                            </h3>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form"
                              action="main"
                              method="post"
                              class="login-form">
                            <div class="form-group">
                                <label class="sr-only"
                                       for="form-username">用户名</label>
                                <input type="text"
                                       name="userId"
                                       placeholder="用户名称"
                                       class="form-username form-control"
                                       id="form-username">
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-lg-6 col-sm-12 col-xs-12">
                                        <label class="sr-only"
                                               for="form-password">密 码</label>
                                        <input type="password"
                                               name="password"
                                               placeholder="用户密码"
                                               class="form-password form-control"
                                               id="form-password">
                                    </div>
                                    <div class="col-lg-6 col-sm-12 col-xs-12">
                                        <div class="row">
                                            <div class="col-lg-6 col-sm-12 col-xs-12"
                                                 style="padding-left: 0px; padding-right: 0px;">
                                                <input type="text"
                                                       name="verification"
                                                       placeholder="验证码"
                                                       class="form-password form-control"
                                                       id="form-verification">
                                            </div>
                                            <div class="col-lg-6 col-sm-12 col-xs-12"
                                                 style="padding-left: 0px;">
                                                <img src=""
                                                     onclick="drawVerification();"
                                                     id="verificationImg"
                                                     style="cursor: pointer; height: 50px; width: 100%">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit"
                                    class="btn">登 入
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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

<!-- Javascript -->
<script src="${ctx}/assets-view/login/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/assets-view/login/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/assets-view/login/js/jquery.backstretch.min.js"></script>
<script src="${ctx}/assets/js/md5.js"></script>
<!--[if lt IE 10]>
<script src="${ctx}/assets-view/login/js/placeholder.js"></script>
<![endif]-->

<script type="text/javascript">
    jQuery(document).ready(function () {

        /*
         * Fullscreen background
         */
        $.backstretch("assets-view/login/img/backgrounds/1.jpg");

        $('#form-username').focus().select();

        /*
         * Form validation
         */
        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
            $(this).removeClass('input-error');
        });

        $('.login-form').on('submit', function (e) {
            var login = true;

            $(this).find('input[type="text"], input[type="password"], textarea').each(function () {
                if ($(this).val() == "") {
                    login = false;
                    e.preventDefault();
                    $(this).addClass('input-error');
                } else {
                    $(this).removeClass('input-error');
                }
            });

            if (login) {
                var elePasswd = $("input[name=password]");
                var passwd = elePasswd.val();
                elePasswd.val($.md5($.md5(passwd) + $("input[name=verification]").val()));
            }

        });

        // load verification image
        drawVerification();
        if ('${verification}' == "1") {
            callError(-900, "验证码录入有误...！");
        } else if ('${verification}' == "2") {
            callError(-900, "录入用户名不存在...！");
        } else if ('${verification}' == "3") {
            callError(-900, "录入密码错误...！");
        }

    });

    function drawVerification() {
        $.ajax({
            async: false,
            type: "POST",
            url: "perVerificationImg",
            cache: true,
            success: function (res) {
                $("#verificationImg").attr("src", res.imgData);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest)
            }
        });
    }

    /**
     * @param code
     * @param message
     * @returns
     */
    function callError(code, message) {
        $("#mwTitle").html('<span class="glyphicon glyphicon-bullhorn" aria-hidden="true">&nbsp;提示</span>');
        $("#mwMessage").html(message);
        $("#modal-warning").modal("show");
    }

    $('#form-username').keydown(function (e) {
        if (e.keyCode == 13) {
            if ($('#form-username').val() != "") {
                $('#form-password').focus().select();
            }
        }
    });

    $('#form-password').keydown(function (e) {
        if (e.keyCode == 13) {
            if ($('#form-password').val() != "" && $('#form-username').val() != "") {
                $('#form-verification').focus().select();
                $('#login').click();
            }
        }
    });

    $('#form-verification').keydown(function (e) {
        if (e.keyCode == 13) {
            $('#login').click();
        }
    });

</script>
</body>
</html>
