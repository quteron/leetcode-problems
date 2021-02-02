public int divide(int dividend, int divisor) {
    if (divisor == 1) return dividend;
    if (divisor == -1){
        return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
    }

    boolean neg = (dividend >= 0) ^ (divisor >= 0);
    dividend = (dividend > 0) ? -dividend: dividend;
    divisor = (divisor > 0) ? -divisor: divisor;

    if (dividend > divisor) {
        return 0;
    }

    int count = 1;
    int divisor_raw = divisor;
    while (dividend - divisor <= divisor) {
        count += count;
        divisor += divisor;
    }

    count += divide(dividend - divisor, divisor_raw);

    return neg ? -count: count;
}
