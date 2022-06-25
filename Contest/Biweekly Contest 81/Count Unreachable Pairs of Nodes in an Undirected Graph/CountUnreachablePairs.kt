class Solution {
    fun countAsterisks(s: String): Int {
        val stack = ArrayDeque<Char>()
        
        var count = 0
        for (char in s) {
            if (char != '|' && char != '*') {
                continue
            }
            
            if (char == '|') {
                if (stack.isEmpty()) {
                    stack.add('|')
                } else {
                    stack.removeLast()
                }
            }
            
            if (char == '*') {
                if (stack.isEmpty()) {
                    count++
                }
            }
        }
        
        return count
    }
}

