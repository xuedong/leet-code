class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        left, right = max(ax1, bx1), min(ax2, bx2)
        bottom, top = max(ay1, by1), min(ay2, by2)

        total = (ax2-ax1) * (ay2-ay1) + (bx2-bx1) * (by2-by1)
        if left >= right or bottom >= top:
            return total
        return total - (right-left) * (top-bottom)

