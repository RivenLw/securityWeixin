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
    
    <title>判断题</title>
    
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
    </style>

</head>
<body>

    <div id="root">
        <div class="">
	        <div class="weui-cells__title">题目编号<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="questionId" readonly="readonly" class="weui-textarea" readonly="readonly" placeholder="" rows="1" value="">${resultques.questionId }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">题目<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="pd_questionContent" readonly="readonly" class="weui-textarea" placeholder="请输入题目内容" rows="3">${resultques.questionContent }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-cells__title">题目答案<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_checkbox">
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="true" type="radio" disabled="disabled" <c:if test="${resultques.answer=='true' }">  
					                         checked="checked"
					                   	</c:if> class="weui-check" name="answer" />
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>正确</p>
	                </div>
	            </label>
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="false" type="radio" disabled="disabled" <c:if test="${resultques.answer=='false' }">  
					                         checked="checked"
					                   	</c:if> name="answer" class="weui-check"/>
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>错误</p>
	                </div>
	            </label>
	        </div>
	
	        <div class="weui-cells__title">题目解析</div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="pd_solution"  readonly="readonly" class="weui-textarea" placeholder="请输入题目解析" rows="3">${resultques.solution }</textarea>
	                </div>
	            </div>
	        </div>
	
	    </div>
    </div>

</body>
</html>
