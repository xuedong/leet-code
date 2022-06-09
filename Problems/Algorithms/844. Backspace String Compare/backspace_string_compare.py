class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        return self.process(s) == self.process(t)

    def process(self, s: str) -> str:
        stack = []

        for ch in s:
            if ch == '#':
                if stack:
                    stack.pop()
                else:
                    continue
            else:
                stack.append(ch)

        return ''.join(stack)

