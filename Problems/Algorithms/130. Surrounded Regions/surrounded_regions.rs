use std::collections::VecDeque;

impl Solution {
    pub fn solve(board: &mut Vec<Vec<char>>) {
        let (n, m) = (board.len(), board[0].len());
        let neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]];
        
        let mut queue: VecDeque<(usize, usize)> = VecDeque::new();
        for i in 0..n {
            if board[i][0] == 'O' {
                queue.push_back((i, 0));
            }
            if board[i][m-1] == 'O' {
                queue.push_back((i, m-1));
            }
        }
        for j in 0..m {
            if board[0][j] == 'O' {
                queue.push_back((0, j));
            }
            if board[n-1][j] == 'O' {
                queue.push_back((n-1, j));
            }
        }

        while let Some(curr) = queue.pop_front() {
            let (r, c) = curr;
            board[r][c] = 'B';
            
            for neighbor in neighbors.iter() {
                let (x, y) = (r + neighbor[0] as usize, c + neighbor[1] as usize);
                if x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O' {
                    queue.push_back((x, y));
                }
            }
        }
        
        for row in board.iter_mut() {
            for col in row.iter_mut() {
                *col = match *col {
                    'O' => 'X',
                    'B' => 'O',
                    col => col,
                }
            }
        }
    }
}

