import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if(curr > 0) {
                s.push(curr);
            } else {
                // -ve val => Left moving asteroid
                curr = -1 * curr;
                while(!s.empty() && s.peek() > 0 && s.peek() < curr) {
                    s.pop();
                }
                // Right ==, >
                if(!s.empty() && s.peek() > 0 && s.peek() == curr) {
                    s.pop();
                    continue;
                } else if(!s.empty() && s.peek() > 0 && s.peek() > curr) {
                    // current asteroid destroyed
                    continue;
                } else {
                    s.push(-1 * curr);
                }
                
            }
        }

        if(s.size() == 0) {
            System.out.print(-1 + " ");
            // return null;
        }
        int arr[] = new int[s.size()];
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            arr[i] = s.pop();
        }
        return arr;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}