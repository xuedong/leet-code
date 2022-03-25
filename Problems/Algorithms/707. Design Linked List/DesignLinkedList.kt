class MyLinkedList() {

    /** Initialize your data structure here. */
    private data class Node(val value: Int, var next: Node? = null)
    private var head: Node? = null
    private var length: Int = 0
    
    private fun findAtIndex(index: Int): Node? =
        when {
            length == 0 || index > length - 1 -> null
            index <= 0 -> head
            else -> {
                var next = head?.next
                repeat(index-1) {
                    next = next?.next
                }
                next
            }
        }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        return findAtIndex(index)?.value ?: -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        addAtIndex(length, `val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index > length) {
            return
        }
        val prev = findAtIndex(index-1)
        val node = Node(`val`)
        when {
            prev == null -> head = node
            index == 0 -> {
                node.next = head
                head = node
            }
            else -> {
                node.next = prev.next
                prev.next = node
            }
        }
        length++
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        when {
            length == 0 || index > length - 1 || index < 0 -> return
            index == 0 -> head = head?.next
            else -> findAtIndex(index-1)?.let {
                it.next = it.next?.next
            }
        }
        length--
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
