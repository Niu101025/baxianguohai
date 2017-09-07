<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel margin-top">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>添加</strong>
		</div>
		<div class="body-content">
			<s:form method="post" class="form-x" action="category_saveCategory"
				theme="simple">
				<div class="form-group">
					<s:hidden name="newsTypeId" value="%{newsTypeId}" />
					<div class="label">
						<label>分类标题：</label>
					</div>
					<div class="field">
						<s:textfield class="input" name="newsTypeName" value="%{newsTypeName}" />
						<div class="tips"></div>
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label>首页展示：</label>
					</div>
					<div class="field" style="padding-top: 8px;">
						是否首页展示 <s:radio name="showHome" list="%{#{'true':'展示','false':'不展示'}}" value="%{showHome}"/>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权重：</label>
					</div>
					<div class="field">
						<s:textfield class="input" name="showWeight" value="%{showWeight}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>