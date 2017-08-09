//Class Stack
function Stack(){
	this.size = 0;
	this.stack = {};
}

/*
	Method - push
	Parameter - data
	Push(Add) Data onto stack
*/
Stack.prototype.push = function(data){
	var top = ++this.size;
	this.stack[top] = data;
}

/*
	Method - pop
	Return - deleted data
	Pop(Delete) data from top of the stack
*/
Stack.prototype.pop = function(){
	var top = this.size;
	var deletedData;
	if(top){
		deletedData = this.stack[top];
		delete this.stack[top];
		this.size--;
	}
	return deletedData;
}