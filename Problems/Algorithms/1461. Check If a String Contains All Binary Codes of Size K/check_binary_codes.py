class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        substrings = set()

        for i in range(len(s)-k+1):
            substrings.add(s[i:i+k])

        return len(substrings) == 1 << k

