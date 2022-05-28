class Solution {
    fun digitCount(num: String): Boolean {
        val map: MutableMap<Int, Int> = mutableMapOf()
        
        for (i in 0..num.length-1) {
            map.put(num.get(i)-'0', map.getOrDefault(num.get(i)-'0', 0) + 1)
        }
        for (i in 0..num.length-1) {
            if (!map.containsKey(i)) {
                map.put(i, 0)
            }
        }
        
        for (i in 0..num.length-1) {
            if (map.get(i) != num.get(i) - '0') {
                return false
            }
        }
        return true
    }
}

