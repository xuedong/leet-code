class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        val n = tops.size
        
        for (i in 0..n-1) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1)
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1)
        }
        
        var max = 0
        var num = 0
        for (key in map.keys) {
            if (map[key]!! > max) {
                max = map[key]!!
                num = key
            }
        }
        
        if (max < n) return -1
        
        var topn = 0
        var bottomn = 0
        for (i in 0..n-1) {
            if (tops[i] != num && bottoms[i] != num) return -1
            
            if (tops[i] != num) {
                topn++
            } else if (bottoms[i] != num) {
                bottomn++
            }
        }
        
        return minOf(topn, bottomn)
    }
}

