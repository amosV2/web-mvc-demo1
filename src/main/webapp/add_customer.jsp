<%@ page import="cn.demo.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: amos
  Date: 2018/10/31
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>add</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script>
        // $(function(){
        //     $(".delete").click(function(){
        //         var content = $(this).parent().parent().find("td:eq(1)").text();
        //         var flag = confirm("确定要是删除" + content + "的信息吗?");
        //         return flag;
        //     });
        // });
        $(function () {
           $(".delete").click(function () {
               var content = $(this).parent().parent().find("td:eq(1)").text();
               var flag = confirm("确定要删除" + content + "吗？");
               return flag;
           });
        });

    </script>

</head>
<body>
    <span style="color: red">
        <%=request.getAttribute("error_msg")==null?"":request.getAttribute("error_msg")%>
    </span>
<form method="post" action="add.do">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=request.getParameter("name")==null?"": request.getParameter("name")%>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%=request.getParameter("address")==null?"": request.getParameter("address")%>"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%=request.getParameter("phone")==null?"": request.getParameter("phone")%>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
            <%--<td><a href="add.do">Add a New Customer</a></td>--%>
        </tr>
    </table>

</form>


</body>
</html>
