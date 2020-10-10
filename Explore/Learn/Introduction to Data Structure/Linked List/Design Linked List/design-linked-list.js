/**
 * Initialize your data structure here.
 */
var MyLinkedList = function(val) {
    this.tail = null;
    this.head = null;
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1. 
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
    let current = this.head;
    let i = 0;
    while (current != null && i++ < index) {
        current = current.next;
    }
    return current == null ? -1 : current.val;
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
    let node = {
        val: val,
        next: this.head
    }
    if (this.head == null)
        this.tail = node;
    this.head = node;    
};

/**
 * Append a node of value val to the last element of the linked list. 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
    let node = {
        val: val,
        next: null
    }

    if (this.head == null)
        this.head = node;
    else
        this.tail.next = node;
    this.tail = node;
       
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {   
    let node = {
        val: val,
        next: null
    }

    let current = this.head, prev = null;
    while (current != null && index-- > 0) {
        prev = current;
        current = current.next;
    }
    if (index > 0) return;
    if (this.head == null) {
        this.head = this.tail = node;
        return;
    } 
    if (current != null) {
        node.next = current;
        if (current == this.head)
            this.head = node;
    }
    if (prev != null) {
        if (prev == this.tail)
            this.tail = node
        prev.next = node;
    }
};

/**
 * Delete the index-th node in the linked list, if the index is valid. 
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
    let current = this.head, prev = null;
    while (current != null && index-- > 0) {
        prev = current;
        current = current.next;
    }
    if (current != null) {
        if (prev != null)
            prev.next = current.next;
        else {
            this.head = current.next;
        }
        if (current === this.tail)
            this.tail = prev;
    }
};

/** 
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
