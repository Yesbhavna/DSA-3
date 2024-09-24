import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    static int[] nextGreaterElementOnLeft(int[] arr) {
        Stack<Integer> st = new Stack<>(); // Stack to store indices of the array
        int[] ngeli = new int[arr.length]; // Array to store nearest greater element indices

        // Traverse the array from left to right
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i]; // Current element (stock price on day i)
            
            // Maintain the stack such that elements in the stack are greater than the current price
            while (!st.isEmpty() && arr[st.peek()] <= ele) {
                st.pop(); // Pop elements that are less than or equal to the current price
            }

            // If the stack is empty, it means there is no greater price on the left
            if (st.isEmpty()) {
                ngeli[i] = -1; // No greater element on the left
            } else {
                ngeli[i] = st.peek(); // Top of the stack is the nearest greater element's index
            }

            // Push the current index onto the stack
            st.push(i);
        }

        return ngeli;
    }
    static int[] stockSpan(int[] a) {
        int[] ngeli = nextGreaterElementOnLeft(a); // Get the nearest greater element index array
    
        int[] span = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            span[i] = i - ngeli[i];// the number of day consecutive days
        }

        return span;

        
    }
}