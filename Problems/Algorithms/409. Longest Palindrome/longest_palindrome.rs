impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        let mut counts = vec![0; 128];
        for &byte in s.as_bytes() {
            counts[byte as usize] += 1;
        }
        
        let mut ans = 0;
        for n in counts.iter() {
            ans += n;
            if n % 2 != 0 {
                ans -= 1;
                if ans % 2 == 0 {
                    ans += 1;
                }
            }
        }
        ans
    }
}

