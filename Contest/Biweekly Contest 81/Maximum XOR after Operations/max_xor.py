class Solution:
    def maximumXOR(self, nums: List[int]) -> int:
        best = max(nums)
        binaries = [bin(num) for num in nums]
        n = len(bin(best)) - 2

        ans = ''
        for i in range(n):
            flag = False
            for binary in binaries:
                if i < len(binary)-2 and binary[-i-1] == '1':
                    ans += '1'
                    flag = True
                    break
            if not flag:
                ans += '0'
        ans += 'b0'
        ans = ans[::-1]
        return int(ans, 2)

