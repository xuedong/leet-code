#!/usr/bin/env python3

from typing import List
from collections import Counter


class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        return len(q := [string for string, count in Counter(arr).items() if count < 2]) >= k and q[k-1] or ""
