<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
</head>

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

  <div class="container" style="width:30%;">

    <!-- content 正文 -->
    <div class="row">
      <div id="caseRecord" class="col-md-6">
  		<h2>项目维护</h2>
	  </div>
	  
	  <br>
	  <br>
	  <br>
	  
	    <div>
		<form accept-charset="UTF-8" action="<%=basePath%>saveProject" class="new_post" data-remote="true" id="new_post" method="post"><div style="display:none"></div>
			<div class="field">
    		<input class="form-control" id="post_pId" name="post_pId" type="hidden" value="<%=request.getParameter("pid") %>"> 
  			</div>
  			
  			<br>
			
			<div class="field">
    		<label for="post_pName">项目名称：</label><br>
    		<input class="form-control" id="post_pName" name="post_pName" type="text" value="<%=request.getParameter("pname") %>">
  			</div>
  			
  			<br>
  			
  			<div class="field">
    		<label for="post_pKey">项目加密key：</label><br>
    		<input class="form-control" id="post_pKey" name="post_pKey" type="text" value="<%=request.getParameter("pkey") %>">
  			</div>
		
			<br>
			
			<div style="padding-left:20px;">
  			<input class="btn btn-primary" name="commit" type="submit" value="保存"></input>
  			</div>
  		</form>
		</div>
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

  </div>

</body></html>
