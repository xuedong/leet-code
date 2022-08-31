impl Solution {
    pub fn to_hex(num: i32) -> String {
        if num == 0 {
            return "0".to_string();
        }

        let mut res = vec![];
        let mut num = num as u32;
        while num > 0 {
            let digit = num % 16;
            num /= 16;
            if digit < 10 {
                res.push(digit as u8 + b'0');
            } else {
                res.push(digit as u8 + b'a' - 10);
            }
        }

        String::from_utf8(res).unwrap().chars().rev().collect()
    }
}
