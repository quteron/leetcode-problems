public String countAndSay(int n) {
    String base = "1";

    while (n != 1) {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < base.length()) {
            char val = base.charAt(i++);
            int k = 1;
            while (i < base.length() && base.charAt(i) == val) {
                i++;
                k++;
            }

            sb.append(k);
            sb.append(val);
        }

        base = sb.toString();
        n--;
    }

    return base;
}
