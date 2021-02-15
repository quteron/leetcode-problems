public boolean isLongPressedName(String name, String typed) {
    int n=0, t=0;
    while (n<name.length() && t<typed.length()) {
        if (name.charAt(n) == typed.charAt(t)) {
            n++; t++;
        } else if (t>0 && typed.charAt(t) == typed.charAt(t-1)) {
            t++;
        } else {
            return false;
        }
    }

    if (n == name.length()) {
       while (t<typed.length() && typed.charAt(t) == typed.charAt(t-1)) {
           t++;
       }
    }

    return n==name.length() && t==typed.length();
}
