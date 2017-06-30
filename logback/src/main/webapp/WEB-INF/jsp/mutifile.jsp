<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>

	<form method="POST" enctype="multipart/form-data"
		action="/batch/upload">

		<p>
			文件1：<input type="file" name="file" />
		</p>

		<p>
			文件2：<input type="file" name="file" />
		</p>

		<p>
			文件3：<input type="file" name="file" />
		</p>

		<p>
			<input type="submit" value="上传" />
		</p>

	</form>
</html>
