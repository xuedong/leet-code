class Solution {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = dominoes.length();

        int[] forcesLeft = new int[n];
        for (int i = 0, force = 0; i < n; i++) {
            if (chars[i] == 'R') {
                force = n;
            } else if (chars[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forcesLeft[i] = force;
        }

        int[] forcesRight = new int[n];
        for (int i = n - 1, force = 0; i >= 0; i--) {
            if (chars[i] == 'L') {
                force = n;
            } else if (chars[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forcesRight[i] = force;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (forcesLeft[i] > forcesRight[i]) {
                sb.append('R');
            } else if (forcesLeft[i] < forcesRight[i]) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
