class Solution {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        courses.sortWith(compareBy({ it -> it[1] }, { it -> -it[0] }))
        
        val queue: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
        
        var totalTime = 0
        var ans = 0
        for (i in 0..courses.size-1) {
            val duration = courses[i][0]
            totalTime += duration
            if (totalTime > courses[i][1]) {
                queue.add(duration)
                val maxDuration = queue.poll()
                totalTime -= maxDuration
            } else {
                queue.add(duration)
                ans++
            }
        }
        
        return ans
    }
}

