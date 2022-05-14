import heapq as hq
from collections import defaultdict


class Solution:
    def __init__(self):
        self.adj = defaultdict(list)

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        for edge in times:
            src, dest, time = edge

            neighbors = self.adj[src]
            self.adj[src].append((time, dest))

        time_to = [1e10 for _ in range(n+1)]

        self.dijkstra(time_to, n, k)

        ans = max(time_to[1:])
        return -1 if ans == 1e10 else ans

    def dijkstra(self, time_to: List[int], n: int, k: int):
        time_to[k] = 0

        pq = []
        hq.heappush(pq, (0, k))

        time_to[k] = 0

        while len(pq) > 0:
            time, node = hq.heappop(pq)
            if time > time_to[node]:
                continue

            if node not in self.adj.keys():
                continue

            for neighbor in self.adj[node]:
                neighbor_time, neighbor_node = neighbor

                if time_to[neighbor_node] > time + neighbor_time:
                    time_to[neighbor_node] = time + neighbor_time
                    hq.heappush(pq, (time_to[neighbor_node], neighbor_node))

