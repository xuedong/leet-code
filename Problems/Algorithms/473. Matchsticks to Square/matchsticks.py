class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        if not matchsticks:
            return False

        perimeter = sum(matchsticks)
        if perimeter % 4 != 0:
            return False
        side = perimeter // 4

        memo = {}
        n = len(matchsticks)

        def aux(mask, sides):
            used = 0
            for i in range(n):
                if not (mask & (1 << i)):
                    used += matchsticks[i]

            if used > 0 and used % side == 0:
                sides += 1

            if sides == 3:
                return True

            if (mask, sides) in memo:
                return memo[(mask, sides)]

            ans = False
            rest = side
            if used % side != 0:
                rest = side - used % side

            for i in range(n):
                if matchsticks[i] <= rest and mask & (1 << i):
                    if aux(mask ^ (1 << i), sides):
                        ans = True
                        break

            memo[(mask, sides)] = ans
            return ans

        return aux((1 << n) - 1, 0)

