class Solution:
    def get_sum(self, n: int, index: int, value: int):
        total = 0

        if value > index:
            total += (value + value - index) * (index + 1) // 2
        else:
            total += (value + 1) * value // 2 + index - value + 1

        if value >= n - index:
            total += (value + value - n + 1 + index) * (n - index) // 2
        else:
            total += (value + 1) * value // 2 + n - index - value

        return total - value

    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        left, right = 0, maxSum + 1
        while right - left > 1:
            mid = left + (right - left) // 2
            if self.get_sum(n, index, mid) <= maxSum:
                left = mid
            else:
                right = mid

        return left
