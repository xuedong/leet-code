class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> results = new ArrayList<>();
        int stringLen = s.length(), size = words.length, substringLen = words[0].length();
        for (int i = 0; i <= stringLen - size * substringLen; i++) {
            Map<String, Integer> visited = new HashMap<>();
            
            int j = 0;
            while (j < size) {
                String word = s.substring(i+j*substringLen, i+(j+1)*substringLen);
                if (counts.containsKey(word)) {
                    visited.put(word, visited.getOrDefault(word, 0) + 1);
                    if (visited.get(word) > counts.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                
                j++;
            }
            
            if (j == size) {
                results.add(i);
            }
        }
        
        return results;
    }
}

