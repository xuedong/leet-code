#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from collections import Counter
from typing import List


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        values = Counter(arr).values()
        return len(values) == len(set(values))
