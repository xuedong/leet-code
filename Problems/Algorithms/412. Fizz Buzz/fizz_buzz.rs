impl Solution {
    pub fn fizz_buzz(n: i32) -> Vec<String> {
        let mut res = vec![];
        for i in 1..=n {
            if i % 15 == 0 {
                res.push("FizzBuzz".to_string());
            } else if i % 3 == 0 {
                res.push("Fizz".to_string());
            } else if i % 5 == 0 {
                res.push("Buzz".to_string());
            } else {
                res.push(i.to_string());
            }
        }
        res
    }
}
