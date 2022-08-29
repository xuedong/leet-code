impl Solution {
    pub fn num_islands(mut grid: Vec<Vec<char>>) -> i32 {
        let mut ans = 0;
        for i in 0..grid.len() {
            for j in 0..grid[0].len() {
                ans += Self::dfs(&mut grid, i, j);
            }
        }
    
        ans
    }

    fn dfs(grid: &mut Vec<Vec<char>>, i: usize, j: usize) -> i32 {
        if i < 0 || i >= grid.len() || j < 0 || j >= grid[0].len() || grid[i][j] == '0' {
            return 0;
        }
        
        grid[i][j] = '0';
        Self::dfs(grid, i-1, j);
        Self::dfs(grid, i+1, j);
        Self::dfs(grid, i, j-1);
        Self::dfs(grid, i, j+1);
        
        1
    }
}
