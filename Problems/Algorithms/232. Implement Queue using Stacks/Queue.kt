class MyQueue() {
    
    private val stack1 = ArrayDeque<Int>()
    private val stack2 = ArrayDeque<Int>()

    fun push(x: Int) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop())
        }
        stack1.push(x)
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop())
        }
    }

    fun pop(): Int {
        return stack1.pop()
    }

    fun peek(): Int {
        return stack1.peek()
    }

    fun empty(): Boolean {
        return stack1.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
