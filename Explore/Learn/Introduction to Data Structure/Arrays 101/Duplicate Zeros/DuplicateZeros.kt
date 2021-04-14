class Solution1 {
	// In-place solution
    fun duplicateZeros(arr: IntArray): Unit {
        val length = arr.size
        var i = 0
        
        while (i < length) {
            if (arr[i] > 0) {
                i++
            } else {
                for (j in length-1 downTo i+1) {
                    arr[j] = arr[j-1]
                }
                i += 2
            }
        }
    }
}


class Solution2 {
	// Using a queue
	fun duplicateZeros(arr: IntArray): Unit {
		val q: Queue<Int> = LinkedList()

		for (i in arr.indices) {
			q.add(arr[i])
			if (arr[i] == 0) {
				q.add(0)
			}
			arr[i] = q.remove()
		}
	}
}

