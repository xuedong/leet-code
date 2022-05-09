class Solution:
    def __init__(self):
        self.combinations = []
        self.letters = {
            '2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno", '7': "pqrs", '8': "tuv", '9': "wxyz"
        }

    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) <= 0:
            return []

        def aux(digits, string, letters, idx, output):
            if idx == len(digits):
                output.append(string)
                return

            num = digits[idx]
            for letter in letters[num]:
                string += letter
                aux(digits, string, letters, idx+1, output)
                string = string[:-1]

        ans = []
        aux(digits, "", self.letters, 0, ans)

        return ans

