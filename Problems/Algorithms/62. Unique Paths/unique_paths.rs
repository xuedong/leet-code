impl Solution {
    pub fn unique_paths(m: i32, n: i32) -> i32 {
        (m.max(n)..m+n-1)
            .zip(1..m.min(n))
            .fold(1, |acc, (num, den)| (acc * num as i128) / den as i128) as i32
    }
}

