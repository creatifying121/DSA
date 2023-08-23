// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
// Example 3:

// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22


import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        // initializing a stack where I will store the elements (input and calculated values)
        Stack<Integer> st = new Stack<>();

        // start traversing through each array element
        for(int i=0; i<tokens.length; i++){
            // taking one element at a time
            String str = tokens[i];

            // checking what current element looks like, if the current element is an operator, I will perform operations
            if(str.equals("+")){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1+val2);
            }else if(str.equals("-")){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1-val2);
            }else if(str.equals("*")){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1*val2);
            }else if(str.equals("/")){
                int val2 = st.pop();
                int val1 = st.pop();
                st.push(val1/val2);
            }else{
                // if current element is not an operator, then surely it is an integer given in string format, so converting string to integer and pushing it onto the stack
                
                st.push(Integer.parseInt(str));
            }
        }
        //int ans = Integer.valueOf(st.pop());
        //return ans;
        return st.pop();
    }
}