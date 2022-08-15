class Solution:
    def romanToInt(self, s: str) -> int:
        values = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

        t = s.replace("IV", "IIII")
        t = t.replace("IX", "VIIII")
        t = t.replace("XL", "XXXX")
        t = t.replace("XC", "LXXXX")
        t = t.replace("CD", "CCCC")
        t = t.replace("CM", "DCCCC")

        ans = 0
        for ch in t:
            ans += values[ch]

        return ans

