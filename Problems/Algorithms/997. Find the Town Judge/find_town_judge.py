class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        scores = [0 for _ in range(n+1)]

        for pair in trust:
            scores[pair[0]] -= 1
            scores[pair[1]] += 1

        i = 1
        while i < n+1:
            if scores[i] == n-1:
                break
            i += 1

        return i if i <= n else -1

