impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        let ns = Self::sort_string(s);
        let nt = Self::sort_string(t);
        
        ns == nt
    }
    
    pub fn sort_string(s: String) -> String {
        let mut ls: Vec<char> = s.chars().collect();
        ls.sort_unstable();
        let ns: String = ls.into_iter().collect();
        ns
    }
}

