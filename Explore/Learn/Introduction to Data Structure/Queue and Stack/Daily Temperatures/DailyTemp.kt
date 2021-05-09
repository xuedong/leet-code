class Solution {
    fun dailyTemperatures(T: IntArray): IntArray {
        val result = IntArray(T.size)
        val stack = ArrayDeque<Int>()
        
        T.forEachIndexed {
            index, value ->
                while (!stack.isEmpty() && value > T[stack.peek()]) {
                    val top = stack.pop()
                    result[top] = index - top
                }
                stack.push(index)
        }
        
        return result
    }
}

