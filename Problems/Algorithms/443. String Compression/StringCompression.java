class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        int n = chars.length;
        
        int i = 0;
        while (i < n) {
            int j = 1;
            while (i + j < n && chars[i + j] == chars[i]) {
                j++;
            }
            chars[ans++] = chars[i];

            if (j > 1) {
                for (char ch : Integer.toString(j).toCharArray()) {
                    chars[ans++] = ch;
                }
            }

            i += j;
        }

        return ans;
    }
}
