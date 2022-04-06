class Solution {
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        val MOD = 1_000_000_007
        val map = mutableMapOf<Int, Long>()
        
        for (num in arr) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        
        var ans: Long = 0

        for (i in map.keys) {
            for (j in map.keys) {
                val k = target - i - j
                if (map.containsKey(k)) {
                    val ci: Long = map[i]!!
                    val cj: Long = map[j]!!
                    val ck: Long = map[k]!!
                    
                    if (i == j && j == k) {
                        ans += ci * (ci - 1) * (ci - 2) / 6
                    } else if (i == j) {
                        ans += ci * (ci - 1) / 2 * ck;
                    } else if (i < j && j < k) {
                        ans += ci * cj * ck
                    }
                    ans %= MOD
                }
            }
        }
        
        return ans.toInt()
    }
}

