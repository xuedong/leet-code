class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }
        
        int ans = 0;
        for (int num : count) {
            ans += num / 2 * 2;
            if (ans % 2 == 0 && num % 2 == 1) {
                ans++;
            }
        }
        
        return ans;
    }
}

