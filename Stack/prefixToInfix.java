// You are given a string S of size N that represents the prefix form of a valid mathematical expression. Convert it to its infix form.

// Example 1:

// Input: 
// *-A/BC-/AKL
// Output: 
// ((A-(B/C))*((A/K)-L))
// Explanation: 
// The above output is its valid infix form.

import java.util.*;
class Solution {
    static String preToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                String val1 = st.pop();
                String val2 = st.pop();
                
                st.push("("+val1+ch+val2+")");
            }
            else{
                st.push(ch+"");
            }
        }
        return st.peek();
    }
}