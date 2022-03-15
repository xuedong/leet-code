class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val n = intervals.size
        if (n <= 1) return intervals
        
        intervals.sortWith(compareBy { it -> it[0] })
        val list = mutableListOf<IntArray>()
        
        var i = 0
        var curr = intervals[0]
        while (i < n-1) {
            val next = intervals[i+1]
            
            if (next[0] > curr[1]) {
                list.add(curr)
                curr = intArrayOf(next[0], next[1])
            } else {
                curr = intArrayOf(curr[0], maxOf(next[1], curr[1]))
            }
            i++
        }
        list.add(curr)
        
        return list.toTypedArray()
    }
}

