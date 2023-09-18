import bisect
import heapq as hq


class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        queue = []
        hq.heapify(queue)

        for i in range(len(mat)):
            num = bisect.bisect_left(mat[i], 0, key=lambda x: -x)
            hq.heappush(queue, (num, i))

        ans = []
        for _ in range(k):
            ans.append(hq.heappop(queue)[1])
        return ans

