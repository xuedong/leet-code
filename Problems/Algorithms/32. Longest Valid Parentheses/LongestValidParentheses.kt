class Solution {
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        stack.add(-1)
        
        var ans = 0
        for (i in 0..s.length-1) {
            if (s.get(i) == '(') {
                stack.add(i)
            } else {
                stack.removeLast()
                if (stack.isEmpty()) {
                    stack.add(i)
                } else {
                    ans = maxOf(ans, i-stack.last())
                }
            }
        }
        
        return ans
    }
}

