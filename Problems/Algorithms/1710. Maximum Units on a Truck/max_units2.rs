use std::cmp::Reverse;

impl Solution {
    pub fn maximum_units(mut box_types: Vec<Vec<i32>>, mut truck_size: i32) -> i32 {
        box_types.sort_by_key(|x| Reverse(x[1]));
        box_types.iter()
            .fold(0, |mut acc, box_type| {
                let cur = box_type[0].min(truck_size);
                truck_size -= cur;
                acc += cur * box_type[1];
                acc
        })
    }
}

