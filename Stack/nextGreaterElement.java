// Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

// Example 1:

// Input: 
// N = 4, arr[] = [1 3 2 4]
// Output:
// 3 4 4 -1
// Explanation:
// In the array, the next larger element 
// to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
// since it doesn't exist, it is -1.
// Example 2:

// Input: 
// N = 5, arr[] [6 8 0 1 3]
// Output:
// 8 -1 1 3 -1
// Explanation:
// In the array, the next larger element to 
// 6 is 8, for 8 there is no larger elements 
// hence it is -1, for 0 it is 1 , for 1 it 
// is 3 and then for 3 there is no larger 
// element on right and hence -1.
// Your Task:
// This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting the next greater elements for all the corresponding elements in the input array.

// Expected Time Complexity : O(N)
// Expected Auxiliary Space : O(N)


import java.util.*;
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        //defining a stack where we will store the elements
        Stack<Long> st = new Stack<>();
        
        //declaring the resultant array
        long[] ans = new long[arr.length];
        
        //since the last element will never have the next greater element, so it will always have -1 as ans, and we will push the last element of given array into the stack
        ans[n-1] = -1; 
        st.push(arr[n-1]);
        
        //start traversing from second last array element
        for(int i=n-2; i>=0; i--){
            //pop out the elements from stack until we find the peek element to be larger than current array element, as peek can be a possible largest element
            while(st.size()>0 && arr[i] >= st.peek()){
                st.pop();
            }
            
            //if stack becomes empty, this means, there is no next greater element for the current element
            if(st.size()==0){
                ans[i] = -1;
            }
            
            //else this means, we were not able to pop the element, and the peek element is the next greater for current element
            else{
                ans[i] = st.peek(); //we are not popping this, because it is possible that this element is next greater for some other element too
            }
            
            //every element is pushed into the stack
            st.push(arr[i]);
        }
        
        return ans;
    } 
}