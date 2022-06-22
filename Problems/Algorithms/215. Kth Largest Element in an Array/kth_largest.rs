use std::collections::BinaryHeap;

impl Solution {
    pub fn find_kth_largest(nums: Vec<i32>, k: i32) -> i32 {
        BinaryHeap::from(nums.to_owned()).into_sorted_vec()[nums.len()-k as usize]
    }
}

