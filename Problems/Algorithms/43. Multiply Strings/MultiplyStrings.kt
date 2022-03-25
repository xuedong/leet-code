class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1.equals("0") || num2.equals("0")) {
            return "0"
        }

        val len1 = num1.length
        val len2 = num2.length
		val results = IntArray(len1 + len2 - 1) { 0 }

		for (i in len1-1 downTo 0) {
			for (j in len2-1 downTo 0) {
				results[i+j] += (num1[i] - '0') * (num2[j] - '0')
			}
		}

		for (i in results.size-1 downTo 1) {
			results[i-1] += results[i] / 10
			results[i] %= 10
		}

		val sb = StringBuilder()
		results.forEach { 
			sb.append(it)
		}

		return sb.toString()
    }
}

