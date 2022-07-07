class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] counts = new int[128];
        for (char ch : p.toCharArray()) counts[ch]++;
        
        List<Integer> results = new ArrayList<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            counts[ch]--;
            while (counts[ch] < 0) {
                counts[s.charAt(left)]++;
                left++;
            }

            if (right - left + 1 == p.length()) {
                results.add(left);
            }
        }
        return results;
    }
}

