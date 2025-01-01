class Solution {

    //Solution 1
    public int[] twoSum1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    //Solution 2
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return(new int[]{map.get(target - nums[i]), i});
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}