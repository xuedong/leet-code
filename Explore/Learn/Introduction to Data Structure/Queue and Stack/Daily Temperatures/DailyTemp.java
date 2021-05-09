class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        if (len == 1) return result;
        
        Stack<Integer> stack = new Stack<>();       
        for (int i=0; i<len; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
        }
        
        return result;
    }
}

