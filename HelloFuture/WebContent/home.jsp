<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>BankTeller</title>
<meta name="author" content="lafranch">
<meta name="description" content="Lex Runtime example from the browser.">
<meta name="keywords" content="Amazon Lex, SDK, Runtime, Browser, JavaScript">
<link rel="icon" type="image/png" href="image/favicon-32x32.png" sizes="32x32"/>
<link rel="icon" type="image/png" href="image/favicon-16x16.png" sizes="16x16"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&family=Titillium+Web:wght@400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="./styles/style.css">
</head>

<body>
<div class="wrapper">
	<div class="upload-details-main">
		<div class="upload-details-main-inn">
			<div class="udmi-logo">
				<img src="images/logo.png" alt="logo">
			</div>
			<div class="udmi-area">
				<div class="audio-control-main">
					<!-- <h2>Hello <%=request.getAttribute("userName")%></h2>-->
					<h2>Hello Bijoy Biswas</h2>					
					<div class="audio-control">
					    <div id="audio-control" class="white-circle">
					        <img src="image/lex.png">
					        <canvas class="visualizer"></canvas>
					    </div>
					    <p id="message"></p>
					    <input type="hidden" id="ACCESS_ID" name="ACCESS ID" placeholder="ACCESS ID" value=""/>
					    <input type="hidden" id="SECRET_KEY" name="SECRET KEY" placeholder="SECRET KEY" value=""/>
					    <input type="hidden" id="BOT" name="BOT" placeholder="BOT" value="BankTeller"/>
					</div>
					<div class="btn-block">
						<a href="index.html">Logout</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://sdk.amazonaws.com/js/aws-sdk-2.48.0.min.js"></script>
<script src="dist/aws-lex-audio.js" type="text/javascript"></script>
<script src="js/renderer.js" type="text/javascript"></script>
<script type="text/javascript">
    var waveform = window.Waveform();
    var message = document.getElementById('message');
    var config, conversation;
    message.textContent = 'Passive';
    document.getElementById('audio-control').onclick = function () {
        AWS.config.credentials = new AWS.Credentials(document.getElementById('ACCESS_ID').value, document.getElementById('SECRET_KEY').value, null);
        AWS.config.region = 'us-east-1';
        
        config = {
            lexConfig: { botName: document.getElementById('BOT').value }
        };
        conversation = new LexAudio.conversation(config, function (state) {
            message.textContent = state + '...';
            if (state === 'Listening') {
                waveform.prepCanvas();
            }
            if (state === 'Sending') {
                waveform.clearCanvas();
            }
        }, function (data) {
            console.log('Transcript: ', data.inputTranscript, ", Response: ", data.message);
        }, function (error) {
            message.textContent = error;
        }, function (timeDomain, bufferLength) {
            waveform.visualizeAudioBuffer(timeDomain, bufferLength);
        });
        conversation.advanceConversation();
    };
</script>
</body>

</html>