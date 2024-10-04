import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) arr[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    Node tree = levelOrderCreateTree(arr);
    System.out.println(timeToBurnTree(tree, k));
  }

  
  public static int timeToBurnTree(Node root, int target) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        markParents(root, parentMap);

        // Modified Level Order Traversal (BFS)
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int dist = 0;
        Node targetNode = find(root, target);
        q.add(targetNode);
        visited.add(targetNode);

        while(!q.isEmpty()) {
            int count = q.size(); // same distance nodes

            for(int i = 0; i < count; i++) {
                Node currNode = q.poll();
                Node parent = parentMap.get(currNode);
                if(parent != null && !visited.contains(parent)) {
                    q.add(parent);
                    visited.add(parent);
                }
                if(currNode.left != null && !visited.contains(currNode.left)) {
                    q.add(currNode.left);
                    visited.add(currNode.left);
                }
                if(currNode.right != null && !visited.contains(currNode.right)) {
                    q.add(currNode.right);
                    visited.add(currNode.right);
                }
            }

            dist++; // for the next level
        }

      return dist - 1;
    }

    static Node find(Node root, int target) {
        if(root == null){
            return null;
        }

        if(root.data == target) {
            return root;
        }

        Node left = find(root.left, target);
        if(left != null) {
            return left;
        }

        Node right = find(root.right, target);
        if(right != null) {
            return right;
        }
        
        return null; // dummy return
    }

    static void markParents(Node root, HashMap<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int count = q.size();

            for(int i = 0; i < count; i++) {
                Node currNode = q.poll();

                if(currNode.left != null) {
                    q.add(currNode.left);
                    parentMap.put(currNode.left, currNode);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                    parentMap.put(currNode.right, currNode);
                }
            }
        }
    }

    

  static void createTree(Node node, int i, String[] arr) {
    if (node != null) {
      if (2 * i + 1 < arr.length) {
        if (arr[2 * i + 1].equals("null")) {
          node.left = null;
        } else {
          node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
        }
        createTree(node.left, 2 * i + 1, arr);
      }
      if (2 * i + 2 < arr.length) {
        if (arr[2 * i + 2].equals("null")) {
          node.right = null;
        } else {
          node.right = new Node(Integer.parseInt((arr[2 * i + 2])));
        }
        createTree(node.right, 2 * i + 2, arr);
      }
    }
  }

  static Node levelOrderCreateTree(String[] arr) {
    if (arr.length == 0) return null;
    Node head = new Node(
      Integer.parseInt(arr[0])
    );
    createTree(head, 0, arr);
    return head;
  }
}

class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
  }
}
