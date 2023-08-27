// Given a string s which represents an expression, evaluate this expression and return its value. 

// The integer division should truncate toward zero.

// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

// Example 1:

// Input: s = "3+2*2"
// Output: 7
// Example 2:

// Input: s = " 3/2 "
// Output: 1
// Example 3:

// Input: s = " 3+5 / 2 "
// Output: 5
 

// Constraints:

// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.

import java.util.*;
class Solution {
    public int eval(int val1, int val2, char op){
        switch(op){
            case '+': return val1+val2;
            case '-': return val1-val2;
            case '*': return val1*val2;
            case '/': return val1/val2;

            default: System.out.print("error");
        }
        return 0;
    }
    public int calculate(String exp)
    {
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();

        int n= exp.length();
        

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch=='('){
                operator.push(ch);
            }else if(Character.isDigit(ch)){
                int num=0;
                while(i<n && Character.isDigit(exp.charAt(i))){
                    num = num*10 + (exp.charAt(i)-'0');
                    i++;
                }
                i--;
                operand.push(num);
            }
            else if(ch==')'){
                while(operator.size()>0 && operator.peek()!='('){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    char op = operator.pop();

                    int res = eval(v1,v2, op);

                    operand.push(res);
                }
                operator.pop();
            }
            else{
                if(ch=='+' || ch=='-'){
                    while(operator.size()>0 && operator.peek()!='('){
                        int v2 = operand.pop();
                        int v1 = operand.pop();
                        char op = operator.pop();

                        int res = eval(v1,v2, op);

                        operand.push(res);
                    }
                    operator.push(ch);
                }else if(ch=='*' || ch=='/'){
                    while(operator.size()>0 && (operator.peek()=='*' || operator.peek()=='/')){
                        int v2 = operand.pop();
                        int v1 = operand.pop();
                        char op = operator.pop();

                        int res = eval(v1,v2, op);

                        operand.push(res);
                    }
                    operator.push(ch);
                }
            }
        }

        while(operand.size()>1){
            int v2 = operand.pop();
            int v1 = operand.pop();
            char op = operator.pop();

            int res = eval(v1,v2, op);

            operand.push(res);
        }
        
        return operand.peek();
    }
}