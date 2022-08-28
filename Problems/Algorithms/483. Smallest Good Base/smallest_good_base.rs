impl Solution {
    pub fn smallest_good_base(n: String) -> String {
        let n = n.parse::<i64>().unwrap();
        for m in (2..=(n as f64).log(2.0) as u32 + 1).rev() {
            let k: i64 = f64::powf(n as f64, 1.0 / (m as f64 - 1.0)) as i64;
            if n * (1 - k) == 1 - k.pow(m) {
                return k.to_string();
            }
        }
        (n-1).to_string()
    }
}
