class Solution {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = ArrayDeque<Pair<Char, Int>>()
        
        for (i in 0..s.length-1) {
            val char = s[i]
            if (!stack.isEmpty() && char == stack.last().first) {
                val top = stack.removeLast()
                if (top.second + 1 < k) {
                    stack.add(Pair(s[i], top.second+1))
                }
            } else {
                stack.add(Pair(char, 1))
            }
        }
        
        val sb = StringBuilder()
        while (!stack.isEmpty()) {
            val curr = stack.removeFirst()
            for (i in 1..curr.second) {
                sb.append(curr.first)
            }
        }
        return sb.toString()
    }
}

