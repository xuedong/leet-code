class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        costs.sortWith(compareBy({ it -> it[0]-it[1] }))
        
        var ans = 0
        val n = costs.size / 2
        for (i in 0..n-1) {
            ans += costs[i][0]
        }
        for (i in n..2*n-1) {
            ans += costs[i][1]
        }
        
        return ans
    }
}

