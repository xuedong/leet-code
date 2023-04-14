class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && i < n && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == n;
    }
}
