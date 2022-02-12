class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        if (dictionary.contains(beginWord)) {
            dictionary.remove(beginWord);
        }
        queue.add(beginWord);
        
        int result = 0;
        while (!queue.isEmpty()) {
            result += 1;
            
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String string = queue.poll();
                if (string.equals(endWord)) {
                    return result;
                }
                List<String> neighbors = findNeighbors(string);
                for (String neighbor : neighbors) {
                    if (dictionary.contains(neighbor)) {
                        queue.add(neighbor);
                        dictionary.remove(neighbor);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private static List<String> findNeighbors(String string){
        char[] chars = string.toCharArray();
        List<String> neighbors = new ArrayList<>();
        
        for (int i = 0; i < string.length(); i++){
            char current = string.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++){
                chars[i] = ch;
                String neighbor = new String(chars);
                neighbors.add(neighbor);
            }
            chars[i] = current;
        }
        
        return neighbors;
    }
}

