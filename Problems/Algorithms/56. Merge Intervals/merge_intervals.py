class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        if n <= 1:
            return intervals

        intervals.sort(key=lambda x: x[0])
        result = []

        i = 0
        curr = intervals[0]
        while i < n-1:
            next = intervals[i+1]

            if next[0] > curr[1]:
                result.append(curr)
                curr = [next[0], next[1]]
            else:
                curr = [curr[0], max(next[1], curr[1])]

            i += 1;

        result.append(curr)

        return result

