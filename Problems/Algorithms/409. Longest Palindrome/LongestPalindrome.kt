class Solution {
    fun longestPalindrome(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        
        for (ch in s) {
            map.put(ch, map.getOrDefault(ch, 0) + 1)
        }
        
        var sumOdd = 0
        var sumEven = 0
        var flag = false
        for (ch in map.keys) {
            if (map[ch]!! % 2 == 0) {
                sumEven += map[ch]!!
            } else {
                sumOdd += map[ch]!! - 1
                flag = true
            }
        }
        
        return if (flag) sumOdd + sumEven + 1 else sumOdd + sumEven 
    }
}

