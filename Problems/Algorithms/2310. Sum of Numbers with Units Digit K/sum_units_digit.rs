impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        if num == 0 { 
            return 0
        }
        
        let digit = num % 10;
        match k {
            0 => if digit == 0 { 1 } else { -1 },
            1 => if digit == 0 { 10 } else { digit },
            2 => if digit % 2 == 1 { -1 } else if digit == 0 { 5 } else { digit / 2 },
            3 => match digit {
                3 => 1,
                6 => 2,
                9 => 3,
                2 => if num >= 12 { 4 } else { -1 },
                5 => if num >= 15 { 5 } else { -1 },
                8 => if num >= 18 { 6 } else { -1 },
                1 => if num >= 21 { 7 } else { -1 },
                4 => if num >= 24 { 8 } else { -1 },
                7 => if num >= 27 { 9 } else { -1 },
                0 => if num >= 30 { 10 } else { -1 },
                _ => -1,
            },
            4 => match digit {
                4 => 1,
                8 => 2,
                2 => if num >= 12 { 3 } else { -1 },
                6 => if num >= 16 { 4 } else { -1 },
                0 => if num >= 20 { 5 } else { -1 },
                _ => -1,
            },
            5 => if digit == 0 { 2 } else if digit == 5 { 1 } else { -1 },
            6 => match digit {
                6 => 1,
                2 => if num >= 12 { 2 } else { -1 },
                8 => if num >= 18 { 3 } else { -1 },
                4 => if num >= 24 { 4 } else { -1 },
                0 => if num >= 30 { 5 } else { -1 },
                _ => -1,
            },
            7 => match digit {
                7 => 1,
                4 => if num >= 14 { 2 } else { -1 },
                1 => if num >= 21 { 3 } else { -1 },
                8 => if num >= 28 { 4 } else { -1 },
                5 => if num >= 35 { 5 } else { -1 },
                2 => if num >= 42 { 6 } else { -1 },
                9 => if num >= 49 { 7 } else { -1 },
                6 => if num >= 56 { 8 } else { -1 },
                3 => if num >= 63 { 9 } else { -1 },
                0 => if num >= 70 { 10 } else { -1 },
                _ => -1,
            },
            8 => match digit {
                8 => 1,
                6 => if num >= 16 { 2 } else { -1 },
                4 => if num >= 24 { 3 } else { -1 },
                2 => if num >= 32 { 4 } else { -1 },
                0 => if num >= 40 { 5 } else { -1 },
                _ => -1,
            },
            9 => match digit {
                9 => 1,
                8 => if num >= 18 { 2 } else { -1 },
                7 => if num >= 27 { 3 } else { -1 },
                6 => if num >= 36 { 4 } else { -1 },
                5 => if num >= 45 { 5 } else { -1 },
                4 => if num >= 54 { 6 } else { -1 },
                3 => if num >= 63 { 7 } else { -1 },
                2 => if num >= 72 { 8 } else { -1 },
                1 => if num >= 81 { 9 } else { -1 },
                0 => if num >= 90 { 10 } else { -1 },
                _ => -1,
            },
            _ => -1,
        }
    }
}

