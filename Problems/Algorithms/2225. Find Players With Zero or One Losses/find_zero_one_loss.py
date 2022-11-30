class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        zeros = set()
        ones = set()
        mores = set()

        for a, b in matches:
            if a not in ones and a not in mores:
                zeros.add(a)
            
            if b in zeros:
                zeros.remove(b)
                ones.add(b)
            elif b in ones:
                ones.remove(b)
                mores.add(b)
            elif b in mores:
                continue
            else:
                ones.add(b)

        return [sorted(list(zeros)), sorted(list(ones))]
