class Solution:
    def isPalindrome(self, s: str) -> bool:
        string = [ch.lower() for ch in s if ch.isalnum()]
        return string == string[::-1]

