from collections import defaultdict
from itertools import combinations


class Solution:
    def maxProduct(self, words: List[str]) -> int:
        masks = defaultdict(int)
        for word in words:
            for ch in word:
                masks[word] |= 1 << (ord(ch) - ord('a'))

        ans = 0
        for word1, word2 in combinations(words, 2):
            if masks[word1] & masks[word2] == 0:
                ans = max(ans, len(word1) * len(word2))

        return ans

