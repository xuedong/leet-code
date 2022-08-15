impl Solution {
    pub fn count_numbers_with_unique_digits(n: i32) -> i32 {
        match n {
            0 => 1,
            1 => 10,
            n => Self::count_numbers_with_unique_digits(n-1) + 9 * ((11-n)..=9).product::<i32>(),
        }
    }
}

