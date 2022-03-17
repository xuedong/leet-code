class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val n = intervals.size
        if (n <= 1) return 0
        
        intervals.sortWith(compareBy { it -> it[1] })
        
        var ans = 0
        var i = 0
        var j = 1
        while (j < n) {
            if (intervals[j][0] < intervals[i][1]) {
                ans++
            } else {
                i = j
            }
            j++
        }
        
        return ans
    }
}

