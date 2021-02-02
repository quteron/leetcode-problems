/**
 * @param buf Destination buffer
 * @param n   Number of characters to read
 * @return    The number of actual characters read
 */
public int read(char[] buf, int n) {
    int pos = 0;
    int copiedChars = 4;
    char[] buf4 = new char[4];

    while (pos < n && copiedChars == 4) {
        copiedChars = read4(buf4);
        if (pos + copiedChars > n) {
            copiedChars = n - pos;
        }

        System.arraycopy(buf4, 0, buf, pos, copiedChars);
        pos += copiedChars;
    }

    return pos;
}
