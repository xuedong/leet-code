impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> bool {
        let n = s.len();
        let mut dp = vec![false; n+1];
        dp[0] = true;
        
        for i in 1..=n {
            for j in 0..i {
                if dp[j] && word_dict.contains(&s[j..i].to_owned()) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        dp[n]
    }
}

