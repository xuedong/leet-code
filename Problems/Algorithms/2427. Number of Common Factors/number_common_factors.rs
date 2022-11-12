impl Solution {
    pub fn common_factors(a: i32, b: i32) -> i32 {
        (1..=Self::gcd(a, b)).filter(|&x| a % x == 0 && b % x == 0).count() as i32
    }

    pub fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Self::gcd(b, a % b)
        }
    }
}
