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
    <%--  <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>--%>
    <title><s:property value="%{websitename}"/></title>
    <meta name="baidu-site-verification" content="<s:property value="%{verfication}"/>"/>
    <meta content="<s:property value="%{websitename}"/> <s:property value="%{keywords}"/>" name="keywords"/>

    <meta content="<s:property value="%{websitename}"/> <s:property value="%{keywords}"/>" name="description"/>

    <link href="<%=basePath%>css/base.css" rel="stylesheet" type="text/css">

    <link href="<%=basePath%>css/pagename.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>css/video-js.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/video.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.SuperSlide.2.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery.masonry.min.js"></script>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=<s:property value="%{mapkey}"/>"></script>

</head>


<body>
<script src="https://qiyukf.com/script/e1cd14efd075fdfb7d833ce92ace638c.js"></script>
<!--header开始-->

<div class="header">

    <div class="w1000">

        <p>你好，欢迎光临<s:property value="%{websitename}"/>！</p>

    </div>

</div>


<div class="w1000">

    <div class="header_bottom">

        <%--<s:a href="#"><h1><s:property value="%{websitename}"/></h1></s:a>--%>
        <s:a href="#"><img src="<s:property value="%{logo}"/>" width="72px" height="72px" alt=""></s:a>
        <ul>
            <li><a href="<%=basePath1%>index_findAll.action">网站首页</a></li>
            <li>
                <div style="border-radius: 5px 5px 5px 5px; background: #E60013;padding-left: 10px;padding-right: 10px">
                    <%--href="<%=basePath1%>index_findAll.action"--%>
                    <p class="p_header">加盟公告</p>
                </div>
            </li>
            <li><a href="<%=basePath1%>index_findVideo.action">视频中心</a></li>
            <li><a href="<%=basePath1%>index_goInfoDetail.action">品牌简介</a></li>
            <li><a href="<%=basePath1%>index_getAllCate.action?categoryid=-1">饕餮盛宴</a></li>
            <li><a href="<%=basePath1%>index_goLeave.action">联系我们</a></li>
        </ul>
    </div>

</div>


<!--header结束-->


<div class="container">

    <!--content开始-->

    <div class="content clearfix">


        <%-- <p class="p_tit1">关于迎辉羽毛</p>--%>

        <div class="leftbar mar">

            <div class="leftnav">

                <h1>所有种类</h1>

                <ul class="ul_left">

                    <s:iterator value="allNewsType" var="n">
                        <s:if test="#n.newsTypeId==newsTypeId">
                            <li><h3><a style="color: red"
                                       href="<%=basePath1%>index_getAllNewsType1.action?newsTypeId=<s:property
                               value="#n.newsTypeId"/>"><s:property
                                    value="#n.newsTypeName"/></a></h3>

                            </li>

                        </s:if>
                        <s:else>
                            <li><h3><a
                                    href="<%=basePath1%>index_getAllNewsType1.action?newsTypeId=<s:property
                               value="#n.newsTypeId"/>"><s:property
                                    value="#n.newsTypeName"/></a></h3>

                            </li>
                        </s:else>

                    </s:iterator>


                </ul>


            </div>
            <div class="left_lx">

                <h1>联系方式</h1>
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
            <div class="left_lx mar">
                <h1>地图</h1>
                <div id="containers"></div>
                <script type="text/javascript">
                    var map = new BMap.Map("containers");          // 创建地图实例
                    var jingdu = document.getElementById("jingdu").value;
                    var weidu = document.getElementById("weidu").value;
                    var point = new BMap.Point(jingdu, weidu);  // 创建点坐标
                    map.centerAndZoom(point, 13);// 初始化地图，设置中心点坐标和地图级别
                    map.addControl(new BMap.NavigationControl());
                    var marker = new BMap.Marker(point);        // 创建标注
                    map.addOverlay(marker);                     // 将标注添加到地图中
                </script>
            </div>
        </div>

        <div class="rightbar  mar newsDiv">


            <ul>
                <s:iterator value="allNews" var="n">
                    <li>
                        <a href="<%=basePath1%>index_findNews.action?newsId=<s:property
                          value="#n.newsId"/>&newsTypeId=<s:property value="#n.newsType.newsTypeId"/>">
                            <span><s:property value="#n.newsTitle"/></span>
                        </a>
                    </li>
                </s:iterator>

            </ul>
            <div class="paging"></div>

        </div>


    </div>

    <!--content 结束-->

</div>

<!--footer开始-->

<div class="footer">
    <p>Copyright &copy; 2016 All Rights Reserved 版权所有 </p>
    <p>地址：<s:property value="%{address}"/></p>

</div>

<!--footer 结束-->

<!--footer 结束-->
<script type="text/javascript">
    $(function () {
        var $container = $('#masonry');
        $container.imagesLoaded(function () {
            $container.masonry({
                itemSelector: '.box',
            });
        });
    });
</script>

</body>

</html>

