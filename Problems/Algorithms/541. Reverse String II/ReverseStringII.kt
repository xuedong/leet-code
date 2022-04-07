class Solution {
    fun reverseStr(s: String, k: Int): String {
        var count = 0
        return s
            .chunked(k)
	        .joinToString("") {
		        val result = if (count % 2 == 0) it.reversed() else it
		        count++
		        result
	        }
    }
}

