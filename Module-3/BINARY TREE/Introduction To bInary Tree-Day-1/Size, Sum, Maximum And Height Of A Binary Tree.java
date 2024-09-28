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


class Solution {
    public int sizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        
        int x = sizeOfTree(root.left);
        int y = sizeOfTree(root.right);

        return x + 1 + y;
    }

    public int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }
    
        int x = sumOfTree(root.left);
        int y = sumOfTree(root.right);

        return x + root.data + y;
    }

    public int maxOfTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        int x = maxOfTree(root.left);
        int y = maxOfTree(root.right);

        return Math.max(root.data, Math.max(x, y));
    }

    public int heightOfTree(Node root) {
        if (root== null) {
            return 0;
        }

        int hLST = heightOfTree(root.left);
        int hRST = heightOfTree(root.right);

        return Math.max(hLST, hRST) + 1;
    }
}