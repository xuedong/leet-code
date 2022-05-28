class Solution {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val out = LongArray(n) { 0 }
        for (road in roads) {
            out[road[0]]++
            out[road[1]]++
        }
        
        out.sort()
        
        var ans = 0.toLong()
        for (i in 1..n) {
            ans += i.toLong() * out[i-1]
        }
        
        return ans
    }
}

