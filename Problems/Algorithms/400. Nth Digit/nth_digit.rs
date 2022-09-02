impl Solution {
    pub fn find_nth_digit(n: i32) -> i32 {
        if n <= 9 {
            return n;
        }
        if n <= 189 {
            return (10 + (n - 10) / 2).to_string().chars().nth((n as usize - 10) % 2).unwrap() as i32 - '0' as i32;
        }
        if n <= 2889 {
            return (100 + (n - 190) / 3).to_string().chars().nth((n as usize - 190) % 3).unwrap() as i32 - '0' as i32;
        }
        if n <= 38889 {
            return (1000 + (n - 2890) / 4).to_string().chars().nth((n as usize - 2890) % 4).unwrap() as i32 - '0' as i32;
        }
        if n <= 488889 {
            return (10000 + (n - 38890) / 5).to_string().chars().nth((n as usize - 38890) % 5).unwrap() as i32 - '0' as i32;
        }
        if n <= 5888889 {
            return (100000 + (n - 488890) / 6).to_string().chars().nth((n as usize - 488890) % 6).unwrap() as i32 - '0' as i32;
        }
        if n <= 68888889 {
            return (1000000 + (n - 5888890) / 7).to_string().chars().nth((n as usize - 5888890) % 7).unwrap() as i32 - '0' as i32;
        }
        if n <= 788888889 {
            return (10000000 + (n - 68888890) / 8).to_string().chars().nth((n as usize - 68888890) % 8).unwrap() as i32 - '0' as i32;
        }
        (100000000 + (n - 788888890) / 9).to_string().chars().nth((n as usize - 788888890) % 9).unwrap() as i32 - '0' as i32
    }
}
