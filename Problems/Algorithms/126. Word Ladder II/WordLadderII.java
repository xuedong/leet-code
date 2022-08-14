class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        Queue<List<String>> queue = new LinkedList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        queue.add(beginList);
        
        List<List<String>> results = new ArrayList<>();
        boolean found = false;
        
        while (!queue.isEmpty()) {
            int len = queue.size();
            Set<String> currentVisited = new HashSet<>();
            
            int i = len;
            while (i > 0) {
                List<String> currentSequence = queue.poll();
                String currentWord = currentSequence.get(currentSequence.size()-1);
                List<String> neighbors = findNeighbors(currentWord);
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor) && dictionary.contains(neighbor)) {
                        List<String> newSequence = new ArrayList<>(currentSequence);
                        newSequence.add(neighbor);
                        if (neighbor.equals(endWord)) {
                            found = true;
                            results.add(newSequence);
                            continue;
                        }
                        currentVisited.add(neighbor);
                        queue.add(newSequence);
                    }
                }
                i--;
            }
            
            for (String word : currentVisited) {
                visited.add(word);
            }
            
            if (found) break;
        }
        
        return results;
    }
    
    private List<String> findNeighbors(String word) {
        char[] chars = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            for (int j = 0; j <= 25; j++) {
                char ch = (char) ((int) 'a' + j);
                chars[i] = ch;
                String neighbor = new String(chars);
                neighbors.add(neighbor);
            }
            chars[i] = current;
        }
        
        return neighbors;
    }
}

