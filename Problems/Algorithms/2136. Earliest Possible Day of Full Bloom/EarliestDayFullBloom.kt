class Solution {
    fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
        val n = plantTime.size
        val time = Array(n) { IntArray(2) }
        for (i in 0 until n) {
            time[i][0] = plantTime[i]
            time[i][1] = growTime[i]
        }

        time.sortWith(compareBy({ -it[1] }, { it[0] }))
        var lastPlant = 0
        var lastGrow = 0
        var ans = 0
        for (i in 0 until n) {
            lastGrow = lastPlant + time[i][1] + time[i][0]
            ans = maxOf(ans, lastGrow)
            lastPlant += time[i][0]
        }

        return ans
    }
}
