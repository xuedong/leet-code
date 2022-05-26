class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val n = startTime.size
        val jobs = Array(n) { IntArray(3) { 0 } }
        for (i in 0..n-1) {
            jobs[i][0] = startTime[i]
            jobs[i][1] = endTime[i]
            jobs[i][2] = profit[i]
        }
        jobs.sortWith(compareBy { it[0] })
        val start = (jobs.map { it[0] }).toIntArray()
        
        val dp = IntArray(n+1) { 0 }
        for (i in n-1 downTo 0) {
            val j = binarySearchLeft(start, jobs[i][1])
            dp[i] = maxOf(dp[i+1], dp[j] + jobs[i][2])
        }

        return dp[0]
    }
    
    private fun binarySearchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] >= target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    
        return left
    }
}

