class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        
        int j = 0, maxCount = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i)-'A']);
            
			if (i-j+1-maxCount > k) {
                count[s.charAt(j)-'A']--;
                j++;
            }
            
            ans = Math.max(ans, i-j+1);
        }
        
        return ans;
    }
}

