class MinStack {
    // We use Long instead of Integer to avoid overflow
    Stack<Long> stack;

    // Stores the current minimum element
    long min;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        // Case 1: First element
        if (stack.isEmpty()) {

            // Push the value normally
            stack.push((long) value);

            // First element is also the minimum
            min = value;
        }

        // Case 2: New value is NOT smaller than current minimum
        else if (value >= min) {

            // Push normally
            stack.push((long) value);

            // Minimum remains unchanged
        }
        // Case 3: New value becomes the new minimum
        else {

            /*
             Example:
             Current minimum = 5
             New value       = 2

             Instead of pushing 2,
             push encoded value.

             encoded = 2 * newValue - oldMin
                     = 2 * 2 - 5
                     = -1
            */

            long encoded = 2L * value - min;

            // Store encoded value instead of actual value
            stack.push(encoded);

            // Update current minimum
            min = value;
        }
    }
    
    public void pop() {
        // Remove top element
        long top = stack.pop();

        /*
         If top < min

         Example:

         Stack = [5,7,-1]
         min   = 2

         -1 is NOT a real value.
         It is an encoded value.

         We must recover the previous minimum.
        */

        if (top < min) {

            /*
             Encoding formula

             encoded = 2 * newMin - oldMin

             Rearranging,

             oldMin = 2 * newMin - encoded

             Example:

             encoded = -1
             newMin  = 2

             oldMin = 2*2 - (-1)
                    = 5
            */

            min = 2 * min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();

        /*
         If top is encoded,
         the actual top element is the current minimum.

         Example:

         Stack = [5,7,-1]
         min = 2

         peek() returns -1

         Actual top should be 2
        */

        if (top < min) {
            return (int) min;
        }

        // Otherwise top is a normal value
        return (int) top;
    }
    
    public int getMin() {
        // Current minimum is always stored separately
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */