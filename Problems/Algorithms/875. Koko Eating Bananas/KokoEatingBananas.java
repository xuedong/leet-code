class Solution {
    private boolean getTime(int[] piles, int h, long k) {
        long time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / (double) k);
        }

        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        long left = 0, right = sum;
        while (right - left > 1) {
            long mid = left + (right - left) / 2;

            if (getTime(piles, h, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return (int) right;
    }
}
