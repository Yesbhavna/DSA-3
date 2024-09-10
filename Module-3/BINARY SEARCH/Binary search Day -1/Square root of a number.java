import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        long pans = -1;
        long si = 1; //low
        long ei = (long) A;  // high

        while (si <= ei) {
            long mid = si + (ei-si) / 2; // mid

            if (mid * mid == A) {
                System.out.println(mid);
                return;
            } else if (mid * mid > A) {
                ei = mid - 1;
            } else {
                pans = mid;
                si = mid + 1;
            }
        }

        System.out.println(pans);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}