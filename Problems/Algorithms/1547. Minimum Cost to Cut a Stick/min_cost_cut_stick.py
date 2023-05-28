class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        cuts = [0] + sorted(cuts) + [n]
        dp = {}
        
        def cost(left, right):
            if (left, right) in dp:
                return dp[(left, right)]

            if right - left == 1:
                return 0

            result = min(cost(left, mid) + cost(mid, right) + cuts[right] - cuts[left] for mid in range(left + 1, right))
            dp[(left, right)] = result

            return result

        return cost(0, len(cuts) - 1)
