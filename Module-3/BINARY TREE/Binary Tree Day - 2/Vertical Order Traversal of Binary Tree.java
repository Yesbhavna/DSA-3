import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution {
    static class Pair{
        // we will take the Pair in which t is Node and x will be the horizonatal distance
        TreeNode t;
        int x;
        Pair(TreeNode t, int x){
            this.t=t;
            this.x=x;
        }
    }
    List<List<Integer>> VerticalTraversal(TreeNode root) {
        //Write your code here

        List<List<Integer>> ans = new ArrayList<>(); // make your answer list
        if(root==null) return ans;

        TreeMap<Integer,ArrayList<Integer> > tm = new TreeMap<>(); // build a treeMap as it will help us to store the 
        // key in ascending order

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0)); // add the root node to queue
        while(!q.isEmpty()){
            Pair p=q.poll();
            int val=p.t.data; // fetch the data of the node
            int dist=p.x; // fetch the horizontal distance
            ArrayList <Integer> ar =new ArrayList<>(); //store arraylist in treemap to avoid collision

            if(tm.containsKey(dist)){
                ar=tm.get(dist);
                ar.add(val);
            }else{
                ar.add(val);
            }
            tm.put(dist,ar);
            if(p.t.left!=null){
                q.add(new Pair(p.t.left,dist-1)); // when you are moving the left decremet the distance by 1
            }
            if(p.t.right!=null){
                q.add(new Pair(p.t.right,dist+1)); // // when you are moving the right increment the distance by 1
            }
        }
        for(int x:tm.keySet()){
            ArrayList<Integer> f= tm.get(x);
            ans.add(f);
        }
        return ans;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            // System.out.println();
            t--;
        }
    }
}