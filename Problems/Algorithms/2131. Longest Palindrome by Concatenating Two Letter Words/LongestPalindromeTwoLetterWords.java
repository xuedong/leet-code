class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int ans = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(1));
            sb.append(word.charAt(0));
            String inv = sb.toString();
            
            if (map.containsKey(inv) && map.get(inv) > 0) {
                map.put(inv, map.get(inv) - 1);
                ans += 4;
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        boolean flag = false;
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) > 0) {
                flag = true;
            }
        }
        
        if (flag) {
            ans += 2;
        }
        
        return ans;
    }
}

