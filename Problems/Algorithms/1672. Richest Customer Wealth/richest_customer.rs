impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        accounts
            .iter()
            .map(|i| i.iter().sum())
            .max()
            .unwrap()
    }
}

