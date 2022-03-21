class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        arr = s.split(" ")
        if len(pattern) != len(arr):
            return False

        bijection = {}
        for i in range(len(pattern)):
            ch = pattern[i]
            if ch not in bijection:
                if arr[i] in bijection.values():
                    return False
                bijection[ch] = arr[i]
            else:
                if arr[i] != bijection[ch]:
                    return False

        return True

