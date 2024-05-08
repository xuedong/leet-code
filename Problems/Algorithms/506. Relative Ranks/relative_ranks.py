#!/usr/bin/env python3

from typing import List
from collections import defaultdict


class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        n = len(score)
        score_copy = score.copy()

        score_to_index = defaultdict(int)
        for i in range(n):
            score_to_index[score_copy[i]] = i

        score_copy.sort(reverse = True)

        rank = [" "] * n
        for i in range(n):
            if i == 0:
                rank[score_to_index[score_copy[i]]] = "Gold Medal"
            elif i == 1:
                rank[score_to_index[score_copy[i]]] = "Silver Medal"
            elif i == 2:
                rank[score_to_index[score_copy[i]]] = "Bronze Medal"
            else:
                rank[score_to_index[score_copy[i]]] = str(i + 1)

        return rank
