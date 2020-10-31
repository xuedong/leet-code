type MyLinkedNode struct {
    val int
    next *MyLinkedNode
    prev *MyLinkedNode
}


type MyLinkedList struct {
    head *MyLinkedNode
    tail *MyLinkedNode
}


/** Initialize your data structure here. */
func Constructor() MyLinkedList {
    return MyLinkedList{nil, nil}
}


func (this *MyLinkedList) getNode(index int) (*MyLinkedNode, int) {
    if index < 0 {
        return nil, -1
    } else {
        var i = 0
        var node = this.head
        for node != nil && i < index {
            node = node.next
            i++
        }
        return node, i
    }
}


/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (this *MyLinkedList) Get(index int) int {
    var node, _ = this.getNode(index)
    if node == nil {
        return -1
    }
    return node.val
}


/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int)  {
    if this.head == nil {
        this.head = &MyLinkedNode{val: val, next: nil, prev: nil}
        this.tail = this.head
    } else {
        var node = &MyLinkedNode{val: val, next: this.head, prev: nil}
        this.head.prev = node
        this.head = node
    }
}


/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int)  {
    if this.tail == nil {
        this.AddAtHead(val)
    } else {
        var node = &MyLinkedNode{val: val, next: nil, prev: this.tail}
        this.tail.next = node
        this.tail = node
    }
}


/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int)  {
    if index == 0 {
        this.AddAtHead(val)
    } else {
        var node, i = this.getNode(index)
        if node == nil {
            if i == index {
                this.AddAtTail(val)
            }
        } else {
            var insert = &MyLinkedNode{val: val, next: node, prev: node.prev}
            node.prev.next = insert
            node.prev = insert
        }
    }
}


/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int)  {
    var node, _ = this.getNode(index)
    if node == nil {
        return
    }
    if node.next != nil {
        node.next.prev = node.prev
    }
    if node.prev != nil {
        node.prev.next = node.next
    }
    if node == this.head {
        this.head = node.next
    }
    if node == this.tail {
        this.tail = node.prev
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
