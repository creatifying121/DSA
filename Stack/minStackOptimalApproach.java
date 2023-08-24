// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.


// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2


import java.util.*;
class MinStack {

    // Stack<Integer> all;
    // Stack<Integer> min;
    Stack<Long> st;
    long mini;

    public MinStack() {
        // all = new Stack<>();
        // min = new Stack<>();
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        // all.push(val);

        // if(min.size()==0 || (min.size()>0 && val <= min.peek()))
        //     min.push(val);

        long value = (long)(val-0);
        if(st.size()==0){
            st.push(value);
            mini = value;
        }
        else if(st.size()>0 && value>=mini){
            st.push(value);
        }
        else{
            long smallerVal = value+value-mini;
            st.push(smallerVal);
            mini = value;
        }
    }
    
    public void pop() {
        // int val = all.pop();
        // if(val==min.peek())
        //     min.pop();

        long value = st.pop();
        if(value < mini){
            mini = mini + mini - value;
        }
    }
    
    public int top() {
        //return all.peek();

        long value = st.peek();
        if(value >= mini){
            return (int)(value-0);
        }
        else{
            return (int)(mini-0);
        }
    }
    
    public int getMin() {
        //return min.peek();
        return (int)(mini-0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */