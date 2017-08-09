/*
	Method return the length of a field.
*/
function getLength(value){
	return value.length;
}

/*
	Method returns the value of a specific id.
*/
function getValue(id){
	return document.getElementById(id).value;
}

/*
	Method changes the border for a specific div id.
*/
function changeBorder(id, Bordertype){
	document.getElementById(id).style.border = Bordertype;
}

/*
	Method changes the content of a specific div id.
*/
function setInnerHTML(id, content){
	document.getElementById(id).innerHTML = content;
}

/*
	Method sets the value of a field.
*/
function setValue(id,value){
	document.getElementById(id).value = value;
}

/*
	Method changes the display type of a specific div.
*/
function changeStyle(id,styleType){
	document.getElementById(id).style.visibility = styleType;
}

/*
	Method checks for the right username Format
	Format : username must be less than 20 chars.
*/
function checkUsername(id){
	if (id === "username") {
		var nameLength = getLength(getValue(id));
		if(nameLength > 20){
			changeBorder(id, "1px solid red");
			changeStyle("name-warning", "visible");
			setInnerHTML("name-warning", "<div class='box'>Name length must be less than 20 chars.</div>");
		}else if(getValue(id).match(/\d+/g) != null || getValue(id).match(/[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/) != null){
			changeBorder(id, "1px solid red");
			changeStyle("name-warning", "visible");
			setInnerHTML("name-warning", "<div class='box'>Name only have chars.</div>");
		}else{
			changeStyle("name-warning", "hidden");
			changeBorder(id, "thin solid #a9a9a9");
		}
	}
}

/*
	Method checks for the right email format
*/
function checkEmail(id){
	if (id === "useremail") {
		var atPos = getValue(id).indexOf("@");
		var dotPos = getValue(id).lastIndexOf(".");

		if (atPos < 1 || dotPos < atPos + 2 || dotPos + 2 >= getLength(getValue(id))) {
			changeStyle("email-warning", "visible");
			setInnerHTML("email-warning", "<div class='box'>Please enter a valid email.</div>");
			changeBorder(id, "1px solid red");
		} else {
			changeStyle("email-warning", "hidden");
			changeBorder(id, "thin solid #a9a9a9");
		}
	}
}

/*
	Method checks for the user city
	Format : city must be selected.
*/
function checkUserCity(id) {
	if (id === "usercity" && getValue(id) != "") {
		changeStyle("city-warning", "hidden");
		changeStyle("citymsg","visible");
		changeBorder(id, "thin solid #a9a9a9");
		setValue('citymsg', "You have selected city : " + getValue(id));
	} else if (id === "usercity" && getValue(id) == "") {
		changeStyle("city-warning", "visible");
		setInnerHTML("city-warning", "<div class='box'>Please choose a city</div>");
		changeBorder(id, "1px solid red");
		setValue('citymsg',"");
		changeStyle("citymsg","hidden");
	}
}

/*
	Method checks for the user organisation format.
	Format : user organisation must only have chars.
*/
function checkUserOrganisation(id) {
	if (id === "userorg") {
		if ((getValue(id).match(/\d+/g) != null || getValue(id).match(/[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/) != null)) {
			changeStyle("org-warning", "visible");
			setInnerHTML("org-warning", "<div class='box'>Organisation must contain only chars.</div>");
			changeBorder(id, "1px solid red");
		} else {
			changeStyle("org-warning", "hidden");
			changeBorder(id, "thin solid #a9a9a9");
		}
	}
}

/*
	Method checks for the user phone number format.
	Format : Phone number must be start from 7/8/9 and then followed by 9 numbers.
*/
function checkUserPhone(id) {
	if (id === "userphone" && getValue(id).length) {
		var pattern = /^[789]\d{9}$/
			if (pattern.test(getValue(id))) {
				changeBorder(id, "thin solid #a9a9a9");
				changeStyle("contact-warning", "hidden");
			} else {
				changeBorder(id, "1px solid red");
				changeStyle("contact-warning", "visible");
				setInnerHTML("contact-warning", "<div class='box'>Please Enter a valid Number.</div>");
			}
	}
}

/*
	Method checks for the user message format.
	Format : message must have length less than 250 chars.
*/
function checkUserMessage(id) {
	if (id === "usermessage") {
		messageLength = getLength(getValue(id));
		if (messageLength > 250) {
			changeStyle("message-warning", "visible");
			setInnerHTML("message-warning", "<div class='box'>Message length should be less than 250 chars.</div>");
			changeBorder(id, "1px solid red");
		} else {
			changeStyle("message-warning", "hidden");
			changeBorder(id, "thin solid #a9a9a9");
		}
	}
}

/*
	Method calls all the validator methods
*/
function validateOnKeyPress(id, e) {
	checkUsername(id); // checks username for right format
	checkEmail(id);		// checks user email for right format
	checkUserCity(id);	// checks user city 
	checkUserOrganisation(id);	// checks user organisation 
	checkUserPhone(id);	// checks user phone number
	checkUserMessage(id);	// checks user message
}
