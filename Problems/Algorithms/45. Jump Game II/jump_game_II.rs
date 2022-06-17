impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {        
        let mut ans = 0;
        if nums.len() == 1 {
            return ans
        }
        
        let mut end = nums[0];
        let mut far = nums[0];
        
        for i in 1..nums.len()-1 {
            far = far.max(i as i32 + nums[i]);
            if i == end as usize {
                ans += 1;
                end = far;
            }
        }
        
        ans+1
    }
}

