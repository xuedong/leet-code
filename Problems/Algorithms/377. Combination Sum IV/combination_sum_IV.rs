impl Solution {
    pub fn combination_sum4(nums: Vec<i32>, target: i32) -> i32 {
        (1..=target).fold(vec![1], |mut acc, x| {
            acc.push(
                nums.iter()
                    .filter_map(|&n| {
                        if n <= x {
                            Some(acc[(x-n) as usize])
                        } else {
                            None
                        }
                    })
                    .sum(),
            );
            acc
        })[target as usize]
    }
}

