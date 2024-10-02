import java.util.*;

public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  // function to construct a BST from
  // its level order traversal
  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }
  static class Pair{
    boolean ib; // we take isbalanced
    int h;// we take h in pair

    Pair(boolean ib, int h){
        this.ib = ib;
        this.h = h;
    }
    
}

public static Pair helper(Node root){
    if(root == null){
        return new Pair(true,0);
    }
    Pair LST = helper(root.left);  
    Pair RST = helper(root.right);

    int h = Math.max(LST.h,RST.h)+ 1; // we know how to find the heighT AS lst AS A PAIR and LST.h 

    boolean isRootBalanced = Math.abs(LST.h-RST.h)<=1 ? true:false;
    // if a bst tree is balanced ...then the difference between Left sub tree and Right subtree is 0 or 1
    // but it should not be more than 1 than it will not be a balanced BST
    if(isRootBalanced == true && LST.ib == true && RST.ib == true){
        return new Pair(true,h);

    }
    return new Pair(false,h);
}

  public static boolean isBalanced(Node root) {
    // your code here
    return helper(root).ib;


  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node {

  int data;
  Node left, right;
}

