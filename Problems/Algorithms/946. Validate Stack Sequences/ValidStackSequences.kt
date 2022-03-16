class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = ArrayDeque<Int>()
        
        var i = 1
        var j = 0
        stack.add(pushed[0])
        while (i < pushed.size) {
            if (stack.isEmpty()) {
                stack.add(pushed[i])
                i++
            } else if (popped[j] == stack.last()) {
                stack.removeLast()
                j++
            } else {
                stack.add(pushed[i])
                i++
            }
        }
        
        while (j < popped.size) {
            if (popped[j] != stack.last()) {
                break
            } else {
                stack.removeLast()
                j++
            }
        }
        
        return stack.isEmpty()
    }
}

