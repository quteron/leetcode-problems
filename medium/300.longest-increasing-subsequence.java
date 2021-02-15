// memoization
class Solution {
    public int lengthOfLIS(int[] nums) {
        Map<Integer, Integer> memo = new HashMap();

        int max = 0;
        for (int i=0; i<nums.length; i++) {
            max = Math.max(max, findMax(nums, i, memo));
        }

        return max;
    }

    private int findMax(int[] nums, int start, Map<Integer, Integer> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        if (start == nums.length) {
            return 0;
        }

        int max = 0;
        for (int j=start+1; j<nums.length; j++) {
            if (nums[j] <= nums[start]) {
                continue;
            }
            max = Math.max(max, findMax(nums, j, memo));
        }

        memo.put(start, 1 + max);
        return memo.get(start);
    }
}

// tabulation
public int lengthOfLIS(int[] nums) {
    int totalMax = 0;

    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i=0; i<nums.length; i++) {
        int curMax = 1;
        for (int j=i+1; j<nums.length; j++) {
            if (nums[j] > nums[i]) {
                dp[j] = Math.max(dp[j], dp[i]+1);
                curMax = Math.max(curMax, dp[j]);
            }
        }

        totalMax = Math.max(totalMax, curMax);
    }

    return totalMax;
}
