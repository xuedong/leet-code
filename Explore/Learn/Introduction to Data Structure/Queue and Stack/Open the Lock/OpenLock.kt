class Solution {
    val source = "0000"
    
    fun mark(queue: ArrayDeque<Pair<String, Int>>, dead: HashSet<String>, visited: HashSet<String>, sb: StringBuilder, turns: Int) {
        val str = sb.toString()
        if (!dead.contains(str) && !visited.contains(str)) {
            queue.add(Pair(str, turns))
            visited.add(str)
        }
    }
    
    fun openLock(deadends: Array<String>, target: String): Int {
        val dead = hashSetOf<String>()
        val visited = hashSetOf<String>()
        val queue = ArrayDeque<Pair<String, Int>>()
        
        deadends.forEach {
            dead.add(it)
        }
        if (dead.contains(source)) return -1
        
        queue.add(Pair(source, 0))
        visited.add(source)
        
        while (queue.size > 0) {
            val curr: Pair<String, Int> = queue.removeFirst()
            val str: String = curr.first
            var turns: Int = curr.second
            
            if (str.equals(target)) return turns
            
            turns++
            
            for (i in 0..(str.length-1)) {
                val sb = StringBuilder(str)
                val c = str[i]
                
                if (c == '0') {
					sb[i] = '9'
					mark(queue, dead, visited, sb, turns)
					sb[i] = '1'
					mark(queue, dead, visited, sb, turns)
				} else if (c == '9') {
					sb[i] = '0'
					mark(queue, dead, visited, sb, turns)
					sb[i] = '8'
					mark(queue, dead, visited, sb, turns)
				} else {
					sb[i] = c+1
					mark(queue, dead, visited, sb, turns)
					sb[i] = c-1
					mark(queue, dead, visited, sb, turns)
				}
            }
        }
        
        return -1
    }
}

