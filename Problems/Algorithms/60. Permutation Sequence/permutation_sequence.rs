impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        let mut prod = (1..n).fold(1, |mut acc, x| {
            acc *= x;
            acc
        });
        let mut ans: String = String::with_capacity(n as usize);
        let mut nums: Vec<char> = (1..=n as u8).map(|i| (b'0'+i) as char).collect();
        
        let mut k = k - 1;
        for i in 0..n-1 {
            ans.push(nums.remove((k / prod) as usize));
            k %= prod;
            prod /= n-i-1;
        }
        ans.push(nums[0]);
        
        ans
    }
}

