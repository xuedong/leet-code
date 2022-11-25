package main

func exist(board [][]byte, word string) bool {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if dfs(board, word, i, j) {
				return true
			}
		}
	}
	return false
}

func dfs(board [][]byte, word string, i, j int) bool {
	if len(word) == 0 {
		return true
	}

	if i < 0 || i >= len(board) || j < 0 || j >= len(board[0]) || board[i][j] != word[0] {
		return false
	}

	curr := board[i][j]
	board[i][j] = '0'
	neighbours := [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}
	res := false
	for _, neighbour := range neighbours {
		res = res || dfs(board, word[1:], i+neighbour[0], j+neighbour[1])
	}

	board[i][j] = curr
	return res
}
