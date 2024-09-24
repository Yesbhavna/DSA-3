import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
       Stack<Integer> st = new Stack<>();
       for(int i =0 ; i<n ; i++){
        st.push(i);
       }
       while(st.size() > 1){
        int p1 = st.pop();
        int p2 = st.pop();
        //check if p1 knows p2
        if(M[p1][p2] == 0){
            //if p1 does not know p2, p2 cannot be a findCelebrity
        //push p1 back to Stack
        st.push(p1);
        }else{
                        //if p1  know p2, p1 cannot be a findCelebrity
                        st.push(p2);

        }
       }
       int pceleb = st.pop();
       //if the pceleb knows no one
       for(int c =0; c<n ; c++){
        if(pceleb != c && M[pceleb][c] == 1){
            return - 1;
        }
       }
       for(int r =0; r<n; r++){
        if(r != pceleb && M[r][pceleb] == 0){
            return -1;
        }
       }
       return pceleb;
    }

}