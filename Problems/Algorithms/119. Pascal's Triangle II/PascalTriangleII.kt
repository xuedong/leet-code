class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var prev = mutableListOf<Int>()
        var curr = mutableListOf<Int>()
        
        for (i in 0..rowIndex) {
            curr = mutableListOf<Int>()
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    curr.add(1)
                } else {
                    curr.add(prev.get(j-1)+prev.get(j))
                }
            }
            prev = curr
        }
        
        return curr
    }
}

