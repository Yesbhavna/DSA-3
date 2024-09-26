import java.util.*;
class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;

        for(int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
			System.out.println(new Solution().tour(p,d));
	}
}
class Solution
{
	int tour(int petrol[], int distance[])
	{
		// totalPetrol < totalDistance -> -1
        int totalPetrol = 0, totalDistance = 0;

        for(int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
        }

        if(totalPetrol < totalDistance) {
            return -1;
        }

        int start = 0, balance = 0;

        for(int i = 0; i < petrol.length; i++) {
            balance += petrol[i] - distance[i];

            if(balance < 0) {
                start = i + 1; // IMP
                balance = 0;
            }
        }

        return start;
	}
}