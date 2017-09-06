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
<%--
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <!-- add styles -->
    <link rel="stylesheet" href="<%=basePath %>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath %>css/admin.css">
    <link href="<%=basePath %>css/main.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath %>css/jquery.Jcrop.min.css" rel="stylesheet" type="text/css"/>

    <!-- add scripts -->
    <script src="<%=basePath %>js/jquery.Jcrop.min.js"></script>
    <script src="<%=basePath %>js/script.js"></script>
    <script src="<%=basePath %>js/jquery.min.js"></script>
    <script src="<%=basePath %>js/pintuer.js"></script>
    <script src="<%=basePath1 %>ckeditor/ckeditor.js"></script>

</head>
<body>
<div class="panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加内容</strong>
    </div>
    <div class="body-content">
        <s:form method="post" class="form-x" action="product_add" enctype="multipart/form-data" theme="simple"
                onSubmit="return checkForm()">
            <!-- hidden crop params -->
            <input type="hidden" id="x1" name="x1"/>
            <input type="hidden" id="y1" name="y1"/>
            <input type="hidden" id="x2" name="x2"/>
            <input type="hidden" id="y2" name="y2"/>
            <s:hidden name="pid" value=""/>
            <s:hidden name="pimg" value=""/>
            <s:hidden name="ptime" value=""/>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pname"
                    />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" id="myFile" name="myFile" onChange="fileSelectHandler()">
                </div>
            </div>
            <div class="error"></div>

            <div class="step2">
                <h2>请选择需要截图的部位,然后按上传</h2>
                <img id="preview"/>

                <div class="info" hidden>
                    <label hidden>文件大小</label> <input type="text" id="filesize" name="filesize"/>
                    <label hidden>类型</label> <input type="text" id="filetype" name="filetype"/>
                    <label hidden>图像尺寸</label> <input type="text" id="filedim" name="filedim"/>
                    <label hidden>宽度</label> <input type="text" id="w" name="w"/>
                    <label hidden>高度</label> <input type="text" id="h" name="h"/>
                </div>
            </div>

            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>请选择分类：</label>
                    </div>
                    <div class="field">
                        <s:select name="category.cid" list="list" listKey="cid" listValue="cname" headerKey=""
                                  headerValue="--请选择--"/>
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
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="pdesc" style="height: 90px;"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
						<textarea name="pcontent" class="ckeditor"
                                  style="height: 800px; border: 1px solid #ddd;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>点击次数：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="pclicknum" value=""/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input class="button bg-main icon-check-square-o" type="submit">
                        提交
                    </input>
                </div>
            </div>
        </s:form>
    </div>
</div>

</body>
</html>--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>jquery+html5实现图片选取裁剪并上传功能 - psd素材网</title>
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
    <script src="<%=basePath1 %>ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>增加内容</strong>
    </div>
    <div class="body-content">
        <s:form method="post" class="form-x" action="product_add" enctype="multipart/form-data" theme="simple"
        >
            <%-- onSubmit="return checkForm()"--%>
            <!-- hidden crop params -->
            <input type="hidden" id="x1" name="x1"/>
            <input type="hidden" id="y1" name="y1"/>
            <input type="hidden" id="x2" name="x2"/>
            <input type="hidden" id="y2" name="y2"/>
            <s:hidden name="pid" value=""/>
            <s:hidden name="pimg" value=""/>
            <s:hidden name="ptime" value=""/>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="pname"
                    />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片：</label>
                </div>
                <div class="field">
                    <input type="file" id="myFile" name="myFile" onChange="fileSelectHandler()">
                </div>
            </div>
            <div class="error"></div>

            <div class="step2" style="margin-left: 50px">
                <h2>请选择需要截图的部位,然后按上传</h2>
                <img id="preview"/>

                <div class="info">
                    <label>文件大小</label> <input type="text" id="filesize" name="filesize"/>
                    <label>类型</label> <input type="text" id="filetype" name="filetype"/>
                    <label>图像尺寸</label> <input type="text" id="filedim" name="filedim"/>
                    <label>宽度</label> <input type="text" id="w" name="w"/>
                    <label>高度</label> <input type="text" id="h" name="h"/>
                </div>
            </div>

            <if condition="$iscid eq 1">
                <div style="margin-top: 50px" class="form-group">
                    <div class="label">
                        <label>请选择分类：</label>
                    </div>
                    <div class="field">
                        <s:select name="category.cid" list="list" listKey="cid" listValue="cname"
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
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea class="input" name="pdesc" style="height: 90px;"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
						<textarea name="pcontent" class="ckeditor"
                                  style="height: 800px; border: 1px solid #ddd;"></textarea>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>点击次数：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="pclicknum" value=""/>
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
