class Solution {
    fun removeDuplicateLetters(s: String): String {
        val freq = IntArray(26) { 0 }
        for (ch in s) {
            freq[ch-'a']++
        }
        
        val used = HashSet<Char>()
        val stack = ArrayDeque<Char>()
        for (ch in s) {
            if (used.contains(ch)) {
                freq[ch-'a']--
                continue
            }
            
            while (!stack.isEmpty() && stack.last() > ch && freq[stack.last()-'a'] > 0) {
                used.remove(stack.removeLast())
            }
            
            stack.add(ch)
            freq[ch-'a']--
            used.add(ch)
        }
        
        var sb = StringBuilder()
        while (!stack.isEmpty()) {
            sb.insert(0, stack.removeLast())
        }
        
        return sb.toString()
    }
}

