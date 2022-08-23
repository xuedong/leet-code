class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        return (x xor y).toString(2).count { it == '1' }
    }
}
