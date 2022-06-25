use rand::distributions::Uniform;
use rand::prelude::*;

struct Solution {
    origin: Vec<i32>,
    rng: ThreadRng,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl Solution {

    fn new(nums: Vec<i32>) -> Self {
        Self {
            origin: nums.clone(),
            rng: thread_rng(),
        }
    }
    
    fn reset(&self) -> Vec<i32> {
        self.origin.clone()
    }
    
    fn shuffle(&mut self) -> Vec<i32> {
        let n = self.origin.len();
        let mut shuffled = self.origin.clone();
        for i in 0..n {
            let uniform = Uniform::from(i..n);
            let j = self.rng.sample(uniform);
            shuffled.swap(i, j);
        }
        shuffled
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * let obj = Solution::new(nums);
 * let ret_1: Vec<i32> = obj.reset();
 * let ret_2: Vec<i32> = obj.shuffle();
 */
