class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i)-'a'] = i;
        }
        
        List<Integer> results = new ArrayList<>();
        int end = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int curr = last[s.charAt(i)-'a'];
            if (curr > end) {
                end = curr;
            }
            if (i == end) {
                results.add(end-start+1);
                start = i + 1;
            }
        }
        
        return results;
    }
}

