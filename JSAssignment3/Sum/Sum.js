/*
	function return the sum of two numbers
*/
function sum(firstOperand, secondOperand) {
    
    var sum = function (secondOperand) {
    	return firstOperand+secondOperand;
    };

    if (typeof secondOperand == 'undefined') {
        return sum;
    } else {
        return sum(secondOperand);
    }
}