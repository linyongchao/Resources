<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MD5</title>
<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../js/md5.js"></script>
<script type="text/javascript">
function checkMD5(){
	$("#after").html($.md5($("#before").val()));
}
</script>
</head>
<body>
	<h3>说明</h3>
	<p>该插件基于 jquery ，所以还需要引入 jquery 文件</p>
	<h3>实现</h3>
	<pre>
function checkMD5(){
	$("#after").html($.md5($("#before").val()));
}
	</pre>
	<h3>效果</h3>
	<p><input type="text" id="before" /></p>
	<p><span id="after"></span></p>
	<p><input type="button" onclick="checkMD5()" value="MD5"/></p>
	<h3>下载</h3>
	<p><a href="../Support?type=down&name=md5.js">插件下载</a></p>
</body>
</html>