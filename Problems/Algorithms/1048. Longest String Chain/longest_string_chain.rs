use std::collections::HashMap;

impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        let mut words = words;
        words.sort_by_cached_key(String::len);
        
        let mut dp = HashMap::new();
        let mut ans = 0;
        for word in words {
            let max = (0..word.len())
                .filter_map(|i| dp.get(&(String::new() + &word[0..i] + &word[i+1..])))
                .max()
                .unwrap_or(&0)
                + 1;
            dp.insert(word, max);
            ans = ans.max(max);
        }
        
        ans
    }
}

