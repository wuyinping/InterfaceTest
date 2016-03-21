<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page language="java" import="com.baidu.mgame.interfacetest.utils.*" %>
<%@ page language="java" import="com.baidu.mgame.interfacetest.entity.*" %>
<%@ page language="java" import="com.baidu.mgame.interfacetest.vo.*" %>
<%@ page language="java" import="java.net.*" %>

<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mgame_InterfaceTest</title>
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/twitter-bootstrap-static/bootstrap.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/twitter-bootstrap-static/fontawesome.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/bootstrap_and_overrides.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/common.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/gets.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/posts.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/welcome.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/application.css?body=1" media="all" rel="stylesheet">
<script data-turbolinks-track="true" src="http://10.11.0.59:3000/assets/Mgame_apiTest_files/jquery.js"></script>

<meta content="authenticity_token" name="csrf-param">
<meta content="qWLJkSG8HZHE5ZsWngYKWoAgb3x4KQvNU0i7BUVqyhs=" name="csrf-token">

<script src="js/c.js" type="text/javascript"></script>
<link href="js/s.css" type="text/css" rel="stylesheet"></link>

<script type="text/javascript">
  function tableAddRow()
  {
   var row = versionTable.insertRow(versionTable.rows.length);  //行对象
   var i = versionTable.rows.length - 2; //table原有的行数
   var col;  //列对象
 
    col = row.insertCell(0);
    col.align="center";
    col.innerHTML = "<input class='form-control' id='urlName0' name='urlName0' type='text' width='200'/>";
    
    col = row.insertCell(1);
    col.align="center";
    col.innerHTML = "<input class='form-control' id='baseUrl0' name='baseUrl0' type='text' width='200'/>";
    
    col = row.insertCell(2);
    col.align="center";
    
    col = row.insertCell(3);
    col.align="center";
    col.innerHTML = "<a href='#' onclick='tableDeleteRow(this.parentElement.parentElement.rowIndex);' >删除</a>";
  }
  
  function tableDeleteRow (rowIndex)  
  {
    versionTable.deleteRow(rowIndex);
  }   
  </script>
  
</head>

<%
	//获得初始化页面的所有参数
	UpdateProjectEnvResponse resp = (UpdateProjectEnvResponse)request.getAttribute("response");
	ProjectMain pm = resp.getProject();
	List<ProjectUrl> puList = resp.getProjectUrlList();
%>


<body>
<!-- navigate bar 导航 -->
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" style="color: white;" >接口自动化测试工具</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <!-- 
        <ul class="nav navbar-nav">
          <li class="active"><a href="http://10.11.0.59:3000/">主页</a></li>
          <li><a href="http://10.11.0.59:3000/gets">Get用例列表</a></li>
          <li><a href="http://10.11.0.59:3000/gets/new">新建Get用例</a></li>
          <li><a href="http://10.11.0.59:3000/posts">Post用例列表</a></li>
          <li><a href="./Mgame_apiTest_files/Mgame_apiTest.html">新建Post用例</a></li>
        </ul>
         -->
        <!-- sign in and sign up 登陆和注册 -->

      </div><!--/.navbar-collapse -->
    </div><!-- /.container -->
  </nav>

  <div class="container" style="width:75%;">

    <!-- content 正文 -->
    <div class="row">
      <div id="caseRecord" class="col-md-6">
  		<h2>项目环境维护</h2>
	  </div>
	  
	  <br>
	  <br>
	  <br>
	  
	  <form accept-charset="UTF-8" action="<%=basePath%>saveProjectEnv" class="new_post" data-remote="true" id="new_post" method="post"><div style="display:none"></div>
	  		<div class="field">
    		<input class="form-control" id="post_pId" name="post_pId" type="hidden" width="200" value="<%=pm.getId() %>"> 
  			</div>
  			
  			<br>
			
			<table id="pTable" border="" >
			<tr>
			<td width="200" align="center" bgcolor="#BE77FF"><h4><strong>项目名称：</strong></h4></td>
    		<td width="200" align="center" bgcolor="#BE77FF"><h4><strong><%=pm.getP_name() %></strong></h4></td>
  			</tr>
  			</table>
  			
  			<br>
	  
	  <table id="versionTable" class="table1" border="1">
		<tr>
		<td width="200" align="center"><h4><strong>环境名称<br> </strong></h4></td>
		<td width="400" align="center"><h4><strong>环境地址<br> </strong></h4></td>
		<td width="200" align="center"><h4><strong>修改时间<br> </strong></h4></td>
		<td width="200" align="center"><h4><strong>删除<br> </strong></h4></td>
		</tr>
		
		<%
			if(null != puList && puList.size()>0){
				for(ProjectUrl pu : puList){
					String uName = pu.getUrl_name();
					String url = pu.getBase_url();
					Integer uid = pu.getId();
					String mtime = TimeUtil.dateFormat(pu.getMtime());
					
			    	
			    	//动态添加行
			    	%>
			    	<tr>
			    	<td align="center"><h5><input class="form-control" id="urlName<%=uid %>" name="urlName<%=uid %>" type="text" width="200" value="<%=uName %>"></h5></td>
			    	<td align="center"><h5><input class="form-control" id="baseUrl<%=uid %>" name="baseUrl<%=uid %>" type="text" width="200" value="<%=url %>"></h5></td>
			    	<td align="center"><h5><%=mtime %></h5></td>
			    	<td align="center"><h5><a href="<%=basePath%>deleteProjectEnv?uid=<%=uid %>&pid=<%=pm.getId() %>">删除</a></h5></td>
			    	</tr>
			    	<%
				}
			}
		%>
		</table>
		
		<br>
		
		<div style="padding-left:20px;">
		<input class="btn btn-success" name="new" type="button" onclick="tableAddRow();" value="新增环境"></input>
  		&nbsp;&nbsp;
  		<input class="btn btn-primary" name="commit" type="submit" value="保存环境"></input>
  		</div>
  		</form>

</div>

    <hr>
    
    <!--json- -->
    <div class="HeadersRow">
 
</div>

<div id="Canvas" class="Canvas"></div>
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript"></script>
<script type="text/javascript" src="js/m.js"></script>
    
    
    
    
    <!-- footer -->
    <footer class="text-center" style="display:none;">
      <p class="btn btn-default"><i class="fa fa-heart-o"></i>Mgame_InterfaceTest<i class="fa fa-heart-o"></i>      </p>
    </footer>

  </div> <!-- /container -->



<div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 1103px; top: 463px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>
