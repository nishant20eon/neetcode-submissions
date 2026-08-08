class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        for(int i=n-1;i>=0;i--) {
            int current_temp = temperatures[i];

            while(!stack.isEmpty() && current_temp>=temperatures[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }

        return answer;
        
    }
}