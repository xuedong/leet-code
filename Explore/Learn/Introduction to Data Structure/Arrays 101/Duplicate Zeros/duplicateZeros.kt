class Solution {
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

