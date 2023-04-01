package main

func search(nums []int, target int) int {
	left, right := -1, len(nums)

	for right-left > 1 {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			left = mid
		} else {
			right = mid
		}
	}
	return -1
}
