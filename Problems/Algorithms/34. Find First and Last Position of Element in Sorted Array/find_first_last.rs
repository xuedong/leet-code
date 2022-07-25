use std::cmp::Ordering;

impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let first = nums.binary_search_by(|n| if n < &target { Ordering::Less } else { Ordering::Greater }).unwrap_err();
        let last = nums.binary_search_by(|n| if n <= &target { Ordering::Less } else { Ordering::Greater }).unwrap_err();
        
        if first == nums.len() || nums[first] != target {
            return vec![-1, -1];   
        }
        vec![first as i32, (last-1) as i32]
    }
}

