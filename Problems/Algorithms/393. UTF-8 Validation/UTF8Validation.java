class Solution {
    public boolean validUtf8(int[] data) {
        int bytes = 0;

        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        for (int i = 0; i < data.length; i++) {
            if (bytes == 0) {
                int mask = 1 << 7;
                while ((mask & data[i]) != 0) {
                    bytes++;
                    mask = mask >> 1;
                }

                if (bytes == 0) {
                    continue;
                }

                if (bytes == 1 || bytes > 4) {
                    return false;
                }
            } else {
                if (!((data[i] & mask1) != 0 && (data[i] & mask2) == 0)) {
                    return false;
                }
            }

            bytes -= 1;
        }

        return bytes == 0;
    }
}
