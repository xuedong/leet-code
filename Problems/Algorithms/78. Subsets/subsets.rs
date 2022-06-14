impl Solution {
    pub fn subsets(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
        if nums.len() == 0 {
            return vec![vec![]]
        }
        
        let last = nums.pop().unwrap();
        let prev = Self::subsets(nums);
        let mut results = prev.clone();
        for mut subset in prev {
            subset.push(last);
            results.push(subset);
        }
        
        results
    }
}

