class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = set()
        rotten = []

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh.add((i, j))
                if grid[i][j] == 2:
                    rotten.append((i, j))

        ans = 0
        while len(fresh) > 0 and len(rotten) > 0:
            ans += 1

            curr_size = len(rotten)
            for k in range(curr_size):
                i, j = rotten.pop(0)

                for neighbor in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                    if neighbor in fresh:
                        fresh.remove(neighbor)
                        rotten.append(neighbor)

        if len(fresh) > 0:
            return -1
        return ans

