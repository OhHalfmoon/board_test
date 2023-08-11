<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>FileUpload Test</title>
</head>
<body>

<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">

<div>
	<input type="file" name="files">
</div>
<div>
	<input type="file" name="files">
</div>
<div>
	<input type="file" name="files">
</div>
<div>
	<input type="file" name="files">
</div>
<div>
	<input type="file" name="files">
</div>
<div>
	<input type="submit">
</div>
</form>

</body>
</html>
