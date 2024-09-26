import java.io.*;
import java.util.*;

class Solution {
    public void TappingWater(int[] height, int n) {
        //Write code here and print output

        // Time Cmplexity = O(N)
        // Space Complexity = O(1)


        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // update leftMax
                } else {
                    trappedWater += leftMax - height[left]; // water trapped
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // update rightMax
                } else {
                    trappedWater += rightMax - height[right]; // water trapped
                }
                right--;
            }
        }

        System.out.println(trappedWater);
        
       
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}