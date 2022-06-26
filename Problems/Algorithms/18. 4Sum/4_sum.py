# The following is a general KSum solution
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        return self.k_sum(nums, target, 4)

    def two_sum(self, nums: List[int], target: int) -> List[List[int]]:
        results = []
        records = set()

        for i in range(len(nums)):
            if len(results) == 0 or results[-1][1] != nums[i]:
                if target - nums[i] in records:
                    results.append([target-nums[i], nums[i]])
                records.add(nums[i])

        return results

    def k_sum(self, nums: List[int], target: int, k: int) -> List[List[int]]:
        results = []

        if not nums:
            return results

        if target // k < nums[0] or target // k > nums[-1]:
            return results

        if k == 2:
            return self.two_sum(nums, target)

        for i in range(len(nums)):
            if i == 0 or nums[i-1] != nums[i]:
                for subset in self.k_sum(nums[i+1:], target-nums[i], k-1):
                    results.append([nums[i]] + subset)
        return results

