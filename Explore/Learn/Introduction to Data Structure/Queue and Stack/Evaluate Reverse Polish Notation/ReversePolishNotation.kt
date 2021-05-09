class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()
        var token = tokens[0]
        stack.push(token)
        var result = token.toInt()
        
        for (idx in 1..(tokens.size-1)) {
            var it = tokens[idx]
            if (!it.equals("+") && !it.equals("-") && !it.equals("*") && !it.equals("/")) {
                stack.push(it)
                continue
            }
                
            val a = stack.pop().toInt()
            val b = stack.pop().toInt()
            if (it.equals("+")) {
                result = a + b
            } else if (it.equals("-")) {
                result = b - a
            } else if (it.equals("*")) {
                result = a * b
            } else if (it.equals("/")) {
                result = b / a
            }
            stack.push(result.toString())
        }
        
        return result
    }
}

