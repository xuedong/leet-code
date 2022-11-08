class Solution {
    fun makeGood(s: String): String {
        val stack: ArrayDeque<Char> = ArrayDeque()

        for (c in s) {
            if (stack.isNotEmpty() && stack.last() != c && stack.last().toLowerCase() == c.toLowerCase()) {
                stack.removeLast()
            } else {
                stack.add(c)
            }
        }

        return stack.joinToString("")
    }
}
