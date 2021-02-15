// memoization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap();
        return backtracking(nums, 0, target, memo);
    }

    public int backtracking(int[] nums, int i, int target, Map<String, Integer> memo) {
        String key = i + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int count = 0;
        count += backtracking(nums, i+1, target-nums[i], memo);
        count += backtracking(nums, i+1, target+nums[i], memo);

        memo.put(key, count);
        return count;
    }
}
