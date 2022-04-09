from collections import Counter


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        c1 = Counter(s1)
        n1 = len(s1)
        n2 = len(s2)

        for i in range(n2-n1+1):
            c2 = Counter(s2[i:i+n1])
            flag = True
            for key in c1:
                if c1[key] > c2[key]:
                    flag = False
                    break
            if flag:
                return True

        return False

