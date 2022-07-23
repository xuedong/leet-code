class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        def helper(nums: List[int]) -> int:
            n = len(nums)
            if n == 0:
                return -1<<32
            if n == 1:
                return nums[0]

            count, product = 0, 1
            for num in nums:
                product *= num
                if num < 0:
                    count += 1

            if count % 2 == 0:
                return product

            front, back = product, product

            i = 0
            while nums[i] > 0:
                back //= nums[i]
                i += 1
            back //= nums[i]

            j = n-1
            while nums[j] > 0:
                front //= nums[j]
                j -= 1
            front //= nums[j]

            return max(front, back)

        n = len(nums)
        if n == 1:
            return nums[0]

        indices = []
        for i in range(n):
            if nums[i] == 0:
                indices.append(i)

        ans = nums[0]
        prev = 0
        for index in indices:
            ans = max(helper(nums[prev:index]), ans)
            prev = index+1
        ans = max(helper(nums[prev:]), ans)

        return max(ans, 0)

