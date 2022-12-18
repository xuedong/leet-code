class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Map<Integer, Integer> next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                next.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }

        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = next.getOrDefault(i, 0);
        }
        return results;
    }
}
