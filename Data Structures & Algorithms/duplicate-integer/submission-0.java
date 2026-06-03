class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> duplicateIdentifier = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (duplicateIdentifier.contains(nums[i])) {
                return true;
            }
            duplicateIdentifier.add(nums[i]);
        }

        return false;
    }
}