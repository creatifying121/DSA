//We are given an array, and we need to look for the element which appears to be the previous smaller than the current element in the array, if it is found, then smaller element will be the ans, otherwise, -1. return an array consisting of previous smaller elements in given array.

//Example 1:
//Input: 1,2,3,4,4
//Output: -1,1,2,3,3
//Explanation: For every element, we found smaller element just to previous left, but for 1 it is not possible, hence -1 is its answer.

//Example 2:
//Input: 5,4,3,2,1
//Output: -1,-1,-1,-1,-1
//Explanation: In the above array there's no element that appeared to be the smallest in the left side of the current element.

//Example 3:
//Input: 10,11,6,9,8,1,5,7
//Output: -1,10,-1,6,6,-1,1,5
//Explanation: It is not necessary that everytime, we  can find the previous smaller just to the previous left element, whichever element appeared the previous smaller, it will be the answer.

import java.util.*;

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] revSmallerElement(long[] arr, int n)
    { 
        //defining a stack where we will store the elements
        Stack<Long> st = new Stack<>();
        
        //declaring the resultant array
        long[] pse = new long[arr.length];
        
        //since the first element will never have the previous smaller element, so it will always have -1 as ans, and we will push the first element of given array into the stack
        pse[0] = -1; 
        st.push(arr[0]);
        
        //start traversing from 1th array element
        for(int i=1; i<n; i++){
            //pop out the elements from stack until we find the peek element to be smaller than current array element, as peek can be a possible smallest element
            while(st.size()>0 && arr[i] <= st.peek()){
                st.pop();
            }
            
            //if stack becomes empty, this means, there is no next greater element for the current element
            if(st.size()==0){
                pse[i] = -1;
            }
            
            //else this means, we were not able to pop the element, and the peek element is the previous smaller for current element
            else{
                pse[i] = st.peek(); //we are not popping this, because it is possible that this element is previous smaller for some other element too
            }
            
            //every element is pushed into the stack
            st.push(arr[i]);
        }
        
        return pse;
    } 
}