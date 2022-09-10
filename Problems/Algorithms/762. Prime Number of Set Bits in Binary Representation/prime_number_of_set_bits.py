class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        ans = 0
        for n in range(left, right+1):
            for prime in [2, 3, 5, 7, 11, 13, 17, 19]:
                if self.count(n) == prime:
                    ans += 1
        return ans

    def count(self, n: int) -> int:
        return bin(n).count("1")
