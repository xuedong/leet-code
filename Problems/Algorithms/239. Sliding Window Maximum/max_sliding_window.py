from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = deque()

        for i in range(k):
            while len(queue) > 0:
                if nums[i] > nums[queue[-1]]:
                    queue.pop()
                else:
                    break
            queue.append(i)

        results = []
        for i in range(k, len(nums)):
            results.append(nums[queue[0]])

            if queue[0] < i - k + 1:
                queue.popleft()

            while len(queue) > 0:
                if nums[i] > nums[queue[-1]]:
                    queue.pop()
                else:
                    break
            queue.append(i)
        results.append(nums[queue[0]])

        return results

