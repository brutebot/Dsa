import java.util.Scanner;
import java.util.Stack;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        left = right = null;
    }
}

// P8: Build an expression tree from an infix expression and traverse it
public class ExpressionTree {

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    static Node constructTree(String exp) {
        Stack<Node> nodes = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == ' ') continue;
            if (Character.isLetterOrDigit(ch)) {
                nodes.push(new Node(ch));
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(')
                    makeNode(nodes, operators.pop());
                operators.pop(); // remove '('
            } else {
                while (!operators.isEmpty() && operators.peek() != '('
                        && precedence(operators.peek()) >= precedence(ch))
                    makeNode(nodes, operators.pop());
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) makeNode(nodes, operators.pop());
        return nodes.pop();
    }

    static void makeNode(Stack<Node> nodes, char op) {
        Node right = nodes.pop();
        Node left = nodes.pop();
        Node newNode = new Node(op);
        newNode.left = left;
        newNode.right = right;
        nodes.push(newNode);
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();
        Node root = constructTree(exp);
        System.out.print("Preorder: ");
        preorder(root);
        System.out.print("\nInorder: ");
        inorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);
        System.out.println();
        sc.close();
    }
}
