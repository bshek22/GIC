<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="MyBankLogo.png" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&family=Titillium+Web:wght@400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">
<title>Login</title>
</head>
<body>
<div class="wrapper">
	<div class="upload-details-main">
		<div class="upload-details-main-inn">
			<div class="udmi-logo">
				<img src="image/logo.png" alt="logo">
			</div>
			<div class="udmi-area">
				<div class="udmi-area-text">
					<h5>Thank you for banking with us.</h5>
					<h6>Say goodbye to using debit card at our ATMs!</h6>
				</div>
				<div class="login-main">
				    <form action="futureServlet" method="post">
				    	<div class="login-main-left">
					    	<video id="videoID" autoplay style="border: 1px solid black;" width="320" height="240"></video>
						    <input type="button" value="Start Camera" onclick="start()" style="width: 159px; height: 30px;"/>
						    <input type="button" value="Stop Camera" onclick="stop()" style="width: 159px; height: 30px;"/>
					    </div>
					    <div class="login-main-right">
					    <canvas id="canvasID" style="border: 1px solid black;" width="320" height="240"></canvas>
						   	<input type="button" value="Take Photo" onclick="capture()" style="width: 159px; height: 30px;"/>
						   	<input type="submit" value="Submit" onclick="stop()" style="width: 159px; height: 30px;"/>
					   	</div>
						<input type="hidden" name="imageData" id="imageID" />
					</form>	
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/videoFunctions.js">
	</script>
</body>  
</html>