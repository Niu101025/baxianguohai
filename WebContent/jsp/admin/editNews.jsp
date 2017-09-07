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
    <title></title>
    <link rel="stylesheet" href="<%=basePath %>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath %>css/admin.css">
    <script src="<%=basePath %>js/jquery.js"></script>
    <script src="<%=basePath %>js/pintuer.js"></script>
    <%--引入百度富文本编辑工具--%>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.all.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath1%>bddeditor/themes/default/css"/>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加内容</strong>
    </div>
    <div class="body-content">
        <s:form method="post" class="form-x" action="news_save" theme="simple">
            <s:hidden name="newsId" value="%{newsId}"/>
            <s:hidden name="newsTime" value="%{newsTime}"/>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <s:textfield class="input" name="newsTitle" value="%{newsTitle}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>副标题：</label>
                </div>
                <div class="field">
                    <s:textfield class="input" name="newsTitle2" value="%{newsTitle2}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>请选择分类：</label>
                    </div>
                    <div class="field">
                        <s:select name="newsType.newsTypeId" list="list" listKey="newsTypeId" listValue="newsTypeName"
                                  value="%{newsType.newsTypeId}"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>其他属性：</label>
                    </div>
                    <div class="field" style="padding-top: 8px;">
                        是否首页展示 <s:radio name="ishome" list="%{#{'true':'展示','false':'不展示'}}" value="%{ishome}"/>

                    </div>
                </div>
            </if>
            <div class="form-group">
                <div class="label">
                    <label>点击量：</label>
                </div>
                <div class="field">
                    <s:textfield class="input" name="newsClickNum" value="%{newsClickNum}"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <s:textarea id="newsEditor" name="newsContent" value="%{newsContent}"
                                style="height: 800px; border: 1px solid #ddd;"></s:textarea>
                    <script type="text/javascript">
                        UE.getEditor('newsEditor');
                        // var content = UE.getPlainTxt();//content就是编辑器的带格式的内容
                    </script>
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