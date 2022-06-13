impl Solution {
    pub fn merge_alternately(word1: String, word2: String) -> String {
        let mut chars1 = word1.chars();
        let mut chars2 = word2.chars();
        
        let mut res = vec![];
        for _ in 0..word1.len().max(word2.len()) {
            if let Some(c) = chars1.next() {
                res.push(c);
            }
            
            if let Some(c) = chars2.next() {
                res.push(c);
            }
        }
        
        res.iter().collect()
    }
}

