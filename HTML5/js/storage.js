function check(){
	if(localStorage.getItem("login") === null){
		document.getElementById("get").style.display="none";
		document.getElementById("remove").style.display="none";
		document.getElementById("err-msg").style.display="none";
	}
	if(localStorage.getItem("instruction") != null){
		document.getElementById("Instruction-layer").style.display="none";
	}
	document.getElementById("err-msg").style.display="none";
}
function getStore(){
	var msg = document.getElementById("msg");
	msg.innerHTML = "Hello "+ localStorage.getItem("login") + " !!";
}
function saveStore(){
	var text = document.getElementById("textbox");
	var atPos = text.value.indexOf("@");
	var dotPos = text.value.lastIndexOf(".");

	if (atPos<1 || dotPos<atPos+2 || dotPos+2>=text.value.length) {
    	document.getElementById("err-msg").style.display="block";
		document.getElementById("err-msg").innerHTML = "Please enter a valid email !!";
	}else if(text.value === ""){
		document.getElementById("err-msg").style.display="block";
		document.getElementById("err-msg").innerHTML = "Login field can't be empty !!";
	}else{
		localStorage.setItem("login", text.value);
		text.value = "";
		document.getElementById("get").style.display="inline-block";
		document.getElementById("remove").style.display="inline-block";
		document.getElementById("err-msg").style.display="none";
	}
}

function removeLogin(){
	if(localStorage.getItem("login") != null){
		localStorage.removeItem("login");
		document.getElementById("get").style.display="none";
		document.getElementById("remove").style.display="none";
		var msg = document.getElementById("msg");
		msg.innerHTML = "Hello Guest !!";
	}
}
