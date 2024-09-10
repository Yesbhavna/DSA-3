import java.util.*;

class Solution{
    public int findPeak(int arr[], int n)
    {
        //Write your code here
       int si =0;
        int ei = n-1;
        
        while(si <= ei){
            int mid = si + (ei-si)/2;

            if( mid > 0 && mid < n-1){
               if(arr[mid]> arr[mid-1] && arr[mid]> arr[mid+1]){
             return mid;
               }
                else if(arr[mid-1]> arr[mid]){
                 ei = mid-1;
                }
                else {
                    si = mid+1;
                    
                }
            }
            else if( mid ==0){
             if(arr[0]>arr[1]){
                    return 0;
}
                else{
                    return 1;
                }
                }
            
            else if(mid == n-1){
                   if(arr[n-1]>arr[n-2]){
                     return n-1;
}
                else{
                    return n-2;
                }
    }
        }
        return -1;
    }
}

class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				Solution ob =new Solution();
				int ans = ob.findPeak(A,n);
                if(ans==0){
                    if(A[ans]>A[ans+1]){
                        System.out.println("true");
                    }
                    else{
                       System.out.println("false");    
                    }
                }
                else if(ans==n-1){
                    if(A[ans]>A[ans-1]){
                        System.out.println("true");                        
                    }
                    else{
                        System.out.println("false");                        
                    }
                }
                else{
                    if(A[ans]>A[ans+1] && A[ans]>A[ans-1]){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");                        
                    }
                }
				t--;
			}
		}
	}
}