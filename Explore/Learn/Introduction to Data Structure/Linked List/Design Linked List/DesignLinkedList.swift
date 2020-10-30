public class MyNode {
    public var val: Int
    public var next: MyNode?
    public var prev: MyNode?
    
    public init(_ val: Int) {
        self.val = val
    }
}


class MyLinkedList {
    var head: MyNode = MyNode(-1)
    var tail: MyNode = MyNode(-1)
    var length: Int = 0
    
    /** Initialize your data structure here. */
    init() {
        head.next = tail
        tail.prev = head
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    func get(_ index: Int) -> Int {
        guard index >= 0 && index < length else {
            return -1
        }
        var current: MyNode? = head.next
        var i = index
        while i > 0 {
            current = current?.next
            i -= 1
        }
        return current!.val
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    func addAtHead(_ val: Int) {
        let first = MyNode(val)
        first.next = head.next
        first.prev = head
        head.next?.prev = first
        head.next = first
        length += 1
    }
    
    /** Append a node of value val to the last element of the linked list. */
    func addAtTail(_ val: Int) {
        let last = MyNode(val)
        last.next = tail
        last.prev = tail.prev
        tail.prev?.next = last
        tail.prev = last
        length += 1
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    func addAtIndex(_ index: Int, _ val: Int) {
        guard index <= length && index >= 0 else {
            return
        }
        var prev: MyNode? = head
        var i = index
        while i > 0 {
            prev = prev?.next
            i -= 1
        }
        let insert = MyNode(val)
        insert.next = prev?.next
        insert.prev = prev
        prev!.next?.prev = insert
        prev!.next = insert
        length += 1
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    func deleteAtIndex(_ index: Int) {
        guard length > index && index >= 0 else {
            return
        }
        var current: MyNode? = head.next
        var i = index
        while i > 0 {
            current = current?.next
            i -= 1
        }
        current?.prev?.next = current?.next
        current?.next?.prev = current?.prev
        length -= 1
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * let obj = MyLinkedList()
 * let ret_1: Int = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index, val)
 * obj.deleteAtIndex(index)
 */
