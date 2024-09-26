import java.io.*;
import java.util.*;

class StackQueue
{
    //Function to push an element in queue by using 2 stacks.
    Stack<Integer> st1;
    Stack<Integer> st2;

    public StackQueue(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }


    void Push(int x)
    {
	   //Write your code here
      if(st1.isEmpty()){
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
        st1.push(x);
 
        while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
	  if(st2.isEmpty())return -1;
	    return st2.pop();
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);  
        StackQueue s = new StackQueue();	
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
            ans.add(s.Pop());
        q--;
        }	
        for(int x:ans)
        System.out.print(x+" ");       
     System.out.println();
    }
}