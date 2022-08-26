class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n-1);
        int i = 0; n = prev.length();
        String results = "";
        int count = 0;
        for (; i < n; i++) {
            if (i > 0 && prev.charAt(i) != prev.charAt(i-1)) {
                if (count > 0) {
                    results += count;
                    results += prev.charAt(i-1);
                }
                count = 1;
            } else {
                count++;
            }
        }
        results += count;
        results += prev.charAt(n-1);

        return results;
    }
}
