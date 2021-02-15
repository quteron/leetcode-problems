public String multiply(String a, String b) {
    int n=a.length(), m=b.length();
    int[] memo = new int[n+m];

    for (int i=m-1; i>=0; i--) {
        int d1 = b.charAt(i) - '0';
        int k=memo.length - (m-i);

        for (int j=n-1; j>=0; j--) {
            int d2 = a.charAt(j) - '0';
            int value = memo[k] + d1*d2;
            memo[k] = value % 10;
            memo[--k] += value / 10;
        }
    }

    StringBuilder ans = new StringBuilder();

    int i=0;
    // skip leading zeros
    while (i<memo.length && memo[i] == 0) {
        i++;
    }

    // put answer
    while(i<memo.length) {
        ans.append(memo[i++]);
    }

    return ans.length() == 0 ? "0" : ans.toString();
}
