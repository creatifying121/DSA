// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

// Example 1:
// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.


// Example 2:
// Input: arr = [11,81,94,43,3]
// Output: 444

import java.util.*;
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);

        for(int i=0; i<=arr.length; i++){
            int currentValue = i==arr.length ? Integer.MIN_VALUE : arr[i];

            while(st.peek()!=-1 && currentValue < arr[st.peek()]){
                int currIndex = st.pop();
                int right = i-currIndex;
                int left = currIndex - st.peek();

                ans += (long)((arr[currIndex]*(long)(right*left))%1000000007);
                ans = ans%1000000007;
            }
            st.push(i);
        }
        return ans;
    }
}