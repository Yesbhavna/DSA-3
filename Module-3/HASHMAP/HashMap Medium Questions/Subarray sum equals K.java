import java.io.*;
import java.util.*;
 
 class Solution
{
         static int solve(int N, int[] Arr, int K){
       // Write your code here
       HashMap<Integer,Integer> map = new HashMap<>();
       int cumulativeSum =0;
       int count =0;
       map.put(0,1);
       for(int i =0; i<N; i++){
        cumulativeSum += Arr[i];
        count += map.getOrDefault(cumulativeSum-K,0);
        map.put(cumulativeSum,map.getOrDefault(cumulativeSum,0)+1);

       }
    return count ;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());
 
         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
}