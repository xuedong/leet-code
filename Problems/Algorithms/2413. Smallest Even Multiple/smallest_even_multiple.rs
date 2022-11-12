impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        match n % 2 {
            0 => n,
            _ => n * 2,
        }
    }
}
