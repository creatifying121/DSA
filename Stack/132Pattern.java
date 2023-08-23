// Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

// Return true if there is a 132 pattern in nums, otherwise, return false.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: There is no 132 pattern in the sequence.

// Example 2:
// Input: nums = [3,1,4,2]
// Output: true
// Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

// Example 3:
// Input: nums = [-1,3,2,0]
// Output: true
// Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

import java.util.*;
class Solution {
    public boolean find132pattern(int[] nums) {
        int[] mini = new int[nums.length];
        mini[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            mini[i] = Math.min(mini[i-1], nums[i]);
        }

        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(st.size()>0 && mini[i]>=st.peek()){
                st.pop();
            }
            if(st.size()>0 && nums[i] > st.peek()){
                return true;
            }
            st.push(nums[i]);
        }
        return false;

    }
}