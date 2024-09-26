import java.util.*;

class Node{
    int data;
     Node next;
     Node(int data){
        this.data = data;
        this.next = null;
     }
}

class Queue {
    //Write your code here

    Node head = null;
    Node tail = null;
    
    public void push(int value) {
        //Write your code here
        Node newNode = new Node(value);
        if(head == null && tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
    }
    public int pop() {
        //Write your code here
        int val = head.data;
        head = head.next;
        return val;

    }
    public int front() {
        //Write your code here
        int val = head.data;
        return val;

    }
    public int getSize() {
        //Write your code here

        Node temp = head;
        int count = 0;
        while(temp != null){
            count += 1;
            temp = temp.next; 
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.getSize());
        }
    }
}