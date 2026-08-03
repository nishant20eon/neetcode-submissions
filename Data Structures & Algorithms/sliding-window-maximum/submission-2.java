class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // step 1. Initilalize the deque and result array
        // Deque store INDICES, not values
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1];

        for(int i=0;i<k;i++) {
        // step 2: Insert value in deque
        while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
            deque.pollLast();
        }
        deque.offerLast(i);
        }

        // deque 1st index refer maxumn number
        result[0]=nums[deque.peekFirst()];

        // start moving window
        for(int i=k;i<n;i++) {
            // if 1st index number is equal to dequq 1st index number then remove it
            if(deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // Now, will iterate window index numbers if any number are greater than deque number then we need to remove it
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
                deque.pollLast();
            }
            // insert the current index which is eligible
            deque.offerLast(i);

            // The front of the deque ia always the max of the current window
            result[i-k+1] = nums[deque.peekFirst()];

        }
        return result;
        
    }
}