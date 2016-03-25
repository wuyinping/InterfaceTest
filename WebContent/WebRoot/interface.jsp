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
</head>

<%
    //获得初始化页面的所有参数
    ProjectViewResponse resp = (ProjectViewResponse)request.getAttribute("response");
    List<ProjectMain> pList = resp.getProjects();
    Map<Integer, List<ProjectUrl>> puMap = resp.getProjectUrls();
    Map<Integer, List<ProjectVersion>> pvMap = resp.getProjectVersions();
    Map<>
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

<div class="container">

    <!-- content 正文 -->
    <div class="row">
        <div id="caseRecord" class="col-md-6">
            <h2>接口信息浏览</h2>
        </div>
        <table width="1200" id="projectTable" class="table1" border="1">
            <tr>
                <td width="120" align="center"><h4><strong>项目名称<br> </strong></h4></td>
            </tr>
        </table>>
        <table width="1200" id="projectTable" class="table1" border="1">
            <tr>

                <td width="140" align="center"><h4><strong>版本<br> </strong></h4></td>
                <td width="150" align="center"><h4><strong>接口名称<br> </strong></h4></td>
                <td width="100" align="center"><h4><strong>接口描述<br> </strong></h4></td>
                <td width="80" align="center"><h4><strong>上行参数<br> </strong></h4></td>
                <td width="80" align="center"><h4><strong>下行参数<br> </strong></h4></td>
                <td width="300" align="center"><h4><strong>环境信息<br> </strong></h4></td>
                <td width="300" align="center">
                    <a href="#"><h4><strong>修改<br> </strong></h4></a>
                    <a href="#"><h4><strong>删除<br> </strong></h4></a>
                </td>

            </tr>

            <%
                if(null != pList && pList.size()>0){
                    for(ProjectMain pm : pList){
                        Integer pid = pm.getId();
                        String pName = pm.getP_name();
                        String pKey = pm.getP_key();
                        String pTime = TimeUtil.dateFormat(pm.getMtime());

                        StringBuilder sb1 = new StringBuilder();
                        List<ProjectUrl> puList = puMap.get(pid);
                        if(null != puList && puList.size()>0){
                            for(ProjectUrl pu : puList){
                                sb1.append(pu.getUrl_name() + " = " + pu.getBase_url() + "<br>");
                            }
                            sb1.delete(sb1.length()-4, sb1.length());
                        }
                        String pUrl = sb1.toString();

                        StringBuilder sb2 = new StringBuilder();
                        List<ProjectVersion> pvList = pvMap.get(pid);
                        if(null != pvList && pvList.size()>0){
                            for(ProjectVersion pv : pvList){
                                sb2.append(pv.getVersion_code() + "<br>");
                            }
                            sb2.delete(sb2.length()-4, sb2.length());
                        }
                        String pVersion = sb2.toString();
                        //动态添加行
            %>

            <tr>
                <td align="center"><h5><%out.println(pName);%></h5></td>
                <td align="center"><h5><%out.println(pKey);%></h5></td>
                <td align="center"><h5><%out.println(pTime);%></h5></td>
                <td align="center"><h5><a href="<%=basePath%>WebRoot/saveProject.jsp?pid=<%=pid %>&pname=<%=pName %>&pkey=<%=pKey %>" >修改</a> &nbsp; <a href="<%=basePath%>deleteProject?pid=<%=pid %>" >删除</a></h5></td>
                <td align="center"><h5><%out.println(pVersion);%></h5></td>
                <td align="center"><h5><a href="<%=basePath%>updateProjectVersion?pid=<%=pid %>" >修改</a></h5></td>
                <td align="center"><h5><%out.println(pUrl);%></h5></td>
                <td align="center"><h5><a href="<%=basePath%>updateProjectEnv?pid=<%=pid %>" >修改</a></h5></td>
                <td align="center"><h5><a href="<%=basePath%>updateProjectCommon?pid=<%=pid %>" >管理公共上行</a></h5></td>
                <td align="center"><h5><a href="<%=basePath%>interfaceView?pid=<%=pid %>" >进入</a></h5></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <br>

        <div style="text-align:center;">
            <table  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="100" align="center">
                        <form accept-charset="UTF-8" action="<%=basePath%>WebRoot/saveProject.jsp?pid=<%="" %>&pname=<%="" %>&pkey=<%="" %>" class="new_post" data-remote="true" id="new_post" method="post">
                            <input class="btn btn-success" name="commit" type="submit" value="新增项目"></input>
                        </form>
                    </td>

                    <td width="100" align="center">
                        <form accept-charset="UTF-8" action="<%=basePath%>recoveryProject" class="new_post" data-remote="true" id="new_post2" method="post">
                            <input class="btn btn-warning" name="commit2" type="submit" value="恢复项目"></input>
                        </form>
                    </td>
                </tr>
            </table>
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
        <p class="btn btn-default"><i class="fa fa-heart-o"></i>Mgame_InterfaceTest<i class="fa fa-heart-o"></i>      </p>
    </footer>

</div> <!-- /container -->



<div class="_bd_ext_tip _bd_ext_search_mode" style="visibility: hidden; left: 1103px; top: 463px;"><span class="_bd_ext_search">百度一下</span><span class="_bd_ext_open">打开链接</span><span class="_bd_ext_copy">复制</span></div></body></html>
