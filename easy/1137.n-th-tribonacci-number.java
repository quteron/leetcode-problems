public int tribonacci(int n) {
    if (n == 0) {
        return 0;
    }

    if (n == 1 || n == 2) {
        return 1;
    }

    int t1 = 0;
    int t2 = 1;
    int t3 = 1;

    while ( n != 2) {
        int next = t1 + t2 + t3;
        t1 = t2;
        t2 = t3;
        t3 = next;
        n--;
    }

    return t3;
}
