public int numDecodings(String s) {
    if (s.charAt(0) == '0') {
        return 0;
    }

    int n = s.length();
    int twoBack = 1;
    int oneBack = 1;

    for (int i=1; i<n; i++) {
        int curr = 0;

        int d1 = s.charAt(i) - '0';
        int d2 = d1 + 10 * (s.charAt(i-1) - '0');

        if (d1 > 0) {
            curr += oneBack;
        }

        if (d2 > 9 && d2 < 27) {
            curr += twoBack;
        }

        twoBack = oneBack;
        oneBack = curr;
    }

    return oneBack;
}
