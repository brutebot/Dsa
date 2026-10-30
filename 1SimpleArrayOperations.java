import java.util.Scanner;

// P1: Array operations - insertion, deletion, traversal, min and max
public class SimpleArrayOperations {

    static void display(int[] a, int n) {
        System.out.println("\nArray Elements:");
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    }

    static int insert(int[] a, int n, int position, int value) {
        for (int i = n; i >= position; i--) a[i] = a[i - 1]; // shift right
        a[position - 1] = value;
        return n + 1;
    }

    static int delete(int[] a, int n, int position) {
        for (int i = position - 1; i < n - 1; i++) a[i] = a[i + 1]; // shift left
        return n - 1;
    }

    static void findMinMax(int[] a, int n) {
        int min = a[0], max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        System.out.println("\nMinimum Element = " + min);
        System.out.println("Maximum Element = " + max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        display(a, n);

        System.out.print("\n\nEnter position for insertion: ");
        int position = sc.nextInt();
        System.out.print("Enter value: ");
        int value = sc.nextInt();
        n = insert(a, n, position, value);
        System.out.println("After Insertion:");
        display(a, n);

        System.out.print("\n\nEnter position for deletion: ");
        position = sc.nextInt();
        n = delete(a, n, position);
        System.out.println("After Deletion:");
        display(a, n);

        findMinMax(a, n);
        sc.close();
    }
}
