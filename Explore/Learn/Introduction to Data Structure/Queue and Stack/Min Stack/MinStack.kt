class MinStack() {
    val min = ArrayDeque<Int>()
    val data = arrayListOf<Int>()

    /** initialize your data structure here. */  

    fun push(`val`: Int) {
        data.add(`val`)
        if (min.isEmpty() || min.last() >= `val`) min.addLast(`val`)
    }

    fun pop() {
        val peek = data.get(data.size-1)
        data.removeAt(data.size-1)
        if (peek == min.last()) min.removeLast()
    }

    fun top(): Int {
        return data.get(data.size-1)
    }

    fun getMin(): Int {
        return min.last()
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
