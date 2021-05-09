class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String token = tokens[0];
        stack.push(token);
        int result = Integer.parseInt(token);
        
        for (int i=1; i<tokens.length; i++) {
            token = tokens[i]; 
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(token);
                continue;
            }
                
            int a = Integer.parseInt(stack.pop());
            int b = Integer.parseInt(stack.pop());
            if (token.equals("+")) {
                result = a + b;
            } else if (token.equals("-")) {
                result = b - a;
            } else if (token.equals("*")) {
                result = a * b;
            } else if (token.equals("/")) {
                result = b / a;
            }
            stack.push(String.valueOf(result));
        }
        
        return result;
    }
}

