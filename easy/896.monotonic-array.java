public boolean isMonotonic(int[] A) {
    boolean increasing = true;
    boolean decreasing = true;

    for(int i=1; i<A.length; i++) {
        if (A[i-1] > A[i]) {
            increasing = false;
        }

        if (A[i-1] < A[i]) {
            decreasing = false;
        }
    }

    return increasing || decreasing;
}
