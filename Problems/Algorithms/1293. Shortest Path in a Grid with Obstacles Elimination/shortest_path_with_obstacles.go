package main

func shortestPath(grid [][]int, k int) int {
	m, n := len(grid), len(grid[0])
	if m == 1 && n == 1 {
		return 0
	}

	// dp[i][j][k] is the minimum steps to reach (i, j) with k obstacles eliminated
	dp := make([][][]int, m)
	for i := range dp {
		dp[i] = make([][]int, n)
		for j := range dp[i] {
			dp[i][j] = make([]int, k+1)
			for l := range dp[i][j] {
				dp[i][j][l] = -1
			}
		}
	}

	// bfs
	type node struct {
		i, j, k, step int
	}

	queue := []node{{0, 0, 0, 0}}
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]

		if dp[curr.i][curr.j][curr.k] != -1 {
			continue
		}
		dp[curr.i][curr.j][curr.k] = curr.step

		for _, dir := range [][2]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} {
			x, y := curr.i+dir[0], curr.j+dir[1]
			if !isValid(grid, x, y) {
				continue
			}

			if grid[x][y] == 1 {
				if curr.k < k && dp[x][y][curr.k+1] == -1 {
					queue = append(queue, node{x, y, curr.k + 1, curr.step + 1})
				}
			} else {
				if dp[x][y][curr.k] == -1 {
					queue = append(queue, node{x, y, curr.k, curr.step + 1})
				}
			}
		}
	}

	res := -1
	for i := 0; i <= k; i++ {
		if dp[m-1][n-1][i] != -1 {
			if res == -1 || res > dp[m-1][n-1][i] {
				res = dp[m-1][n-1][i]
			}
		}
	}

	return res
}

func isValid(grid [][]int, i, j int) bool {
	return i >= 0 && i < len(grid) && j >= 0 && j < len(grid[0])
}
