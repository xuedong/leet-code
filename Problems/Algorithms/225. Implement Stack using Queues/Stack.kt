class MyStack() {
    
    private val q1: ArrayDeque<Int>
    private val q2: ArrayDeque<Int>
    private var top: Int
    
    init {
        q1 = ArrayDeque()
        q2 = ArrayDeque()
        top = 0
    }

    fun push(x: Int) {
        q1.add(x)
        top = x
    }

    fun pop(): Int {
        while (q1.size > 1) {
            top = q1.removeFirst()
            q2.add(top)
        }
        return q1.removeFirst().also {
            while (!q2.isEmpty()) {
                q1.add(q2.removeFirst())
            }
        }
    }

    fun top(): Int {
        return top
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
