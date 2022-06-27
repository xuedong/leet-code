class Solution {
    fun minPartitions(n: String): Int {
        var ans = '0'
        for (char in n) {
            ans = maxOf(ans, char)
        }
        return (ans-'0').toInt()
    }
}

