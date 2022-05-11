class Solution:
    def countVowelStrings(self, n: int) -> int:
        a, e, i, o, u = 1, 1, 1, 1, 1

        for _ in range(n-1):
            a += e + i + o + u
            e += i + o + u
            i += o + u
            o += u

        return a + e + i + o + u

