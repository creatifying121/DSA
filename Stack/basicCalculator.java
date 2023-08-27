// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:

// Input: s = "1 + 1"
// Output: 2
// Example 2:

// Input: s = " 2-1 + 2 "
// Output: 3
// Example 3:

// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.

import java.util.*;
class Solution {
    public int calculate(String s) {
        int sum = 0, sign = 1, n = s.length();

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int num = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                num = num*sign;
                sign = 1;
                sum += num;
            }
            else if(ch == '('){
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(ch == ')'){
                sum *= st.pop();
                sum += st.pop();
            }
            else if(ch == '-'){
                sign = -1;
            }
        }
        return sum;
    }
}