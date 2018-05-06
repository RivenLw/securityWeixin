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
    
    <title>答题记录</title>
    
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
    
    <script type="text/javascript">
        $(function(){
        
        })
        
        
    </script>
    <style type="text/css">
        body {background-color: #f8f8f8}
        .page__hd {padding: 40px;}
    </style>

</head>
<body>

	<div class="page">
	    <div class="page__hd">
	        <h1 class="page__title">答题记录</h1>
	        <p class="page__desc">点击题目编号可以查看题目内容</p>
	    </div>
	    <div class="page__bd">
	    	<c:forEach var="recordExt" items="${recordExts}" varStatus="status">
		        <div class="weui-form-preview">
		            <div class="weui-form-preview__hd">
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">正确率</label>
		                    <em class="weui-form-preview__value">${recordExt.zhengquelv }%</em>
		                </div>
		            </div>
		            <div class="weui-form-preview__bd">
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">记录编号</label>
		                    <span class="weui-form-preview__value">${recordExt.recordId }</span>
		                </div>
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">答题时间</label>
		                    <span class="weui-form-preview__value">${recordExt.startTime }</span>
		                </div>
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">题目总数</label>
		                    <span class="weui-form-preview__value">${recordExt.questionSum }</span>
		                </div>
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">答题用时</label>
		                    <span class="weui-form-preview__value">${recordExt.useTime }</span>
		                </div>
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">回答正确</label>
		                    <span class="weui-form-preview__value">
			                    <c:forEach var="trueQ" items="${recordExt.truelist }" varStatus="statusT">
									<a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${trueQ }" >${trueQ }</a>,
								</c:forEach>
		                    </span>
		                </div>
		                <div class="weui-form-preview__item">
		                    <label class="weui-form-preview__label">回答错误</label>
		                    <span class="weui-form-preview__value">
		                    	<c:forEach var="falseQ" items="${recordExt.falselist }" varStatus="statusF">
									<a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${falseQ }" >${falseQ }</a>,
								</c:forEach>
		                    </span>
		                </div>
		            </div>
		        </div>
		        <br>
	        </c:forEach> 
	    </div>
	</div>

	<%-- <div>
		<c:forEach var="recordExt" items="${recordExts}" varStatus="status">
			${recordExt.zhengquelv }<br>
			${recordExt.recordId }<br>
			${recordExt.startTime }<br>
			${recordExt.questionSum }<br>
			${recordExt.useTime }<br>
			<c:forEach var="trueQ" items="${recordExt.truelist }" varStatus="statusT">
				<a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${trueQ }" >${trueQ }</a>,
			</c:forEach>
			<br>
			<c:forEach var="falseQ" items="${recordExt.falselist }" varStatus="statusF">
				<a href="http://<%=waiUrl %>/securityWeixin/question/lookonequestion.action?questionId=${falseQ }" >${falseQ }</a>,
			</c:forEach> 
			<br>
		</c:forEach> 
	</div> --%>

</body>
</html>
