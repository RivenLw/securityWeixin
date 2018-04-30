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
        var timer;
        $(function(){
            var m=0;
            var s=0;

            //答题计时器
            timer = setInterval(function(){
                if(s<10){
                    //如果秒数少于10在前面加上0
                    $('#timer').html('答题用时&nbsp;'+m+'分0'+s+"秒");
                }else{
                    $('#timer').html('答题用时&nbsp;'+m+'分'+s+"秒");
                }
                s++;
                if(s==60){
                    //如果秒数少于0就变成59秒
                    s=0;
                    m++;
                }
            },1000);

        })

        //判断题目正确后将数据提交后台，更改答题页样式（选项只读，对错变色，提交按钮隐藏），提示用户答题汇总信息，用户选择离开界面还是查看答题情况；
        function submitanswer() {
            var truesum = 0;
            var falsesum = 0;
            var noanswer = 0;

            //获取所有选择题的div
            var allxzqueslist = $("#xzQues").children();
            //循环所有选择题，判断是否有没有选择答案的题目
            allxzqueslist.each(function(index,domEle){
                var xzquesid = $(domEle).prop("id");//当前题目的id
                var xzanswer =  $('input:radio[name="'+xzquesid+'"]:checked').val();//当前题目选择的答案
                var trueanswer = $("#"+xzquesid+" input:last-child").val();//当前题目的正确答案
                var solutiondiv = $("#"+xzquesid).children().eq(1);//解析的div文档对象

                //判断完根据是否正确更改底色，同时显示正确答案和解析
                if(xzanswer!=undefined){//如果题目选择了答案，则判断是否正确后添加到对应input
                    if (xzanswer==trueanswer){
                        $("#trueQuestions").val($("#trueQuestions").val()+xzquesid+",");
                        truesum++;
                        $(domEle).prop("class","trueques");
                    }else {
                        $("#falseQuestion").val($("#falseQuestion").val()+xzquesid+",");
                        falsesum++;
                        $(domEle).prop("class","falseques");
                    }
                }else {
                    noanswer++;
                    $(domEle).prop("class","falseques");
                }

                //展示题目解析
                solutiondiv.prop("style","");
                //
                $("#"+xzquesid).children().eq(2).prop("style","background-color:#ECECEC;");
            });

            //获取所有判断题的div
            var allpdqueslist = $("#pdQues").children();
            allpdqueslist.each(function(index,domEle){
                var pdquesid = $(domEle).prop("id");
                var pdanswer =  $('input:radio[name="'+pdquesid+'"]:checked').val();
                var trueanswer = $("#"+pdquesid+" input:last-child").val();
                var solutiondiv = $("#"+pdquesid).children().eq(1);//解析的div文档对象

                //判断完根据是否正确更改底色，同时显示正确答案和解析
                if(pdanswer!=undefined){//如果题目选择了答案，则判断是否正确后添加到对应input
                    if (pdanswer==trueanswer){
                        $("#trueQuestions").val($("#trueQuestions").val()+pdquesid+",");
                        truesum++;
                        $(domEle).prop("class","trueques");
                    }else {
                        $("#falseQuestion").val($("#falseQuestion").val()+pdquesid+",");
                        falsesum++;
                        $(domEle).prop("class","falseques");
                    }
                }else {
                    noanswer++;
                    $(domEle).prop("class","falseques");
                }

                //展示题目解析
                solutiondiv.prop("style","");
                //
                $("#"+pdquesid).children().eq(2).prop("style","background-color:#ECECEC;");
            });

            //设置所有input为只读
            var allinput = $("#quesBody input");
            allinput.each(function(index,domEle){
                $(domEle).attr("disabled","disabled");
            });

            //隐藏提交按钮
            $("#submitbut").hide();

            //计时器停止
            clearInterval(timer);
            $("#status").html("答题完成");

            //ajax提交答题记录信息

            
            var openid = $("#openid").val();
            var startTime = $("#statrTime").val();
            var questionSum = $("#questionSum").val();
            var trueQuestions = $("#trueQuestions").val();
            var falseQuestion = $("#falseQuestion").val();
            var nickname = $("#nickname").val();
            
            var json = '{"openid":"'+openid
        			+'","startTime":"'+startTime
        			+'","questionSum":"'+questionSum
        			+'","trueQuestions":"'+trueQuestions
        			+'","falseQuestion":"'+falseQuestion
        			+'","nickname":"'+nickname+'"}'
        	
        	
            $.ajax({
                    url: "answer/saveAnswerRecord.action",
                    type: "post",
                    contentType:'application/json;charset=utf-8',
                    data: json,
                    success: function (data) {
                        if(data.indexOf("true")>-1){
                        	
                        	var countstr = "本次题目总数："+$("#questionSum").val()+"。正确数："+truesum+"。错题数："+falsesum+"。未答数："+noanswer+"。";
                        
							weui.confirm(countstr, {
							    title: '答题完成',
							    buttons: [{
							        label: '确定',
							        type: 'primary',
							        onClick: function(){ console.log('yes') }
							    }]
							});
			            }else{
			            	weui.alert('网络故障，请稍后再试');
			            }
                    },
                    error: function () {
                        weui.alert('网络故障，请稍后再试');
                    }
                });
            
        }


        //点击提交按钮执行的函数
        //校验是否有没有选择答案的题目,提示用户，题目都已选择则返回true，
        //如果有未选择答案的题目，提示用户，如果用户选择继续提交则返回true，如果用户取消则返回false
        function validataanswer() {
            var cansubmit = true;//是否能提交的标志
            //获取所有选择题的div
            var allxzqueslist = $("#xzQues").children();
            //循环所有选择题，判断是否有没有选择答案的题目
            allxzqueslist.each(function(index,domEle){
                var xzquesid = $(domEle).prop("id");
                var xzanswer =  $('input:radio[name="'+xzquesid+'"]:checked').val();
                if(xzanswer==undefined){//如果有没有选择的题目，则提示有未选择答案的题目
                    cansubmit = false;
                    weui.confirm('还有题目未选择答案，是否继续提交'
                                , function(){
                                    console.log('yes');
                                    submitanswer();
                                }
                                , function(){
                                    console.log('no');
                                }
                                , {title: '提示'}
                                );
                }
            });

            //获取所有判断题的div
            var allpdqueslist = $("#pdQues").children();
            allpdqueslist.each(function(index,domEle){
                var pdquesid = $(domEle).prop("id");
                var pdanswer =  $('input:radio[name="'+pdquesid+'"]:checked').val();
                if(pdanswer==undefined){//如果有没有选择的题目，则提示有未选择答案的题目
                    cansubmit = false;
                    weui.confirm('还有题目未选择答案，是否继续提交'
                        , function(){
                            console.log('yes');
                            submitanswer();
                        }
                        , function(){
                            console.log('no');
                        }
                        , {title: '提示'}
                    );
                }
            });
            if (cansubmit){
                weui.confirm('请确认提交'
                    , function(){
                        console.log('yes');
                        submitanswer();
                    }
                    , function(){
                        console.log('no');
                    }
                    , {title: '提示'}
                );
            }
        }

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
        .weui-cells__title{
            font-size: 17px;
            color: black;
        }
        .trueques{background-color: rgba(4,255,0,0.25);}
        .falseques{background-color: rgba(255,0,0,0.23);}

        .weui-cells__title {
            margin-top: 0;
        }

    </style>
</head>
<body>
    <div id="container" class="container">
        <div id="top"><!--固定在顶部，显示答题中以及计时器-->
            <span id="status">答题中</span><span id="timer">答题用时&nbsp;0分00秒</span>
        </div>
        <div id="quesBody" style="margin-top: 40px"><!--所有题目div-->
            <div id="xzQues"><!--选择题div-->
                <!--从这里开始循环生成选择题-->
                <c:forEach var="choques" items="${xzqueslist}" varStatus="status">
                <div id="${choques.questionId }">
                    <div class="weui-cells__title">${status.index+1 }、${choques.questionContent }</div>
                    <div class="weui-cells__title" style="display: none">正确答案：${choques.trueopt }。<br>解析：${choques.solution }</div>
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
                    <div class="weui-cells__title" style="display: none">正确答案：<c:if test="${torfques.answer=='true' }">对</c:if><c:if test="${torfques.answer=='false' }">错</c:if>。<br>解析：${torfques.solution }</div>
                    <div class="weui-cells weui-cells_checkbox">
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="true" type="radio" class="weui-check" name="${torfques.questionId }" />
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>对</p>
                            </div>
                        </label>
                        <label class="weui-cell weui-check__label">
                            <div class="weui-cell__hd">
                                <input value="false" type="radio" name="${torfques.questionId }" class="weui-check"/>
                                <i class="weui-icon-checked"></i>
                            </div>
                            <div class="weui-cell__bd">
                                <p>错</p>
                            </div>
                        </label>
                        <input type="text" style="display: none" value="${torfques.answer }"><!--这个隐藏，用来放正确答案-->
                    </div>
                </div>
				</c:forEach>
            </div>
        </div>
        <div id="options">
            <a href="javascript:;" id="submitbut" style="margin: 10% 3%;" class="weui-btn weui-btn_primary"  onclick="validataanswer()">提交</a>
        </div>
    </div>
    <div style="display: none"><!--隐藏域，用于存放当前答题记录相关信息-->
        <input type="text" id="openid" value="${loginUser.openid }"><!--答题人openid-->
        <input type="text" id="nickname" value="${loginUser.nickname }"><!--答题人昵称-->
        <input type="text" id="questionSum" value="${fn:length(xzqueslist)+fn:length(pdqueslist) }"><!--答题总数-->
        <input type="text" id="trueQuestions" value=""><!--正确题目编号，用逗号分隔-->
        <input type="text" id="falseQuestion" value=""><!--错误题目编号，用逗号分隔-->
        <input type="text" id="statrTime" value="${startTime }">
    </div>
</body>
</html>
