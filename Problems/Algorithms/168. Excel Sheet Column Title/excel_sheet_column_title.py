class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        ans = ""

        div = columnNumber
        while div > 0:
            rest = 26 if div % 26 == 0 else div % 26
            div -= rest
            div //= 26
            ans += chr(ord("A")+rest-1)

        return ans[::-1]

