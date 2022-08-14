class Solution {
    private int factorial(int n) {
        if (n < 2) return 1;
        
        int ans = 1;            
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
    private boolean isUnique(int n) {
        int[] used = new int[10];
        if (n < 10) return true;
        
        while (n > 0) {
            int digit = n % 10;
            if (used[digit] == 1) return false;
            
            used[digit] = 1;
            n /= 10;
        }
        return true;
    }
    
    private int digitsLength(int n) {
        if (n < 1) return 0;
        
        int count = 9;
        int nums = 9;
        while (--n > 0) {
            if (nums == 0) {
                return 0;
            }
            
            count *= nums;
            nums--;
        }
        return count;
    }
    
    public int numDupDigitsAtMostN(int n) {
        int[] used = new int[10];
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int m = chars.length;
        
        int ans = 0;
        for (int i = 1; i < chars.length; i++) {
            ans += digitsLength(i);
        }

        ans += (chars[0] - '0' - 1) * factorial(9) / factorial(9 - m + 1);
        used[chars[0] - '0'] = 1;
        for (int i = 1; i < m; i++) {
            int count = 0;
            for (int j = 0; j < chars[i] - '0'; j++) {
                if (used[j] != 1) count++;
            }
            
            ans += count * factorial(9 - i) / factorial(9 - m + 1);
            if (used[chars[i] - '0'] == 1){
                break;
            }

            used[chars[i] - '0'] = 1;
        }

        if (isUnique(n)) {
            ans++;
        }
        return n - ans;
    }
}

