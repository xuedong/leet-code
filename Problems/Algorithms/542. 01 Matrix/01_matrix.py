class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n, m = len(mat), len(mat[0])
        results = [[n*m if mat[i][j] == 1 else 0 for j in range(m)] for i in range(n)]

        queue = []
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    queue.append([i, j])

        neighbors = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while len(queue) > 0:
            r, c = queue.pop(0)

            for neighbor in neighbors:
                x, y = r + neighbor[0], c + neighbor[1]
                if self.is_valid(n, m, x, y):
                    if results[x][y] > results[r][c] + 1:
                        results[x][y] = results[r][c] + 1
                        queue.append([x, y])

        return results

    @staticmethod
    def is_valid(n: int, m: int, r: int, c: int) -> bool:
        return r >= 0 and c >= 0 and r < n and c < m

