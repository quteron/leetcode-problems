class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int number = 0;

        int l=0, r=s.length()-1;

        // ignore leading spaces
        while (l<=r && s.charAt(l) == ' ') {
            l++;
        }

        // check sign
        if (l<=r) {
            if (s.charAt(l) == '-') {
                sign = -1;
                l++;
            } else if (s.charAt(l) == '+') {
                l++;
            }
        }

        // read number itself
        while (l<=r && Character.isDigit(s.charAt(l))) {
            int digit = s.charAt(l++) - '0';
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digit;
        }

        return number * sign;
    }
}
