class Solution {
    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        // find All leftMax
        leftMax[0]=height[0];
        for(int i=1;i<height.length;i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        // find All rightMax
        rightMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        // Main calculation
        int storeWater = 0;

        for(int i=0;i<height.length;i++) {
            int waterTraPAtMax = Math.min(leftMax[i],rightMax[i]);

            int waterStorePerBar = (waterTraPAtMax - height[i])*1;
            storeWater+=waterStorePerBar;
        }
        return storeWater;
    }
}