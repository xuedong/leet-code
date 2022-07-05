impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        (2..=n).into_iter().fold((1, 1), |acc, _| {
            (acc.1, acc.0+acc.1)
        }).1
    }
}

