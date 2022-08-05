class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1

        results = []
        for i in reversed(range(len(digits))):
            curr = digits[i] + carry
            carry = curr // 10
            curr %= 10
            results.append(curr)

        if carry == 1:
            results.append(1)

        return results[::-1]

