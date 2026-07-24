class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : set) {

            // Skip if this is not the end of a sequence
            if (set.contains(num + 1)) {
                continue;
            }

            int length = 1;

            while (set.contains(num - length)) {
                length++;
            }

            result = Math.max(result, length);
        }

        return result;
    }
}