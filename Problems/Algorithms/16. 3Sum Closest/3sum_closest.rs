impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let mut result = nums[0] + nums[1] + nums[n-1];
        
        let mut nums = nums;
        nums.sort();
        for i in 0..=n-3 {
            let mut j = i + 1;
            let mut k = n - 1;
            while j < k {
                let curr = nums[i] + nums[j] + nums[k];
                if curr > target {
                    k -= 1;
                } else {
                    j += 1;
                }
                
                if (curr - target).abs() < (result - target).abs() {
                    result = curr;
                }
            }
        }
        
        result
    }
}

