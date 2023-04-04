class Solution {
    public int partitionString(String s) {
        int ans = 0;
        
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i) - 'a'] >= start) {
                ans++;
                start = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        
        return ans + 1;
    }
}
