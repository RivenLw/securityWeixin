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
    
    <title>判断题修改</title>
    
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
        
        /*判断题表单保存*/
        function pdupdate(){
        	if(!pdvalidate()){
				return false;
			};
			
			var questionContent = $("#pd_questionContent").val();
			var questionId = $("#questionId").val();
        	var answer = $('input:radio[name="answer"]:checked').val();
        	var solution = $("#pd_solution").val();
        	
        	var json = '{"questionContent":"'+questionContent
        				+'","questionId":"'+questionId
			        	+'","answer":"'+answer
			        	+'","solution":"'+solution+'"}'
			
			
			$.ajax({
                    url: "question/updatatorfquestion.action",
                    type: "post",
                    contentType:'application/json;charset=utf-8',
                    data: json,
                    success: function (data) {
                        if(data.indexOf("true")>-1){
                        	weui.toast('修改成功', {
							    duration: 3000,
							    callback: function(){
											window.location.href="http://<%=waiUrl %>/securityWeixin/question/lookquestion.action"
											}
							});
			            }else{
			            	weui.alert('保存失败，请稍后再试');
			            }
                    },
                    error: function () {
                        weui.alert('保存失败，请稍后再试');
                    }
                });
			
        }
        /*判断题表单校验*/
        function pdvalidate(){
        	var questionContent = $("#pd_questionContent").val();
        	var answer = $('input:radio[name="answer"]:checked').val();
        	var solution = $("#pd_solution").val();
        
        	if(questionContent==''||questionContent.length<1){
		    	weui.alert('题目不能为空');
		    	return false;
		    };
		    if(questionContent.length>50){
		        weui.alert('题目不能超过50字');
		        return false;
		    };
		    if(valichar(questionContent)){
		        weui.alert('题目不能含有特殊字符');
		        return false;
		    };
		    
		    if(answer==undefined){
		        weui.alert('请选择正确答案');
		        return false;
		    }
		    
		    if(solution.length>200){
		        weui.alert('题目解析不能超过200字');
		        return false;
		    };
		    if(valichar(solution)){
		        weui.alert('题目解析不能含有特殊字符');
		        return false;
		    };
        	
        	return true;
        	
        }
        
        function deleteques(quesId){
        	weui.confirm('确定删除编号为'+quesId+'的题目吗？'
        	,function(){ 
				console.log('yes');
				
				var json = '{"questionId":"'+quesId+'"}'
				
				$.ajax({
                    url: "question/deletetorfquestion.action",
                    type: "post",
                    contentType:'application/json;charset=utf-8',
                    data: json,
                    success: function (data) {
                        if(data.indexOf("true")>-1){
                        	weui.toast('删除成功', {
							    duration: 3000,
							    callback: function(){
											window.location.href="http://<%=waiUrl %>/securityWeixin/question/lookquestion.action";
											}
							});
			            }else{
			            	weui.alert('删除失败，请稍后再试');
			            }
                    },
                    error: function () {
                        weui.alert('删除失败，请稍后再试');
                    }
                });
				
			 }
			 ,function(){
				console.log('no');														 
			});
        }
        
        function valichar(s){
    		var testStr=/['"#$%<>;~/`&\^*]/;
    		return testStr.test(s)
		}
        
        </script>
    <style type="text/css">
        body {background-color: #f8f8f8}
    </style>

</head>
<body>

    <div id="root">
        <div class="">
	        <div class="weui-cells__title">题目编号（不可更改）<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="questionId" class="weui-textarea" readonly="readonly" placeholder="" rows="1" value="">${editpdquestion.questionId }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">题目<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="pd_questionContent" class="weui-textarea" placeholder="请输入题目内容" rows="3">${editpdquestion.questionContent }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-cells__title">题目答案<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_checkbox">
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="true" type="radio" <c:if test="${editpdquestion.answer=='true' }">  
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
	                    <input value="false" type="radio" <c:if test="${editpdquestion.answer=='false' }">  
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
	                    <textarea id="pd_solution" class="weui-textarea" placeholder="请输入题目解析" rows="3">${editpdquestion.solution }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-btn-area">
	            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="pdupdate()">保存</a>
	            <a href="javascript:;" class="weui-btn weui-btn_warn" onclick="deleteques('${editpdquestion.questionId }')">删除此题</a>
	        </div>
	
	    </div>
    </div>

</body>
</html>
