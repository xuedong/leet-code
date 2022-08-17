class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String curr = "";
            for (char ch : word.toCharArray()) {
                curr += table[ch - 'a'];
            }
            set.add(curr);
        }
        
        return set.size();
    }
}
