
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
            System.out.print(num+" ");

            System.out.println();
		}
	}
}
  
class qObj{
    Node node;
    int level;

    qObj(Node n , int l){
        node = n;
        level = l;
    }
}

class Solution{
    public ArrayList <Integer> bottomView(Node root)

    {
        // Your code here
        TreeMap<Integer,Node> tm = new TreeMap<>();
        Queue<qObj> q = new LinkedList<>();
        q.add(new qObj(root, 0));
        tm.put(0, root);
        while(!q.isEmpty()){
            qObj front = q.poll();
            Node frontNode = front.node;
            int frontlevel = front.level;

            tm.put(frontlevel, frontNode);
            if(frontNode.left != null){
                q.add(new qObj(frontNode.left , frontlevel-1));
            }
             if(frontNode.right != null){
                q.add(new qObj(frontNode.right , frontlevel+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int x: tm.keySet()){
            ans.add(tm.get(x).data);
        }
        return ans;
    }
}
