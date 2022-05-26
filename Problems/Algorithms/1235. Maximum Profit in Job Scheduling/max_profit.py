import bisect


class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        n = len(startTime)
        jobs = sorted(zip(startTime, endTime, profit), key=lambda job: job[0])
        start = [jobs[i][0] for i in range(n)]

        dp = [0] * (n+1)
        for i in range(n-1, -1, -1):
            j = bisect.bisect_left(start, jobs[i][1])
            dp[i] = max(dp[i+1], dp[j] + jobs[i][2])

        return dp[0]

