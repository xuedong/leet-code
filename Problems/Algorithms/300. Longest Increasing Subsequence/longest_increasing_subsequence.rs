impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        let mut pile = vec![];
        
        for num in nums {
            if let Err(pos) = pile.binary_search(&num) {
                if pos == pile.len() {
                    pile.push(num);
                } else {
                    pile[pos] = num;
                }
            }
        }
        
        pile.len() as i32
    }
}

