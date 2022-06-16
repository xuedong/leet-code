impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        if digits.is_empty() {
            return vec![]
        }
        
        digits.chars().fold(vec![String::from("")],
            |acc, digit| acc.iter().flat_map(
                |x| Self::get_char(digit).chars().map(
                    |y| format!("{}{}", x, y)
                ).collect::<Vec<String>>()
            ).collect::<Vec<String>>()
        )
    }
    
    fn get_char(c: char) -> String {
        let res = match c {
            '2' => "abc",
            '3' => "def",
            '4' => "ghi",
            '5' => "jkl",
            '6' => "mno",
            '7' => "pqrs",
            '8' => "tuv",
            '9' => "wxyz",
            _ => "",
        };
        
        String::from(res)
    }
}

