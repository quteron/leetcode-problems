public String addStrings(String a, String b) {
    StringBuilder sb = new StringBuilder();

    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0) {
        int vA = (i >= 0) ? a.charAt(i--) - '0' : 0;
        int vB = (j >= 0) ? b.charAt(j--) - '0' : 0;
        carry += vA + vB;
        sb.append(carry % 10);
        carry /= 10;
    }

    if (carry > 0) {
        sb.append(carry);
    }

    return sb.reverse().toString();
}
