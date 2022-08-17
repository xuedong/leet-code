impl Solution {
    pub fn is_self_crossing(distance: Vec<i32>) -> bool {
        let n = distance.len();
        if n < 4 {
            return false;
        }

        for i in 3..n {
            if distance[i] >= distance[i-2] && distance[i-1] <= distance[i-3] {
                return true;
            }
            if i >= 4 && distance[i] + distance[i-4] >= distance[i-2] && distance[i-1] == distance[i-3] {
                return true;
            }
            if i >= 5 && distance[i-2] >= distance[i-4] && distance[i-3] >= distance[i-1] && distance[i] + distance[i-4] >= distance[i-2] && distance[i-1] + distance[i-5] >= distance[i-3] {
                return true;
            }
        }

        false
    }
}