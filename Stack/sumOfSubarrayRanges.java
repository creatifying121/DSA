// You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
// Return the sum of all subarray ranges of nums.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:
// Input: nums = [1,2,3]
// Output: 4
// Explanation: The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0 
// [2], range = 2 - 2 = 0
// [3], range = 3 - 3 = 0
// [1,2], range = 2 - 1 = 1
// [2,3], range = 3 - 2 = 1
// [1,2,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.


// Example 2:
// Input: nums = [1,3,3]
// Output: 4
// Explanation: The 6 subarrays of nums are the following:
// [1], range = largest - smallest = 1 - 1 = 0
// [3], range = 3 - 3 = 0
// [3], range = 3 - 3 = 0
// [1,3], range = 3 - 1 = 2
// [3,3], range = 3 - 3 = 0
// [1,3,3], range = 3 - 1 = 2
// So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.


// Example 3:
// Input: nums = [4,-2,-3,4,1]
// Output: 59
// Explanation: The sum of all subarray ranges of nums is 59.

import java.util.*;
class Solution {
    public long subArrayRanges(int[] arr) {
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        st.push(-1);

        for(int i=0; i<=arr.length; i++){
            int currentValue = i==arr.length ? Integer.MIN_VALUE : arr[i];

            while(st.peek()!=-1 && currentValue < arr[st.peek()]){
                int currIndex = st.pop();
                int right = i-currIndex;
                int left = currIndex - st.peek();

                ans -= (long)(arr[currIndex]*(long)(right*left));
                
            }
            st.push(i);
        }

        st.clear();
        st.push(-1);
        for(int i=0; i<=arr.length; i++){
            int currentValue = i==arr.length ? Integer.MAX_VALUE : arr[i];

            while(st.peek()!=-1 && currentValue > arr[st.peek()]){
                int currIndex = st.pop();
                int right = i-currIndex;
                int left = currIndex - st.peek();

                ans += (long)(arr[currIndex]*(long)(right*left));
                
            }
            st.push(i);
        }

        return ans;
    }
}