use std::collections::BinaryHeap;

impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        let mut hp = BinaryHeap::from(stones);
        while hp.len() > 1 {
            let last = hp.pop().unwrap();
            let prev = hp.pop().unwrap();
            hp.push(last-prev);
        }
        hp.pop().unwrap_or(0)
    }
}

