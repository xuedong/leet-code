impl Solution {
    pub fn combination_sum(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut results: Vec<Vec<i32>> = Vec::new();
        let mut nums = vec![];
        
        Self::aux(&candidates, &mut results, &mut nums, target, 0);
        
        results
    }
    
    pub fn aux(candidates: &Vec<i32>, results: &mut Vec<Vec<i32>>, nums: &mut Vec<i32>, target: i32, start: usize) {
        if target == 0 {
            results.push(nums.clone());
            return
        }
        
        if target > 0 {
            for i in start..candidates.len() {
                nums.push(candidates[i]);
                Self::aux(candidates, results, nums, target-candidates[i], i);
                nums.pop();
            }
        }
    }
}

