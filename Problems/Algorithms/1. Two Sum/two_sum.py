class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pairs = dict()

        for i in range(len(nums)):
            rest = target - nums[i]
            if rest in pairs:
                return [pairs[rest], i]

            pairs[nums[i]] = i

        return [-1, -1]

