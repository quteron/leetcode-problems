public String minRemoveToMakeValid(String s) {
    int open = 0;
    int balance = 0;

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
            open++;
            balance++;
        } else if (ch == ')') {
            if (balance == 0) {
                continue;
            }
            balance--;
        }

        sb.append(ch);
    }

    int openToKeep = open - balance;
    StringBuilder output = new StringBuilder();
    for(int i=0; i<sb.length(); i++) {
        char ch = sb.charAt(i);
        if (ch == '(') {
            if (openToKeep == 0) {
                continue;
            }
            openToKeep--;
        }
        output.append(ch);
    }

    return output.toString();
}
