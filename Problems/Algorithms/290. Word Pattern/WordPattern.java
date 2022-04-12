class Solution {
    public boolean wordPattern(String pattern, String s) {
        Set<String> wordSet = new HashSet();
        Set<Character> patternSet = new HashSet();
        
        String[] words = s.split(" ");
        for (String word : words) wordSet.add(word);
        for (char ch : pattern.toCharArray()) patternSet.add(ch);
        
        if (words.length != pattern.length() || wordSet.size() != patternSet.size()) return false;
        
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(words[i])) return false;
            } else {
                map.put(key, words[i]);
            }
        }
        
        return true;
    }
}

