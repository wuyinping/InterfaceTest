<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
  <title>My JSP 'tableaddrow.jsp' starting page</title>
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->
  <script type="text/javascript">
  function tableAddRow(tableName)
  {
   var row = tableName.insertRow(tableName.rows.length);  //行对象
   var i = tableName.rows.length - 2; //table原有的行数
   var col;  //列对象
 
   if(tableName==tableId)
   {
    col = row.insertCell(0);
    col.innerHTML = "<input type='text' size='1' value='123'/>";
    col = row.insertCell(1);
    col.innerHTML = "<input type='text' size='1' />";
    col = row.insertCell(2);
    col.innerHTML = "<input type='text' size='1' />";
    col = row.insertCell(3);
    col.innerHTML = "<input type='text' size='1' />";
   }
  }
  </script>
</head>
<body>
  <input type=button value=增加行 onclick="tableAddRow(tableId);" />

  <table id="tableId">
   <tr bgcolor="#E1F0C4">
    <td>标号</td>
    <td>姓名</td>
    <td>性别</td>
    <td>年龄</td>
   </tr>
  </table>
</body>
</html>