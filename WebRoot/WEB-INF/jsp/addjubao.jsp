<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增举报</title>
    
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

            $("#jubaotype").change(function () {
                var selected = $("#jubaotype").val();

                if (selected=="实名举报") {
                    $("#userinfo").show();
                }else {
                    $("#userinfo").hide();
                    
		            $("#name").val('');
		            $("#phone").val('');
		            $("#idcard").val('');
                }
            });
        })


        /*表单保存*/
        function jubaosave(){
            if(!jubaovalidata()){
                return false;
            };


            var jubaotype = $("#jubaotype").val();
            var name = $("#name").val();
            var phone = $("#phone").val();
            var idcard = $("#idcard").val();
            var jubaocontent = $("#jubaocontent").val();

            var json = '{"jubaoType":"'+jubaotype
                +'","name":"'+name
                +'","phone":"'+phone
                +'","idcard":"'+idcard
                +'","jubaoContent":"'+jubaocontent+'"}'


            $.ajax({
                url: "jubao/savejubao.action",
                type: "post",
                contentType:'application/json;charset=utf-8',
                data: json,
                success: function (data) {
                    if(data.indexOf("true")>-1){
                        weui.toast('保存成功', {
                            duration: 3000,
                            callback: function(){jubaoreset()}
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
        /*表单校验*/
        function jubaovalidata(){
            var jubaocontent = $("#jubaocontent").val();

            if(jubaocontent==''||jubaocontent.length<1){
                weui.alert('举报内容不能为空');
                return false;
            };
            if(jubaocontent.length>1000){
                weui.alert('举报内容不能超过1000字');
                return false;
            };
            if(valichar(jubaocontent)){
                weui.alert('举报内容不能含有特殊字符');
                return false;
            };

            return true;

        }
        /*表单重置*/
        function jubaoreset(){
            $("#name").val('');
            $("#phone").val('');
            $("#idcard").val('');
            $("#jubaocontent").val('');

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

        <div class="weui-cells__title">举报类型<span style="color: red">*</span></div>
        <div class="weui-cells">
            <div class="weui-cell weui-cell_select">
                <div class="weui-cell__bd">
                    <select class="weui-select" name="select1" id="jubaotype">
                        <option selected="" value="实名举报">实名举报</option>
                        <option value="匿名举报">匿名举报</option>
                    </select>
                </div>
            </div>
        </div>

        <div id="userinfo">
            <div class="weui-cells__title">姓名</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea id="name" class="weui-textarea" placeholder="请输入姓名" rows="1"></textarea>
                    </div>
                </div>
            </div>
            <div class="weui-cells__title">联系电话</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea id="phone" class="weui-textarea" placeholder="请输入联系电话" rows="1"></textarea>
                    </div>
                </div>
            </div>
            <div class="weui-cells__title">身份证号</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea id="idcard" class="weui-textarea" placeholder="请输入身份证号" rows="1"></textarea>
                    </div>
                </div>
            </div>
        </div>

        <div class="weui-cells__title">举报内容<span style="color: red">*</span></div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea id="jubaocontent" class="weui-textarea" placeholder="请输入举报内容" rows="6"></textarea>
                </div>
            </div>
        </div>

        <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" onclick="jubaosave()">保存</a>
            <a href="javascript:;" class="weui-btn weui-btn_warn" onclick="jubaoreset()">重置表单</a>
        </div>

    </div>
</div>
</body>
</html>