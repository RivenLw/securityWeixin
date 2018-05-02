<%@ page language="java" import="java.util.*,com.Riven.ssm.util.Peizhi" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String waiUrl = Peizhi.waiUrl;
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理菜单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/weui.min.css">
    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="js/weui.min.js"></script>
    
    <style type="text/css">
		body {background-color: #f8f8f8}
        #touandname{
            text-align: center;
            padding-top: 20%;
            padding-bottom: 15%;
        }
        img{
            width:100px;
            height:100px;
            border-radius:50%;
        }
    </style>

</head>
	<body>
		<div id="root">
        <div id="touandname">
            <div id="touimg">
                <img src="${loginUser.headimgurl } ">
            </div>
            <div id="nickname">
                管理员：${loginUser.nickname }
            </div>
        </div>
        <div id="menu">
            <a href="http://<%=waiUrl %>/securityWeixin/question/addquestion.action" style="margin-bottom: 10%;margin-left: 10px;margin-right: 10px;margin-top: 15%" class="weui-btn weui-btn_primary">新增题目</a>
            <a href="http://<%=waiUrl %>/securityWeixin/question/lookquestion.action" style="margin-bottom: 10%;margin-left: 10px;margin-right: 10px;" class="weui-btn weui-btn_primary">题目管理</a>
            <a href="http://<%=waiUrl %>/securityWeixin/jubao/lookalljubaorecord.action" style="margin-left: 10px;margin-right: 10px;" class="weui-btn weui-btn_primary">所有举报</a>
        </div>
    </div>
	 </body>
</html>
