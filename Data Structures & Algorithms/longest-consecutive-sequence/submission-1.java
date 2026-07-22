class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num:nums) {
            set.add(num);
        }

 
        int result = 0;
        for(int num : set) {
                   int increment=1;
            if(set.contains(num-1)) {
                // if predessor then ignore
                continue;
            }

            while(set.contains(num+increment)) {
                increment++;
            }

            result = Math.max(increment, result);
        }
        
        return result;
    }
}
