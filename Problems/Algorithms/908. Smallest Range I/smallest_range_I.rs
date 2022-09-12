impl Solution {
    pub fn smallest_range_i(mut nums: Vec<i32>, k: i32) -> i32 {
        nums.sort();
        let n = nums.len();
        let a = nums[0] + k;
        let b = nums[n - 1] - k;
        0.max(b-a)
    }
}
