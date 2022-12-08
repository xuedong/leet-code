class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = (int) coordinates.charAt(1);
        return (x + y) % 2 == 0;
    }
}
