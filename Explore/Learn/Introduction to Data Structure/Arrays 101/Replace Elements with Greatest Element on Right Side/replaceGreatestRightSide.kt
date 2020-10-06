class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val length = arr.size
        var currentMax = -1
        
        for (i in (length-1) downTo 0) {
            if (currentMax < arr[i]) {
                var temp = arr[i]
                arr[i] = currentMax
                currentMax = temp
            } else {
                arr[i] = currentMax
            }
        }
        
        return arr
    }
}

