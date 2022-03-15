class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val stack = ArrayDeque<Int>()
        val chars = s.toCharArray()

        for ((idx, char) in chars.withIndex()) {
            when (char) {
                '(' -> stack.push(idx)
                ')' -> {
                    if (stack.isEmpty()) {
                        chars[idx] = '.'
                    } else {
                        stack.poll()
                    }
                }
                else -> {}
            }
        }
        
        while (!stack.isEmpty()) {
            chars[stack.poll()] = '.'
        }
        
        val sb = StringBuilder()
        for (char in chars) {
            if (char != '.') {
                sb.append(char)
            }
        }

        return sb.toString()
    }
}

