impl Solution {
    pub fn max_depth(s: String) -> i32 {
        fn aux(s: &str, depth: i32, max_depth: i32) -> (i32, i32, i32) {
            match s.chars().next() {
                None => (0, depth, max_depth),
                Some('(') => aux(&s[1..], depth+1, max_depth.max(depth+1)),
                Some(')') => aux(&s[1..], depth-1, max_depth),
                Some(_) => aux(&s[1..], depth, max_depth),
            }
        }

        aux(&s, 0, 0).2
    }
}
