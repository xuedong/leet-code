class Solution {
    fun hIndex(citations: IntArray): Int {
        val n: Int = citations.size
        var low: Int = 0
        var high: Int = n-1
        
        var ans: Int = 0
        while (low <= high) {
            val mid: Int = (low + high) / 2
            val citation: Int = n - mid
            if (citations[mid] >= citation && citation > ans){
                ans = citation
                high = mid-1
            } else {
                low++
            }
        }
        
        return ans
    }
}

