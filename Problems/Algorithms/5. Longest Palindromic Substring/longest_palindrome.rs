impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        for size in (1..=s.len()).rev() {
            match s.as_bytes()
                .windows(size)
                .find(|substr| Self::is_palindrome(substr)) {
                    Some(palindrome) => return String::from_utf8(palindrome.to_vec()).unwrap(),
                    None => continue,
            }
        }
        
        String::from("")
    }
    
    pub fn is_palindrome(s: &[u8]) -> bool {
        s.iter().zip(s.iter().rev()).all(|(left, right)| left == right)
    }
}

