from typing import List


class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        prefixes = [0]
        for num in nums:
            prefixes.append(prefixes[-1] + num)
        
        best = float('inf')
        ans = 0
        for i in range(1, len(prefixes)):
            prefix = prefixes[i] // i
            if i == len(prefixes) - 1:
                if best > prefix:
                    best = prefix
                    ans = i - 1
            else:
                suffix = (prefixes[-1] - prefixes[i]) // (len(prefixes) - i - 1)
                if abs(prefix - suffix) < best:
                    best = abs(prefix - suffix)
                    ans = i - 1
        
        return ans
