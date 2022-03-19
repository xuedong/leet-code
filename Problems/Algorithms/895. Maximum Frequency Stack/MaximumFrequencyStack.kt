class FreqStack() {
    
    val counts = mutableMapOf<Int, Int>()
    val stacks = mutableMapOf<Int, ArrayDeque<Int>>()
    var maxFreq = 0

    fun push(`val`: Int) {
        counts.put(`val`, counts.getOrDefault(`val`, 0) + 1)
        stacks.getOrPut(counts[`val`]!!) { ArrayDeque<Int>() }.add(`val`)
        if (counts[`val`]!! > maxFreq) maxFreq = counts[`val`]!!
    }

    fun pop(): Int {
        val x = stacks[maxFreq]!!.removeLast()
        counts[x] = counts[x]!! - 1
        if (stacks[maxFreq]!!.isEmpty()) maxFreq--
        return x
    }

}

/**
 * Your FreqStack object will be instantiated and called as such:
 * var obj = FreqStack()
 * obj.push(`val`)
 * var param_2 = obj.pop()
 */
