class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        return process(s) == process(t)
    }
    
    private fun process(s: String): String {
        val stack = ArrayDeque<Char>()
        
        s.forEach {
            when (it) {
                '#' -> try {
                    stack.removeLast()
                } catch (e: NoSuchElementException) {
                    // ignore
                }
                else -> stack.add(it)
            }
        }
        
        return stack.joinToString()
    }
}

