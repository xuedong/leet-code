impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        
        let mut ans = 0;
        let mut visited = vec![vec![false; n]; m];
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                ans = ans.max(Self::dfs(&grid, &mut visited, m, n, i, j));
            }
        }
        
        ans
    }
    
    fn dfs(grid: &[Vec<i32>], visited: &mut [Vec<bool>], m: usize, n: usize, i: usize, j: usize) -> i32 {
        if visited[i][j] { 
            return 0; 
        }
        visited[i][j] = true;

        let mut area = 1;
        if i > 0 && grid[i-1][j] == 1 {
            area += Self::dfs(grid, visited, m, n, i-1, j);
        }
        if i < m-1 && grid[i+1][j] == 1 {
            area += Self::dfs(grid, visited, m, n, i+1, j);
        }
        if j > 0 && grid[i][j-1] == 1 {
            area += Self::dfs(grid, visited, m, n, i, j-1);
        }
        if j < n-1 && grid[i][j+1] == 1 {
            area += Self::dfs(grid, visited, m, n, i, j+1);
        }
        
        area
    }
}

