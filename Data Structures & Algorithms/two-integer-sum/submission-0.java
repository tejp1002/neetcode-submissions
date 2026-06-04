class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> sumMap = new HashMap();
        final int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(nums[i])) {
                if (nums[i] + nums[i] == target) {
                    ans[0] = sumMap.get(nums[i]);
                    ans[1] = i;
                    return ans;
                }
            } else {
                sumMap.put(nums[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (sumMap.containsKey(target - key)) {
                int index = sumMap.get(target - key);
                if (value > index) {
                    ans[0] = index;
                    ans[1] = value;
                } else {
                    ans[1] = index;
                    ans[0] = value;
                }
                break;
            }
        }

        return ans;
    }
}
