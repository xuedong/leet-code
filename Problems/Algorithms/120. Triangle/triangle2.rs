impl Solution {
    pub fn minimum_total(triangle: Vec<Vec<i32>>) -> i32 {
        (0..triangle.len()-1)
            .rev()
            .fold(triangle[triangle.len()-1].to_vec(), |mut acc, i| {
                (0..i+1).for_each(|j| acc[j] = triangle[i][j] + acc[j].min(acc[j+1]));
                acc
        })[0]
    }
}

