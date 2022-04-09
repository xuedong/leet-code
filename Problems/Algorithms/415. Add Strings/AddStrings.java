class Solution {
    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
    
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int maxLen = Math.max(l1, l2);
        
        String s1 = padLeftZeros(num1, maxLen);
        String s2 = padLeftZeros(num2, maxLen);
        
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = maxLen-1; i >= 0; i--) {
            int current = (s1.charAt(i) - '0') + (s2.charAt(i) - '0') + carry;
            result.append(current % 10);
            carry = current / 10;
        }
        
        if (carry > 0) {
            result.append(1);
        }
        
        return result.reverse().toString();
    }
}

