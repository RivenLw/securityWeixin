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
    
    <title>详情</title>
    
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
    	
			var imgsObj = $('img');  
		    var imgs = new Array();  
		    for(var i = 0; i < imgsObj.size(); i++){  
		        imgs.push(imgsObj.eq(i).attr('src'));  
		    }  
		      
		        $('img').on('click',function(){  
		            WeixinJSBridge.invoke('imagePreview', {  
		            'current': $(this).attr('src'),  
		            'urls': imgs  
		        });  
		        });
		    	
		    	})
    
    </script>
    
    <style type="text/css">
        body {background-color: #f8f8f8}
    </style>

</head>
<body>

<div id="root">
    <div class="">

        <div class="weui-cells__title">举报类型</div>
        <div class="weui-cells">
            <div class="weui-cell weui-cell_select">
                <div class="weui-cell__bd">
                    <select disabled="disabled" class="weui-select" name="select1" id="jubaotype">
                        <option  <c:if test="${jubaoRecord.jubaoType=='实名举报' }"> selected="selected" </c:if> value="实名举报" >实名举报</option>
                        <option <c:if test="${jubaoRecord.jubaoType=='匿名举报' }"> selected="selected" </c:if> value="匿名举报">匿名举报</option>
                    </select>
                </div>
            </div>
        </div>

        <div id="userinfo" <c:if test="${jubaoRecord.jubaoType=='匿名举报' }"> style="display:none;" </c:if>>
            <div class="weui-cells__title">姓名</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea readonly="readonly" id="name" class="weui-textarea" placeholder="请输入姓名" rows="1">${jubaoRecord.name }</textarea>
                    </div>
                </div>
            </div>
            <div class="weui-cells__title">联系电话</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea readonly="readonly" id="phone" class="weui-textarea" placeholder="请输入联系电话" rows="1">${jubaoRecord.phone }</textarea>
                    </div>
                </div>
            </div>
            <div class="weui-cells__title">身份证号</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea readonly="readonly" id="idcard" class="weui-textarea " placeholder="请输入身份证号" rows="1">${jubaoRecord.idcard }</textarea>
                    </div>
                </div>
            </div>
        </div>

        <div class="weui-cells__title">举报内容</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea readonly="readonly" id="jubaocontent" class="weui-textarea" placeholder="请输入举报内容" rows="6">${jubaoRecord.jubaoContent }</textarea>
                </div>
            </div>
        </div>
        
        <div class="weui-cells__title">举报图片</div>
		<div class="weui-cells weui-cells_form">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<div class="weui-uploader">
						<div class="weui-uploader__bd">
							<ul class="weui-uploader__files">
								<c:forEach var="imageName" items="${jubaoRecord.imageNames }" varStatus="status9">
									<img  class="weui-uploader__file weui-uploader__file_status" src="http://<%=waiUrl %>/securityWeixin/jubaoImg/${imageName }" alt="">
								</c:forEach> 
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

    </div>
</div>
</body>
</html>