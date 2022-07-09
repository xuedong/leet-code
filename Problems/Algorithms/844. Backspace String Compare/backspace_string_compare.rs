impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        fn process(s: String) -> Vec<char> {
            let mut stack = vec![];
            for ch in s.chars() {
                match ch {
                    '#' => {
                        if !stack.is_empty() {
                            stack.pop();
                        }
                    },
                    _ => stack.push(ch),
                }
            }
            stack
        }
        
        process(s) == process(t)
    }
}

