class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum = 0;

        for (int curr : salary) {
            sum += curr;
            minSalary = Math.min(minSalary, curr);
            maxSalary = Math.max(maxSalary, curr);
        }

        return (double)(sum - minSalary - maxSalary) / (double)(salary.length - 2);
    }
}
