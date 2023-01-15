#!/usr/bin/env python3


# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
class ArrayReader(object):
    # Compares the sum of arr[l..r] with the sum of arr[x..y]
    # # return 1 if sum(arr[l..r]) > sum(arr[x..y])
	# return 0 if sum(arr[l..r]) == sum(arr[x..y])
	# return -1 if sum(arr[l..r]) < sum(arr[x..y])
    def compareSub(self, l: int, r: int, x: int, y: int) -> int:
        pass

	# Returns the length of the array
    def length(self) -> int:
        pass


class Solution:
    def getIndex(self, reader: 'ArrayReader') -> int:
        left = 0
        length = reader.length()
        while length > 1:
            length //= 2
            result = reader.compareSub(left, left + length - 1, left + length, left + 2 * length - 1)
            if result == 0:
                return left + 2 * length
            if result == -1:
                left += length
        return left
