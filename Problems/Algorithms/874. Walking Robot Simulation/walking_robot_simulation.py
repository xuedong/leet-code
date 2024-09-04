#!/usr/bin/env python3

from typing import List


class Solution:
    def __init__(self):
        self.multiplier = 60013

    def hash_coordinates(self, x: int, y: int) -> int:
        return x + self.multiplier * y

    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        obstacles_set = {self.hash_coordinates(x, y) for x, y in obstacles}

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        x, y = 0, 0
        max_dist = 0
        curr = 0

        for command in commands:
            if command == -1:
                curr = (curr + 1) % 4
                continue

            if command == -2:
                curr = (curr + 3) % 4
                continue

            dx, dy = directions[curr]
            for _ in range(command):
                next_x, next_y = x + dx, y + dy
                if self.hash_coordinates(next_x, next_y) in obstacles_set:
                    break
                
                x, y = next_x, next_y

            max_dist = max(max_dist, x * x + y * y)
        
        return max_dist
