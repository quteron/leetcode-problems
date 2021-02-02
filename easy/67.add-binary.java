public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();

    int iA = a.length() - 1;
    int iB = b.length() - 1;

    int carry = 0;
    while (iA >= 0 || iB >= 0) {
        carry += (iA >= 0 && a.charAt(iA--) == '1') ? 1 : 0;
        carry += (iB >= 0 && b.charAt(iB--) == '1') ? 1 : 0;

        if (carry % 2 == 1) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        carry /= 2;
    }

    if (carry != 0) {
        sb.append(carry);
    }

    return sb.reverse().toString();
}
