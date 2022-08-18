impl Solution {
    pub fn is_power_of_three(n: i32) -> bool {
        if n <= 0 {
            return false;
        }
        if n == 1 {
            return true;
        }
        match n % 3 {
            0 => Self::is_power_of_three(n / 3),
            _ => false,
        }
    }
}
