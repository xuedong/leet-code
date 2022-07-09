class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();
        
        int i = 0;
        String ans = "";
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int curr = 0;
                while (Character.isDigit(s.charAt(i))) {
                    curr = 10 * curr + (s.charAt(i) - '0');
                    i++;
                }
                count.push(curr);
                stack.push(ans);
                ans = "";
            } else if (ch == '[') {
                i++;
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(stack.pop());
                int n = count.pop();
                for (int j = 0; j < n; j++) {
                    sb.append(ans);
                }
                ans = sb.toString();
                i++;
            } else {
                ans += ch;
                i++;
            }
        }
        return ans;
    }
}

