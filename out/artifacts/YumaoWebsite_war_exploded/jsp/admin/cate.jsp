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
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong>
		</div>
		<div class="padding border-bottom">
			<button type="button" class="button border-yellow"
				onclick="window.location.href='<%=basePath%>addcate.jsp'">
				<span class="icon-plus-square-o"></span> 添加分类
			</button>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="5%">ID</th>
				<th width="15%">分类名</th>
				<th width="10%">操作</th>
			</tr>
		<s:iterator value="list" var="d">
		
		<tr>
				<td><s:property value="#d.cid"/></td>
				<td><s:property value="#d.cname"/></td>
				<td><div class="button-group">
						<a class="button border-main" href="<%=basePath1%>category_editCategory?cid=<s:property value="#d.cid"/>"><span
							class="icon-edit"></span> 修改</a> 
							<a class="button border-red"
							href="<%=basePath1%>category_deleteCategory?cid=<s:property value="#d.cid"/>" ><span
							class="icon-trash-o"></span> 删除</a>
					</div></td>
			</tr>
	
</s:iterator>
			
		</table>
	</div>
	<script type="text/javascript">
		function del(id, mid) {
			if (confirm("您确定要删除吗?")) {

			}
		}
	</script>

</body>
</html>