<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<
<html lang="en">
<head>
<link rel="shortcut icon" href="MyBankLogo.png" />
<title>Express File Upload</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="./styles/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<img src="MyBankLogo.png" alt="logo">
			<h1>Authentication</h1>
		</div>
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"></div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="col-sm-12">
			<div class="form">
				<h1>Upload your photo to Login!</h1>

				<!-- IMAGE UPLOAD FORM -->
				<form action="futureServlet" enctype="multipart/form-data"
					method="POST">

					<div class="section">Note: Only image files are allowed.</div>
					<div class="inner-wrap">
						<label><input type="file" name="inputPhoto" /></label>
						<div class="btn-block">
							<!--input type="submit" name="Upload" value="Upload Photo" /-->
							<button type="submit" name="Upload" value="Upload Photo">Submit Details</button>
						</div>
					</div>
			</div>
			</form>


		</div>
	</div>
	</div>



</body>
</html>