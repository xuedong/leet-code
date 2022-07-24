use std::collections::HashMap;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut start: usize = 0;
        let mut ans = 0;
        let mut map: HashMap<char, usize> = HashMap::new();

        for (idx, ch) in s.char_indices() {
            map.entry(ch).and_modify(|prev| {
                if *prev >= start {
                    ans = ans.max(idx-start);
                    start = *prev + 1;
                }
                *prev = idx;
            }).or_insert(idx);
        }

        ans.max(s.len()-start) as i32
    }
}

