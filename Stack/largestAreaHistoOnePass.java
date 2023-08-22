// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.
// Example 2:

// Input: heights = [2,4]
// Output: 4
import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0; //aisa ho skta hai ki km se km value 1 aaye, aur hme greater chahiye, isiliye 0 le rhe hain
        for(int i=0; i<=heights.length; i++){
            int currentVal = i==heights.length ? Integer.MIN_VALUE : heights[i];
            while(st.peek() != -1 && currentVal < heights[st.peek()]){
 
                int val = heights[st.pop()];
                int left = st.peek();
                int right = i;
                int prod = val * (right-left-1);

                ans = Math.max(ans, prod);
            }
            st.push(i);
        }

        return ans;
    }
}