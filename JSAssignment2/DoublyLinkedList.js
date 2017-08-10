//Class Node
function Node(data) {
    this.data = data;
    this.next = null;
    this.previous = null;
}
 
//Class Doubly Linked List
function DoublyLinkedList() {
    this.length = 0;
    this.head = null;
    this.tail = null;
}
 
/*
    Method - add
    Parameter - value
    Return - New Node
*/
DoublyLinkedList.prototype.add = function(value) {
    var node = new Node(value);

    if (this.length) {
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
    } else {
        this.head = node;
        this.tail = node;
    }
 
    this.length++;
     
    return node;
};
 
/*
    Method - search
    Parameter - position
    Return Data at specified position
*/ 
DoublyLinkedList.prototype.search = function(position) {
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
DoublyLinkedList.prototype.remove = function(position) {
    var currentNode = this.head;
    var length = this.length;
    var count = 1;
    var previousNode = null;
    var nextNode = null;
    var nodeToDelete = null;
    var deletedNode = null;
 
    if (length === 0 || position < 1 || position > length) {
        return null;
    }
 
    if (position === 1) {
        this.head = currentNode.next;
 
        if (this.head != null) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }
 
    } else if (position === this.length) {
        this.tail = this.tail.previous;
        this.tail.next = null;
    } else {
        while (count < position) {
            currentNode = currentNode.next;
            count++;
        }
 
        previousNode = currentNode.previous;
        nodeToDelete = currentNode;
        nextNode = currentNode.next;
 
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        deletedNode = nodeToDelete;
        nodeToDelete = null;
    }
 
    this.length--;
 
    return deletedNode;
};
