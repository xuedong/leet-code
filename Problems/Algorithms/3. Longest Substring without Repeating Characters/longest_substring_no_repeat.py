class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        if n <= 1:
            return n

        count = {}

        i, j, ans = 0, 0, 0
        count[s[0]] = 1
        while j < n-1:
            if s[j+1] not in count or count[s[j+1]] == 0:
                count[s[j+1]] = 1
                j += 1
            else:
                count[s[i]] -= 1
                i += 1
            ans = max(ans, j-i+1)

        return ans

