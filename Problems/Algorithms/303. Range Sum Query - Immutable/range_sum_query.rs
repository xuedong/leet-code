struct NumArray {
    prefixes: Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumArray {

    fn new(nums: Vec<i32>) -> Self {
        let mut prefixes = vec![0; nums.len()+1];
        for i in 0..nums.len() {
            prefixes[i+1] = prefixes[i] + nums[i];
        }
        Self { prefixes }
    }
    
    fn sum_range(&self, left: i32, right: i32) -> i32 {
        self.prefixes[right as usize + 1] - self.prefixes[left as usize]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * let obj = NumArray::new(nums);
 * let ret_1: i32 = obj.sum_range(left, right);
 */
