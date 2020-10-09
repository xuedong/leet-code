class MyNode(object):
    
    def __init__(self, val):
        self.val = val
        self.next = None


class MyLinkedList(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.length = 0
        self.head = None
        

    def get(self, index):
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= self.length:
            return -1
        if index == 0:
            return self.head.val
        else:
            current = self.head
            for i in range(index):
                current = current.next
            return current.val
        

    def addAtHead(self, val):
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        :type val: int
        :rtype: None
        """
        first = MyNode(val)
        first.next = self.head
        self.head = first
        self.length += 1
        

    def addAtTail(self, val):
        """
        Append a node of value val to the last element of the linked list.
        :type val: int
        :rtype: None
        """
        last = MyNode(val)
        current = self.head
        if self.length == 0:
            self.head = last
            self.length += 1
        else:
            for _ in range(self.length-1):
                current = current.next
            current.next = last
            self.length += 1
        

    def addAtIndex(self, index, val):
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        :type index: int
        :type val: int
        :rtype: None
        """
        if index < 0 or index > self.length:
            return;
        elif index == 0:
            self.addAtHead(val)
        elif index == self.length:
            self.addAtTail(val)
        else:
            insert = MyNode(val)
            prev = self.head
            for _ in range(index-1):
                prev = prev.next
            succ = prev.next
            prev.next = insert
            insert.next = succ
            self.length += 1
        

    def deleteAtIndex(self, index):
        """
        Delete the index-th node in the linked list, if the index is valid.
        :type index: int
        :rtype: None
        """
        if index < 0 or index >= self.length:
            return
        elif index == 0:
            self.head = self.head.next
            self.length -= 1
        else:
            current = self.head
            for _ in range(index-1):
                current = current.next
            current.next = current.next.next
            self.length -= 1


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)

