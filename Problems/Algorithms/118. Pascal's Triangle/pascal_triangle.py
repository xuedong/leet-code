class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        if numRows == 1:
            return [[1]]

        results = [[1]]
        for i in range(2, numRows+1):
            curr = [1]
            prev = results[-1]
            for j in range(len(prev)-1):
                curr.append(prev[j]+prev[j+1])
            curr.append(1)
            results.append(curr)

        return results

