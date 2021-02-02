public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> output = new ArrayList<>();

    if (nums.length == 0) {
        addRange(lower, upper, output);
        return output;
    }

    if (nums[0] > lower) {
        addRange(lower, nums[0]-1, output);
    }

    for (int i=1; i<nums.length; i++) {
        if (nums[i] > nums[i-1]+1) {
            addRange(nums[i-1]+1, nums[i]-1, output);
        }
    }

    if (nums[nums.length-1] < upper) {
        addRange(nums[nums.length-1]+1, upper, output);
    }

    return output;
}

private void addRange(int low, int high, List<String> output) {
    if (low == high) {
        output.add(low + "");
    } else {
        output.add(low + "->" + high);
    }
}
