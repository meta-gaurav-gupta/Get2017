//Class Node
function Node(data) {
    this.data = data;
    this.next = null;
}

//Class Singly Linked List
function SinglyLinkedList() {
    this.length = 0;
    this.head = null;
}
 
/*
	Method - add
	Parameter - value
	Return - New Node
*/
SinglyLinkedList.prototype.add = function(value) {
    var node = new Node(value);
    var currentNode = this.head;

    if (!currentNode) {
        this.head = node;
        this.length++;
 
        return node;
    }
 
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
 
    currentNode.next = node;
 
    this.length++;
     
    return node;
};

/*
	Method - search
	Parameter - position
	Return Data at specified position
*/ 
SinglyLinkedList.prototype.search = function(position) {
    var currentNode = this.head;
    var length = this.length;
    var count = 1;
 
    if (length === 0 || position < 1 || position > length) {
    	return null;
    }
 
    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }
 
    return currentNode;
};
 
/*
	Method - remove
	Parameter - position
	Return - deleted data
*/
SinglyLinkedList.prototype.remove = function(position) {
    var currentNode = this.head;
    var length = this.length;
    var count = 0;
    var previousNode = null;
    var nodeToDelete = null;
    var deletedNode = null;
 
    if (position < 0 || position > length) {
    	return null;
    }
 
    if (position === 1) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this.length--;
         
        return deletedNode;
    }
 
    while (count < position) {
        previousNode = currentNode;
        nodeToDelete = currentNode.next;
        count++;
    }
 
    previousNode.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this.length--;
 
    return deletedNode;
};