// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
// Example 2:

// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
// Example 3:

// Input: temperatures = [30,60,90]
// Output: [1,1,0]

import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] nge = new int[n];

        st.push(n-1); 
        nge[n-1]=0;

        for(int i=n-2; i>=0; i--){
            while(st.size()>0 && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = 0;
            }else{
                nge[i] = st.peek()-i;
            }

            st.push(i);
        }

        return nge;
    }
}
