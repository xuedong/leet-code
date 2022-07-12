class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        n1, n2 = len(num1), len(num2)
        num1, num2 = num1[::-1], num2[::-1]

        results = [0] * (n1+n2)
        for i in range(n1):
            for j in range(n2):
                results[i+j] += int(num1[i]) * int(num2[j])

        for k in range(n1+n2-1):
            results[k+1] += results[k] // 10
            results[k] %= 10

        if results[-1] == 0:
            results = results[:-1]

        return ''.join([str(i) for i in results])[::-1]

