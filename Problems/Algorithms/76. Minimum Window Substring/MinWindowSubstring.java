class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        
        int formed = 0;
        int required = target.size();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int[] ans = {Integer.MAX_VALUE, 0, 0};
        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if (target.containsKey(ch) && map.get(ch).intValue() == target.get(ch).intValue()) {
                formed++;
            }
            
            while (i <= j && formed == required) {
                if (j - i + 1 < ans[0]) {
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }
                
                char st = s.charAt(i);
                map.put(st, map.get(st) - 1);
                if (target.containsKey(st) && map.get(st).intValue() < target.get(st).intValue()) {
                    formed--;
                }
                
                i++;
            }
            
            j++;
        }
        
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2]+1);
    }
}

