class Solution {
    public String longestPalindrome(String s) {
        int length = 0;
        int n = s.length();
        
        int start = 0;
        int end = n-1;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    start = left;
                    end = right;
                    length = right - left + 1;
                }
                left--;
                right++;
            }
            
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    start = left;
                    end = right;
                    length = right - left + 1;
                }
                left--;
                right++;
            }
        }
            
        return s.substring(start, end + 1);
    }
}

