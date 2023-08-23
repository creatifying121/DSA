// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

// Example 1:
// 1 0 1 0 0
// 1 0 |1_1_1|
// 1 1 |1_1_1|
// 1 0 0 1 0
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The rectangle enclosed in pipe signs is the maximal rectangle. 

// Example 2:
// Input: matrix = [["0"]]
// Output: 0

// Example 3:
// Input: matrix = [["1"]]
// Output: 1

//NOTE: this solution is almost dependent on largest area histogram one pass solution

import java.util.*;

class Solution {

    public int maximal(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;

        for(int i=0; i<=arr.length; i++){
            int currentVal = i==arr.length ? Integer.MIN_VALUE :arr[i];

            while(st.peek()!=-1 && currentVal < arr[st.peek()]){
                int val = arr[st.pop()];
                int right = i;
                int left = st.peek();

                int prod = val * (right-left-1);

                ans = Math.max(prod, ans);
            }
            st.push(i);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }
                else{
                    arr[j]++;
                }
            }
            int res = maximal(arr);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}