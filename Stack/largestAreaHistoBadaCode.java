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
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nser = new int[n];
        nser[n-1] = n;
        st.push(n-1);
        for(int i = n-2 ;i >= 0; i--)
        {
            while(st.size() > 0 && heights[i] <= heights[st.peek()])
            {
                st.pop();
            }
            if(st.size() == 0)
                nser[i] = n;
            else nser[i] = st.peek();
            st.push(i);
        }
        st = new Stack<>();
        int[] nsel = new int[n];
        nsel[0] = -1;
        st.push(0);
        for(int i = 1; i <n ; i++)
        {
            while(st.size() > 0 && heights[i] <= heights[st.peek()])
            {
                st.pop();
            }
            if(st.size() == 0)
                nsel[i] = -1;
            else nsel[i] = st.peek();
            st.push(i);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++)
        {
            if( (heights[i] * (nser[i]-nsel[i]-1)) > ans)
                ans = heights[i] * (nser[i]-nsel[i]-1);
        }
        return ans;
    }
}