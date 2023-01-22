class Solution {
    fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
        score.sortWith(compareBy { it -> -it[k] })
        return score
    }
}
