// We are given an array asteroids of integers representing asteroids in a row.

// For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

// Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

// Example 1:
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

// Example 2:
// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.

// Example 3:
// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

import java.util.*;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{

                //jisme pehle wala plus aur dusra minus hai, uske andr plus wali value minus wali se choti hai
                while(st.size() > 0 && st.peek()>0 && st.peek() < -asteroids[i]){
                    st.pop();
                }
                //if 8 and -8 appears
                if(st.size()>0 && st.peek() == -asteroids[i] && st.peek()>0){
                    st.pop();
                }
                //isme plus bada hoga aur minus chota hoga (10 and -7)
                else if(st.size()>0 && st.peek()>0 && st.peek()> -asteroids[i]){
                    
                }
                else{
                    st.push(asteroids[i]);
                }
            }
        }
        int[] result = new int[st.size()];
        int var = st.size();
        while(st.size()>0){
            result[var-1] = st.pop();
            var--;
        }

        return result;
    }
}