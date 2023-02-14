impl Solution {
    pub fn add_binary(mut a: String, mut b: String) -> String {
        if a.len() < b.len() {
            std::mem::swap(&mut a, &mut b);
        }

        let mut ans = String::new();
        let mut carry = 0;
        let mut chars = b.chars().rev();
        for ch in a.chars().rev() {
            if ch == '1' {
                carry += 1;
            }
            if let Some('1') = chars.next() {
                carry += 1;
            }

            ans.insert(0, if carry & 1 == 1 { '1' } else { '0' });
            carry >>= 1;
        }

        if carry != 0 {
            ans.insert(0, '1');
        }
        ans
    }
}
