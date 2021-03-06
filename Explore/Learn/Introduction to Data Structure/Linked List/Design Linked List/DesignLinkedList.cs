public class MyNode {
    public int val;
    public MyNode next;
    public MyNode(int val) {
        this.val = val;
    }
}


public class MyLinkedList {
    public int length;
    public MyNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int Get(int index) {
        if (index < 0 || index >= length) return -1;
        if (index == 0) return head.val;
        else {
            MyNode current = head;
            for (int i=0; i<index; i++) {
                current = current.next;
            }
            return current.val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void AddAtHead(int val) {
        MyNode first = new MyNode(val);
        first.next = head;
        head = first;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void AddAtTail(int val) {
        MyNode last = new MyNode(val);
        MyNode current = head;
        if (length == 0) {
            head = last;
            length++;
        } else {
            for (int i=0; i<length-1; i++) {
                current = current.next;
            }
            current.next = last;
            length++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void AddAtIndex(int index, int val) {
        if (index < 0 || index > length) AddAtTail(val);
        else if (index == 0) AddAtHead(val);
        else {
            MyNode insert = new MyNode(val);
            MyNode prev = head;
            MyNode next;
            for (int i=0; i<index-1; i++) {
                prev = prev.next;
            }
            next = prev.next;
            prev.next = insert;
            insert.next = next;
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void DeleteAtIndex(int index) {
        if (index < 0 || index >= length) return;
        else if (index == 0) {
            head = head.next;
            length--;
        } else {
            MyNode current = head;
            for (int i=0; i<index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
