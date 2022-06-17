impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let mut n = 1;
        for i in (0..nums.len()-1).rev() {
            n = if nums[i] < n { n+1 } else { 1 };
        }
        n == 1
    }
}

