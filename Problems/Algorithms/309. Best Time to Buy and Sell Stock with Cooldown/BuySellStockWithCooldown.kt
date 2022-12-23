class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profitPrev = 0
        var profit0 = 0
        var profit1 = Int.MIN_VALUE

        for (price in prices) {
            var temp = profit0
            profit0 = maxOf(profit0, profit1 + price)
            profit1 = maxOf(profit1, profitPrev - price)
            profitPrev = temp
        }

        return profit0
    }
}
