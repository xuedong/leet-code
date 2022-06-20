impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        s.as_bytes()
            .iter()
            .rev()
            .map(|b| (b - b'0') as usize)
            .fold((1, 1, 27), |(dp1, dp2, b1), b0| {
                (
                    if b0 == 0 {
                        0
                    } else {
                        dp1 + if (1..=26).contains(&(b0 * 10 + b1)) {
                            dp2
                        } else {
                            0
                        }
                    },
                    dp1,
                    b0,
                )
        }).0
    }
}

