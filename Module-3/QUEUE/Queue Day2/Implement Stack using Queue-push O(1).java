import java.io.*;
import java.util.*;
class Stack
{
    Queue<Integer> q = new LinkedList<>();

    void push(int a)
    {
        // your code here
        q.add(a);
    }
    
    public int pop()
    {
        // your code here
        if(q.isEmpty()){
            return -1;
        }
        int size = q.size();
        for(int i =0; i< size -1; i++){
            int x = q.poll();
            q.add(x);
        }
        return q.poll();

    }	
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                    // call push function here
                    g.push(a);
            }
            else if(QueryType == 2){
                    // call pop function here
                    System.out.print(g.pop() + " ");
            }
            q--;
        }	
    }
}