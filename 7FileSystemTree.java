// Node represents a file or folder
class Node {
    String name;
    Node left, right;

    Node(String name) {
        this.name = name;
        left = null;
        right = null;
    }
}

// P7: File system as a binary tree - preorder, inorder, postorder
public class FileSystemTree {

    static void preorder(Node root) {   // Root, Left, Right
        if (root == null) return;
        System.out.print(root.name + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root) {    // Left, Root, Right
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.name + " ");
        inorder(root.right);
    }

    static void postorder(Node root) {  // Left, Right, Root
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.name + " ");
    }

    public static void main(String[] args) {
        Node root = new Node("Root");
        root.left = new Node("Documents");
        root.right = new Node("Pictures");
        root.left.left = new Node("Notes.txt");
        root.left.right = new Node("Report.txt");
        root.right.left = new Node("Photo.jpg");

        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.print("\nInorder Traversal: ");
        inorder(root);
        System.out.print("\nPostorder Traversal: ");
        postorder(root);
        System.out.println();
    }
}
