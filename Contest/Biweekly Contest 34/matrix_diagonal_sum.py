class Solution(object):
    def diagonalSum(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: int
        """
        length = len(mat)
        
        primary = sum([mat[i][i] for i in range(length)])
        secondary = sum([mat[i][length-i-1] for i in range(length)])
        
        total = primary + secondary
        if length % 2 == 1:
            total -= mat[(length-1)/2][(length-1)/2]
        
        return total   
        
