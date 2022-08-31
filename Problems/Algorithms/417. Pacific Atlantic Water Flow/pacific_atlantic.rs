impl Solution {
    pub fn pacific_atlantic(heights: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        if heights.is_empty() {
            return vec![];
        }

        let m = heights.len();
        let n = heights[0].len();

        let mut pacific = vec![vec![false; n]; m];
        let mut atlantic = vec![vec![false; n]; m];
        for i in 0..m {
            Self::dfs(&mut pacific, &heights, i, 0);
            Self::dfs(&mut atlantic, &heights, i, n - 1);
        }
        for j in 0..n {
            Self::dfs(&mut pacific, &heights, 0, j);
            Self::dfs(&mut atlantic, &heights, m - 1, j);
        }

        let mut res = vec![];
        for i in 0..m {
            for j in 0..n {
                if pacific[i][j] && atlantic[i][j] {
                    res.push(vec![i as i32, j as i32]);
                }
            }
        }

        res
    }

    fn dfs(reachable: &mut Vec<Vec<bool>>, heights: &Vec<Vec<i32>>, i: usize, j: usize) {
        reachable[i][j] = true;

        let m = heights.len();
        let n = heights[0].len();
        for &(x, y) in &[(0, 1), (0, -1), (1, 0), (-1, 0)] {
            let ni = i as i32 + x;
            let nj = j as i32 + y;
            if ni >= 0 && ni < m as i32 && nj >= 0 && nj < n as i32 && !reachable[ni as usize][nj as usize] && heights[ni as usize][nj as usize] >= heights[i][j] {
                Self::dfs(reachable, heights, ni as usize, nj as usize);
            }
        }
    }
}
