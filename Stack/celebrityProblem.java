// A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
// A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
// Note: Follow 0 based indexing.
// Follow Up: Can you optimize it to O(N)

// Example 1:

// Input:
// N = 3
// M[][] = {{0 1 0},
//          {0 0 0}, 
//          {0 1 0}}
// Output: 1
// Explanation: 0th and 2nd person both
// know 1. Therefore, 1 is the celebrity. 

// Example 2:

// Input:
// N = 2
// M[][] = {{0 1},
//          {1 0}}
// Output: -1
// Explanation: The two people at the party both
// know each other. None of them is a celebrity.

// Your Task:
// You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.


// Expected Time Complexity: O(N^2)
// Expected Auxiliary Space: O(1)


import java.util.*;
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// defining a stack where we store the possible celebrity
    	Stack<Integer> st = new Stack<>();
    	
    	//pushing all the indices into the stack
    	for(int i=0; i<n; i++){
    	    st.push(i);
    	}
    	
    	//finding out the possible celebrity
    	while(st.size()>=2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(M[i][j] == 1){  //this means ith index knows jth index, so i is not possible celebrity, push j back
    	        st.push(j);
    	    }
    	    else{ //this means ith index does not know jth index, so it can be a possible celebrity, push i back
    	        st.push(i);
    	    }
    	}
    	
    	//at the end of above loop, we will be having a single value in stack, that can be a possible celebrity.
    	int possCeleb = st.pop();
    	
    	//checkinf if the possible index is celebrity or not
    	for(int i=0; i<n; i++){
    	    //if i is not equal to possible celeb for this iteration
    	    if(i != possCeleb){
    	        //checking if possible celeb knows anyone at the party or if anyone does not know the possible celeb
    	        if(M[i][possCeleb] == 0 || M[possCeleb][i]==1){
    	            return -1;
    	        }
    	    }
    	}
    	
    	return possCeleb;
    	
    }
}