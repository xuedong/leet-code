impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        let mut map: [usize; 256] = [0; 256];
        for c in magazine.chars() {
            map[c as usize] += 1;
        }
        for c in ransom_note.chars() {
            if map[c as usize] == 0 {
                return false;
            }
            map[c as usize] -= 1;
        }
        true
    }
}
