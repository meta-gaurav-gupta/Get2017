/*
	function to update Time after 2 minutes
*/
function timedCount() {
	var currentTime = new Date();

	var currentOffset = currentTime.getTimezoneOffset();

	var ISTOffset = 330;   // IST offset UTC +5:30 

	var ISTTime = new Date(currentTime.getTime() + (ISTOffset + currentOffset) * 60000);

	// ISTTime now represents the time in IST coordinates

	var hoursIST = ISTTime.getHours();
	var minutesIST = ISTTime.getMinutes();
	var secondIST = ISTTime.getSeconds();

    postMessage("<b>" + hoursIST + ":" + minutesIST + ":" + secondIST + " " + "</b>");
    setTimeout("timedCount()", 120000); // timeout for 2 minutes
}

timedCount();
