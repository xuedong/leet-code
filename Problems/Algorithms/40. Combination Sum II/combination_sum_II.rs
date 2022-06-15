impl Solution {
    pub fn combination_sum2(candidates: Vec<i32>, target: i32) -> Vec<Vec<i32>> {
        let mut results: Vec<Vec<i32>> = Vec::new();
        let mut nums = vec![];
        
        let mut candidates = candidates;
        candidates.sort();
        
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
                if i > start && candidates[i-1] == candidates[i] {
                    continue
                }
                
                nums.push(candidates[i]);
                Self::aux(candidates, results, nums, target-candidates[i], i+1);
                nums.pop();
            }
        }
    }
}

