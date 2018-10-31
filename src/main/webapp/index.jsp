<%@ page import="cn.demo.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: amos
  Date: 2018/10/31
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<!--
  <a href="addCustomer.do">add</a>
  <br><br>

  <a href="delete.do">delete</a>
  <br><br>

  <a href="update.do">update</a>
  <br><br>
  -->
<form method="post" action="query.do">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="query"></td>
            <td><a href="add.do">Add a New Customer</a></td>
        </tr>
    </table>

    <%
        List<Customer> customers = (List<Customer>) request.getAttribute("customers");
        if (customers != null && customers.size() != 0) {
    %>
    <hr>
    <br>
    <table border="1" cellpadding="10" cellspacing="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ADDRESS</th>
            <th>PHONE</th>
            <th colspan="2">OPERATE</th>
        </tr>
        <%
            for (Customer c : customers) {
        %>
        <tr>
            <td><%=c.getId()%>
            </td>
            <td><%=c.getName()%>
            </td>
            <td><%=c.getAddress()%>
            </td>
            <td><%=c.getPhone()%>
            </td>
            <td>
                <a href="edit.do">EDIT</a>
            </td>
            <td>
                <a href="delete.do">DELETE</a>
            </td>
        </tr>

        <%
            }
        %>
    </table>
    <%
        }
    %>


</form>


</body>
</html>
