class MyCircularQueue(k: Int) {
    private val data = IntArray(k)
    private var head = -1
    private var tail = -1
    private val size = k

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false
        
        if (isEmpty()) head++
        tail = (tail + 1) % size
        data[tail] = value
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false
        
        data[head] = 0
        
        if (head == tail) {
            head = -1
            tail = -1
        } else {
            head = (head + 1) % size
        }    
        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else data[head]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else data[tail]
    }

    fun isEmpty(): Boolean {
        return head == tail && head == -1
    }

    fun isFull(): Boolean {
        return (tail + 1) % size == head
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
