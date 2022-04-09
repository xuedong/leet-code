class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        var i = 0;
        var j = 0;
        map.put(s.charAt(0), 1);
        var ans = 0;
        while (j < n-1) {
            if (!map.containsKey(s.charAt(j+1)) || map.get(s.charAt(j+1)) == 0) {
                map.put(s.charAt(j+1), 1);
                j++;
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
        }
        
        return ans;
    }
}

