// Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

// Example 1:

// Input: S = "231*+9-"
// Output: -4
// Explanation:
// After solving the given expression, 
// we have -4 as result.
// Example 2:

// Input: S = "123+*8-"
// Output: -3
// Explanation:
// After solving the given postfix 
// expression, we have -3 as result.

import java.util.*;
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String tokens)
    {
        // Your code here
                // initializing a stack where I will store the elements (input and calculated values)
        Stack<Integer> st = new Stack<>();

        // start traversing through each array element
        for(int i=0; i<tokens.length(); i++){
            // taking one element at a time
            char ch = tokens.charAt(i);

            // checking what current element looks like, if the current element is an operator, I will perform operations
            if(ch=='+'){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1+val2);
            }else if(ch=='-'){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1-val2);
            }else if(ch=='*'){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1*val2);
            }else if(ch=='/'){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1/val2);
            }else{
                // if current element is not an operator, then surely it is an integer given in string format, so converting string to integer and pushing it onto the stack
                
                st.push(ch-'0');
            }
        }
        //int ans = Integer.valueOf(st.pop());
        //return ans;
        return st.pop();
    }
}