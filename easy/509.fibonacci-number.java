public int fib(int n) {
    if (n <= 1) {
        return n;
    }

    int prev=0, next=1;
    while (n != 1) {
        int temp = prev+next;
        prev = next;
        next = temp;

        n--;
    }

    return next;
}
