impl Solution {
    pub fn min_moves2(mut nums: Vec<i32>) -> i32 {
        nums.sort();
        let n = nums.len();
        nums.iter().fold(0, |mut acc, x| {
            acc += if x >= &nums[n/2] { x - &nums[n/2] } else { &nums[n/2] - x };
            acc
        })
    }
}

