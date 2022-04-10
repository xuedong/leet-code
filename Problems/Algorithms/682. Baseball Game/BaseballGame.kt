class Solution {
    fun calPoints(ops: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        
        var ans = 0
        ops.forEach {
            when (it) {
                "+" -> {
                    val last = stack.removeLast()
                    val secondLast = stack.last()
                    stack.add(last)
                    stack.add(last+secondLast)
                    ans += last + secondLast
                }
                "D" -> {
                    val last = stack.last()
                    stack.add(last*2)
                    ans += last*2
                }
                "C" -> {
                    val last = stack.removeLast()
                    ans -= last
                }
                else -> {
                    val curr = it.toInt()
                    stack.add(curr)
                    ans += curr
                }
            }
        }
        
        return ans
    }
}

