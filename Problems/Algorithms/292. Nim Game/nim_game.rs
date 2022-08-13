impl Solution {
    pub fn can_win_nim(n: i32) -> bool {
        match n % 4 {
            0 => false,
            _ => true,
        }
    }
}

