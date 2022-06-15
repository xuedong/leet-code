impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut results: Vec<Vec<i32>> = Vec::new();
        let mut permutation = vec![];
        
        let n = nums.len();
        let mut used = vec![false; n];
        
        let mut nums = nums;
        nums.sort();
        
        Self::aux(&nums, &mut results, &mut permutation, &mut used);
        
        results
    }
    
    pub fn aux(nums: &Vec<i32>, results: &mut Vec<Vec<i32>>, permutation: &mut Vec<i32>, used: &mut Vec<bool>) {
        if nums.len() == permutation.len() {
            results.push(permutation.clone());
            return
        }
        
        for i in 0..nums.len() {
            if used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1] {
                continue;
            }
            
            used[i] = true;
            permutation.push(nums[i]);
            Self::aux(nums, results, permutation, used);
            used[i] = false;
            permutation.pop();
        }
    }
}

