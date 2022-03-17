class Solution {
    fun scoreOfParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()

        var score = 0
        for (i in 0..s.length-1) {
            if (s.get(i) == '(') {
                stack.push(score)
                score = 0
            } else {
                score = stack.pop() + maxOf(2*score, 1)
            }
        }

        return score
    }
}

