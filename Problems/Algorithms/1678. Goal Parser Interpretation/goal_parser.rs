impl Solution {
    pub fn interpret(command: String) -> String {
        let mut res = String::new();
        let mut prev = ' ';
        
        for curr in command.chars() {
            match (prev, curr) {
                (_, 'G') => res.push('G'),
                ('(', ')') => res.push('o'),
                ('(', 'a') => res.push_str("al"),
                _ => prev = curr,
            }
        }
        
        res
    }
}

