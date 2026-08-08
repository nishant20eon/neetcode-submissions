class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // ---------------------------------------
        // LEFT SMALLER
        // ---------------------------------------

        int[] left = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            int current = heights[i];

            // Remove elements which are greater than
            // or equal to current.
            //
            // They cannot be the previous smaller element.
            while (!stack.isEmpty() &&
                   current <= heights[stack.peek()]) {

                stack.pop();
            }

            // If stack is empty:
            // No smaller element on the left.
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                // Stack top is previous smaller index.
                left[i] = stack.peek();
            }

            // Store INDEX because later we need
            // the width.
            stack.push(i);
        }


        // ---------------------------------------
        // RIGHT SMALLER
        // ---------------------------------------

        int[] right = new int[n];

        // Clear the stack before finding
        // smaller elements on the right.
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            int current = heights[i];

            // Remove elements which are greater than
            // or equal to current.
            //
            // They cannot be the next smaller element.
            while (!stack.isEmpty() &&
                   current <= heights[stack.peek()]) {

                stack.pop();
            }

            // If stack is empty:
            // No smaller element on the right.
            //
            // We keep -1 according to our current logic.
            if (stack.isEmpty()) {
                right[i] = -1;
            } else {
                // Stack top is next smaller index.
                right[i] = stack.peek();
            }

            // Store INDEX.
            stack.push(i);
        }


        // ---------------------------------------
        // CALCULATE AREA
        // ---------------------------------------

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int actualRight;

            // If there is no smaller element on the right,
            // the rectangle can extend until the END of
            // the array.
            if (right[i] == -1) {
                actualRight = n;
            } else {
                actualRight = right[i];
            }

            // Width between left smaller and right smaller.
            int width = actualRight - left[i] - 1;

            // Rectangle area.
            int area = heights[i] * width;

            // Keep maximum area.
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}