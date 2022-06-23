impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        match n {
            2 => 1,
            3 => 2,
            4 => 4,
            _ => Self::helper(n),
        }
    }
    
    pub fn helper(n: i32) -> i32 {
        match n {
            2 => 2,
            3 => 3,
            4 => 4,
            _ => 3 * Self::helper(n-3),
        }
    }
}

