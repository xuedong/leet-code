import bisect


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = bisect.bisect_left(matrix, target, key=lambda x: x[-1])
        return row < len(matrix) and matrix[row][bisect.bisect_left(matrix[row], target)] == target

