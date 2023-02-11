#!/usr/bin/env python3

from collections import defaultdict


class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        red_graph = defaultdict(list)
        for edge in redEdges:
            red_graph[edge[0]].append(edge[1])
        
        blue_graph = defaultdict(list)
        for edge in blueEdges:
            blue_graph[edge[0]].append(edge[1])
        
        visited = set()   
        results = [-1] * n

        queue = [(0, "null")]
        steps = 0
        while len(queue) > 0:
            length = len(queue)
            for i in range(length):
                curr = queue.pop(0)
                node, color = curr[0], curr[1]
                
                key = str(node) + "->" + color
                if key in visited:
                    continue
                visited.add(key)
                
                if results[node] == -1:
                    results[node] = steps
                
                if color == "null" or color == "red":
                    if blue_graph[node]:
                        for neighbor in blue_graph[node]:
                            queue.append((neighbor, "blue"))
                if color == "null" or color == "blue":
                    if red_graph[node]:
                        for neighbor in red_graph[node]:
                            queue.append((neighbor, "red"))

            steps += 1
        
        return results
