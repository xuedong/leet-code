use std::cmp::Reverse;

impl Solution {
    pub fn maximum_units(mut box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        box_types.sort_by_key(|x| Reverse(x[1]));
        let mut num = 0;
        let mut ans = 0;
        let mut i = 0;
        while num < truck_size && i < box_types.len() {
            let cur = (truck_size-num).min(box_types[i][0]);
            num += cur;
            ans += cur * box_types[i][1];
            i += 1;
        }
        
        ans
    }
}

