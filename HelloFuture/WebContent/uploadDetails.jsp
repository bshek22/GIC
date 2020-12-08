<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Future Bank</title>
</head>
<body>
<h1>Welcome to the future Banking</h1>
	<form action="uploadUserDetails" method="post" enctype="multipart/form-data">
		Upload photo to Register:
		<br/><br/>
		<input type="file" id="uploadPhoto" name="inputPhoto" /> 
		<br/><br/>
		<label for="fname">Full name:</label><br/>
	  	<input type="text" id="fname" name="fname"><br><br>
		<input type="submit" value="Upload" />	
	</form>
</body>
</html>