use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn word_pattern(pattern: String, s: String) -> bool {
        if pattern.len() != s.matches(' ').count() + 1 {
            return false;
        }

        let mut map = HashMap::new();
        let mut words = HashSet::new();
        for (word, character) in s.split_ascii_whitespace().zip(pattern.chars()) {
            if let Some(existing_word) = map.insert(character, word) {
                if existing_word != word {
                    return false;
                }
            } else if !words.insert(word) {
                return false;
            }
        }

        true
    }
}
