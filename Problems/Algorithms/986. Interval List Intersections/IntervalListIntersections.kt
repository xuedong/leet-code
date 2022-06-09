class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val results: MutableList<IntArray> = mutableListOf()
        
        var i = 0
        var j = 0
        while (i < firstList.size && j < secondList.size) {
            val left = maxOf(firstList[i][0], secondList[j][0])
            val right = minOf(firstList[i][1], secondList[j][1])
            
            if (left <= right) {
                results.add(intArrayOf(left, right))
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++
            } else {
                j++
            }
        }
        
        return results.toTypedArray()
    }
}

