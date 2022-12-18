class Solution {
    public int countEven(int num) {
        if (num % 2 == 1) {
            return num / 2;
        }
        
        int sum = 0;
        int rest = num;
        while (rest > 0) {
            sum += rest % 10;
            rest /= 10;
        }

        if (sum % 2 == 0) {
            return num / 2;
        }
        return num / 2 - 1;
    }
}
