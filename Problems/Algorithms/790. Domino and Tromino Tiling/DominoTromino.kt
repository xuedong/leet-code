class Solution {
    fun numTilings(n: Int): Int {
        if (n == 1) return 1

        var domino1: Long = 1
        var domino2: Long = 2
        var tromino0: Long = 0
        var tromino1: Long = 1

        for (i in 3..n) {
            var temp1 = domino2
            var temp2 = tromino1
            domino2 = (domino1 + domino2 + 2 * tromino1) % 1000000007
            tromino1 = (tromino1 + domino1) % 1000000007
            domino1 = temp1
            tromino0 = temp2
        }

        return domino2.toInt()
    }
}
