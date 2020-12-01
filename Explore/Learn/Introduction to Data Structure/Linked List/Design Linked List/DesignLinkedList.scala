class MyLinkedList() {

    /** Initialize your data structure here. */
    trait MyList[+A]
    case object Nil extends MyList[Nothing]
    case class Node[A](`val`: A, next: MyList[A]) extends MyList[A]
    
    private var head: MyList[Int] = Nil

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    def get(index: Int): Int = {
        def aux(node: MyList[Int], index: Int): Int = node match {
            case Nil => -1
            case Node(value, next) => if (index == 0) value else aux(next, index-1)
        }
        aux(head, index)
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    def addAtHead(`val`: Int) {
        head = Node(`val`, head)
    }

    /** Append a node of value val to the last element of the linked list. */
    def addAtTail(`val`: Int) {
        def aux(node: MyList[Int], `val`: Int): MyList[Int] = node match {
            case Nil => Node(`val`, Nil)
            case Node(value, next) => Node(value, aux(next, `val`))
        }
        head = aux(head, `val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    def addAtIndex(index: Int, `val`: Int) {
        def aux(node: MyList[Int], index: Int, `val`: Int): MyList[Int] =
            (node, index) match {
                case (Nil, i) => if (i == 0) Node(`val`, Nil) else Nil
                case (Node(value, next), 0) => Node(`val`, Node(value, next))
                case (Node(value, next), 1) => Node(value, Node(`val`, next))
                case (Node(value, next), i) => Node(value, aux(next, i-1, `val`))
                case (_, _) => node
            }
        head = aux(head, index, `val`)
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    def deleteAtIndex(index: Int) {
        def aux(node: MyList[Int], index: Int): MyList[Int] =
            (node, index) match {
                case (Nil, _) => Nil
                case (Node(value, next), 0) => next
                case (Node(value1, Node(value2, next)), 1) => Node(value1, next)
                case (Node(value, next), k) => Node(value, aux(next, k-1))
                case (_, _) => node
            }
        head = aux(head, index)
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
