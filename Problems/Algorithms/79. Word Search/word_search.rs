impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let mut board = board;
        if board.is_empty() {
            return false
        }
        
        let (n, m) = (board.len(), board[0].len());
        for i in 0..n {
            for j in 0..m {
                if Self::dfs(&mut board, &word, 0, i, j) {
                    return true
                }
            }
        }
        false
    }
    
    pub fn dfs(board: &mut Vec<Vec<char>>, word: &str, offset: usize, i: usize, j: usize) -> bool {
        if i == board.len() || j == board[0].len() {
            return false
        }
        
        if word.chars().nth(offset) != Some(board[i][j]) {
            return false
        }
        
        if offset == word.len() - 1 {
            return true
        }
        
        let curr = board[i][j];
        board[i][j] = '.';

        let mut found = Self::dfs(board, word, offset+1, i+1, j);
        if !found {
            found = Self::dfs(board, word, offset+1, i, j+1);
        }
        if !found && i > 0 {
            found = Self::dfs(board, word, offset+1, i-1, j);
        }
        if !found && j > 0 {
            found = Self::dfs(board, word, offset+1, i, j-1);
        }

        board[i][j] = curr;
        found
    }
}

