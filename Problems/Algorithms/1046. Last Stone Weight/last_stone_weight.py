class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        n = len(stones)

        while n > 1:
            stones = sorted(stones)
            if stones[-1] == stones[-2]:
                n -= 2
                stones = stones[:-2]
            else:
                temp = stones[-1] - stones[-2]
                stones = stones[:-2]
                stones.append(temp)
                n -= 1

        if n == 0:
            return 0
        else:
            return stones[0]

