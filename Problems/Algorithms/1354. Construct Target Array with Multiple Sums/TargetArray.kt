class Solution {
    fun isPossible(target: IntArray): Boolean {
        val n = target.size
        if (n == 1) {
            return if (target[0] == 1) true else false
        }
        
        val queue: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
        
        var sum: Long = 0
        for (i in 0..target.size-1) {
            sum += target[i].toLong()
            queue.add(target[i])
        }
        
        while (queue.peek() != 1) {
            val prev = queue.poll()
            if (prev.toLong() <= sum - prev.toLong()) {
                return false
            }
            
            var curr: Long = -1
            val rest = prev.toLong() % (sum - prev.toLong())
            if (rest == 0.toLong()) {
                curr = sum - prev.toLong()
            } else {
                curr = rest
            }
            
            sum += curr - prev.toLong()
            queue.add(curr.toInt())
        }
        return true
    }
}

