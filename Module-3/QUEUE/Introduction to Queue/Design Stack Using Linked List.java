import java.util.*;

class Node {
    int data;
    Node link;

    Node (int data) {
        this.data = data;
    }
}

class Main {
	public static void main(String[] args) {
		StackUsingLinkedlist obj = new StackUsingLinkedlist();
		Scanner sc = new Scanner(System.in);
        int q;
        q = sc.nextInt();
        while(q-->0){
            int x;
            x = sc.nextInt();
            if(x==1){
                int y;
                y = sc.nextInt();
                obj.push(y);
            }
            if(x==2){
                System.out.println(obj.peek());
            }
            if(x==3){
                obj.pop();
            }
            if(x==4){
                Node temp = obj.display();
                while (temp != null) {

                    System.out.print(temp.data+" ");

                    temp = temp.link;
			    }
				System.out.println();
            }
        }
	}
}

class StackUsingLinkedlist {
	Node top;
	StackUsingLinkedlist() { 
        this.top = null; 
    }

    // TC: O(1)
    // add first in the linkedList
	public void push(int x) {
        Node node = new Node(x);
        
        if (top == null) {
            top = node;
        } else {
            node.link = top;
            top = node;
        }
	}

    // TC: O(1)
    // top elemenet of the linkedList
	public int peek() {
		if (top == null) {
            return -1;
        } else {
            return top.data;
        }
	}

    // TC: O(1)
    // remove first from LinkedList
	public void pop() {
        if (top == null) {
            return;
        } else {
            Node temp = top.link;
            top.link = null;
            top = temp;   
        }
	}

    // return top of the linkedList
	public Node display() {
		return top;
	}
}
