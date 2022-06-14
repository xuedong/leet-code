impl Solution {
    pub fn to_lower_case(s: String) -> String {
        s.chars().fold(String::from(""), |mut acc, c| {
            if c >= 'A' && c <= 'Z' {
                acc.push(((c as u8) + ('a' as u8) - ('A' as u8)) as char);
            } else {
                acc.push(c);
            }
            acc
        })
    }
}

