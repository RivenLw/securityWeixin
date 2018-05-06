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
    
    <title>用户列表</title>
    
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
        
        })
        
        function canceladmin(openid,nickname,thisa){
        
        	weui.confirm('是否取消“'+nickname+'”的管理员权限？'
                        , function(){
                            console.log('yes');
                            
                            var json = '{"openid":"'+openid+'"}'
                            
                            $.ajax({
			                    url: "admin/canceladmin.action",
			                    type: "post",
			                    contentType:'application/json;charset=utf-8',
			                    data: json,
			                    success: function (data) {
			                        if(data.indexOf("true")>-1){
			                        	weui.toast('修改成功', {
										    duration: 3000,
										    callback: function(){
										    	
											    $(thisa).parent().html("<button class='weui-btn weui-btn_mini weui-btn_plain-disabled'>已取消管理员</button>");
										     }
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
                        , function(){
                            console.log('no');
                        }
                        , {title: '提示'}
                    );
        
        }
        
        
        function setadmin(openid,nickname,thisa){
        
        	weui.confirm('是否设置“'+nickname+'”为管理员？'
                        , function(){
                            console.log('yes');
                            
                            var json = '{"openid":"'+openid+'"}'
                            
                            $.ajax({
			                    url: "admin/setadmin.action",
			                    type: "post",
			                    contentType:'application/json;charset=utf-8',
			                    data: json,
			                    success: function (data) {
			                        if(data.indexOf("true")>-1){
			                        	weui.toast('修改成功', {
										    duration: 3000,
										    callback: function(){
										    	
											    $(thisa).parent().html("<button class='weui-btn weui-btn_mini weui-btn_plain-disabled'>已设为管理员</button>");
										     }
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
                        , function(){
                            console.log('no');
                        }
                        , {title: '提示'}
                    );
        
        }
        
    </script>
    <style type="text/css">
        body {background-color: #f8f8f8}
        th{text-align: center;}
        td{text-align: center;}
    </style>

</head>
<body>

    <div id="root">
       <div class="">
           <table id="yhtable" class="table table-striped">
               <thead>
                   <tr>
                       <th>openid</th>
                       <th>昵称</th>
                       <th>操作</th>
                   </tr>
               </thead>
               <tbody>
               	<c:forEach var="weixinuser" items="${allUser}" varStatus="status">
                     <tr>
                         <td>${fn:substring(weixinuser.openid, 0, 10)}...</td>
          				 <td>${weixinuser.nickname }</td>
                         <td>
                         	<c:if test="${weixinuser.admin=='1' }">
								<c:if test="${loginUser.openid==weixinuser.openid }">
                      				<button style="width: 112.3px;" class="weui-btn weui-btn_mini weui-btn_plain-disabled">自己</button>
                      			</c:if>
                      			<c:if test="${loginUser.openid!=weixinuser.openid }">
                      				<button style="width: 112.3px;" onclick="canceladmin('${weixinuser.openid }','${weixinuser.nickname }',this)" class="weui-btn weui-btn_mini weui-btn_warn">取消管理员</button>
                      			</c:if>
                			</c:if>
                			<c:if test="${weixinuser.admin!='1' }">
                   				<button style="width: 112.3px;" onclick="setadmin('${weixinuser.openid }','${weixinuser.nickname }',this)" class="weui-btn weui-btn_mini weui-btn_primary">设为管理员</button>
                			</c:if>
                         </td>
                     </tr>
				</c:forEach> 
               </tbody>
           </table>
       </div>
    </div>

</body>
</html>
