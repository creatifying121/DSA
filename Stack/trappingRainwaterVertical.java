// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

class Solution {
    public int trap(int[] height) {
        int lmax = 0, rmax = 0, li = 0, ri = height.length-1;

        int countUnits = 0;

        while(li < ri){
            lmax = Math.max(lmax, height[li]);
            rmax = Math.max(rmax, height[ri]);

            if(lmax < rmax){
                countUnits += lmax-height[li];
                li++;
            }
            else{
                countUnits += rmax-height[ri];
                ri--;
            }
        }

        return countUnits;
    }
}