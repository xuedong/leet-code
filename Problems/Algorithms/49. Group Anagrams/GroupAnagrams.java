class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String curr = String.valueOf(charArr);
            if (map.containsKey(curr)) {
                map.get(curr).add(str);
            } else {
                map.put(curr, new ArrayList<String>());
                map.get(curr).add(str);
            }
        }
        
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        
        return ans;
    }
}

