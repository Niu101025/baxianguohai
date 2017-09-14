<%--
  Created by IntelliJ IDEA.
  User: niuhongbin
  Date: 16/12/12
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/jsp/user/";
    String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--<meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>--%>
    <title><s:property value="%{websitename}"/></title>
    <meta name="baidu-site-verification" content="<s:property value="%{verfication}"/>"/>
    <meta content="<s:property value="%{websitename}"/> <s:property value="%{keywords}"/>" name="keywords"/>

    <meta content="<s:property value="%{websitename}"/> <s:property value="%{keywords}"/>" name="description"/>

    <link href="<%=basePath%>css/base.css" rel="stylesheet" type="text/css">

    <link href="<%=basePath%>css/pagename.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.SuperSlide.2.1.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=<s:property value="%{mapkey}"/>"></script>

</head>


<body>
<script src="https://qiyukf.com/script/e1cd14efd075fdfb7d833ce92ace638c.js"></script>

<!--header开始-->

<div class="header">

    <div class="w1000">

        <p style="float: left">你好，欢迎光临<s:property value="%{websitename}"/>！</p>
        <div style="float:right;">
            <a href="#" style="color: #E60013">加入收藏</a>
            <a href="#" style="color: #E60013">联系我们</a>
            <a href="#" style="color: #E60013">加入我们</a>
        </div>

    </div>

</div>


<div class="w1000">

    <div class="header_bottom">

        <%--<s:a href="#"><h1><s:property value="%{websitename}"/></h1></s:a>--%>
        <s:a href="#"><img src="<s:property value="%{logo}"/>" width="72px" height="72px" alt=""></s:a>
        <ul>
            <li>
                <div style="border-radius: 5px 5px 5px 5px; background: #E60013;padding-left: 10px;padding-right: 10px">
                    <%--href="<%=basePath1%>index_findAll.action"--%>
                    <p class="p_header">网站首页</p>
                </div>
            </li>
            <li><a href="<%=basePath1%>index_getAllNewsType.action?newsTypeId=-1">加盟公告</a></li>
            <li><a href="<%=basePath1%>index_findVideo.action">视频中心</a></li>
            <li><a href="<%=basePath1%>index_goInfoDetail.action">品牌简介</a></li>
            <li><a href="<%=basePath1%>index_getAllCate.action?categoryid=-1">饕餮盛宴</a></li>
            <li><a href="<%=basePath1%>index_goLeave.action">联系我们</a></li>
        </ul>

    </div>

</div>


<!--header结束-->
<div class="container">
    <!--banner开始-->
    <div class="banner">
        <div class="bd">
            <ul>
                <li style="background:url(<%=basePath%>images/banner1.jpg) no-repeat center top;   background-size: cover;">
                </li>
                <li style="background:url(<%=basePath%>/images/banner2.jpg) no-repeat center top;  background-size: cover;">
                </li>
                <li style="background:url(<%=basePath%>images/banner3.jpg) no-repeat center top;  background-size: cover;">
                </li>
            </ul>
        </div>
        <div class="hd">
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <a class="prev" href="javascript:void(0)"></a>
        <a class="next" href="javascript:void(0)"></a>
    </div>
    <!--调用JS模块图片滚动-->
    <script type="text/javascript">jQuery(".banner").slide({
        titCell: ".hd ul",
        mainCell: ".bd ul",
        effect: "fold",
        delayTime: 500,
        interTime: 2000,
        autoPlay: true,
        autoPage: true,
        trigger: "click"
    });</script>

    <!--banner结束-->
    <!--content开始-->

    <div class="content clearfix">

        <div class="leftbar mar">
            <div class="left_lx">

                <h1><span>联系方式</span>

                </h1>
                <s:if test="!''.equals(name)">
                    <p>联系人：<s:property value="%{name}"/></p>
                </s:if>
                <s:if test="!''.equals(tel)">
                    <p>电话：<s:property value="%{tel}"/></p>
                </s:if>
                <s:if test="!''.equals(phone)">
                    <p>手机：<s:property value="%{phone}"/></p>
                </s:if>
                <s:if test="!''.equals(qq)">
                    <p>qq: <a target="_blank"
                              href="http://wpa.qq.com/msgrd?v=3&uin=<s:property value="%{qq}"/>&site=qq&menu=yes"><img
                            border="0"
                            src="http://wpa.qq.com/pa?p=2:2047599731:41" alt="点击这里给我发消息"
                            title="点击这里给我发消息"/><s:property
                            value="%{qq}"/></a></p>
                </s:if>
                <s:if test="!''.equals(fax)">
                    <p>传真：<s:property value="%{fax}"/></p>
                </s:if>
                <s:if test="!''.equals(email)">
                    <p>Email：<s:property value="%{email}"/></p>
                </s:if>
                <s:if test="!''.equals(address)">
                    <p>地址：<s:property value="%{address}"/></p>
                </s:if>
                <s:hidden id="jingdu" name="jingdu" value="%{jingdu}"/>
                <s:hidden id="weidu" name="weidu" value="%{weidu}"/>
                <s:if test="!''.equals(youbian)">
                    <p>邮编：<s:property value="%{youbian}"/></p>
                </s:if>
            </div>

            <s:iterator value="showNewsBeans" var="showNews">
                <div class="left_lx left_lx_height">
                    <h1><span><s:property value="#showNews.newsType.newsTypeName"/></span>
                        <span style="float: right; border-bottom-width: 0px;"><a
                                href="<%=basePath1%>index_getAllNewsType1.action?newsTypeId=<s:property
                               value="#showNews.newsType.newsTypeId"/>">查看更多</a></span>
                    </h1>
                    <ul>
                        <s:iterator value="#showNews.newsList" var="news">
                            <li><a href="<%=basePath1%>index_findNews.action?newsId=<s:property
                          value="#news.newsId"/>&newsTypeId=<s:property value="#showNews.newsType.newsTypeId"/>"><s:property
                                    value="#news.newsTitle"/></a></li>
                        </s:iterator>
                    </ul>
                </div>

            </s:iterator>
        </div>


        <ul class="ul_jishu  rightbar ">
            <s:if test="hotProduct.size()>0">
                <li class="fl">
                    <div class="clearfix">
                        <p class="p_tit1">热门小吃</p>
                        <div class="picScroll-left">
                            <div class="hd">
                                <a class="prev" style="margin-top: 90px"><</a>
                                <a class="next" style="margin-top: 90px ">></a>
                            </div>
                            <div class="bd">
                                <ul class="picList">
                                    <s:iterator value="hotProduct" var="h">
                                        <li>
                                            <div class="pic">
                                                <a class="f14 pt10"
                                                   href="<%=basePath1%>index_findProduct.action?pid=<s:property value="#h.pid"/>&categoryid=-1&ishome=true"><img
                                                        src="<s:property value="#h.pimg"/>">
                                                    <s:property value="#h.pname"/>
                                                </a>
                                            </div>
                                        </li>
                                    </s:iterator>
                                </ul>
                            </div>
                            <!--为热销产品模块图片向左滚到-->
                            <script type="text/javascript">
                                jQuery(".picScroll-left").slide({
                                    titCell: ".hd ul",
                                    mainCell: ".bd ul",
                                    autoPage: true,
                                    effect: "leftLoop",
                                    autoPlay: true,
                                    vis:1,
                                    trigger: "click"
                                });
                            </script>
                        </div>
                    </div>

                </li>
            </s:if>


            <li class="fl">
                <p class="p_tit1">门店地址</p>
                <%-- <h1 style="text-align: center;font-size: 14px">门店地址</h1>--%>
                <div id="containers"></div>
                <script type="text/javascript">
                    var map = new BMap.Map("containers");          // 创建地图实例
                    var jingdu = document.getElementById("jingdu").value;
                    var weidu = document.getElementById("weidu").value;
                    var point = new BMap.Point(jingdu, weidu);  // 创建点坐标
                    map.centerAndZoom(point, 11);// 初始化地图，设置中心点坐标和地图级别
                    map.addControl(new BMap.NavigationControl());
                    var marker = new BMap.Marker(point);        // 创建标注
                    map.addOverlay(marker);                     // 将标注添加到地图中
                </script>
            </li>


        </ul>


    </div>
    <div class="content">
        <a href="<%=basePath%>template/introduce.html"></a><br>
        <s:property value="%{infodesc}" escape="false"/>
    </div>
    <!--content 结束-->

</div>

<!--footer开始-->

<div class="footer">
    <p>Copyright &copy; 2016 All Rights Reserved 版权所有 </p>
    <p>地址：<s:property value="%{address}"/></p>
</div>

<!--footer 结束-->

</body>

</html>


