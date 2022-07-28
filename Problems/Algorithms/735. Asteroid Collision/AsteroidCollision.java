class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            
            boolean flag = false;
            while (!stack.empty() && curr < 0 && stack.peek() > 0) {
                int prev = stack.pop();
                if (Math.abs(curr) < Math.abs(prev)) {
                    curr = prev;
                } else if (curr + prev == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) stack.push(curr);
        }
        
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}

