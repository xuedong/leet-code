impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut nums = nums;
        nums.sort();
        if nums[0] < 0 && nums[1] < 0 {
            let a = nums[0] * nums[1] * nums[n - 1];
            let b = nums[n - 1] * nums[n - 2] * nums[n - 3];
            return a.max(b);
        }

        nums[n - 1] * nums[n - 2] * nums[n - 3]
    }
}
