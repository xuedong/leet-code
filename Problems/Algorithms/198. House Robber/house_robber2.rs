// More idiomatic rust solution
impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        nums.into_iter()
            .fold((0, 0), |acc, x| {
                (acc.0.max(acc.1+x), acc.0)
        }).0
    }
}

