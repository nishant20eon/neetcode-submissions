class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max_water = 0;

        while(left<right) {
            int water_qun = (right-left) * Math.min(height[left], height[right]);
            max_water = Math.max(water_qun, max_water);

            if(height[left]<=height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max_water;
        
    }
}