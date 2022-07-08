class Solution {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val dp = Array(m) { Array(n) { IntArray(target+1) { 1000001 } } }
        
        for (color in 1..n) {
            if (houses[0] == color) {
                dp[0][color-1][1] = 0
            } else if (houses[0] == 0) {
                dp[0][color-1][1] = cost[0][color-1]
            }
        }
        
        for (house in 1..m-1) {
            for (color in 1..n) {
                for (neighbors in 1..minOf(target, house+1)) {
                    if (houses[house] != 0 && color != houses[house]) {
                        continue
                    }
                    
                    var prevCost = 1000001
                    for (prevColor in 1..n) {
                        if (prevColor != color) {
                            prevCost = minOf(prevCost, dp[house-1][prevColor-1][neighbors-1])
                        } else {
                            prevCost = minOf(prevCost, dp[house-1][prevColor-1][neighbors])
                        }
                    }
                    
                    var currCost = 0
                    if (houses[house] == 0) {
                        currCost = cost[house][color-1]
                    }
                    
                    dp[house][color-1][neighbors] = currCost + prevCost
                }
            }
        }
        
        var ans = 1000001
        for (color in 1..n) {
            ans = minOf(ans, dp[m-1][color-1][target])
        }
        
        if (ans == 1000001) return -1
        return ans
    }
}

