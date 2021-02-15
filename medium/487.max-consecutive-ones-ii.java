public int findMaxConsecutiveOnes(int[] nums) {
    int lo = 0, hi = 0, flip = 1;

    for (; hi<nums.length; hi++) {
        if (nums[hi] == 0) {
            flip--;
        }

        if (flip < 0) {
            if (nums[lo] == 0) {
                flip++;
            }
            lo++;
        }
    }

    return hi-lo;
}
