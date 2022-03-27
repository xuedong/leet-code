class MinStack() {
    
    private val stack = ArrayDeque<Pair<Int, Int>>()
    private var minValue = Int.MAX_VALUE

    fun push(`val`: Int) {
        minValue = minOf(minValue, `val`)
        stack.add(Pair(`val`, minValue))
    }

    fun pop() {
        stack.removeLast()
        if (!stack.isEmpty()) {
            minValue = getMin()
        } else {
            minValue = Int.MAX_VALUE
        }
    }

    fun top(): Int {
        return stack.last().first
    }

    fun getMin(): Int {
        return stack.last().second
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
