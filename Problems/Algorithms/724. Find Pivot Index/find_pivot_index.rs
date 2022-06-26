impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let prefixes = nums.into_iter()
            .scan(0, |acc, x| {
                *acc += x;
                Some(*acc)
        }).collect::<Vec<_>>();
        
        if prefixes[n-1] == prefixes[0] {
            return 0
        }
        for i in 1..n {
            if prefixes[i-1] == prefixes[n-1] - prefixes[i] {
                return i as i32
            }
        }
        -1
    }
}

