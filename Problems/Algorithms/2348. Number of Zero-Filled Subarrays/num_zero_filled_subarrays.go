package main

func zeroFilledSubarray(nums []int) int64 {
	curr := 0
	res := int64(0)
	for _, num := range nums {
		if num == 0 {
			curr++
		} else {
			res += int64(curr * (curr + 1) / 2)
			curr = 0
		}
	}
	res += int64(curr * (curr + 1) / 2)

	return res
}
