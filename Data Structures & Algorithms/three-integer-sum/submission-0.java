class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int first=0;first<nums.length-2;first++) {
            if(first>0 && nums[first]==nums[first-1]) continue;

            int middle = first+1;
            int end = nums.length-1;

            while(middle<end) {
                int sum = nums[first]+nums[middle]+nums[end];

                if(sum>0) {
                    end--;
                } else if(sum<0) {
                    middle++;
                } else {
                    result.add(Arrays.asList(nums[first], nums[middle], nums[end]));
                    middle++;
                    end--;
                    while(middle<end && nums[middle] == nums[middle-1]) middle++;
                    while(middle<end && nums[end] == nums[end+1]) end--;
                } 
            }
        }

        return result;
        
    }
}