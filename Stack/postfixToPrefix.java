// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

// Example:

// Input: 
// ABC/-AK/L-*
// Output: 
// *-A/BC-/AKL
// Explanation: 
// The above output is its valid prefix form.

import java.util.*;
class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<post_exp.length(); i++){
            char ch = post_exp.charAt(i);
            
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                String val2 = st.pop();
                String val1 = st.pop();
                
                st.push(ch+val1+val2);
            }
            else{
                st.push(ch+"");
            }
        }
        return st.peek();
    }
}