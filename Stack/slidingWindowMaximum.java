// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7


// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nger = new int[n];
        st.push(n-1);
        nger[n-1] = n;

        for(int i=nums.length-2;i>=0;i--)
        {
            while(st.size()>0 && nums[i] >= nums[st.peek()])
                st.pop();
            if(st.size()==0)
                nger[i] = n;
            else
                nger[i] = st.peek();
            st.push(i);
        }
        int[] ans = new int[n-k+1];
        int limit = n-k+1;
        int j=0;
        for(int i=0;i<limit ; i++)
        {
            if(j<i)
            {
                j=i;
            }
            while(nger[j]<i+k)
                j = nger[j];
            ans[i] = nums[j];
        }
    return ans;
    }
}