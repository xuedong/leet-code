class Solution {
    public int maximum69Number (int num) {
        if (num == 0) return 9;
        int[] digits = new int[4];
        int i = 0;
        while (num > 0) {
            digits[i++] = num % 10;
            num /= 10;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (digits[j] == 6) {
                digits[j] = 9;
                break;
            }
        }
        int res = 0;
        for (int j = i - 1; j >= 0; j--) {
            res = res * 10 + digits[j];
        }
        return res;
    }
}
