class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0]
        for i in range(1, len(strs)):
            while True:
                try:
                    if strs[i].index(prefix) != 0:
                        prefix = prefix[:-1]
                    else:
                        break
                except ValueError:
                    prefix = prefix[:-1]
            if not prefix:
                return ""
        return prefix

