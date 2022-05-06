class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        n, m = len(image), len(image[0])
        neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        def dfs(r, c):
            if image[r][c] == color:
                image[r][c] = newColor

                for neighbor in neighbors:
                    x, y = r + neighbor[0], c + neighbor[1]
                    if x >= 0 and y >= 0 and x < n and y < m:
                        dfs(x, y)

        color = image[sr][sc]
        if color != newColor:
            dfs(sr, sc)
        return image

