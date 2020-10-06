class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val length = arr.size
        if (length <= 1) return false
        
        for (i in 0..(length-1)) {
            for (j in (i+1)..(length-1)) {
                if (arr[j] == 2 * arr[i]) return true
            }
            if (arr[i] % 2 == 0) {
                for (j in (i+1)..(length-1)) {
                    if (arr[j] == arr[i] / 2) return true
                }
            }
        }
        
        return false
    }
}

