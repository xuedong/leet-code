impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        let mut map1: [usize; 26] = [0; 26];
        let mut map2: [usize; 26] = [0; 26];
        for c in s1.chars() {
            map1[(c as u8 - b'a') as usize] += 1;
        }

        let n = s1.len();
        let s: &[u8] = s2.as_bytes();
        for (i, c) in s.iter().enumerate() {
            map2[(c - b'a') as usize] += 1;
            if i >= n {
                map2[(s[i - n] - b'a') as usize] -= 1;
            }

            if map1 == map2 {
                return true;
            }
        }

        false
    }
}
