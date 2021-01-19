struct MyNode {
    int val;
    MyNode *next;
    MyNode(int x) : val(x), next(NULL) {}
};


class MyLinkedList {
public:
    MyNode *head;
    int length;
    
    /** Initialize your data structure here. */
    MyLinkedList() {
        head = NULL;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index < 0 || index >= length)
            return -1;
        if (index == 0) {
            return head->val;
        } else {
            MyNode *current = head;
            for (int i=0; i<index; i++) {
                current = current->next;
            }
            return current->val;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        MyNode *first = new MyNode(val);
        first->next = head;
        head = first;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        MyNode *last = new MyNode(val);
        MyNode *current = head;
        if (length == 0) {
            head = last;
            length++;
        } else {
            for (int i=0; i<length-1; i++) {
                current = current->next;
            }
            current->next = last;
            length++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            MyNode *insert = new MyNode(val);
            MyNode *prev = head;
            MyNode *next;
            for (int i=0; i<index-1; i++) {
                prev = prev->next;
            }
            next = prev->next;
            prev->next = insert;
            insert->next = next;
            length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        } else if (index == 0) {
            head = head->next;
            length--;
        } else {
            MyNode *current = head;
            for (int i=0; i<index-1; i++) {
                current = current->next;
            }
            current->next = current->next->next;
            length--;
        }
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */
