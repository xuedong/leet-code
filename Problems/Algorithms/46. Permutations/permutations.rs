impl Solution {
    pub fn permute(nums: Vec<i32>) -> Vec<Vec<i32>> {
        let mut results: Vec<Vec<i32>> = Vec::new();
        let mut curr = vec![];
        
        let mut used = vec![false; nums.len()];
        Self::aux(&nums, &mut results, &mut curr, &mut used);
        
        results
    }
    
    pub fn aux(nums: &Vec<i32>, results: &mut Vec<Vec<i32>>, curr: &mut Vec<i32>, used: &mut Vec<bool>) {
        if nums.len() == curr.len() {
            results.push(curr.clone());
            return
        }
        
        for i in 0..=nums.len()-1 {
            if used[i] {
                continue;
            }
            
            used[i] = true;
            curr.push(nums[i]);
            Self::aux(nums, results, curr, used);
            curr.pop();
            used[i] = false;
        }
    }
}

