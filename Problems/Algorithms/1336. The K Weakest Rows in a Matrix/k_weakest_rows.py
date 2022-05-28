class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        counts = []
        result = []

        for i in range(len(mat)):
            counts.append([i, sum(mat[i])])

        return [sorted(counts, key=lambda x: x[1])[i][0] for i in range(k)] 

