impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        let l = ops.len();
        if l == 0 {
            return m * n;
        }
        ops.iter().map(|a| a[0]).min().unwrap() * ops.iter().map(|a| a[1]).min().unwrap()
    }
}
