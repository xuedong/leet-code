class Solution {
    public String fractionAddition(String expression) {
        List<Character> signs = new ArrayList<>();
        if (expression.charAt(0) != '-') {
            signs.add('+');
        }
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                signs.add(expression.charAt(i));
            }
        }

        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        for (String fraction : expression.split("[+-]")) {
            if (fraction.length() == 0) {
                continue;
            }
            String[] parts = fraction.split("/");
            numerators.add(Integer.parseInt(parts[0]));
            denominators.add(Integer.parseInt(parts[1]));
        }

        int lcm = 1;
        for (int i = 0; i < denominators.size(); i++) {
            lcm = lcm_(lcm, denominators.get(i));
        }

        int ans = 0;
        for (int i = 0; i < numerators.size(); i++) {
            int numerator = numerators.get(i) * (lcm / denominators.get(i));
            if (signs.get(i) == '+') {
                ans += numerator;
            } else {
                ans -= numerator;
            }
        }

        int gcd = gcd_(Math.abs(ans), lcm);
        return ans / gcd + "/" + lcm / gcd;
    }

    public int lcm_(int a, int b) {
        return a * (b / gcd_(a, b));
    }

    public int gcd_(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
