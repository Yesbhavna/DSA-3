import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.arcadeFrenzy(scores, k));
        
    }
}

class Solution {
    public int arcadeFrenzy(int[] scores, int k) {
        int n = scores.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (long)scores[i - 1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        if(ans == Long.MAX_VALUE)
            return -1;
        else
            return (int)ans;
    }
}