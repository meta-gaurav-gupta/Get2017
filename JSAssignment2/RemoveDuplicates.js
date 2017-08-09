/*
	Method to remove the consecutive repeating string
	example - input "eeabcddcbfgf" => output "afgf"
	Method - removeDuplicates
	Parameter - String input
*/
function removeDuplicates(input){
	var output = input;

	while(true){
		var counter = 0;	

		for(var indexOfOutput = 0; indexOfOutput < output.length; indexOfOutput++){
			//check if two consecutive characters are same
			if(output.charAt(indexOfOutput) === output.charAt(indexOfOutput + 1)){		 
				counter++;
			} else if (counter !== 0) {
				output = output.slice(0, indexOfOutput - counter) + output.slice(indexOfOutput + 1, output.length);
				break;
			}
		}

		if(counter === 0){
			break;
		}
	}

	return output;
}