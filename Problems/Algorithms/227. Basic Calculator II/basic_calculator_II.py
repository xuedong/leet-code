class Solution:
    def calculate(self, s: str) -> int:
        n = len(s)
        if n <= 0:
            return 0

        stack = []
        curr_num, curr_op = 0, '+'
        for i in range(n):
            curr_char = s[i]
            if curr_char.isdigit():
                curr_num = curr_num * 10 + int(curr_char)

            if not curr_char.isdigit() and curr_char != ' ' or i == n-1:
                if curr_op == '+':
                    stack.append(curr_num)
                elif curr_op == '-':
                    stack.append(-curr_num)
                elif curr_op == '*':
                    stack.append(stack.pop() * curr_num)
                elif curr_op == '/':
                    if stack[-1] < 0 and stack[-1] % curr_num != 0:
                        stack.append(stack.pop() // curr_num + 1)
                    else:
                        stack.append(stack.pop() // curr_num)

                curr_op = curr_char
                curr_num = 0

        ans = 0
        for num in stack:
            ans += num
        return ans

