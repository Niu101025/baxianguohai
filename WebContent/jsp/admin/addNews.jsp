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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- add styles -->
    <link href="<%=basePath%>css/main.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>css/jquery.Jcrop.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath %>css/pintuer.css" rel="stylesheet"/>
    <link href="<%=basePath %>css/admin.css" rel="stylesheet"/>
    <!-- add scripts -->
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/jquery.Jcrop.min.js"></script>
    <script src="<%=basePath%>js/script.js"></script>
    <script src="<%=basePath %>js/pintuer.js"></script>
    <%--引入百度富文本编辑工具--%>
    <!-- 配置文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="<%=basePath1%>bdeditor/ueditor.all.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath1%>bddeditor/themes/default/css"/>

</head>
<body>
<div class="panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加内容</strong>
    </div>
    <div class="body-content">
        <s:form method="post" class="form-x" action="news_add" theme="simple">

        <s:hidden name="newsId" value=""/>
        <s:hidden name="newsTime" value=""/>
        <div class="form-group">
            <div class="label">
                <label>标题：</label>
            </div>
            <div class="field">
                <input type="text" class="input w50" value="" name="newsTitle"
                />
                <div class="tips"></div>
            </div>
        </div>
        <div class="form-group">
            <div class="label">
                <label>副标题：</label>
            </div>
            <div class="field">
                <input type="text" class="input w50" value="" name="newsTitle2"
                />
                <div class="tips"></div>
            </div>
        </div>

        <if condition="$iscid eq 1">
            <div style="margin-top: 50px" class="form-group">
                <div class="label">
                    <label>请选择分类：</label>
                </div>
                <div class="field">

                    <s:select name="newsType.newsTypeId" list="list" listKey="newsTypeId" listValue="newsTypeName"
                    />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field" style="padding-top: 8px;">
                    是否首页展示 <s:radio name="ishome" list="%{#{'true':'展示','false':'不展示'}}" value="false"/>

                </div>
            </div>
        </if>

        <div class="form-group">
            <div class="label">
                <label>内容：</label>
            </div>
            <div class="field">
                <div class="field">
                    <s:textarea id="newsEditor" name="newsContent"
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
                    <input type="text" class="input w50" name="newsClickNum" value=""/>
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
