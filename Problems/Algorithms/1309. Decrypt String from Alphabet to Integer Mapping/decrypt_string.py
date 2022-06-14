import re


class Solution:
    def freqAlphabets(self, s: str) -> str:
        return ''.join([chr(int(pattern[:2])+96) for pattern in re.findall(r'\d\d#|\d', s)])

