<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="MyBankLogo.png" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&family=Titillium+Web:wght@400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./styles/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	window.addEventListener("DOMContentLoaded", function () {
		jQuery("#upload-photo-area").on("change", function(){
	        var files = !!this.files ? this.files : [];
	        if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support

	        if (/^image/.test( files[0].type)){ // only image file
	            var reader = new FileReader(); // instance of the FileReader
	            reader.readAsDataURL(files[0]); // read the local file

	            reader.onloadend = function(){ // set image data as background of div
	            	jQuery("#upload-photo-show").prepend("<img src="+this.result+" />");
	            }
	        }
	    });
		jQuery('#up-photo-text').click(function(){
			jQuery('#upload-photo-area').click();
		});
		jQuery('#tak-photo-text').click(function(){
			jQuery('#upload-photo-show').find('img').remove();
			jQuery('.take-photo-show-pop').addClass('take-photo-show-pop-open');
		});
		jQuery('.take-photo-show-pop-close').click(function(){
			jQuery('.take-photo-show-pop').removeClass('take-photo-show-pop-open');
		});
	});
</script>
<title>Registration</title>
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
				
				<form action="uploadUserDetails" method="post" enctype="multipart/form-data">
					<div class="udmi-area-form">
						<div class="udmi-item">					
							<label>Full Name<span class="required">*</span></label>
							<input type="text" id="fname" name="fname" placeholder="Full Name" required />
						</div>
						<div class="udmi-item">
							<label>Email<span class="required">*</span></label>
							<input type="text" name="name" placeholder="email id" required />
						</div>
						<div class="udmi-item">
							<label>Phone<span class="required">*</span></label>
							<input type="text" id="phoneNumber" name="phoneNumber" placeholder="phone number" required />
						</div>
						<div class="udmi-item">
							<label>Date of Birth<span class="required">*</span></label>
							<input type="date" name="bdate" placeholder="mm/dd/yyyy" required />
						</div>
						<div class="udmi-item udmi-item-full">
							<div class="udmi-item-inn">
								<span>
									<input type="radio" id="tak-photo" name="ta-up" value="">
									<label for="tak-photo" id="tak-photo-text">Take photo</label>
								</span>								
								<div id="take-photo-show" class="udmi-item-img">
									
								</div>
							</div>
							<div class="take-photo-show-pop"> 
								<div class="take-photo-show-pop-inn"> 
									<div class="tpspi-left">	
									    <video id="videoID" autoplay style="border: 1px solid black;" width="320" height="240"></video>								    
									    <input type="button" value="Start Camera" onclick="start()" style="width: 159px; height: 30px;"/>
									    <input type="button" value="Stop Camera" onclick="stop()" style="width: 159px; height: 30px;"/>
								    </div>
								    <div class="tpspi-right">
									    <canvas id="canvasID" style="border: 1px solid black;" width="320" height="240"></canvas>
									   	<input type="button" value="Take Photo" onclick="capture()" style="width: 159px; height: 30px;"/>
									   	<input type="button" class="take-photo-show-pop-close" value="Done" onclick="stop()" style="width: 159px; height: 30px;"/>
								   	</div>
									<input type="hidden" name="imageData" id="imageID" />
								</div>  	
						   	</div>
							<div class="udmi-item-inn">
								<span>
									<input type="radio" id="up-photo" name="ta-up" value="">
									<label for="up-photo" id="up-photo-text">Upload photo</label>
								</span>
								<input type="file" id="upload-photo-area" name="inputPhoto" accept="image">
								<div id="upload-photo-show" class="udmi-item-img">
									
								</div>
							</div>
						</div>
					</div>
					<div class="btn-block">
						<button type="submit">Submit Details</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="videoFunctions.js">
</script>
</body>
</html>