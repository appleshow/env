<%--
  Created by IntelliJ IDEA.
  User: liuguanb
  Date: 2017/12/20
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>

<style type="text/css">
    .maskBox {
        position: absolute;
        width: 130px;
        left: 50%;
        height: auto;
        z-index: 100;
        background-color: #fff;
        border: 1px #ddd solid;
        padding: 1px;
    }

    #mask {
        background-color: #666;
        position: absolute;
        z-index: 99;
        left: 0;
        top: 0;
        display: none;
        width: 100%;
        height: 100%;
        opacity: 0.5;
        filter: alpha(opacity=50);
        -moz-opacity: 0.5;
    }
</style>
<div id="__mask"></div>
<div class="maskBox"
     style="display: none">
    <img src="${ctx}/assets-view/comm/css/images/loading.gif"
         alt="数据加载中..."/>
    数据加载中 ...
</div>
<script type="application/javascript">
    /******************************************************************************
     * 显示遮盖层
     *******************************************************************************/
    function __showMask() {
        $("#__mask").css({
            display: "block",
            height: $(document).height()
        });
        var box = $('.maskBox');
        box.css({
            //设置弹出层距离左边的位置
            left: ($("body").width() - box.width()) / 2 - 20 + "px",
            //设置弹出层距离上面的位置
            top: ($(window).height() - box.height()) / 2 + $(window).scrollTop() + "px",
            display: "block"
        });
    }

    /******************************************************************************
     * 隐藏显示遮盖层
     *******************************************************************************/
    function __hideMask() {
        $("#__mask,.maskBox").css("display", "none");
    }
</script>

