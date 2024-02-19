#!/usr/bin/env python3

from typing import List


class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        availabilities, counts = [0] * n, [0] * n

        for start, end in sorted(meetings):
            min_time = inf
            room = 0
            unused = False

            for i in range(n):
                if availabilities[i] <= start:
                    unused = True
                    counts[i] += 1
                    availabilities[i] = end
                    break

                if min_time > availabilities[i]:
                    min_time = availabilities[i]
                    room = i

            if not unused:
                availabilities[room] += end - start
                counts[room] += 1

        return counts.index(max(counts))
