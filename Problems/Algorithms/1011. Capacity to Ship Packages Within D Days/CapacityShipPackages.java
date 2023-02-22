class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight: weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        left -= 1;
        right += 1;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            int need = 1, curr = 0;
            for (int weight: weights) {
                if (curr + weight > mid) {
                    need += 1;
                    curr = 0;
                }
                curr += weight;
            }

            if (need <= days) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
