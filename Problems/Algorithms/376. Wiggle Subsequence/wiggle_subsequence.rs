impl Solution {
    pub fn wiggle_max_length(nums: Vec<i32>) -> i32 {
        let (down, up) = nums.windows(2).fold((1, 1), |(mut down, mut up), x| {
            if x[1] > x[0] { up = down + 1 } else if x[1] < x[0] { down = up + 1 };
            (down, up)
        });
        down.max(up)
    }
}

