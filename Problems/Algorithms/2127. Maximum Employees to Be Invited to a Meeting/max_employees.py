#!/usr/bin/env python3

from collections import deque
from typing import List


class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        def _bfs(start: int, visited_nodes: set, graph: List[List[int]]):
            queue = deque([(start, 0)])
            max_distance = 0

            while queue:
                curr, curr_distance = queue.popleft()
                for neighbor in graph[curr]:
                    if neighbor in visited_nodes:
                        continue
                    
                    visited_nodes.add(neighbor)
                    queue.append((neighbor, curr_distance+1))
                    max_distance = max(max_distance, curr_distance+1)

            return max_distance

        persons = len(favorite)
        graph = [[] for _ in range(persons)]
        for person in range(persons):
            graph[favorite[person]].append(person)

        longest_cycle = 0
        two_cycle = 0
        visited = [False] * persons

        for person in range(persons):
            if not visited[person]:
                visited_persons = {}
                curr_person = person
                distance = 0

                while True:
                    if visited[curr_person]:
                        break

                    visited[curr_person] = True
                    visited_persons[curr_person] = distance
                    distance += 1
                    next_person = favorite[curr_person]

                    if next_person in visited_persons:
                        length = distance - visited_persons[next_person]
                        longest_cycle = max(longest_cycle, length)

                        if length == 2:
                            visited_nodes = {curr_person, next_person}
                            two_cycle += (2 + _bfs(next_person, visited_nodes, graph) + _bfs(curr_person, visited_nodes, graph))
                        break

                    curr_person = next_person

        return max(longest_cycle, two_cycle)
