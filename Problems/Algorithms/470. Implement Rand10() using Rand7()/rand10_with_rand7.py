# The rand7() API is already defined for you.
# def rand7():
# @return a random integer in the range 1 to 7

class Solution:
    def rand10(self):
        """
        :rtype: int
        """
        while True:
            row = rand7()
            col = rand7()
            if (row-1)*7 + col <= 40:
                return ((row-1)*7 + col) % 10 + 1
