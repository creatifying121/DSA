//We are given an array, and we need to look for the element which appears to be the next smaller than the current element in the array, if it is found, then smaller element will be the ans, otherwise, -1. return an array consisting of next smaller elements in given array.

//Example 1:
//Input: 1,2,3,4,4
//Output: -1,-1,-1,-1,-1
//Explanation: In the above array there's no element that appeared to be the smallest in the right side of the current element.

//Example 2:
//Input: 5,4,3,2,1
//Output: 4,3,2,1,-1
//Explanation: For every element, we found smaller element just to next right, but for 1 it is not possible, hence -1 is its answer.

//Example 3:
//Input: 10,11,6,9,8,1,5,7
//Output: 6,6,1,8,1,-1,-1,-1
//Explanation: It is not necessary that everytime, we  can find the next smaller just next right element, whichever element appeared the next smaller, it will be the answer.

import java.util.*;

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextSmallerElement(long[] arr, int n)
    { 
        //defining a stack where we will store the elements
        Stack<Long> st = new Stack<>();
        
        //declaring the resultant array
        long[] nse = new long[arr.length];
        
        //since the last element will never have the next greater element, so it will always have -1 as ans, and we will push the last element of given array into the stack
        nse[n-1] = -1; 
        st.push(arr[n-1]);
        
        //start traversing from second last array element
        for(int i=n-2; i>=0; i--){
            //pop out the elements from stack until we find the peek element to be smaller than current array element, as peek can be a possible smallest element
            while(st.size()>0 && arr[i] <= st.peek()){
                st.pop();
            }
            
            //if stack becomes empty, this means, there is no next greater element for the current element
            if(st.size()==0){
                nse[i] = -1;
            }
            
            //else this means, we were not able to pop the element, and the peek element is the next smaller for current element
            else{
                nse[i] = st.peek(); //we are not popping this, because it is possible that this element is next smaller for some other element too
            }
            
            //every element is pushed into the stack
            st.push(arr[i]);
        }
        
        return nse;
    } 
}