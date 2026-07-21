class Solution {
    public int climbStairs(int steps) {
        int [] dp = new int[steps+1];
		Arrays.fill(dp,-1);
		return climbStairDPWay(steps,dp);
    }

    	private int climbStairDPWay(int steps, int[] dp) {
		// TODO Auto-generated method stub
		if(steps==0) return 1;
		if(steps<0) return 0;
		if(dp[steps]!=-1) {
			return dp[steps];
		}
		
		dp[steps] = climbStairDPWay(steps-1,dp) + climbStairDPWay(steps-2,dp);
		
		return dp[steps];
	}
}
