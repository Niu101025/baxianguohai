<%--
  Created by IntelliJ IDEA.
  User: niuhongbin
  Date: 16/12/15
  Time: 上午1:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="<%=basePath %>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath %>css/admin.css">
    <script src="<%=basePath %>js/jquery.js"></script>
    <script src="<%=basePath %>js/pintuer.js"></script>
</head>
<body>
<form method="post" action="">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 留言管理</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th width="120">ID</th>
                <th>姓名</th>
                <th>电话</th>
                <th>qq</th>
                <th width="25%">内容</th>
                <th>操作</th>
            </tr>
            <s:iterator value="leaveList" var="l">
                <tr>
                    <td><s:property value="#l.lid"/></td>
                    <td><s:property value="#l.lname"/></td>
                    <td><s:property value="#l.ltel"/></td>
                    <td><s:property value="#l.lqq"/></td>
                    <td><s:property value="#l.lcontent"/></td>
                    <td>
                        <div class="button-group"><a class="button border-red"
                                                     href="<%=basePath1%>leave_deleteLeave?lid=<s:property value="#l.lid"/>"
                        ><span class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>
            </s:iterator>

        </table>
    </div>
</form>
<script type="text/javascript">

    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            }
            else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
        }
        else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

</script>
</body>
</html>
