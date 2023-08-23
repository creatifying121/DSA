// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.

// Example:

// Input:
// ab*c+ 
// Output: 
// ((a*b)+c)
// Explanation: 
// The above output is its valid infix form.

import java.util.*;
class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                String val2 = st.pop();
                String val1 = st.pop();
                
                st.push("("+val1+ch+val2+")");
            }
            else{
                st.push(ch+"");
            }
        }
        return st.peek();
    }
}