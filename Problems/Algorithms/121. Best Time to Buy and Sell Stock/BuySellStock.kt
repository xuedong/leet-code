class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit: Int = 0
        var buy: Int = prices[0]
        
        for (price in prices) {
            profit = maxOf(profit, price-buy)
            buy = minOf(buy, price)
        }
        
        return profit
    }
}

