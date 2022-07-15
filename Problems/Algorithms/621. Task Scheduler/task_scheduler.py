#!/usr/bin/env python3

import heapq as hq
from collections import Counter


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        heap = []
        hq.heapify(heap)

        for task, count in Counter(tasks).items():
            heappush(heap, (-count, task))

        ans = 0
        while heap:
            curr = []
            i = 0
            while i <= n:
                ans += 1
                if heap:
                    count, task = heappop(heap)
                    if count != -1:
                        curr.append((count+1, task))

                if not heap and not curr:
                    break
                else:
                    i += 1

            for item in curr:
                heappush(heap, item)

        return ans

