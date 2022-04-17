class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '.';
                } else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '.';
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch != '.') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

