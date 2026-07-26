class Solution {
    public int trap(int[] height) {

        int leftM=0;
        int rightM=0;

        int left=0;
        int right=height.length-1;

        int store=0;

        while(left<right) {
         if(height[left]<=height[right]) {
            leftM= Math.max(height[left], leftM);
            store+=(leftM-height[left]);
            left++;
         } else {
            rightM= Math.max(height[right], rightM);
            store+=(rightM-height[right]);
            right--;
         }
        }

        return store;
        
    }
}