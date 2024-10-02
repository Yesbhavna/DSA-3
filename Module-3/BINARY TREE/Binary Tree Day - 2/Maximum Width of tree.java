import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution {
    // with the help of height we know the to travel around how many levels
    // and you will see if level is 1 then good retuen 1 ..but if level is more than 2
    // just decrement the level from both the end
    int height(Node root){
        if(root == null) return 0;
        else{
            int l = height(root.left);
            int r = height(root.right);
            return 1 + Math.max(l,r);
        }
    }
    int getWidth(Node node, int level){
        if(node == null) return 0;
        if(level == 1) return 1;
        else if(level >1){
            return getWidth(node.left,level-1)+ 
            getWidth(node.right, level-1);
        }
        return 0;
    }

    public int solve(Node root) {
        // your code here
        int h = height(root);
        int maxWidth = Integer.MIN_VALUE;
        int width;
        for(int i = 1; i<=h; i++){
            width = getWidth(root,i);
            if(width > maxWidth){
                maxWidth = width;
            }
        }
        return maxWidth;
    }
}

// we can also solve this with the help of level order traversal by comparing the size of the queue>

public int solve(Node root) {
        // your code here
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int maxwidth =0;
        while(!q.isEmpty()){
            int size = q.size();
            maxwidth = Math.max(maxwidth, size);
            for(int i =0; i< size; i++){
                Node node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return maxwidth;
    }
