class Solution {
    public int search(int[] nums, int target) {

        int left=0;
        int right = nums.length-1;

        while(left<=right) {
            int middle = left+ (right-left)/2;
            int middleNum = nums[middle];

            if(middleNum<target) {
                left=middle+1;
            } else if(middleNum>target) {
                right= middle-1;
            } else if(middleNum==target) {
                return middle;
            } 
            }
                return -1;
        }
        
        
    }