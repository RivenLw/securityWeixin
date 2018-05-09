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
    
    <title>我的错题集</title>
    
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
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/weui.min.js"></script>
    
    <script type="text/javascript">
        $(function(){
            weui.tab('#tab',{
                defaultIndex: 0,
                onChange: function(index){

                }
            });
            
        })
        
        
        
        </script>
    <style type="text/css">
        body {background-color: #f8f8f8}
        th{text-align: center;}
        td{text-align: center;}
    </style>

</head>
<body>

    <div id="root">
        <div class="weui-tab" id="tab">
            <div class="weui-navbar">
                <div class="weui-navbar__item">选择题</div>
                <div class="weui-navbar__item">判断题</div>
            </div>
            <div class="weui-tab__panel">
                <div class="weui-tab__content">
                    <table id="xztable" class="table table-striped">
                        <thead>
                            <tr>
                                <th>题目编号</th>
                                <th>题目内容</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="choques" items="${choList}" varStatus="status">
		                            <tr>
		                                <td>${choques.questionId }</td>
		                                <td value="${choques.questionContent}">
			                                <c:if test="${fn:length(choques.questionContent)>10 }">  
						                         ${fn:substring(choques.questionContent, 0, 10)}...
						                   	</c:if>
						                   	<c:if test="${fn:length(choques.questionContent)<=10 }">  
						                         ${choques.questionContent}
						                   	</c:if>
	                  				 	</td>
		                                <td><a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${choques.questionId }" class="weui-btn weui-btn_mini weui-btn_primary">查看</a></td>
		                            </tr>
							</c:forEach> 
                        </tbody>
                    </table>
                </div>

                <div class="weui-tab__content">
                    <table id="pdtable" class="table table-striped">
                        <thead>
                        <tr>
                            <th>题目编号</th>
                            <th>题目内容</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="torfques" items="${torfList}" varStatus="status">
		                            <tr>
		                                <td>${torfques.questionId }</td>
		                                <td value="${torfques.questionContent}">
			                                <c:if test="${fn:length(torfques.questionContent)>10 }">  
						                         ${fn:substring(torfques.questionContent, 0, 10)}...
						                   	</c:if>
						                   	<c:if test="${fn:length(torfques.questionContent)<=10 }">  
						                         ${torfques.questionContent}
						                   	</c:if>
	                  				 	</td>
		                                <td><a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${torfques.questionId }" class="weui-btn weui-btn_mini weui-btn_primary">查看</a></td>
		                            </tr>
							</c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
