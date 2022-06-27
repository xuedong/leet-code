impl Solution {
    pub fn my_pow(mut x: f64, n: i32) -> f64 {
        match n {
            0 => 1.0,
            -2147483648 => Self::my_pow(x*x, -2147483648/2),
            m if m < 0 => 1.0 / Self::my_pow(x, -m),
            _ => {
                if n % 2 == 0 {
                    Self::my_pow(x*x, n/2)
                } else {
                    x * Self::my_pow(x*x, n/2)
                }
            },
        }
    }
}

