public int repeatedStringMatch(String a, String b) {
    int count = 0;
    StringBuilder str = new StringBuilder();

    while (str.length() < b.length()) {
        str.append(a);
        count++;
    }

    if (str.indexOf(b) >= 0) {
        return count;
    }

    str.append(a);
    return str.indexOf(b) != -1 ? count+1 : -1;
}
