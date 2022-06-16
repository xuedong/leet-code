impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        let s = x.to_string();
        let s = s.as_bytes();
        s.iter().zip(s.iter().rev()).all(|(left, right)| left == right)
    }
}

