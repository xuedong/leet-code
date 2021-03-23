class Node {
    public val: number;
    public next: Node;

    constructor(val) {
        this.val = val;
        this.next = null;
    }
}


class MyLinkedList {
    public length: number;
    public head: Node;

    constructor() {
        this.length = 0;
        this.head = null;
    }

    get(index: number): number {
        if (index < 0 || index >= this.length) {
            return -1;
        }
        if (!this.head) {
            return -1;
        }
        
        let current = this.head;
        for (let i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current.val;
    }

    addAtHead(val: number): void {
        this.addAtIndex(0, val);
    }

    addAtTail(val: number): void {
        this.addAtIndex(this.length, val);
    }

    addAtIndex(index: number, val: number): void {
        if (index < 0 || index > this.length) {
            return;
        }
        
        const node = new Node(val);
        if (index == 0) {
            node.next = this.head;
            this.head = node;
        } else {
            let current = this.head;
            if (!current) {
                this.head = node;
            } else {
                for (let i = 0; i < index-1; i++) {
                    current = current.next;
                }
                node.next = current.next;
                current.next = node;
            }
        }

        this.length += 1;
    }

    deleteAtIndex(index: number): void {
        if (index < 0 || index >= this.length) {
            return;
        }
        
        let current = this.head;
        if (index == 0) {
            this.head = current.next;
        } else {
            for (let i = 0; i < index-1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        this.length -= 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
