impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        let (row, col) = (mat.len(), mat[0].len());
        if row * col != (r * c) as usize { return mat; }
        mat.concat().chunks(c as usize).map(|i| i.to_vec()).collect()
    }
}

