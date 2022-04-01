class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val len = trust.size-1
        if (n == 1) {
            if (trust.isEmpty()) return 1
            return -1
        }
        
        val mapIn = mutableMapOf<Int, Int>()
        val mapOut = mutableMapOf<Int, Int>()
        
        for (i in 0..len) {
            val a: Int = trust[i][0]
            val b: Int = trust[i][1]
            mapIn.put(b, mapIn.getOrDefault(b, 0) + 1)
            mapOut.put(a, mapOut.getOrDefault(a, 0) + 1)
        }
        
        for (key in mapIn.keys) {
            if (mapIn[key] == n-1 && !mapOut.containsKey(key)) return key 
        }
        
        return -1
    }
}

