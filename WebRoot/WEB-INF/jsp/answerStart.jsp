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
    
    <title>答题页面</title>
    
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
            var m=0;
            var s=0;
            setInterval(function(){
                if(s<10){
                    //如果秒数少于10在前面加上0
                    $('#timer').html('答题用时&nbsp;'+m+':0'+s);
                }else{
                    $('#timer').html('答题用时&nbsp;'+m+':'+s);
                }
                s++;
                if(s==60){
                    //如果秒数少于0就变成59秒
                    s=0;
                    m++;
                }
            },1000)
        })

    </script>
    <style type="text/css">
        body {background-color: #f8f8f8}
        #top{
            position:fixed;
            top:0;
            width:100%;
            height: 40px;
            background: #393a3f;
            z-index: 100;
            color: white;
            line-height: 40px;
        }
        #timer{float: right;margin-right: 5%}
        #status{margin-left: 33%}

    </style>
</head>
<body>
    <div id="container" class="container">
        <div id="top"><!--固定在顶部，显示答题中以及计时器-->
            <span id="status">答题中</span><span id="timer">答题用时0:00</span>
        </div>
        <div id="quesBody" style="margin-top: 45px"><!--所有题目div-->
            <div id="xzQues"><!--选择题div-->
                <!--从这里开始循环生成选择题-->
                <c:forEach var="choques" items="${xzqueslist}" varStatus="status">
                <div id="${choques.questionId }">
                    <div class="weui-cells__title">${status.index+1 }、${choques.questionContent }</div>
                    <div class="weui-cells__title" style="display: none">答案：${choques.trueopt }。<br>解析：${choques.solution }</div>
                    <div class="weui-cells weui-cells_checkbox">
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="A" type="radio" class="weui-check" name="${choques.questionId }" />
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>${choques.optionA }</p>
                            </div>
                        </label>
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="B" type="radio" name="${choques.questionId }" class="weui-check"/>
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>${choques.optionB }</p>
                            </div>
                        </label>
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="C" type="radio" name="${choques.questionId }" class="weui-check"/>
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>${choques.optionC }</p>
                            </div>
                        </label>
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="D" type="radio" name="${choques.questionId }" class="weui-check"/>
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>${choques.optionD }</p>
                            </div>
                        </label>

                        <input type="text" style="display: none" value="${choques.trueopt }"><!--这个隐藏，用来放正确答案-->
                    </div>
                </div>
				</c:forEach>
            </div>
            <div id="pdQues"><!--判断题div-->
                <!--从这里开始循环生成判断题-->
                <c:forEach var="torfques" items="${pdqueslist}" varStatus="status">
                <div id="${torfques.questionId }">
                    <div class="weui-cells__title">${status.index+1 }、${torfques.questionContent }</div>
                    <div class="weui-cells__title" style="display: none">答案：<c:if test="${torfques.answer=='true' }">正确</c:if><c:if test="${torfques.answer=='false' }">错误</c:if>。<br>解析：${torfques.solution }</div>
                    <div class="weui-cells weui-cells_checkbox">
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="true" type="radio" class="weui-check" name="${torfques.questionId }" />
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>正确</p>
                            </div>
                        </label>
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="false" type="radio" name="${torfques.questionId }" class="weui-check"/>
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>错误</p>
                            </div>
                        </label>
                        <input type="text" style="display: none" value="${torfques.answer }"><!--这个隐藏，用来放正确答案-->
                    </div>
                </div>
				</c:forEach>
            </div>
        </div>
        <div id="options">
            <a href="javascript:;" style="margin-top: 5%" class="weui-btn weui-btn_primary">提交</a>
        </div>
    </div>
    <div style="display: none"><!--隐藏域，用于存放当前答题记录相关信息-->
        <input type="text" id="openid" value="${loginUser.openid }"><!--答题人openid-->
        <input type="text" id="nickname" value="${loginUser.nickname }"><!--答题人昵称-->
        <input type="text" id="questionSum" value="${fn:length(xzqueslist)+fn:length(pdqueslist) }"><!--答题总数-->
        <input type="text" id="trueQuestions" value=""><!--正确题目编号，用逗号分隔-->
        <input type="text" id="falseQuestion" value=""><!--错误题目编号，用逗号分隔-->
    </div>
</body>
</html>
