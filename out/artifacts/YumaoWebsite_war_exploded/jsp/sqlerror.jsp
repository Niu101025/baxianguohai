<%--
Created by IntelliJ IDEA.
User: niuhongbin
Date: 16/12/14
Time: 下午9:28
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%--   <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>--%>
    <title>错误页面</title>
    <body>
        <h1>发生错误，错误原因是:<s:property value="%{errorinfo}"/>！</h1>
    </body>
</html>


