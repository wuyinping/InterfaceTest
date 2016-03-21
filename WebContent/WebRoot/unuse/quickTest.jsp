<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="com.baidu.mgame.interfacetest.utils.*" %>
<%@ page language="java" import="java.net.*" %>
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mgame_apiTest</title>
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/twitter-bootstrap-static/bootstrap.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/twitter-bootstrap-static/fontawesome.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/bootstrap_and_overrides.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/common.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/gets.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/posts.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/welcome.css?body=1" media="all" rel="stylesheet">
<link data-turbolinks-track="true" href="http://10.11.0.59:3000/assets/application.css?body=1" media="all" rel="stylesheet">
  <script data-turbolinks-track="true" src="http://10.11.0.59:3000/assets/Mgame_apiTest_files/jquery.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/jquery_ujs.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/transition.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/alert.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/modal.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/dropdown.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/scrollspy.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/tab.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/tooltip.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/popover.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/button.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/collapse.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/carousel.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/affix.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/bootstrap.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/turbolinks.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/bootstrap(1).js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/common.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/gets.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/posts.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/welcome.js"></script>
<script data-turbolinks-track="true" src="./Mgame_apiTest_files/application.js"></script>
<meta content="authenticity_token" name="csrf-param">
<meta content="qWLJkSG8HZHE5ZsWngYKWoAgb3x4KQvNU0i7BUVqyhs=" name="csrf-token">

<script src="js/c.js" type="text/javascript"></script>
<link href="js/s.css" type="text/css" rel="stylesheet"></link>
</head>
<%
	String error = "";

	String url = request.getParameter("post_url") == null ? ""
			: request.getParameter("post_url");
	String tag = request.getParameter("post_title") == null ? ""
			: request.getParameter("post_title");
	String post_data = request.getParameter("post_data") == null ? ""
			: request.getParameter("post_data");
	String des_type = request.getParameter("des_type") == null ? "1"
			: request.getParameter("des_type");
	String result = "";

	int type = Integer.parseInt(des_type);
	try {
		String sKey = "AKlMU89D3FchIkhK";
		AES myaes = null;
		out.println("");
		//不加密
		if (type == 2) {
			myaes = new AES(sKey, true);
		}
		String param = null != myaes ? myaes.aesEncrypt(post_data
				.trim()) : URLEncoder.encode(post_data.trim(), "UTF-8");
		String sr = HttpUtil.http(url, param);
		result = null != myaes ? myaes.aesDecrypt(sr) : URLDecoder
				.decode(sr, "UTF-8");
		if (!"".equals(result)) {
			result = JsonFormatTool.formatJson(result.trim(), "");
		}

	} catch (Exception e) {
		error = e.toString();
	}
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
        <a class="navbar-brand" style="color: white;" >单机SDK2.0 H5接口测试工具</a>
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

  <div class="container">

    <!-- content 正文 -->
    <div class="row">
      <div id="caseRecord" class="col-md-6">
  <h2>填加测试用例</h2>
  <form accept-charset="UTF-8" action="index.jsp" class="new_post" data-remote="true" id="new_post" method="post"><div style="display:none">
  
  <input name="utf8" type="hidden" value="✓"></div>

  <div class="field">
    <label for="post_用例标题">用例标题TAG号：</label><br>
    <input class="form-control" id="post_title" name="post_title" type="text" value ="<%=tag%>">
  </div>
  <div class="field">
    <label for="post_项目">项目</label><br>
    <select id="project" name="project"><option value="1">单机SDK</option>
</select>
  </div>
  <div>
    <label for="post_网址">网址</label><br>
    <input class="form-control" id="post_url" name="post_url" type="text" value ="<%=url%>"/>
  </div>
  
  <div>
	<input name="des_type" type="radio" value="1" <%if(type ==1){%>checked<%}%>>不加密</input>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input name="des_type" type="radio" value="2" <%if(type ==2){%>checked<%}%>>加密</input>
  </div>
  
  
  <div>
    <label for="post_数据">上行参数</label><br>
    <textarea class="form-control" id="post_data" name="post_data" rows="10" ><%=post_data%></textarea>
  </div>
  <div>
  
  </div>
  <br/>
  <div>
  <input class="btn btn-primary" name="commit" type="submit" value="获取数据"></input>
  <input class="btn btn-success" name="reset" type="reset" value="清空"></input>
  </div>
  
</form>
</div>

 <div id="getData" class="col-md-6">
  <h2>获取数据</h2>

<div>
      期望结果
  <per>
   <textarea id="RawJson"  name="RawJson" rows="15" style="width: 500px;height: 400px;overflow-y:visible "><%=result%> </textarea>
  </per>
  <div id="ControlsRow">
  <input type="Button" value="格式化" onclick="Process()"/>
  <span id="TabSizeHolder">
    缩进量
    <select id="TabSize" onchange="TabSizeChanged()">
      <option value="3" selected="true">3</option>
    </select >
  </span>
  <label for="QuoteKeys">
    <input type="checkbox" id="QuoteKeys" onclick="QuoteKeysClicked()" checked="true" /> 
    引号
  </label>&nbsp; 
  <a href="javascript:void(0);" onclick="SelectAllClicked()">全选</a>
  &nbsp;
  <span id="CollapsibleViewHolder" >
      <label for="CollapsibleView">
        <input type="checkbox" id="CollapsibleView" onclick="CollapsibleViewClicked()" checked="true" /> 
        显示控制
      </label>
  </span>
  <span id="CollapsibleViewDetail">
    <a href="javascript:void(0);" onclick="ExpandAllClicked()">展开</a>
    <a href="javascript:void(0);" onclick="CollapseAllClicked()">叠起</a>
  </span>
</div>
  </div>
  
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
    <footer class="text-center">
      <p class="btn btn-default"><i class="fa fa-heart-o"></i>Standalone by Technology<i class="fa fa-heart-o"></i>      </p>
    </footer>

  </div> <!-- /container -->



<div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 1103px; top: 463px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>
