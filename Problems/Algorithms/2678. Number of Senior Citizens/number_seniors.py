#!/usr/bin/env python3

from typing import List


class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return len([detail for detail in details if int(detail[-4:-2]) > 60])
