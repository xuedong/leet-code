class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < haystack.length()) {
            for (j = i, k = 0; j < haystack.length() && k < needle.length(); j++, k++) {
                if (haystack.charAt(j) != needle.charAt(k)) {
                    break;
                }
            }
            if (k == needle.length()) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
