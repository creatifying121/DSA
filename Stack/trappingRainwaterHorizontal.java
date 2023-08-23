// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

import java.util.*;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
  
        // size of the array
        int n = height.length;
  
        // Stores the final result
        int ans = 0;
        for (int i = 0; i < n; i++) {
  
            while ((!stack.isEmpty())
                   && (height[stack.peek()] < height[i])) {
  
                int pop_height = height[stack.pop()];
  
                if (stack.isEmpty())
                    break;
  
                int distance = i - stack.peek() - 1;
  
                int min_height
                    = Math.min(height[stack.peek()],
                               height[i])
                      - pop_height;
  
                ans += distance * min_height;
            }
  
            stack.push(i);
        }
  
        return ans;
    }
}