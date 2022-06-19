impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        
        let mut partial = 0;
        let mut ans = 0;
        for i in 2..n {
            if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] {
                partial += 1;
                ans += partial;
            } else {
                partial = 0;
            }
        }
        
        ans
    }
}

