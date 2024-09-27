import java.util.*;

class StackQueue{
   
    // write your code here
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void Push(int a){
	  s1.push(a);
	  
    }
   
    int Pop()  { 
         //move all the elements except last to s2
         if(s1.empty()){
            return - 1;
         }
         while(s1.size() != 1){
            int x = s1.pop();
            s2.push(x);
         }
         int elementToRemoved = s1.pop();
         while(!s2.empty()){
            int x = s2.pop();
            s1.push(x);
         }
         return elementToRemoved;
    }
}

class Main {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        StackQueue s = new StackQueue();	
        int q = scanner.nextInt();
       
        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                s.Push(a); 
            } else if (queryType == 2) {
                System.out.print(s.Pop() + " ");
            }
        }
    }
}
