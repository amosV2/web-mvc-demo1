<%@ page import="cn.demo.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: amos
  Date: 2018/10/31
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>update</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script>
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
        <%=request.getAttribute("error_msg") == null ? "" : request.getAttribute("error_msg")%>
    </span>
<%
    String address = null;
    String name = null;
    String phone = null;
    String id = null;
    String oldName = null;
    Customer customer = (Customer) request.getAttribute("customer");
    if (customer != null) {
        address = customer.getAddress();
        name = customer.getName();
        phone = customer.getPhone();
        id = customer.getId() + "";
        oldName = customer.getName();
    }else {
    	id = request.getParameter("id");
        name = request.getParameter("name");
        phone = request.getParameter("phone");
        address = request.getParameter("address");
        oldName = request.getParameter("oldName");
    }
%>
<form method="post" action="update.do">
    <input type="hidden" name="id" value="<%=id %>">
    <input type="hidden" name="oldName" value="<%=oldName %>">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=name %>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%=address %>"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" value="<%=phone %>"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
            <%--<td><a href="add.do">Add a New Customer</a></td>--%>
        </tr>
    </table>

</form>


</body>
</html>
