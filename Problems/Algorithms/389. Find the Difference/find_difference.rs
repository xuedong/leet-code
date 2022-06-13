impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        s.as_bytes().iter()
            .chain(t.as_bytes().iter())
            .fold(0, |acc, x| acc ^ x) as char
    }
}

