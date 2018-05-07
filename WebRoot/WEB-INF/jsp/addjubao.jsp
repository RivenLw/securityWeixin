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
    <!-- <script type="text/javascript" src="js/uploadexample.js"></script> -->
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    
    <script type="text/javascript">
        $(function(){
        
        	// 允许上传的图片类型
			var allowTypes = [ 'image/jpg', 'image/jpeg', 'image/png', 'image/gif' ];
			// 1024KB，也就是 1MB
			var maxSize = 10240 * 1024;
			// 图片最大宽度
			var maxWidth = 1920;
			// 最大上传图片数量
			var maxCount = 5;
			$('.js_file').on('change', function(event) {
				var files = event.target.files;
				// 如果没有选中文件，直接返回
				if (files.length === 0) {
					return;
				}
				for (var i = 0, len = files.length; i < len; i++) {
					var file = files[i];
					var reader = new FileReader();
					// 如果类型不在允许的类型范围内
					if (allowTypes.indexOf(file.type) === -1) {
						weui.alert('该类型不允许上传');
						continue;
					}
 					if (file.size > maxSize) {
 						weui.alert('图片太大，不允许上传');
 						continue;
 					}
 					if ($('.weui_uploader_file').length >= maxCount) {
 						weui.alert('最多只能上传' + maxCount + '张图片');
 						return;
 					}
					reader.onload = function(e) {
						var img = new Image();
						img.onload = function() {
							// 不要超出最大宽度
							var w = Math.min(maxWidth, img.width);
							// 高度按比例计算
							var h = img.height * (w / img.width);
							var canvas = document.createElement('canvas');
							var ctx = canvas.getContext('2d');
							// 设置 canvas 的宽度和高度
							canvas.width = w;
							canvas.height = h;
							ctx.drawImage(img, 0, 0, w, h);
							var base64 = canvas.toDataURL('image/png');

							// 插入到预览区
							var $preview = $('<li class="weui-uploader__file weui-uploader__file_status" style="background-image:url('
									+ base64 + ')"><div class="weui-uploader__file-content">0%</div><input type="text" style="display:none;" class="base64code" value='+base64+'></li>');

							$('.weui-uploader__files').append($preview);
							
							//base64数据插入到隐藏域
							

							// 然后假装在上传，可以post base64格式，也可以构造blob对象上传，也可以用微信JSSDK上传
							var progress = 0;
							function uploading() {
								$preview.find('.weui-uploader__file-content').text(++progress + '%');
								if (progress < 100) {
									setTimeout(uploading, 30);
								} else {
									// 如果是失败，塞一个失败图标
									//$preview.find('.weui-uploader__file-content').html('<i class="weui_icon_warn"></i>');
									$preview.removeClass('weui-uploader__file_status')
											.find('.weui-uploader__file-content')
											.remove();
								}
							}
							setTimeout(uploading, 30);
						};
						img.src = e.target.result;
					};
					reader.readAsDataURL(file);
				}
			});
        
        
        	// 缩略图预览
			$('#uploaderCustomFiles').on('click', function (e) {
			    var target = e.target;
		
			    while (!target.classList.contains('weui-uploader__file') && target) {
			        target = target.parentNode;
			    }
			    if (!target) return;
		
			    var url = target.getAttribute('style') || '';
			    var id = target.getAttribute('data-id');
		
			    if (url) {
			        url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
			    }
			    var gallery = weui.gallery(url, {
			        className: 'custom-name',
			        onDelete: function onDelete() {
			            weui.confirm('确定删除该图片？', function () {
			                target.remove();
			                gallery.hide();
			            });
			        }
			    });
			});
        

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

			var loading = weui.loading('正在保存', {
			    className: 'custom-classname'
			});

            var jubaotype = $("#jubaotype").val();
            var name = $("#name").val();
            var phone = $("#phone").val();
            var idcard = $("#idcard").val();
            var jubaocontent = $("#jubaocontent").val();
            var base64codes = $(".base64code");

			

            var json = '{"jubaoType":"'+jubaotype
                +'","name":"'+name
                +'","phone":"'+phone
                +'","idcard":"'+idcard
                
                +'","base64codes":[ ';
                
		    	
		    	$.each(base64codes,function(index,element){
		    		if(index==0){
						var base64body = '"'+element.value+'"';
						json+=base64body;
					}else{
						var base64body = ',"'+element.value+'"'
						json+=base64body;
					}
		    	
        		})
                
                json+='],"jubaoContent":"'+jubaocontent+'"}'


            $.ajax({
                url: "jubao/savejubao.action",
                type: "post",
                contentType:'application/json;charset=utf-8',
                data: json,
                success: function (data) {
                	loading.hide();
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
                	loading.hide();
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
            $("#uploaderCustomFiles").empty();

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

		<div class="weui-cells__title">图片上传</div>
		<div class="weui-cells weui-cells_form" id="uploaderCustom">
			<div class="weui-cell">
				<div class="weui-cell__bd">
					<div class="weui-uploader">
						<div class="weui-uploader__bd">
							<ul class="weui-uploader__files" id="uploaderCustomFiles"></ul>
							<div class="weui-uploader__input-box">
								<input id="uploaderCustomInput" class="weui-uploader__input js_file"
									type="file" accept="image/*" multiple="" />
							</div>
						</div>
					</div>
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