#!/usr/bin/env python3


class Solution:
    def isPathCrossing(self, path: str) -> bool:
        visited = set()

        curr = (0, 0)
        visited.add(curr)
        step = {'N': (0, 1), 'S': (0, -1), 'E': (1, 0), 'W': (-1, 0)}
        for direction in path:
            curr = curr[0] + step[direction][0], curr[1] + step[direction][1]
            if curr in visited:
                return True
            visited.add(curr)

        return False
