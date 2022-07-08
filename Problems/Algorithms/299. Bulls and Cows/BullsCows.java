class Solution {
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];
        for (char ch : secret.toCharArray()) {
            counts[ch-'0']++;
        }
        
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            if (curr == secret.charAt(i)) {
                counts[curr-'0']--;
                bulls++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char curr = guess.charAt(i);
            if (curr != secret.charAt(i)) {
                if (--counts[curr-'0'] >= 0) {
                    cows++;
                }
            }
        }
        
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}

