impl Solution {
    pub fn fib(n: i32) -> i32 {
        match n {
            0 => 0,
            1 => 1,
            n => Self::fib(n-1) + Self::fib(n-2),
        }
    }
}

