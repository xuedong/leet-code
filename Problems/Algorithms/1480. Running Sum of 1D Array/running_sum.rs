impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        let mut sum = 0;
        nums.iter()
            .map(|x| {
                sum += x;
                sum
        }).collect()
    }
}

