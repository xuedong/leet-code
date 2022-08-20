impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        let primes: Vec<i32> = vec![2, 3, 5, 7, 13, 17, 19, 31];
        for p in primes {
            let euler = (1 << (p-1)) * ((1 << p) - 1);
            if euler == num {
                return true;
            }
        }
        false
    }
}
