class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;

        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;        // Slowest possible speed
        int right = maxPile; // Fastest speed we need to consider

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid;     // mid works; search for a slower speed
            } else {
                left = mid + 1;  // mid is too slow
            }
        }

        return left; // Smallest speed that works
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        long hoursNeeded = 0;

        for (int pile : piles) {
            // Ceiling of pile / speed: e.g., 7 bananas at speed 3 takes 3 hours
            hoursNeeded += (pile + (long) speed - 1) / speed;

            if (hoursNeeded > h) {
                return false;
            }
        }

        return true;
    }
}
