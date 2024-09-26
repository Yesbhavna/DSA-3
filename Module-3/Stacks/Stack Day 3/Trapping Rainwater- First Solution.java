import java.io.*;
import java.util.*;

class Solution {

//Time Complexity = O(N)
// Space Complexity = O(N)

    public static int[] leftmax(int[] arr , int n){
        int[] lmax = new int[n];
        lmax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        }
        return lmax;
    }
    public static int[] rightmax(int[] arr , int n){
        int[] rmax = new int[n];
        rmax[n-1] = arr[n-1];
        for (int i = n-2; i>=0 ; i--) {
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        return rmax;
    }
    public void TappingWater(int[] arr, int n) {
      int[] lmax = leftmax(arr,n);
      int[] rmax = rightmax(arr,n);

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int h = (Math.min(lmax[i],rmax[i]) - arr[i]);
            totalWater += h;
        }

        System.out.println(totalWater);
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

