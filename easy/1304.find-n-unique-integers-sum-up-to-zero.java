public int[] sumZero(int n) {
    int[] ans = new int[n];
    int last = 0;
    while (n > 0) {
        ans[--n] = n;
        last +=n;
    }

    ans[n] = -last;
    return ans;
}
