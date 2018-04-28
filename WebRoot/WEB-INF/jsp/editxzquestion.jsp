<%@ page language="java" import="java.util.*,com.Riven.ssm.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String waiUrl = Peizhi.waiUrl;
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增题目</title>
    
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
        
       	/*选择题表单修改保存*/
        function xzupdate(){
			if(!xzvalidate()){
				return false;
			};
			
			var questionContent = $("#xz_questionContent").val();
        	var questionId = $("#questionId").val();
        	var optionA = $("#optionA").val();
        	var optionB = $("#optionB").val();
        	var optionC = $("#optionC").val();
        	var optionD = $("#optionD").val();
        	var trueopt = $('input:radio[name="trueopt"]:checked').val();
        	var solution = $("#xz_solution").val();
        	
        	var json = '{"questionContent":"'+questionContent
        	+'","questionId":"'+questionId
        	+'","optionA":"'+optionA
        	+'","optionB":"'+optionB
        	+'","optionC":"'+optionC
        	+'","optionD":"'+optionD
        	+'","trueopt":"'+trueopt
        	+'","solution":"'+solution+'"}'
			
			
			$.ajax({
                    url: "question/updatachoicequestion.action",
                    type: "post",
                    contentType:'application/json;charset=utf-8',
                    data: json,
                    success: function (data) {
                        if(data.indexOf("true")>-1){
                        	weui.toast('修改成功', {
							    duration: 3000,
							    callback: function(){
											window.location.href="http://<%=waiUrl %>/securityWeixin/question/lookquestion.action";
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
        /*选择题表单校验,不通过则返回false*/
        function xzvalidate(){
        	var questionContent = $("#xz_questionContent").val();
        	var optionA = $("#optionA").val();
        	var optionB = $("#optionB").val();
        	var optionC = $("#optionC").val();
        	var optionD = $("#optionD").val();
        	var trueopt = $('input:radio[name="trueopt"]:checked').val();
        	var solution = $("#xz_solution").val();
        	
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
		    
		    if(optionA==''||optionA.length<1){
		    	weui.alert('选项A不能为空');
		    	return false;
		    };
		    if(optionA.length>20){
		        weui.alert('选项A不能超过20字');
		        return false;
		    };
		    if(valichar(optionA)){
		        weui.alert('选项A不能含有特殊字符');
		        return false;
		    };
		    
		    if(optionB==''||optionB.length<1){
		    	weui.alert('选项B不能为空');
		    	return false;
		    };
		    if(optionB.length>20){
		        weui.alert('选项B不能超过20字');
		        return false;
		    };
		    if(valichar(optionB)){
		        weui.alert('选项B不能含有特殊字符');
		        return false;
		    };
		    if(optionC==''||optionC.length<1){
		    	weui.alert('选项C不能为空');
		    	return false;
		    };
		    if(optionC.length>20){
		        weui.alert('选项C不能超过20字');
		        return false;
		    };
		    if(valichar(optionC)){
		        weui.alert('选项C不能含有特殊字符');
		        return false;
		    };
		    if(optionD==''||optionD.length<1){
		    	weui.alert('选项D不能为空');
		    	return false;
		    };
		    if(optionD.length>20){
		        weui.alert('选项D不能超过20字');
		        return false;
		    };
		    if(valichar(optionD)){
		        weui.alert('选项D不能含有特殊字符');
		        return false;
		    };
		    
		    if(trueopt==undefined){
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
                    url: "question/deletechoicequestion.action",
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
	                    <textarea id="questionId" class="weui-textarea" readonly="readonly" placeholder="" rows="1" value="">${editxzquestion.questionId }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">题目<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="xz_questionContent" class="weui-textarea" value="" placeholder="请输入题目内容" rows="3">${editxzquestion.questionContent }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-cells__title">选项A<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="optionA" class="weui-textarea" value="" placeholder="请输入选项A" rows="2">${editxzquestion.optionA }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">选项B<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="optionB" class="weui-textarea" value="" placeholder="请输入选项B" rows="2">${editxzquestion.optionB }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">选项C<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="optionC" class="weui-textarea" value="" placeholder="请输入选项C" rows="2">${editxzquestion.optionC }</textarea>
	                </div>
	            </div>
	        </div>
	        <div class="weui-cells__title">选项D<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="optionD" class="weui-textarea" value="" placeholder="请输入选项D" rows="2">${editxzquestion.optionD }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-cells__title">题目答案<span style="color: red">*</span></div>
	        <div class="weui-cells weui-cells_checkbox">
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="A" type="radio" <c:if test="${editxzquestion.trueopt=='A' }">  
					                         checked="checked"
					                   	</c:if> class="weui-check" name="trueopt" />
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>选项A</p>
	                </div>
	            </label>
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="B" type="radio" name="trueopt" <c:if test="${editxzquestion.trueopt=='B' }">  
					                         checked="checked"
					                   	</c:if> class="weui-check"/>
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>选项B</p>
	                </div>
	            </label>
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="C" type="radio" name="trueopt" <c:if test="${editxzquestion.trueopt=='C' }">  
					                         checked="checked"
					                   	</c:if> class="weui-check"/>
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>选项C</p>
	                </div>
	            </label>
	            <label class="weui-cell weui-check__label">
	                <div class="weui-cell__hd">
	                    <input value="D" type="radio" name="trueopt" <c:if test="${editxzquestion.trueopt=='D' }">  
					                         checked="checked"
					                   	</c:if> class="weui-check"/>
	                    <i class="weui-icon-checked"></i>
	                </div>
	                <div class="weui-cell__bd">
	                    <p>选项D</p>
	                </div>
	            </label>
	        </div>
	
	        <div class="weui-cells__title">题目解析</div>
	        <div class="weui-cells weui-cells_form">
	            <div class="weui-cell">
	                <div class="weui-cell__bd">
	                    <textarea id="xz_solution" class="weui-textarea" placeholder="请输入题目解析" rows="3">${editxzquestion.solution }</textarea>
	                </div>
	            </div>
	        </div>
	
	        <div class="weui-btn-area">
	            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="xzupdate()">保存</a>
	            <a href="javascript:;" class="weui-btn weui-btn_warn" onclick="deleteques('${editxzquestion.questionId }')">删除此题</a>
	        </div>
	
	    </div>
    </div>
  </body>
</html>
