class Solution {
    fun checkDistances(s: String, distance: IntArray): Boolean {
        val map = mutableMapOf<Char, Int>()

        for (i in s.indices) {
            val c = s[i]
            if (map.containsKey(c)) {
                if (i - map[c]!! != distance[c - 'a'] + 1) {
                    return false
                }
            }
            map[c] = i
        }

        return true
    }
}
