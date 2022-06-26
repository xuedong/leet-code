impl Solution {
    pub fn max_score(card_points: Vec<i32>, k: i32) -> i32 {
        let n = card_points.len();
        let sub_arr = &card_points[..k as usize];
        let mut curr: i32 = sub_arr.iter().sum();
        let mut ans = curr;
        
        for i in 1..=k as usize {
            curr += card_points[n - i] - card_points[k as usize - i];
            ans = ans.max(curr);
        }
        
        ans
    }
}

