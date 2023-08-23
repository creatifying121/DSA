// You are given a string ‘expression’ consists of characters ‘+’, ‘-’, ‘*’, ‘/’, ‘(‘, ‘)’ and ‘0’ to ‘9’, that represents an Arithmetic Expression in Infix Notation. Your task is to evaluate this Arithmetic Expression.

// In Infix Notation, operators are written in-between their operands.

// Note :
// 1. We consider the ‘/’ operator as the floor division.

// 2. Operators ‘*’ and ‘/’ expression has higher precedence over operators‘+’ and ‘-’ 

// 3. String expression always starts with ‘(‘ and ends with ‘)’.

// 4. It is guaranteed that ‘expression’ represents’ a valid expression in Infix notation.

// 5. It is guaranteed that there will be no case that requires division by 0.

// 6. No characters other than those mentioned above are present in the string. 

// 7. It is guaranteed that the operands and final result will fit in a 32-bit integer.
// For Example :
// Consider string ‘expression’ = ‘((2+3)*(5/2))’. 
// Then it’s value after evaluation will be ((5)*(2)) = 10. 


import java.util.* ;
public class infixEvaluation
{
    public static int eval(int val1, int val2, char op){
        switch(op){
            case '+': return val1+val2;
            case '-': return val1-val2;
            case '*': return val1*val2;
            case '/': return val1/val2;

            default: System.out.print("error");
        }
        return 0;
    }
    public static int evaluateArithmeticExpression(String exp) 
    {
        // Write your code here
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

        // while(operand.size()>1){
        //     int v2 = operand.pop();
        //     int v1 = operand.pop();
        //     char op = operator.pop();

        //     int res = eval(v1,v2, op);

        //     operand.push(res);
        // }

        return operand.pop();
    }
}