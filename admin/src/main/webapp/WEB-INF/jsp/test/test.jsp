<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="/admin/com/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		function mysub() {
			var user = {
					"name":"xiaoxian",
					"age":31
			};
			$.ajax({
				data:user,
				type:"POST",
				dataType:"json",
				url:"/admin/test/ajax",
				//xhrFields:{withCredentials: true},
				error:function(data){
					alert("fail");
				},
				success:function(data) {
					var code = data.code;
					var desc = data.desc;
					if (code!=0) {
						alert("fail");
						return;
					}
					
					var info = data.info;
					cbOk(info);	//回调
				}
			});
		}
		
		function cbOk(info) {
			alert("hello");
		}
	</script>
</head>
<body>
	<input id="mysubmit" type="button" value="ajax提交" onclick="mysub();"/>
</body>
</html>