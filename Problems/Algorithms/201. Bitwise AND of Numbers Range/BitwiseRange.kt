class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var m = left
        var n = right
        var i = 0
        while (m != n) {
            m = (m shr 1)
            n = (n shr 1)
            i++
        }
        return (m shl i)
    }
}

