//Class Queue
function Queue(){
	this.first = 1;
	this.last = 1;
	this.queue = {};
}

/*
	Method - size
	Return size of Queue 
*/
Queue.prototype.size = function(){
	return this.last - this.first;
}

/*
	Method - enqueue
	Parameter - data
	Add data at last in Queue
*/
Queue.prototype.enqueue = function(data){
	this.queue[this.last] = data;
	this.last++;
}

/*
	Method - dequeue
	Return - deleted data
	Dequeue(remove) data from first position of Queue
*/
Queue.prototype.dequeue = function(){
	var first = this.first;
	var last = this.last;
	var deletedData;

	if(first !== last){
		deletedData = this.queue[this.first];
		delete this.queue[this.first];
		this.first++;
	}

	return deletedData;
}