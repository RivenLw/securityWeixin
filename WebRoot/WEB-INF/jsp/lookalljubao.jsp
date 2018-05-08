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
    
    <title>举报列表</title>
    
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
        	var $searchBar = $('#searchBar'),
            	$searchResult = $('#searchResult'),
            	$searchText = $('#searchText'),
            	$searchInput = $('#searchInput'),
            	$searchClear = $('#searchClear'),
            	$searchCancel = $('#searchCancel');
        	
        	function hideSearchResult(){
	            $searchResult.hide();
	            $searchInput.val('');
	        }
	        function cancelSearch(){
	            hideSearchResult();
	            $searchBar.removeClass('weui-search-bar_focusing');
	            $searchText.show();
	        }
	
	        $searchText.on('click', function(){
	            $searchBar.addClass('weui-search-bar_focusing');
	            $searchInput.focus();
	        });
	        $searchInput
	            .on('blur', function () {
	                if(!this.value.length) cancelSearch();
	            })
	            .on('input', function(){
	                if(this.value.length) {
	                    $searchResult.show();
	                } else {
	                    $searchResult.hide();
	                }
	            })
	        ;
	        $searchClear.on('click', function(){
	            hideSearchResult();
	            $searchInput.focus();
	        });
	        $searchCancel.on('click', function(){
	            cancelSearch();
	            $searchInput.blur();
	        });
        	
        	
        	//所有tr
        	var alltr = $("tbody tr");
        
            //获取键盘搜索按钮事件
		    $("#searchInput").on('keypress', function(e) {
		        var keycode = e.keyCode;
		        //获取搜索框的值
		        var searchContent = $(this).val();
		        if (keycode == '13') {
		            e.preventDefault();
		            //请求搜索接口
		            if (searchContent.trim() == '') {//输入框没有东西则显示所有
						$.each(alltr,function(index,element){
							$(element).show();
						});
		            } else {
		                $.each(alltr,function(index,element){
							var contenttd = $(element).children().eq(1);
							
							if(contenttd.attr("value").indexOf(searchContent)>=0){
								$(element).show();
							}else{
								$(element).hide();
							}
							
						});
		            }
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

    	<div class="weui-search-bar" id="searchBar">
            <div class="weui-search-bar__form">
                <div class="weui-search-bar__box">
                    <i class="weui-icon-search"></i>
                    <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="搜索" required/>
                    <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
                </div>
                <label class="weui-search-bar__label" id="searchText">
                    <i class="weui-icon-search"></i>
                    <span>搜索</span>
                </label>
            </div>
            <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
        </div>
       <div class="">
           <table id="jbtable" class="table table-striped">
               <thead>
                   <tr>
                       <th>举报编号</th>
                       <th>举报内容</th>
                       <th>操作</th>
                   </tr>
               </thead>
               <tbody>
               	<c:forEach var="jubao" items="${jubaolist}" varStatus="status">
                     <tr>
                         <td>${jubao.recordId }</td>
                         <td value="${jubao.jubaoContent}">
                          <c:if test="${fn:length(jubao.jubaoContent)>10 }">  
                      ${fn:substring(jubao.jubaoContent, 0, 10)}...
                	</c:if>
                	<c:if test="${fn:length(jubao.jubaoContent)<=10 }">  
                      ${jubao.jubaoContent}
                	</c:if>
          				 	</td>
                         <td><a href="http://<%=waiUrl %>/securityWeixin/jubao/lookonejubao.action?recordid=${jubao.recordId }" class="weui-btn weui-btn_mini weui-btn_primary">查看</a></td>
                     </tr>
				</c:forEach> 
               </tbody>
           </table>
       </div>

</body>
</html>
