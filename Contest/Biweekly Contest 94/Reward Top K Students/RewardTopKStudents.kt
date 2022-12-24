class Solution {
    fun topStudents(positive_feedback: Array<String>, negative_feedback: Array<String>, report: Array<String>, student_id: IntArray, k: Int): List<Int> {
        val n = report.size
        
        val positive_set = HashSet(Arrays.asList(*positive_feedback))
        val negative_set = HashSet(Arrays.asList(*negative_feedback))
        
        val heap = PriorityQueue<Pair<Int, Int>>({ a, b -> 
            if (a.second != b.second) {
                a.second - b.second
            } else {
                b.first - a.first
            } })
        for (i in 0..n-1) {
            val student = report[i].split(" ").toTypedArray()
            val id = student_id[i]
            
            var score = 0
            for (j in 0..student.size-1) {
                if (positive_set.contains(student[j])) {
                    score += 3
                }
                if (negative_set.contains(student[j])) {
                    score -= 1
                }
            }
            
            heap.add(Pair(id, score))
            if (heap.size > k) {
                heap.remove()
            }
        }
        
        val ans: MutableList<Int> = mutableListOf()
        for (i in 0..k-1) {
            ans.add(heap.remove().first)
        }
        
        return ans.reversed()
    }
}
