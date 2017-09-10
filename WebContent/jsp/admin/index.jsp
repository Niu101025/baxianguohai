<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/jsp/admin/";
    String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>css/admin.css">
    <script src="<%=basePath%>js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1>
            <img src="<%=basePath%>images/y.jpg"
                 class="radius-circle rotate-hover" height="50" alt=""/>后台管理中心
        </h1>
    </div>
    <div class="head-l">
        <a class="button button-little bg-green" href="" target="_blank"><span
                class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##"
                                                                  class="button button-little bg-blue"><span
            class="icon-wrench"></span>
        清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red"
                                href="<%=basePath%>login.jsp"><span class="icon-power-off"></span>
        退出登录</a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title">
        <strong><span class="icon-list"></span>菜单列表</strong>
    </div>
    <h2>
        <span class="icon-user"></span>基本设置
    </h2>
    <ul style="display: block">
        <li><a href="<%=basePath1%>info_findInfo.action" target="right"><span
                class="icon-caret-right"></span>网站设置</a></li>
        <li><a href="<%=basePath%>pass.jsp" target="right"><span
                class="icon-caret-right"></span>修改密码</a></li>
        <li><a href="<%=basePath%>leave_loadAllLeave.action" target="right"><span
                class="icon-caret-right"></span>留言管理</a></li>
    </ul>
    <h2>
        <span class="icon-pencil-square-o"></span>产品管理
    </h2>
    <ul style="display: block">
        <li><a href="<%=basePath1%>category_findAllCategory.action" target="right"><span
                class="icon-caret-right"></span>分类管理</a></li>
        <li><a href="<%=basePath%>/addcate.jsp" target="right"><span
                class="icon-caret-right"></span>添加分类</a></li>
        <li><a href="<%=basePath1%>product_findAllProduct.action" target="right"><span
                class="icon-caret-right"></span>内容管理</a></li>
        <li><a href="<%=basePath1%>/category_findAll.action" target="right"><span
                class="icon-caret-right"></span>添加内容</a></li>
    </ul>
    <h2>
        <span class="icon-pencil-square-o"></span>发布管理
    </h2>
    <ul style="display: block">
        <li><a href="<%=basePath1%>newsType_findAllNewsType.action" target="right"><span
                class="icon-caret-right"></span>新闻类型管理</a></li>
        <li><a href="<%=basePath%>/addnewtype.jsp" target="right"><span
                class="icon-caret-right"></span>添加新闻分类</a></li>
        <li><a href="<%=basePath1%>news_findAllNews.action" target="right"><span
                class="icon-caret-right"></span>新闻管理</a></li>
        <li><a href="<%=basePath1%>/newsType_findAll.action" target="right"><span
                class="icon-caret-right"></span>添加新闻</a></li>
    </ul>
    <h2>
        <span class="icon-pencil-square-o"></span>视频管理
    </h2>
    <ul style="display: block">
        <li><a href="<%=basePath1%>video_findVideo.action" target="right"><span
                class="icon-caret-right"></span>添加视频</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<div class="admin">
    <iframe scrolling="auto" rameborder="0"
            src="<%=basePath1%>info_findInfo.action" name="right" width="100%"
            height="100%"></iframe>
</div>
<div style="text-align: center;"></div>
</body>
</html>