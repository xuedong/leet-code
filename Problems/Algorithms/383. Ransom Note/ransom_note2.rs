use std::collections::HashMap;

impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        let mut map: HashMap<char, usize> = HashMap::new();
        for c in magazine.chars() {
            *map.entry(c).or_insert(0) += 1;
        }

        let mut map_ransom: HashMap<char, usize> = HashMap::new();
        for c in ransom_note.chars() {
            *map_ransom.entry(c).or_insert(0) += 1;
        }

        for (c, count) in map_ransom.iter() {
            if !map.contains_key(c) || map[c] < *count {
                return false;
            }
        }
        true
    }
}