class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        arr.sort(key=lambda x: (self.number_of_1(x), x))
        return arr

    def number_of_1(self, x: int) -> int:
        ans = 0

        while x > 0:
            ans += 1
            x &= x-1

        return ans

