#!/usr/bin/env python3


class ProductOfNumbers:

    def __init__(self):
        self.prefix = [1]
        self.size = 0

    def add(self, num: int) -> None:
        if num == 0:
            self.prefix = [1]
            self.size = 0
        else:
            self.prefix.append(self.prefix[self.size] * num)
            self.size += 1

    def getProduct(self, k: int) -> int:
        if k > self.size:
            return 0

        return self.prefix[self.size] // self.prefix[self.size-k]


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)