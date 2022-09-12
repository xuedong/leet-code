impl Solution {
    pub fn min_max_game(mut nums: Vec<i32>) -> i32 {
        let n = nums.len();
        match n {
            1 => nums[0],
            2 => nums[0].min(nums[1]),
            _ => {
                let mut new_nums = nums.chunks(2).enumerate().map(|(i, x)|
                    match i % 2 {
                        0 => x[0].min(x[1]),
                        _ => x[0].max(x[1]),
                    }
                ).collect();
                Self::min_max_game(new_nums)
            },
        }
    }
}
