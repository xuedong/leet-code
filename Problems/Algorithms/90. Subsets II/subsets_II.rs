impl Solution {
    pub fn subsets_with_dup(mut nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut results: Vec<Vec<i32>> = Vec::new();
        let mut path = vec![];
        let n = nums.len();
        
        nums.sort();
        
        Self::aux(&nums, &mut results, &mut path, 0, n);
        
        results
    }
    
    pub fn aux(nums: &Vec<i32>, results: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, start: usize, length: usize) {
        results.push(path.clone());
        
        for i in start..length {
            if i > start && nums[i-1] == nums[i] {
                continue;
            }
            
            path.push(nums[i]);
            Self::aux(nums, results, path, i+1, length);
            path.pop();
        }
    }
}

