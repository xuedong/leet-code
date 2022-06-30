impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        let min = nums.iter().min().unwrap_or(&0);
        nums.iter().fold(0, |mut acc, x| {
            acc += x - min;
            acc
        })
    }
}

