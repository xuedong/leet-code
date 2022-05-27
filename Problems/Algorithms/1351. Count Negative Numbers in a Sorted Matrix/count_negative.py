import bisect


class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])

        ans = 0
        for row in range(n):
            col = bisect.bisect_left(grid[row], 1, key=lambda x: -x)
            ans += m - col

        return ans

