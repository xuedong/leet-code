class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        indice = {}
        for i, num in enumerate(nums):
            if num in indice and i - indice[num] <= k:
                return True
            indice[num] = i
        return False
