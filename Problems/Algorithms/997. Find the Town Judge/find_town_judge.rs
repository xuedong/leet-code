impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        if n == 1 {
            return n;
        }

        let mut counts = vec![0; (n + 1) as usize];
        trust.iter().for_each(|pair| {
            counts[pair[0] as usize] -= 1;
            counts[pair[1] as usize] += 1;
        });

        counts.iter().position(|&num| num == n - 1)
            .map_or(-1, |i| i as i32)
    }
}
