class Solution {
    fun edgeScore(edges: IntArray): Int {
        val n = edges.size
        val scores = LongArray(n) { 0.toLong() }
        
        for (i in 0..n-1) {
            scores[edges[i]] += i.toLong()
        }
        
        var ans = 0
        var best = -1.toLong()
        for (i in 0..n-1) {
            if (scores[i] > best) {
                best = scores[i]
                ans = i
            }
        }
        
        return ans
    }
}

