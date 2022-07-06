impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        let results = (2..cost.len()).into_iter().fold((cost[0], cost[1]), |acc, i| {
            (acc.1, cost[i]+acc.0.min(acc.1))
        });
        results.0.min(results.1)
    }
}

