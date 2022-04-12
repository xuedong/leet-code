class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
		int[] results = new int[len1+len2-1];

		for (int i = len1-1; i >= 0; i--) {
			for (int j = len2-1; j >= 0; j--) {
				results[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}

		for (int k = results.length-1; k >= 1; k--) {
			results[k-1] += results[k] / 10;
			results[k] %= 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int num : results) { 
			sb.append(num);
		}

		return sb.toString();
    }
}

