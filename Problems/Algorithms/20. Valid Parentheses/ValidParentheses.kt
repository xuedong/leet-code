class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        
        s.forEach {
            when (it) {
                '(', '[', '{' -> stack.push(it)
                else -> {
                    val end: Char = when (it) {
                        ')' -> '('
                        ']' -> '['
                        '}' -> '{'
                        else -> throw RuntimeException("Unknown entry $it")
                    }
                    
                    if (end != stack.poll()) return false
                }
            }
        }
        
        return stack.isEmpty()
    }
}

