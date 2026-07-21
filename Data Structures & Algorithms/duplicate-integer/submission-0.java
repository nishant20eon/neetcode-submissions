class Solution {
    public boolean hasDuplicate(int[] nums) {
         // Use a Hashset to track numbers seen so far.
        // If a number already exist in the set, a duplicate is found

        Set<Integer> set = new HashSet<>();
        for(int i  = 0; i<nums.length;i++) {
            if(set.contains(nums[i])) {
                return true; // duplicate found
            }
            set.add(nums[i]);
        }
        return false; // all element are unique       
    }
}