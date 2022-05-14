class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        int[][] frequencies = new int[n][26];
        
        int[] frequency = new int[26];
        for (int i = 0; i < n; i++) {
            int c = (int) (s.charAt(i) - 'a');
            frequency[c]++;
            frequencies[i] = frequency.clone();
        }
        
        int ans = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (a == b || frequencies[n-1][a] == 0 || frequencies[n-1][b] == 0) continue;
                
                int max = 0, min = 0;
                for (int k = 0; k < n; k++){
                    int c = (int) (s.charAt(k) - 'a');
                    
                    if (c == b) max++;
                    if (c == a) min++;
                    
                    if (min > 0) {
                        ans = Math.max(ans, max-min);
                    }
                    
                    if (max < min && frequencies[n-1][a] - frequencies[k][a] > 0){
                        max = 0;
                        min = 0;
                    }   
                }
            }
        }
        
        return ans;
    }
}

