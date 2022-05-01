class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val stack1 = ArrayDeque<Char>()
        val stack2 = ArrayDeque<Char>()
        
        var i = 0
        while (i < s.length) {
            val ch = s[i]
            if (ch == '#') {
                if (stack1.isEmpty()) {
                    i++
                    continue
                } else {
                    stack1.removeLast()
                }
            } else {
                stack1.add(ch)
            }
            i++
        }
        
        var j = 0
        while (j < t.length) {
            val ch = t[j]
            if (ch == '#') {
                if (stack2.isEmpty()) {
                    j++
                    continue
                } else {
                    stack2.removeLast()
                }
            } else {
                stack2.add(ch)
            }
            j++
        }
        
        return stack1.joinToString() == stack2.joinToString()
    }
}

