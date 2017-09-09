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
    <link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath%>css/admin.css">
    <script src="<%=basePath%>js/jquery.js"></script>
    <script src="<%=basePath%>js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder"> 内容列表</strong> <a href=""
                                                           style="float: right; display: none;">添加字段</a>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align: left; padding-left: 20px;">ID</th>
                <th>图片</th>
                <th>名称</th>
                <th>分类名称</th>
                <th width="10%">更新时间</th>
                <th width="310">操作</th>
            </tr>
            <s:iterator value="list" var="p">
                <tr>
                    <td><s:property value="#p.pid"/></td>
                    <td width="10%"><img src="<s:property value="#p.pimg"/>" alt="" width="70"
                                         height="50"/>
                    </td>
                    <td><s:property value="#p.pname"/></td>
                    <td><s:property value="#p.category.cname"/></td>
                    <td><s:date name="#p.ptime" format="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <div class="button-group">
                            <a class="button border-main" href="<%=basePath1%>/product_edit.action?pid=<s:property value="#p.pid"/>"><span
                                    class="icon-edit"></span> 修改</a>
                            <a class="button border-red" href="<%=basePath1%>/product_delete.action?pid=<s:property value="#p.pid"/>"><span
                                class="icon-trash-o"></span> 删除</a>
                        </div>
                    </td>
                </tr>
            </s:iterator>
            <tr>
                <td colspan="8">
                    <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
                    <span>总记录数：<s:property value="totalCount"/>&nbsp;&nbsp;每页显示:<s:property value="pageSize"/></span>&nbsp;&nbsp;
   <span>
	   <s:if test="currPage != 1">
	       <a href="<%=basePath1%>/product_findAll.action?currPage=1"><font color="aqua">[首页]</font></a>&nbsp;&nbsp;
	       <a href="<%=basePath1%>/product_findAll.action?currPage=<s:property value="currPage-1"/>"><font color="aqua">[上一页]</font></a>&nbsp;&nbsp;
	   </s:if>
	   <s:if test="currPage != totalPage">
	       <a href="<%=basePath1%>/product_findAll.action?currPage=<s:property value="currPage+1"/>"><font color="aqua">[下一页]</font></a>&nbsp;&nbsp;
	       <a href="<%=basePath1%>/product_findAll.action?currPage=<s:property value="totalPage"/>"><font color="aqua">[尾页]</font></a>&nbsp;&nbsp;
	   </s:if>
                </td>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    //搜索
    function changesearch() {

    }

    //单个删除
    function del(id, mid, iscid) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    //全选
    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false)
                return false;
            $("#listform").submit();
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");
            return false;
        }
    }

    //批量首页显示
    function changeishome(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量移动
    function changecate(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var i = 0;
            $("input[name='id[]']").each(function () {
                if (this.checked == true) {
                    i++;
                }
            });
            if (i > 1) {
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected", "selected");
            } else {

                $("#listform").submit();
            }
        } else {
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected", "selected");
            return false;
        }
    }
</script>
</body>
</html>