use std::collections::HashMap;

impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        let mut map: HashMap<char, i32> = HashMap::new();
        for ch in s.chars() {
            *map.entry(ch).or_insert(0) += 1;
        }
        
        for (i, v) in s.chars().enumerate() {
            if map.get(&v) == Some(&1) {
                return i as i32;
            }
        }
        -1
    }
}

