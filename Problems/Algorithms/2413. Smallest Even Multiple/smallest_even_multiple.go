package main

func smallestEvenMultiple(n int) int {
	if n%2 == 1 {
		return n * 2
	}
	return n
}
