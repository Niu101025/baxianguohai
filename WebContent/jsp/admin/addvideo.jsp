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
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>css/admin.css">
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/pintuer.js"></script>
    <%--引入百度富文本编辑工具--%>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.all.js"></script>
    <%-- <link rel="stylesheet" type="text/css" href="<%=basePath1%>bdeditor/themes/default/css"/>--%>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <strong><span class="icon-pencil-square-o"></span> 网站信息</strong>
    </div>
    <div class="body-content">
        <s:form method="post" class="form-x" action="video_saveInfo"
                enctype="multipart/form-data" theme="simple">
            <s:hidden name="vodeoId" value="1"/>
            <s:hidden name="videoTime" value=""/>
            <s:hidden name="videoTitle" value=""/>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <s:textarea id="newsEditor" name="videoUrl" value="%{videoUrl}"
                                style="height: 800px; border: 1px solid #ddd;"></s:textarea>
                    <script type="text/javascript">
                        UE.getEditor('newsEditor');
                        // var content = UE.getPlainTxt();//content就是编辑器的带格式的内容
                    </script>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>点击次数：</label>
                </div>
                <div class="field">
                    <s:textfield name="newsClickNum" value="%{newsClickNum}" class="input"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">
                        提交
                    </button>
                </div>
            </div>
        </s:form>
    </div>
</div>
</body>
</html>