public boolean checkPossibility(int[] nums) {
    int problem = -1;

    for (int i=0; i+1<nums.length; i++) {
        if (nums[i] > nums[i+1]) {
            if (problem != -1) {
                return false;
            }

            problem = i;
        }
    }

    return problem == -1
        || problem == 0
        || nums[problem-1] <= nums[problem+1]
        || problem == nums.length-2
        || nums[problem] <= nums[problem+2];
}
