class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        counts = Counter(nums)
        minimum, maximum = min(nums), max(nums)

        i = 0
        for num in range(minimum, maximum + 1):
            while counts.get(num, 0) > 0:
                nums[i] = num
                i += 1
                counts[num] -= 1
        
        return nums
