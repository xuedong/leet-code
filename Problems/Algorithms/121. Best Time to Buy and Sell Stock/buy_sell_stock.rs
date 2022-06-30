impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut buy = prices[0];
        prices.iter().fold(0, |mut acc, x| {
            acc = acc.max(x-&buy);
            buy = buy.min(*x);
            acc
        })
    }
}

