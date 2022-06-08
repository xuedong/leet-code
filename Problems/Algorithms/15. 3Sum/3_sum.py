class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if n <= 2:
            return []

        nums.sort()

        results = []
        for i in range(n-1):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            j, k = i+1, n-1
            while j < k:
                total = nums[i] + nums[j] + nums[k]
                if total == 0:
                    results.append([nums[i], nums[j], nums[k]])

                    k -= 1
                    while j < k and nums[k] == nums[k+1]:
                        k -= 1
                elif total > 0:
                    k -= 1
                else:
                    j += 1

        return results

