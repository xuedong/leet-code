impl Solution {
    pub fn tribonacci(n: i32) -> i32 {
        let mut a = 0;
        let mut b = 1;
        let mut c = 1;
        for _ in 0..n {
            let d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        a
    }
}
