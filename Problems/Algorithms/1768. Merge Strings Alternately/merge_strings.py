class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans = ""
        n = min(len(word1), len(word2))
        m, l = max(0, len(word1) - n), max(0, len(word2) - n)
        
        for i in range(n):
            ans += word1[i]
            ans += word2[i]
        
        for j in range(m):
            ans += word1[j+n]

        for k in range(l):
            ans += word2[k+n]

        return ans
