#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import heapq as hq
from collections import Counter
from typing import List


class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        pq = []
        hq.heapify(pq)

        word_count = Counter(words)

        for word, count in word_count.items():
            hq.heappush(pq, (-count, word))

        result = []
        for _ in range(k):
            result.append(hq.heappop(pq)[1])
        return result
