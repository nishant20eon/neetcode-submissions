class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // prefix product
        int prefix = 1;
        for(int i=0;i<nums.length;i++) {
            answer[i] = prefix;
            prefix*=nums[i];
        }

        // suffix product
        int suffix = 1;
        for(int i=n-1;i>=0;i--) {
            answer[i]*=suffix;
            suffix*=nums[i];
        }

        return answer;
        
    }
}  
