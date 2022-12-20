#!/usr/bin/env python3

from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        visited = set()
        visited.add(0)
        
        queue = [0]
        while len(queue) > 0:
            curr = queue.pop(0)
            
            for neighbor in rooms[curr]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        
        return len(visited) == n
