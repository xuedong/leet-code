class Solution {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val dictionary: HashSet<String> = wordList.toHashSet()
        val visited: HashSet<String> = HashSet<String>()
        val queue = ArrayDeque<MutableList<String>>()
        val ans = mutableListOf<MutableList<String>>()
        var found = false
        
        queue.add(mutableListOf<String>(beginWord))
        visited.add(beginWord)
        
        while (!queue.isEmpty()) {
            val len = queue.size
            val currentVisited: HashSet<String> = HashSet<String>()
            
            var i = len
            while (i > 0) {
                val currentSequence = queue.removeFirst()
                val currentWord: String = currentSequence.last()
                val neighbors: List<String> = findNeighbors(currentWord)
                for (neighbor in neighbors) {
                    if (!visited.contains(neighbor) && dictionary.contains(neighbor)) {
                        val newSequence = currentSequence.toMutableList()
                        newSequence.add(neighbor)
                        if (neighbor.equals(endWord)) {
                            found = true
                            ans.add(newSequence)
                            continue
                        }
                        currentVisited.add(neighbor)
                        queue.add(newSequence)
                    }
                }
                i--
            }
            
            for (word in currentVisited) {
                visited.add(word)
            }
            
            if (found) break
        }
        
        return ans
    }
    
    private fun findNeighbors(string: String): List<String> {
        val chars = string.toCharArray()
        val neighbors = mutableListOf<String>()
        
        for (i in 0..string.length-1){
            val current = string.get(i)
            for (ch in 'a'..'z'){
                chars[i] = ch
                val neighbor: String = String(chars)
                neighbors.add(neighbor)
            }
            chars[i] = current
        }
        
        return neighbors
    }
}

