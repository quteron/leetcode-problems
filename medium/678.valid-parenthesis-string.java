public boolean checkValidString(String s) {
    int balance = 0;

    // all stars are open braces
    for (int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(' || ch == '*') {
            balance++;
        } else {
            balance--;
        }

        // we have more close braces than opens+stars
        if (balance < 0) {
            return false;
        }
    }

    // all stars are close braces
    balance = 0;
    for (int i=s.length()-1; i>=0; i--) {
        char ch = s.charAt(i);
        if (ch == ')' || ch == '*') {
            balance++;
        } else {
            balance--;
        }

        // we have more close braces than opens+stars
        if (balance < 0) {
            return false;
        }
    }

    return true;
}
