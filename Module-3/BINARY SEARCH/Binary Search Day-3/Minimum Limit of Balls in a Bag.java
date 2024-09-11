import java.util.*;
import java.io.*;
class Solution
{
    public static int solve(int n,int m,int arr[])
    {
        // Write your code here
        int low = 1;
        int high = -1 ;//(max operation allows)
        for(int i=0; i<n; i++){
            high = Math.max(high,arr[i]);
        }
        int ans = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(isValid(arr,mid,m)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static boolean isValid(int[] arr, int maxPenality, int maxOperation){
        int ops =0;
        for(int i =0; i< arr.length; i++){
            if(arr[i] > maxPenality){
                if(arr[i] % maxPenality == 0){

                    ops += (arr[i]/maxPenality)-1;

                }else{
                    ops += arr[i]/ maxPenality;
                }
            }
        }
        if(ops <= maxOperation){
            return true;
        }else{
            return false;
        }

    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}