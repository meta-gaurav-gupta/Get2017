var x = document.getElementById("demo");
var error = document.getElementById("err-msg");

function getLocation() {
	var e = document.getElementById("err-msg").style.display = "block";
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else { 
        error.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {
	var e = document.getElementById("err-msg").style.display = "block";
	 setTimeout(function(){ 
	 	x.innerHTML = "<div class='table-white'>Latitude: " + position.coords.latitude + 
    "</div><div class='table-grey'>Longitude: " + position.coords.longitude + "</div>";
        var m = document.getElementById("right-box").style.display = "block";
        var e = document.getElementById("err-msg").style.display = "none";
    }, 2000);
}