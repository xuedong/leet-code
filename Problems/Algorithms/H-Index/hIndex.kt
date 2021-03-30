class Solution {
	fun hIndex(citations: IntArray): Int {
		if (citations.size == 0) return 0

		val n = citations.size
		var counts = IntArray(n+1)
		var ans : Int = 0

		for (i in 0..n-1) {
			if (citations[i] >= n) {
				counts[n]++
			} else {
				counts[citations[i]]++
			}
		}

		for (i in counts.lastIndex downTo 0) {
			ans += counts[i]
			if (ans >= i) {
				return i;
			}
		}

		return 0;
	}
}

