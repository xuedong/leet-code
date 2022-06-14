impl Solution {
    pub fn to_lower_case(s: String) -> String {
        s.chars().map(|c| {
            if c >= 'A' && c <= 'Z' {
                ((c as u8) + ('a' as u8) - ('A' as u8)) as char
            } else {
                c
            }
        }).collect()
    }
}

