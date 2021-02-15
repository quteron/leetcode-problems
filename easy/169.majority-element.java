public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = -1;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }

        count += (candidate == num) ? 1 : -1;
    }

    return candidate;
}
