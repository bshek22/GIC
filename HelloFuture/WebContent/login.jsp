<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="MyBankLogo.png" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&family=Titillium+Web:wght@400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./styles/style.css">
<title>Login</title>
</head>
<body>
<div class="wrapper">
	<div class="upload-details-main">
		<div class="upload-details-main-inn">
			<div class="udmi-logo">
				<img src="images/logo.png" alt="logo">
			</div>
			<div class="udmi-area">
				<div class="udmi-area-text">
					<h5>Thank you for banking with us. <span>Please register your photo to help us serve you better.</span></h5>
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

<script type="text/javascript" src="videoFunctions.js">
		/* var video = document.getElementById('videoID');
		var canvas = document.getElementById('canvasID');
		var context = canvas.getContext('2d');
		function capture() {
			context.drawImage(video, 0, 0, canvas.width, canvas.height);
			document.getElementById('imageID').value = canvas.toDataURL("image/png");
		};
		
		var stop = function() {
			  var stream = video.srcObject;
			  var tracks = stream.getTracks();
			  for (var i = 0; i < tracks.length; i++) {
			    var track = tracks[i];
			    track.stop();
			  }
			  video.srcObject = null;
		}
		var start = function() {
			var video = document.getElementById("videoID"),
			 vendorUrl = window.URL || window.webkitURL;
			if (navigator.mediaDevices.getUserMedia) {
				navigator.mediaDevices.getUserMedia({ video: true })
				.then(function (stream) {
				  video.srcObject = stream;
				}).catch(function (error) {
				  console.log("Something went wrong!");
				});
			}
		} */
	</script>
</body>  
</html>