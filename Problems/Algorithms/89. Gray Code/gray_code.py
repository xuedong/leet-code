class Solution:
    def grayCode(self, n: int) -> List[int]:
        results = [0]
        for i in range(n):
            results += [x + int(2**i) for x in results[::-1]]
        return results

