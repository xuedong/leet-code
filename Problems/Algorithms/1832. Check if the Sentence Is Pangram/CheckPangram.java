class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] counts = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            counts[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
