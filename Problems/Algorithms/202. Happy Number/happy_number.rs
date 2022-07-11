impl Solution {
    pub fn get_next(mut n: i32) -> i32 {
        let mut ans = 0;
        while n > 0 {
            let d = n % 10;
            n = n / 10;
            ans += d * d;
        }
        ans
    }
    
    pub fn is_happy(mut n: i32) -> bool {
        loop {
            match n {
                1 | 4 => break n == 1,
                _ => n = Self::get_next(n),
            }
        }
    }
}

