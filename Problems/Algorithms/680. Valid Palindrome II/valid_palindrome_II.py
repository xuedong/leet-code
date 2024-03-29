class Solution:
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s)-1

        while left < right:
            if s[left] == s[right]:
                left += 1
                right -= 1
            else:
                sl = s[:left] + s[left+1:]
                sr = s[:right] + s[right+1:]
                return sl == sl[::-1] or sr == sr[::-1]

        return True

