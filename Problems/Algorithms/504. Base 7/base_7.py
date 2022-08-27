class Solution:
    def convertToBase7(self, num: int) -> str:
        ans = ""
        if num == 0:
            return "0"

        if num < 0:
            ans += "-"
            num = -num

        while num > 0:
            ans += str(num % 7)
            num //= 7

        if ans[0] == "-":
            ans = ans[1:]
            ans = ans[::-1]
            ans = "-" + ans
        else:
            ans = ans[::-1]
        return ans
