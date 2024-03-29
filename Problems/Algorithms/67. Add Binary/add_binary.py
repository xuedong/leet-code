class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a) - 1, len(b) - 1

        results = []
        carry = 0
        while i >= 0 or j >= 0 or carry:
            d1 = int(a[i]) if i >= 0 else 0
            d2 = int(b[j]) if j >= 0 else 0
            results.append(str((d1 + d2 + carry) % 2))
            carry = (d1 + d2 + carry) // 2
            i, j = i-1, j-1

        return ''.join(results[::-1])

