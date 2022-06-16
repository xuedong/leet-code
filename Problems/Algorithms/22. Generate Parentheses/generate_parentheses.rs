impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut results: Vec<String> = Vec::new();
        if n == 0 {
            results.push(String::from(""));
            return results
        }
        
        for i in 0..n {
            for left in Self::generate_parenthesis(i) {
                for right in Self::generate_parenthesis(n-1-i) {
                    let mut curr: String = "(".to_owned();
                    curr.push_str(&left);
                    curr.push_str(")");
                    curr.push_str(&right);
                    results.push(curr);
                }
            }
        }
        
        results
    }
}

