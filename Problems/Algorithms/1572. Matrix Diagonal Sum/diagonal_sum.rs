impl Solution {
    pub fn diagonal_sum(mat: Vec<Vec<i32>>) -> i32 {
        let n = mat.len();
        let extra = if n % 2 == 1 { mat[n/2][n/2] } else { 0 };
        (0..n).fold(0, |sum, i| sum + mat[i][i] + mat[i][n-i-1]) - extra
    }
}

