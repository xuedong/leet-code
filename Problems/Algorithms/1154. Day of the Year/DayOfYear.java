class Solution {
    private static final int[] DAYS = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public int dayOfYear(String date) {
        int year, month, day;
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(5, 7));
        day = Integer.parseInt(date.substring(8, 10));

        int days = day;
        for (int i = 0; i < month - 1; i++) {
            days += DAYS[i];
        }
        if (month > 2 && isLeap(year)) {
            days += 1;
        }

        return days;
    }
}
