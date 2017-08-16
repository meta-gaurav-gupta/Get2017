/*
	function saves the data which is submitted by user.
*/
function saveToLocalStorage(){

	// if localStorage is not yet set.
	if(localStorage.getItem("data") != null){
		localStorage.removeItem("data");
	}

	var JsonObj = {data : []}; // a JSON objectt which stroes the data of user as key value pair in a JSON array

	var name = document.getElementById('username').value;
	JsonObj.data.push({"name" : name}); // push the name to the JSON array

	var email = document.getElementById('useremail').value;
	JsonObj.data.push({"email" : email}); // push the email to the JSON array

	var city = document.getElementById('usercity').value; 
	JsonObj.data.push({"city" : city}); // push the city to the JSON array

	var organisation = document.getElementById('userorg').value;
	JsonObj.data.push({"org" : organisation}); // push the organization to the JSON array

	var contact = document.getElementById('usermob').value;
	JsonObj.data.push({"contact" : contact}); // push the contact to the JSON array

	var message = document.getElementById('usermessage').value;
	JsonObj.data.push({"message" : message}); // push the message to the JSON array

	localStorage.setItem("data", JSON.stringify(JsonObj)); // set the localStorage

	document.getElementById("info").innerHTML = "Data Saved!";
	document.getElementById("info").style.display = "block";
}

function getFromLocalStorage(){
	// set the input fields only if localStorage is set.
	if (localStorage.getItem("data") != null){
		document.getElementById('username').value = JSON.parse(localStorage.getItem("data")).data[0].name;
		document.getElementById('useremail').value = JSON.parse(localStorage.getItem("data")).data[1].email;
		document.getElementById('usercity').value = JSON.parse(localStorage.getItem("data")).data[2].city;
		document.getElementById('userorg').value = JSON.parse(localStorage.getItem("data")).data[3].org;
		document.getElementById('usermob').value = JSON.parse(localStorage.getItem("data")).data[4].contact;
		document.getElementById('usermessage').value = JSON.parse(localStorage.getItem("data")).data[5].message;
	}
	
}

function clearLocalStorage(){
	if (localStorage.getItem("data") != null ){
		localStorage.removeItem("data");
		alert("Data Cleared!");
		location.reload();
	}
}