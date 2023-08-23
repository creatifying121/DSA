// You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

// Example:

// Input: 
// *-A/BC-/AKL
// Output: 
// ABC/-AK/L-*
// Explanation: 
// The above output is its valid postfix form.

import java.util.*;;
class Solution {
    static String preToPost(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=exp.length()-1; i>=0; i--){
            char ch = exp.charAt(i);
            
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                String val1 = st.pop();
                String val2 = st.pop();
                
                st.push(val1+val2+ch);
            }
            else{
                st.push(ch+"");
            }
        }
        return st.peek();
    }
}
 