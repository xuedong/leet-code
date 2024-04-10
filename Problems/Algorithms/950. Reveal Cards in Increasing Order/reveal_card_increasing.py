#!/usr/bin/env python3

from typing import List


class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        n = len(deck)
        ans = [0] * n

        skip = False
        idx_deck, idx_ans = 0, 0
        
        deck.sort()
        while idx_deck < n:
            if ans[idx_ans] == 0:
                if not skip:
                    ans[idx_ans] = deck[idx_deck]
                    idx_deck += 1
                skip = not skip

            idx_ans = (idx_ans + 1) % n

        return ans
