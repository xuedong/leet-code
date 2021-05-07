class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        if (s == "") return true;
        
        int length = s.length();
        int n = 0;
        char c = s.charAt(n);
        if (c == '}' || c == ')' || c == ']') return false;
        stack.push(s.charAt(n));
        
        while (n < length-1) {
            n++;
            
            c = s.charAt(n);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                if (c == '}' || c == ')' || c == ']') return false;
            }
            
            char p = stack.peek();
            if (p == '{' && c == '}' || p == '(' && c == ')' || p == '[' && c == ']') {
                stack.pop();
            } else {
                return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        return false;
    }
}

