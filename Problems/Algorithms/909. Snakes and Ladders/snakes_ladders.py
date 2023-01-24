#!/usr/bin/env python3

from collections import deque
from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)

        cells = [None] * (n**2 + 1)
        label = 1
        cols = list(range(n))
        for row in range(n-1, -1, -1):
            for col in cols:
                cells[label] = (row, col)
                label += 1
            cols.reverse()

        distances = [-1] * (n**2 + 1)
        queue = deque([1])
        distances[1] = 0
        while queue:
            curr = queue.popleft()
            for neighbor in range(curr+1, min(curr+6, n**2)+1):
                row, col = cells[neighbor]
                dest = board[row][col] if board[row][col] != -1 else neighbor
                if distances[dest] == -1:
                    distances[dest] = distances[curr] + 1
                    queue.append(dest)

        return distances[n**2]
